package dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MessageDTO {

    private Long id;
    @Size(max = 150, message = "Message cannot be longer than 150 characters")
    private String text;
    private String createdDate;
    private Long author;
    private Long chat;

}
