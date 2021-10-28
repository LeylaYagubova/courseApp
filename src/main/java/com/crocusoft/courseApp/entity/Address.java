package com.crocusoft.courseApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String district;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Student student;

}
