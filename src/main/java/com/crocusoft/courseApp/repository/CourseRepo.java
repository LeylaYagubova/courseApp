package com.crocusoft.courseApp.repository;

import com.crocusoft.courseApp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
}
