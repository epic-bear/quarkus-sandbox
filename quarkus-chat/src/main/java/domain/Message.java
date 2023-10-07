package domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
public class Message {

    @Id
    private Long id;

    @Size(max = 150, message = "Message cannot be longer than 150 characters")
    private String text;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @ManyToOne
    @NotNull
    private User author;

    @ManyToOne
    @NotNull
    private Chat chat;
}
