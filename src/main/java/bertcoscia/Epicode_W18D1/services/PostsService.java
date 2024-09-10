package bertcoscia.Epicode_W18D1.services;

import bertcoscia.Epicode_W18D1.entities.Post;
import bertcoscia.Epicode_W18D1.exceptions.NotFoundException;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PostsService {

    private List<Post> postList = new ArrayList<>();
    Faker faker = new Faker();

    public List<Post> findAll() {
        return this.postList;
    }

    public Post findById(int id) {
        Post found = null;
        for (Post post : postList) {
            if (post.getId() == id) found = post;
        }
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public Post save(Post body) {
        body.setId(faker.number().numberBetween(1, 100));
        body.setCover("https://picsum.photos/200/300");
        body.setBody(faker.lorem().fixedString(50));
        body.setReadingTime(faker.number().numberBetween(1, 15));
        this.postList.add(body);
        return body;
    }

    public Post findPostByIdAndUpdate(int id, Post updPost) {
        Post found = this.findById(id);
        found.setBody(updPost.getBody());
        found.setTitle(updPost.getTitle());
        found.setCategory(updPost.getCategory());
        found.setCover(updPost.getCover());
        found.setReadingTime(updPost.getReadingTime());
        return found;
    }

    public void findPostByIdAndDelete(int id) {
        Post found = this.findById(id);
        this.postList.remove(found);
    }
}
