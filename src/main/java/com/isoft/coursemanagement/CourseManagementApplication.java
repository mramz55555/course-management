package com.isoft.coursemanagement;

import com.isoft.coursemanagement.models.Course;
import com.isoft.coursemanagement.models.Student;
import com.isoft.coursemanagement.repositories.CourseRepository;
import com.isoft.coursemanagement.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CourseManagementApplication implements CommandLineRunner {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseManagementApplication(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CourseManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Course math = new Course("math");
        Course physics = new Course("physics");
        Course chemistry = new Course("chemistry");

        Student ali = new Student("Ali");
        ali.getCourses().add(math);

        Student hossein = new Student("Hossein");
        hossein.getCourses().add(math);
        hossein.getCourses().add(physics);

        Student hassan = new Student("Hassan");
        hassan.getCourses().add(math);
        hassan.getCourses().add(physics);
        hassan.getCourses().add(chemistry);

        math.getStudents().add(ali);
        math.getStudents().add(hossein);
        math.getStudents().add(hassan);

        physics.getStudents().add(hossein);
        physics.getStudents().add(hassan);

        chemistry.getStudents().add(hassan);

        courseRepository.saveAll(List.of(math, physics, chemistry));
        studentRepository.saveAll(List.of(ali, hassan, hossein));


    }
}
