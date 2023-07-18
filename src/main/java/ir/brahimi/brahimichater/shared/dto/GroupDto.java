package ir.brahimi.brahimichater.shared.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupDto {
    private ArrayList<UserDto> members = new ArrayList<>();
    private ArrayList<UserDto> admins = new ArrayList<>();
    private Queue<MessageDto> chats = new PriorityQueue<>();

}
