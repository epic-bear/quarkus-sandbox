package controller;

import domain.Chat;
import dto.ChatDTO;
import io.quarkus.qute.Template;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mapper.ChatMapper;
import service.ChatService;

@Path("/chat")
@Produces(MediaType.TEXT_HTML)
public class ChatController {

    @Inject
    ChatService chatService;

    @Inject
    Template chatPage;

    @POST
    public Response createChat(@Valid ChatDTO chatDTO) {
        Chat chat = chatService.createChat(chatDTO);
        return Response.status(Response.Status.CREATED)
                .entity(chat.getId())
                .type(MediaType.TEXT_PLAIN)
                .build();
    }

    @GET
    @Path("/{id}")
    public String getChat(@PathParam("id") Long id,@QueryParam("username") String username){
        Chat chat = chatService.getChat(id);
        return chatPage.data("username", username).data("chat", ChatMapper.mapChatToChatDTO(chat)).render();
    }
}
