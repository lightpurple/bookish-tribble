package lightpurple.server.users.controller;

import lightpurple.server.models.Users;
import lightpurple.server.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    @ResponseBody
    public List<Users> getUsers() {
        List<Users> users = this.userRepository.findAll();

        return users;
    }

    @PostMapping("/users")
    @ResponseBody
    public Users create(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        Users newUser = new Users();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        this.userRepository.save(newUser);
        return newUser;
    }

}
