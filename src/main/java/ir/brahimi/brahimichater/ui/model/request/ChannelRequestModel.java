package ir.brahimi.brahimichater.ui.model.request;

import ir.brahimi.brahimichater.shared.dto.MessageDto;
import ir.brahimi.brahimichater.shared.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChannelRequestModel {
    private ArrayList<UserDto> members = new ArrayList<>();
    private ArrayList<UserDto> admins = new ArrayList<>();
    private Queue<MessageDto> chats = new PriorityQueue<>();
}
