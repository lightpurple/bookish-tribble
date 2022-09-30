package lightpurple.server.posts;

import lightpurple.server.entitys.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;

//    public List<PostEntity> getPosts() {
//        List<PostEntity> allPosts = postsRepository.findAll();
//        return allPosts;
//    }

    @Transactional
    public void createPost(PostsDTO postsDTO) {
        PostEntity newPost = new PostEntity();
        newPost.setTitle(postsDTO.getTitle());
        newPost.setContent(postsDTO.getContent());

        postsRepository.save(newPost);
    }
}
