package co.uk.howardpaget.cms.repository;

import co.uk.howardpaget.cms.model.Count;
import co.uk.howardpaget.cms.model.Post;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PostRepository extends MongoRepository<Post, String> {

  List<Post> findAllByPublishedDateTimeBetween(LocalDateTime from, LocalDateTime to);

  @Query("{ 'tags': { $all: ?0 } }")
  List<Post> findAllTaggedWith(List<String> tags);

  @Aggregation(pipeline = """
      {
        $group: {
          _id: { $dateToString: { date: '$publishedDateTime', format: '%Y-%m-01' } },
          count: { $sum: 1 }
        }
      }
      """)
  List<Count> countByMonth();
}
