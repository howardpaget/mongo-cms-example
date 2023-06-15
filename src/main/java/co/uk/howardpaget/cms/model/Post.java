package co.uk.howardpaget.cms.model;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("posts")
public class Post {

  @Id
  private final String id;

  private String title;
  private String authorId;
  private String author;
  private LocalDateTime publishedDateTime;
  private List<String> tags;
  private String body;

  public Post(String id, String title, String authorId, String author,
      LocalDateTime publishedDateTime, List<String> tags, String body) {
    this.id = id;
    this.title = title;
    this.authorId = authorId;
    this.author = author;
    this.publishedDateTime = publishedDateTime;
    this.tags = tags;
    this.body = body;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthorId() {
    return authorId;
  }

  public String getAuthor() {
    return author;
  }

  public LocalDateTime getPublishedDateTime() {
    return publishedDateTime;
  }

  public List<String> getTags() {
    return tags;
  }

  public String getBody() {
    return body;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthorId(String authorId) {
    this.authorId = authorId;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setPublishedDateTime(LocalDateTime publishedDateTime) {
    this.publishedDateTime = publishedDateTime;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public void setBody(String body) {
    this.body = body;
  }
}
