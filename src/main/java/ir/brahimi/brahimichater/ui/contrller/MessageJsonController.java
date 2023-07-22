package ir.brahimi.brahimichater.ui.contrller;

import ir.brahimi.brahimichater.publisher.RabbitMQJsonProducer;
import ir.brahimi.brahimichater.shared.dto.MessageDto;
import ir.brahimi.brahimichater.shared.dto.UserDto;
import ir.brahimi.brahimichater.ui.model.request.MessageRequestModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@RestController
    @RequestMapping("/jsonRabbit")
public class MessageJsonController {

    private RabbitMQJsonProducer jsonProducer;

    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }


        @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody MessageDto messageDto){
        ArrayList<String> channel = new ArrayList<>();
        channel.add("amir");
        channel.add("reza");

        ArrayList<String> group = new ArrayList<>();
        group.add("amir");
        group.add("reza");

        if (messageDto.getType().equals("PV")){
            jsonProducer.sendJsonMessage(messageDto);
        } else if (messageDto.getType().equals("CHANNEL")) {
            for(String s:channel){
                messageDto.setType("PV");
                messageDto.setReceiver(s);
                jsonProducer.sendJsonMessage(messageDto);
            }
        }else{
            for(String s:group){
                messageDto.setType("PV");
                messageDto.setReceiver(s);
                jsonProducer.sendJsonMessage(messageDto);
            }
        }
        messageDto.setDate(new Date(System.currentTimeMillis()));
        return ResponseEntity.ok("json message sent to RabbitMQ ...");
    }
}
