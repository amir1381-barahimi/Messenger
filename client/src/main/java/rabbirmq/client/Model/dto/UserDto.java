package rabbirmq.client.Model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private long id;
    private String publicId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String encryptedPassword;
    private String email;
}
