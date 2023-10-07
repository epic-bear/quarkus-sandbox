package mapper;

import domain.Chat;
import dto.ChatDTO;
import dto.Contact;

public class ChatMapper {

    public static ChatDTO mapChatToChatDTO(Chat chat) {
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setId(chat.getId());
        chatDTO.setUsers(chat.getUsers().stream().map(Contact::mapUserToContact).toList());
        chatDTO.setMessages(chat.getMessages().stream().map(MessageMapper::mapMessageToMessageDTO).toList());
        return chatDTO;
    }
}
