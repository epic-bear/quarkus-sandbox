package dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;


@Data
public class UserDTO {

    private Long id;
    @Size(max = 15, message = "Username cannot be longer than 15 characters")
    private String username;
    private List<Contact> contacts;
    private List<Long> chats;

}


