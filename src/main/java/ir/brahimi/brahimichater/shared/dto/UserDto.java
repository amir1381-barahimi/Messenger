package ir.brahimi.brahimichater.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto implements Serializable {
    private long id;
    private String publicId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String encryptedPassword;
    private String email;

//    private ArrayList<UserDto> contacts = new ArrayList<>();

//    private ArrayList<GroupDto> groups = new ArrayList<>();
//
//    private ArrayList<ChannelDto> channels = new ArrayList<>();



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

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }



    public String getPublicId() {
        return publicId;
    }

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
}
