package com.isoft.coursemanagement.repositories;

import com.isoft.coursemanagement.models.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
}
