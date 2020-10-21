package Course;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends CrudRepository <Course, String> {

    @Query("select co from course co where co.topic_id in :topicId")
    List<Course> findByTopicId (@Param("topicId") String ids);

}
