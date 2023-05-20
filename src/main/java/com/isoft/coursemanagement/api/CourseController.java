package com.isoft.coursemanagement.api;

import com.isoft.coursemanagement.models.Course;
import com.isoft.coursemanagement.models.Student;
import com.isoft.coursemanagement.repositories.CourseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController()
@RequestMapping("/courses")
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable int id) {
        return courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("course with id: " + id + " not found"));
    }

    @GetMapping("/{id}/students")
    public Set<Student> getStudent(@PathVariable int id) {
        return getCourse(id).getStudents();
    }
}
