package bertcoscia.Epicode_W18D1.controllers;

import bertcoscia.Epicode_W18D1.entities.Post;
import bertcoscia.Epicode_W18D1.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class PostsController {

    @Autowired
    PostsService postsService;

    // GET http://localhost:3001/blogPosts
    @GetMapping
    public List<Post> getAllPosts() {
        return postsService.findAll();
    }

    // GET http://localhost:3001/blogPosts/{postId}
    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable int postId) {
        return postsService.findById(postId);
    }

    // POST http://localhost:3001/blogPosts
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Post createPost(@RequestBody Post body) {
        return postsService.save(body);
    }

    // PUT http://localhost:3001/blogPosts/{postId}
    @PutMapping("/{postId}")
    public Post findPostByIdAndUpdate(@PathVariable int postId, @RequestBody Post body) {
        return postsService.findPostByIdAndUpdate(postId, body);
    }

    // DELETE http://localhost:3001/blogPosts/{postId}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{postId}")
    public void findPostByIdAndDelete(@PathVariable int postId) {
        postsService.findPostByIdAndDelete(postId);
    }

}
