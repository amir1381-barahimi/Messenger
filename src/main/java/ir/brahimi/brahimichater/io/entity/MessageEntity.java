package ir.brahimi.brahimichater.io.entity;


import ir.brahimi.brahimichater.shared.dto.UserDto;
import ir.brahimi.brahimichater.shared.enums.Status;
import ir.brahimi.brahimichater.shared.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "messages")
public class MessageEntity implements Serializable {
    @Id
    private long id;

    @Column(nullable = false , length = 400)
    private String text;

    @Column(nullable = false)
    private String sender;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "message_user",
//            joinColumns = @JoinColumn(name = "message_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
    private String receiver;

    @Column(nullable = false)
    private Type type;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Date date;

}
