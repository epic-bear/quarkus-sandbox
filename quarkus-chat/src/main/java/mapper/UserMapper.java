package mapper;

import domain.Chat;
import domain.User;
import dto.Contact;
import dto.UserDTO;

public class UserMapper {

    public static UserDTO mapUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setContacts(user.getContacts().stream().map(Contact::mapUserToContact).toList());
        userDTO.setChats(user.getChats().stream().map(Chat::getId).toList());
        return userDTO;
    }
}
