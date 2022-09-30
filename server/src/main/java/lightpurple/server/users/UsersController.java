package lightpurple.server.users;

import lightpurple.server.entitys.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping()
    public ResponseEntity getUsers() {
        List<UsersDTO> users = usersService.getUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity create(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setName(name);
        usersDTO.setEmail(email);
        usersDTO.setPassword(password);

        usersService.create(usersDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

