package co.uk.howardpaget.cms.controller;

import co.uk.howardpaget.cms.controller.dto.PostRequest;
import co.uk.howardpaget.cms.model.Author;
import co.uk.howardpaget.cms.model.Count;
import co.uk.howardpaget.cms.model.Post;
import co.uk.howardpaget.cms.repository.AuthorRepository;
import co.uk.howardpaget.cms.repository.PostRepository;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class PostController {

  private final PostRepository postRepository;
  private final AuthorRepository authorRepository;

  public PostController(PostRepository postRepository, AuthorRepository authorRepository) {
    this.postRepository = postRepository;
    this.authorRepository = authorRepository;
  }

  @PostMapping("/posts")
  public Post createPost(@Valid @RequestBody PostRequest post) {
    Author author = authorRepository.findById(post.authorId()).orElseThrow();

    return postRepository.save(new Post(null, post.title(), post.authorId(), author.getName(), post.publishedDateTime(),
        post.tags(), post.body()));
  }

  @GetMapping("/posts")
  public List<Post> getPosts(@RequestParam(required = false) List<String> tags,
      @RequestParam(required = false) LocalDateTime from, @RequestParam(required = false) LocalDateTime to) {
    if (tags != null && !tags.isEmpty()) {
      return postRepository.findAllTaggedWith(tags);
    }

    if (from != null && to != null) {
      return postRepository.findAllByPublishedDateTimeBetween(from, to);
    }

    return postRepository.findAll();
  }

  @GetMapping("/posts/summary")
  public List<Count> getPostsSummary() {
    return postRepository.countByMonth();
  }
}
