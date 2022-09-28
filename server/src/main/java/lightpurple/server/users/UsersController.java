package lightpurple.server.users;

import lightpurple.server.entitys.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersRepository UsersRepository;

    @GetMapping("/users")
    @ResponseBody
    public List<UserEntity> getUsers() {
        List<UserEntity> users = this.UsersRepository.findAll();

        return users;
    }

    @PostMapping("/users")
    @ResponseBody
    public UserEntity create(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        UserEntity newUser = new UserEntity();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        this.UsersRepository.save(newUser);
        return newUser;
    }

}
