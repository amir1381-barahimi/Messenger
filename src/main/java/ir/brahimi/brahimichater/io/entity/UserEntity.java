package ir.brahimi.brahimichater.io.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Column(nullable = false,length = 100,unique = true)
    private String userName;
    @Column(nullable = false,length = 50)
    private String password;
    @Column()
    private String encryptedPassword;
    @Column(length = 60)
    private String email;

//    @ManyToMany(mappedBy = "members")
//    private ArrayList<UserEntity> contact = new ArrayList<>();
//
//    @ManyToMany(mappedBy = "admins")
//    private ArrayList<GroupEntity> groups = new ArrayList<>();
//
//    @ManyToMany(mappedBy = "admins")
//    private ArrayList<ChannelEntity> channels = new ArrayList<>();



    public long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }


    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }


    public void setEmail(String email) {
        this.email = email;
    }
}
