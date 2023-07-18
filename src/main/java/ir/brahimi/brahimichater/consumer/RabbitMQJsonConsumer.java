package ir.brahimi.brahimichater.consumer;

import ir.brahimi.brahimichater.publisher.RabbitMQJsonProducer;
import ir.brahimi.brahimichater.shared.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RabbitMQJsonConsumer {

    private final static Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consumeJsonMessage(MessageDto messageDto){
        LOGGER.info(String.format("receive json message -> %s",messageDto.toString()));
    }

}
