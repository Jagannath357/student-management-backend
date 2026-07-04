package com.edu.scms.repository;

import com.edu.scms.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Custom search query to look up courses matching any subset of text
    List<Course> findByCourseNameContainingIgnoreCase(String courseName);
}