package com.crocusoft.courseApp.service.implementation;

import com.crocusoft.courseApp.repository.StudentRepo;
import com.crocusoft.courseApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    final
    StudentRepo studentRepo;


}
