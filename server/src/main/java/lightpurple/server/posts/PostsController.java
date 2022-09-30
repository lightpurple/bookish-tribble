package lightpurple.server.posts;

import lightpurple.server.entitys.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;

    @PostMapping()
    @ResponseBody
    public ResponseEntity getPosts(@RequestParam String title, @RequestParam String content) {
        PostsDTO postsDTO = new PostsDTO();
        postsDTO.setTitle(title);
        postsDTO.setContent(content);

        postsService.createPost(postsDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
