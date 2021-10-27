package com.crocusoft.courseApp.repository;

import com.crocusoft.courseApp.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Courses, Long> {
}
