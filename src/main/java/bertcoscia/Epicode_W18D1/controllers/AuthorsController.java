package bertcoscia.Epicode_W18D1.controllers;

import bertcoscia.Epicode_W18D1.entities.Author;
import bertcoscia.Epicode_W18D1.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    AuthorsService authorsService;

    // GET http://localhost:3001/authors
    @GetMapping
    private List<Author> getAllAuthors() {
        return authorsService.findAll();
    }

    // GET http://localhost:3001/authors/{authorId}
    @GetMapping("/{authorId}")
    private Author getAuthorById(@PathVariable int authorId) {
        return authorsService.findById(authorId);
    }

    // POST http://localhost:3001/authors + body
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Author createAuthor(@RequestBody Author body) {
        return authorsService.save(body);
    }

    // PUT http://localhost:3001/authors/{authorId}
    @PutMapping("/{authorId}")
    private Author findAuthorByIdAndUpdate(@PathVariable int authorId, @RequestBody Author body) {
        return authorsService.findByIdAndUpdate(authorId, body);
    }

    // DELETE http://localhost:3001/authors/{authorId}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{authorId}")
    private void findAuthorByIdAndDelete(@PathVariable int authorId) {
        authorsService.findByIdAndDelete(authorId);
    }

}
