package lightpurple.server.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;

    @GetMapping
    public ResponseEntity getPosts() {
        List<PostsDTO> allUsers = postsService.getPosts();

        return new ResponseEntity(allUsers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createPost(@RequestParam String title, @RequestParam String content) {
        PostsDTO postsDTO = new PostsDTO();
        postsDTO.setTitle(title);
        postsDTO.setContent(content);

        postsService.createPost(postsDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
