package dto;

import lombok.Data;

import java.util.List;

@Data
public class ChatDTO {

    private Long id;
    private String username;
    private List<Contact> users;
    private List<MessageDTO> messages;

}
