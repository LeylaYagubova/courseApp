package com.crocusoft.courseApp.service;

import com.crocusoft.courseApp.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
     String createStudent(StudentDto studentDto);
     StudentDto updateStudent(Long id,StudentDto studentDto);
     StudentDto getStudent(Long id);
     Boolean deleteStudent(Long id);
     List<StudentDto> getAllStudents();


}
