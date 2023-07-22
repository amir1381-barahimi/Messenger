package rabbirmq.client.Service.Impl;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import rabbirmq.client.Model.RequestModel.MessageRequestModel ;
import rabbirmq.client.Service.RabbitMQConsumerService;

import java.io.IOException;

@Service
public class RabbitMQConsumerServiceImpl implements RabbitMQConsumerService {

    @RabbitListener(queues = "${rabbitmq.queue.json.name}",ackMode = "MANUAL")
    public void consume(MessageRequestModel message, Channel channel , @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException, InterruptedException {
        if(message.getReceiver().equals("reza")){
            channel.basicAck(tag , true);
        }else{
            Thread.sleep(10);
            channel.basicAck(tag,false);
        }
        LOGGER.info(String.format("received message is -> %s" , message));
    }
}
