package co.uk.howardpaget.cms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("authors")
public class Author {

  @Id
  private final String id;

  private String name;
  private String bio;

  public Author(String id, String name, String bio) {
    this.id = id;
    this.name = name;
    this.bio = bio;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getBio() {
    return bio;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }
}
