package io.java.springbootquickstartapiserverdata.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    private List<Course> courses;

    public List<Course> getAllCourse() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id) {
//       return topics.stream().filter((t -> t.getId().equals(id))).findFirst().get();
       return courseRepository.findOne(id);
    }

    public void addCourse(Course course) {
//        topics.add(topic);
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        courseRepository.save(course);
//        for(int i = 0; i < topics.size(); i++) {
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)) {
//                topics.set(i, topic);
//                return;
//            }
//        }
    }

    public void deleteCourse(String id) {
        courseRepository.delete(id);
//        topics.removeIf(t -> t.getId().equals(id));
    }
}
