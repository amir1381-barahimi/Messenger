package rabbirmq.client.Model.RequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rabbirmq.client.Model.dto.UserDto;
import rabbirmq.client.Model.enums.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageRequestModel {
    private String text;
    private String sender;
    private String receiver;
    private String type;
    private String status;
    private Date date;
}
