package com.crocusoft.courseApp.repository;

import com.crocusoft.courseApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
