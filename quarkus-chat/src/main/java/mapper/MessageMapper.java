package mapper;

import domain.Message;
import dto.MessageDTO;

import java.time.format.DateTimeFormatter;

public class MessageMapper {

    public static MessageDTO mapMessageToMessageDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setText(message.getText());
        messageDTO.setCreatedDate(message.getCreatedDate().format(DateTimeFormatter.RFC_1123_DATE_TIME));
        messageDTO.setAuthor(message.getAuthor().getId());
        messageDTO.setChat(message.getChat().getId());
        return  messageDTO;
    }
}
