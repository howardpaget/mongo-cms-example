package co.uk.howardpaget.cms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Count {

  @Id
  private final String id;

  private final int count;

  public Count(String id, int count) {
    this.id = id;
    this.count = count;
  }

  public String getId() {
    return id;
  }

  public Integer getCount() {
    return count;
  }
}
