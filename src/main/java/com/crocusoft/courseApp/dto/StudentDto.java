package com.crocusoft.courseApp.dto;

import com.crocusoft.courseApp.entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
        private String name;
        private String surname;
        private String email;
        private Address address;
        private List<Long> courseIdList;

    }


