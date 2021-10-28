package com.crocusoft.courseApp.service.implementation;

import com.crocusoft.courseApp.dto.StudentDto;
import com.crocusoft.courseApp.entity.Course;
import com.crocusoft.courseApp.entity.Student;
import com.crocusoft.courseApp.repository.CourseRepo;
import com.crocusoft.courseApp.repository.StudentRepo;
import com.crocusoft.courseApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    final StudentRepo studentRepo;
    final CourseRepo courseRepo;
    final ModelMapper modelMapper;


    @Override
    public String createStudent(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
//  studentin dto-undan kursun idlerini goturub courseIdList reference-inde saxladim
        List<Long> courseIdList = studentDto.getCourseIdList();
        //yeni kurs list yaratdim
        List<Course> courses = new ArrayList<>();
//dto-dan gelen kurs id-lerin her birini repoda varsa yaratdigim liste elave edirem
        for (Long id : courseIdList) {
            courses.add(courseRepo.findById(id).orElseThrow(() -> new RuntimeException("Course id not found")));
        }
//alinmish listi studente set edirem
        student.setCourses(courses);
        studentRepo.save(student);


        return " new student saved";
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
//studenti id-e gore tapiriq
        Student student = studentRepo.findById(id).orElseThrow(
                () -> new RuntimeException("student with id:" + id + "  doesn't exist"));

//gelen entity-e dto-u set edirik
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setEmail(studentDto.getEmail());
        student.setAddress(studentDto.getAddress());

//kurs uchun bir list yaradiriq
        List<Course> list= new ArrayList<>();

//student dto-dan gelen kurs idlerin her birinin repoda varsa yaratdigimiz liste add edirik
        for (Long item : studentDto.getCourseIdList()) {
            list.add(courseRepo.findById(id).orElseThrow(() -> new RuntimeException("Course id not found")));
        }
        //studenti update edib save olan studenti maplayib qaytaririq
        student.setCourses(list);
        return modelMapper.map(studentRepo.save(student), StudentDto.class);
    }

    @Override
    public StudentDto getStudent(Long id) {
        Optional<Student> optStudent = studentRepo.findById(id);
        if (optStudent.isPresent()){
            return modelMapper.map(optStudent.get(),StudentDto.class);
        }
        else throw new RuntimeException("student with given id doesn't exist");
    }

    @Override
    public Boolean deleteStudent(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            studentRepo.deleteById(id);
            return true;
        }
        throw new RuntimeException("student with given id doesn't exist");

    }


    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        List<StudentDto> studentDtos = students
                .stream()
                .map(student -> modelMapper.map(student,StudentDto.class))
                .collect(Collectors.toList());
       return studentDtos;
    }
}
