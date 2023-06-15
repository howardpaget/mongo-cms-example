package co.uk.howardpaget.cms.repository;

import co.uk.howardpaget.cms.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {

}
