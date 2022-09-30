package lightpurple.server.users;

import lightpurple.server.entitys.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public List<UsersDTO> getUsers() {
        List<UserEntity> allUsers = usersRepository.findAll();
        List<UsersDTO> ret = new ArrayList<>();


        for (UserEntity user : allUsers) {
            UsersDTO tmpUser = new UsersDTO();
            tmpUser.setName(user.getName());
            tmpUser.setEmail(user.getEmail());
            tmpUser.setPassword(null);
            ret.add(tmpUser);
        }

        return ret;
    }

    @Transactional
    public void create(UsersDTO usersDTO) {
        UserEntity newUser = new UserEntity();
        newUser.setName(usersDTO.getName());
        newUser.setEmail(usersDTO.getEmail());
        newUser.setPassword(usersDTO.getPassword());
        usersRepository.save(newUser);
    }
}
