package dto;

import domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact {

    private Long id;
    private String username;

    public static Contact mapUserToContact(User user) {
        return new Contact(user.getId(), user.getUsername());
    }
}

