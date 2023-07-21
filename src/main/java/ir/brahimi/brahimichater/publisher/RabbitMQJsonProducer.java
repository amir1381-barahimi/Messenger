package ir.brahimi.brahimichater.publisher;

//import ir.brahimi.brahimichater.consumer.RabbitMQConsummer;
import ir.brahimi.brahimichater.shared.dto.MessageDto;
import ir.brahimi.brahimichater.shared.dto.UserDto;
import ir.brahimi.brahimichater.ui.model.request.MessageRequestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {
    private final static Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;


    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private RabbitTemplate rabbitTemplate;
    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(MessageDto messageDto){
        LOGGER.info(String.format("json message sent -> %s",messageDto.toString()));
        rabbitTemplate.convertAndSend(exchange,routingJsonKey,messageDto);
    }

}
