package ir.brahimi.brahimichater.ui.contrller;

import ir.brahimi.brahimichater.publisher.RabbitMQJsonProducer;
import ir.brahimi.brahimichater.shared.dto.MessageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jsonRabbit")
public class MessageJsonController {

    private RabbitMQJsonProducer jsonProducer;

    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }


    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody MessageDto messageDto){
        jsonProducer.sendJsonMessage(messageDto);
        return ResponseEntity.ok("json message sent to RabbitMQ ...");
    }
}
