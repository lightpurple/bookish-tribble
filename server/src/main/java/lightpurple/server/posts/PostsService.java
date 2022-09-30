package lightpurple.server.posts;

import lightpurple.server.entitys.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;

    public List<PostsDTO> getPosts() {
        List<PostEntity> allPosts = postsRepository.findAll();
        List<PostsDTO> ret = new ArrayList<>();

        for (PostEntity post : allPosts) {
            PostsDTO tmp = new PostsDTO();

            tmp.setTitle(post.getTitle());
            tmp.setContent(post.getContent());
            ret.add(tmp);
        }
        return ret;
    }

    @Transactional
    public void createPost(PostsDTO postsDTO) {
        PostEntity newPost = new PostEntity();
        newPost.setTitle(postsDTO.getTitle());
        newPost.setContent(postsDTO.getContent());

        postsRepository.save(newPost);
    }
}
