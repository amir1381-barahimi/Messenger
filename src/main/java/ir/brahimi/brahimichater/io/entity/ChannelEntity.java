//package ir.brahimi.brahimichater.io.entity;
//
//import ir.brahimi.brahimichater.shared.dto.MessageDto;
//import ir.brahimi.brahimichater.shared.dto.UserDto;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name = "channel")
//public class ChannelEntity implements Serializable {
//
//    @Id
//    private long id;
//
//    @Column
//    private String channelName;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "channel_user",
//            joinColumns = {@JoinColumn(name = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "channel_id")}
//    )
//    private ArrayList<UserEntity> members = new ArrayList<>();
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "channel_user",
//            joinColumns = {@JoinColumn(name = "channel_id")},
//            inverseJoinColumns = {@JoinColumn(name = "user_id")}
//    )
//    private ArrayList<UserEntity> admins = new ArrayList<>();
//
//    @OneToMany
//    @JoinColumn(name = "chat_id")
//    private Queue<MessageEntity> chats = new PriorityQueue<>();
//}
