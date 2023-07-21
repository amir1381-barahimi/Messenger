package rabbirmq.client.Model.responseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.ref.PhantomReference;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageResponseModel {
    private String text;
    private String sender;
    private String receiver;
}
