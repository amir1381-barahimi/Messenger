package ir.brahimi.brahimichater.ui.model.response;

import ir.brahimi.brahimichater.shared.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.util.calendar.BaseCalendar;
import ir.brahimi.brahimichater.ui.model.request.MessageRequestModel.*;
import ir.brahimi.brahimichater.shared.enums.*;
import java.util.ArrayList;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageResponseModel {
    private String publishId;
    private String text;
    private UserDto senders;
    private Object receiver;
    private Status status = Status.SEND;
    private Date date;

}

