package lightpurple.server.users;

import lightpurple.server.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserEntity, Integer> {

}
