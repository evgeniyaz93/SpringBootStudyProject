package Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("lalala", "lalala lalala", "lalala lalala Description", "Java"),
            new Course("tatata", "tatata tatata", "tatata tatata Description", "Spring"),
            new Course("kakaka", "kakaka kakaka ", "kakaka kakaka Description","JavaScript")
    ));

    public List<Course> getAllCourses(String topicId) {

        //return topics;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Course getCourse(String courseId) {
       // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(courseId).orElse(null);
    }

    public void addCourse(Course course) {

        //topics.add(topic);
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
//        for (int i = 0; i < topics.size(); i++) {
//            Topic.Topic t = topics.get(i);
//            if (t.getId().equals(id)) {
//                topics.set(i, topic);
//                return;
//            }
//        }
        courseRepository.save(course);
    }

    public void deleteCourse(String courseId) {
      //topics.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(courseId);
    }
}

