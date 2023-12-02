package io.java.springbootquickstartapiserverdata.course;

import io.java.springbootquickstartapiserverdata.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getAllCourse();

    }

    @RequestMapping("/topics/{id}/courses/{courseId}")
    public Course getCourse(@PathVariable String id, @PathVariable String courseId) {
        return courseService.getCourse(id);

    }


    @RequestMapping(method = RequestMethod.POST, value = "/topics/{id}/courses/{courseId}")
    public void addCourse(@RequestBody Course course, @PathVariable String id) {
        course.setTopic(new Topic(id, "", ""));
        courseService.addCourse(course);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}/courses/{courseId}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id) {
        course.setTopic(new Topic(id, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourse(courseId);
    }
}
