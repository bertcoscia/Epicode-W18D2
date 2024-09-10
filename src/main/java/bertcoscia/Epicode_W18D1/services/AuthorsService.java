package bertcoscia.Epicode_W18D1.services;

import bertcoscia.Epicode_W18D1.entities.Author;
import bertcoscia.Epicode_W18D1.exceptions.NotFoundException;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorsService {

    private List<Author> authorList = new ArrayList<>();
    Faker faker = new Faker();


    public List<Author> findAll(){
        return this.authorList;
    }

    public Author findById(int id) {
        Author found = null;
        for (Author author : this.authorList) {
            if (author.getId() == id) found = author;
        }
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public Author save(Author body) {
        body.setId(faker.number().numberBetween(1, 100));
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getName() + "+" + body.getSurname());
        body.setEmail(body.getName().toLowerCase() + "." + body.getSurname().toLowerCase() + "@gmail.com");
        this.authorList.add(body);
        return body;
    }

    public Author findByIdAndUpdate(int id, Author updAuthor) {
        Author found = this.findById(id);
        found.setName(updAuthor.getName());
        found.setSurname(updAuthor.getSurname());
        found.setEmail(updAuthor.getEmail());
        found.setBirthDate(updAuthor.getBirthDate());
        return found;
    }

    public void findByIdAndDelete(int id) {
        Author found = this.findById(id);
        this.authorList.remove(found);
    }
}
