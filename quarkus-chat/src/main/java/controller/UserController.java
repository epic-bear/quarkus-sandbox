package controller;

import domain.User;
import dto.UserDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mapper.UserMapper;
import service.UserService;
import io.quarkus.qute.Template;

@Path("/user")
@Produces(MediaType.TEXT_HTML)
public class UserController {

    @Inject
    UserService userService;

    @Inject
    Template userPage;

    @POST
    @Path("/{username}")
    public Response createUser(@PathParam("username") String username) {
        userService.createUser(username);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{username}")
    public String getUser(@PathParam("username") String username) {
        User user = userService.getUser(username);
        return userPage.data("user", UserMapper.mapUserToUserDTO(user)).render();
    }
}
