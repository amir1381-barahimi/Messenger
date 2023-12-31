package ir.brahimi.brahimichater.shared.dto;

import ir.brahimi.brahimichater.shared.enums.Status;
import ir.brahimi.brahimichater.shared.enums.Type;
import ir.brahimi.brahimichater.ui.model.request.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.util.calendar.BaseCalendar;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageDto {
    private String text;
    private String sender;
    private String receiver;
    private String type;
    private String status;
    private Date date;
}
