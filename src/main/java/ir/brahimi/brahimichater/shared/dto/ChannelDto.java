package ir.brahimi.brahimichater.shared.dto;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ChannelDto {
    private ArrayList<UserDto> members = new ArrayList<>();
    private ArrayList<UserDto> admins = new ArrayList<>();
    private Queue<MessageDto> chats = new PriorityQueue<>();

}
