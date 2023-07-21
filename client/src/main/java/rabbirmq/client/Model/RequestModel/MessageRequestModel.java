package rabbirmq.client.Model.RequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
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

    public JSONObject toJson() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("text", this.text);
        jsonObject.put("sender", this.sender);
        jsonObject.put("receiver", this.receiver);
        jsonObject.put("type", this.type);
        jsonObject.put("status", this.status);
        jsonObject.put("date", this.date);
        return jsonObject;
    }
}
