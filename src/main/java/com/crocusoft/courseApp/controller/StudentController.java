package com.crocusoft.courseApp.controller;

import com.crocusoft.courseApp.dto.StudentDto;
import com.crocusoft.courseApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
    final
    StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<String> createStudent(@RequestBody StudentDto studentDto){
        String createdStudent = studentService.createStudent(studentDto);
        return ResponseEntity.ok("Student created ");
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long id, @RequestBody StudentDto studentDto){
        StudentDto updatedStudent = studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok(updatedStudent);

    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent (@PathVariable("id") Long id){
        StudentDto student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable("id") Long id){
         Boolean status =studentService.deleteStudent(id);
        return ResponseEntity.ok(status);

    }
    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);



    }






}
