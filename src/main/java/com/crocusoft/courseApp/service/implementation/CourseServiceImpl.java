package com.crocusoft.courseApp.service.implementation;

import com.crocusoft.courseApp.dto.CourseDto;
import com.crocusoft.courseApp.entity.Course;
import com.crocusoft.courseApp.repository.CourseRepo;
import com.crocusoft.courseApp.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    final CourseRepo courseRepo;
    final ModelMapper modelMapper;



    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = modelMapper.map(courseDto, Course.class);
        return modelMapper.map(courseRepo.save(course),CourseDto.class);
    }

    @Override
    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        // id-e gore kursu axtar, yoxdursa exception
        Course course = courseRepo.findById(id).orElseThrow(
                () -> new RuntimeException("student with id" + id + "doesn't exist")
        );
        //id ile kursu getirdikden sonra, dto ichindeki field-lari entity fieldlara set edirik
        course.setName(courseDto.getName());
        //sonra cliente maplayaraq qaytaririq
        return modelMapper.map(courseRepo.save(course), CourseDto.class);


    }

    @Override
    public CourseDto getCourse(Long id) {
       Optional<Course> course = courseRepo.findById(id);
       if (course.isPresent()){
           return modelMapper.map(course.get(),CourseDto.class);
       }else {
           throw new RuntimeException("course with given id not found");
       }
    }

    @Override
    public Boolean deleteCourse(Long id) {
        Optional<Course> course = courseRepo.findById(id);
        if (course.isPresent()) {
            courseRepo.deleteById(id);
            return true;
        }
        throw new RuntimeException("course with given id doesn't exist");
    }

    @Override
    public List<CourseDto> getAllCourses() {
       List<Course> courses = courseRepo.findAll();
       List<CourseDto> courseDtos =     courses.stream().map(course -> modelMapper.map(course,CourseDto.class)).collect(Collectors.toList());
       return courseDtos;
    }
}
