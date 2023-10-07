package service;

import jakarta.inject.Inject;
import domain.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import repository.UserRepository;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public User createUser(String username) {
        User user = new User();
        user.setUsername(username);
        userRepository.persist(user);
        return user;
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
