package rabbirmq.client.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import rabbirmq.client.Model.RequestModel.MessageRequestModel;

import java.sql.SQLOutput;

public interface RabbitMQConsumerService {
    public static Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumerService.class);

    public void consume(MessageRequestModel message);
}
