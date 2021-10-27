package com.crocusoft.courseApp.controller;

import com.crocusoft.courseApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    final
    StudentService studentService;

}
