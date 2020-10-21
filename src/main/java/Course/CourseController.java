package Course;

import Topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

        @RequestMapping("/topics/{topicId}/courses")
        public List<Course> getAllCourses(@PathVariable String topicId) {
            return courseService.getAllCourses(topicId);
        }

        @RequestMapping("/topics/{topicId}/courses/{courseId}")
        public Course getCourse(@PathVariable String courseId) {
            return courseService.getCourse(courseId);
        }

        @PostMapping(value = "/topics/{topicId}/courses")
        public void addCourse(@RequestBody Course course,@PathVariable String topicId)
        {
            System.out.println("POST ");
            course.setTopic(new Topic(topicId,"",""));
            courseService.addCourse(course);
        }

        @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
        public void updateCourse(@RequestBody Course course, @PathVariable String courseId, @PathVariable String topicId) {
            course.setTopic(new Topic(topicId,"",""));
            courseService.updateCourse(course);
        }

        @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}")
        public void deleteCourse(@PathVariable String courseId) {
            courseService.deleteCourse(courseId);
        }
    }

