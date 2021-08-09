package web.util;

import org.springframework.stereotype.Component;
import web.models.User;
import web.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void Init() {
        User user = new User("Bob", 21);
        userService.save(user);

    }
}