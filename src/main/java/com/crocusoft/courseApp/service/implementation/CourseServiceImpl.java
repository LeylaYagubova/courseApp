package com.crocusoft.courseApp.service.implementation;

import com.crocusoft.courseApp.repository.CourseRepo;
import com.crocusoft.courseApp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    final
    CourseRepo courseRepo;

}
