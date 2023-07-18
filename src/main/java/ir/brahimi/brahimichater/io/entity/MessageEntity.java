package ir.brahimi.brahimichater.io.entity;


import ir.brahimi.brahimichater.shared.dto.UserDto;
import ir.brahimi.brahimichater.shared.enums.Status;
import ir.brahimi.brahimichater.shared.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "messages")
public class MessageEntity {
    @Id
    private long id;

    @Column(nullable = false , length = 400)
    private String text;

    @Column(nullable = false)
    private UserDto sender;

    @Column(nullable = false)
    private Object receiver;

    @Column(nullable = false)
    private Type type;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Date date;

}
