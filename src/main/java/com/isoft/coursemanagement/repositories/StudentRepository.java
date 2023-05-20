package com.isoft.coursemanagement.repositories;

import com.isoft.coursemanagement.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
