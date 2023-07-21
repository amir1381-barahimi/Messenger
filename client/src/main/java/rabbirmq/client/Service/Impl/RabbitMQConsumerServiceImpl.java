package rabbirmq.client.Service.Impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import rabbirmq.client.Model.RequestModel.MessageRequestModel ;
import rabbirmq.client.Service.RabbitMQConsumerService;

@Service
public class RabbitMQConsumerServiceImpl implements RabbitMQConsumerService {

    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consume(MessageRequestModel message){
        LOGGER.info(String.format("received message is -> %s" , message));
    }
}
