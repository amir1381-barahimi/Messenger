package ir.brahimi.brahimichater.ui.contrller;


import ir.brahimi.brahimichater.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rabbitMessage")
public class RabbitMessageController {

    private final RabbitMQProducer producer;


    public RabbitMessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }


    //http://localhost:8080/rabbitMessage/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("message sent to rabbitMQ ...");
    }
}
