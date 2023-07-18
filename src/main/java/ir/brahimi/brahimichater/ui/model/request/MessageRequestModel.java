package ir.brahimi.brahimichater.ui.model.request;

import ir.brahimi.brahimichater.shared.dto.UserDto;
import ir.brahimi.brahimichater.shared.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ir.brahimi.brahimichater.shared.enums.Type;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageRequestModel {
    private String text;
    private UserDto sender;
    private Object receiver;
    private Type type;
    private Status status;
    private Date date;


}
