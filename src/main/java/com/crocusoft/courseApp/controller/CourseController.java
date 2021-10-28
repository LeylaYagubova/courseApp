package com.crocusoft.courseApp.controller;

import com.crocusoft.courseApp.dto.CourseDto;
import com.crocusoft.courseApp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {
    final
    CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto){
       CourseDto newCourse =  courseService.createCourse(courseDto);
        return ResponseEntity.ok(newCourse);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getCourses(){
        List<CourseDto> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable("id") Long id){
       CourseDto courseDto = courseService.getCourse(id);
       return ResponseEntity.ok(courseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable("id")Long id, @RequestBody CourseDto courseDto){
        CourseDto updatedCourse = courseService.updateCourse(id,courseDto);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCourse(@PathVariable("id") Long id){
        Boolean status = courseService.deleteCourse(id);
        return ResponseEntity.ok(status);
    }
}
