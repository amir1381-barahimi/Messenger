package rabbirmq.client.Service;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import rabbirmq.client.Model.RequestModel.MessageRequestModel;

import java.io.IOException;
import java.sql.SQLOutput;

public interface RabbitMQConsumerService {
    public static Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumerService.class);

    public void consume(MessageRequestModel message, Channel channel , @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException, InterruptedException;
}
