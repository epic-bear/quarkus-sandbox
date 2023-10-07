package service;

import domain.Chat;
import dto.ChatDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.ChatRepository;

@ApplicationScoped
public class ChatService {

    @Inject
    ChatRepository chatRepository;

    @Inject
    UserService userService;

    public Chat createChat(ChatDTO chatDTO) {
        Chat chat = new Chat();
        chat.setUsers(chatDTO.getUsers().stream().map(user -> userService.getUser(user.getUsername())).toList());
        chatRepository.persist(chat);
        return chat;
    }

    public Chat getChat(Long id) {
        return chatRepository.findById(id);
    }
}
