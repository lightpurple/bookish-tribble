package lightpurple.server.posts;

import lightpurple.server.entitys.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<PostEntity, Integer> {

}
