package ir.brahimi.brahimichater.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsummer {
    private final static Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsummer.class);


    @RabbitListener(queues="${rabbitmq.queue.name}")
    public void consume(String message){
        LOGGER.info(String.format("received message -> %s",message));
    }
}
