package com.crocusoft.courseApp.service;

import com.crocusoft.courseApp.dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
     CourseDto createCourse(CourseDto courseDto);
     CourseDto updateCourse(Long id,CourseDto courseDto);
     CourseDto getCourse(Long id);
     Boolean deleteCourse(Long id);
     List<CourseDto> getAllCourses();

}