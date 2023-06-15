package co.uk.howardpaget.cms.controller;

import co.uk.howardpaget.cms.controller.dto.AuthorRequest;
import co.uk.howardpaget.cms.controller.dto.PostRequest;
import co.uk.howardpaget.cms.model.Author;
import co.uk.howardpaget.cms.model.Post;
import co.uk.howardpaget.cms.repository.AuthorRepository;
import co.uk.howardpaget.cms.repository.PostRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class AuthorController {

  private final AuthorRepository authorRepository;

  public AuthorController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @PostMapping("/authors")
  public Author createPost(@Valid @RequestBody AuthorRequest author) {
    return authorRepository.save(new Author(null, author.name(), author.bio()));
  }
}
