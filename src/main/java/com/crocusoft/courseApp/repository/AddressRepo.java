package com.crocusoft.courseApp.repository;

import com.crocusoft.courseApp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepo extends JpaRepository<Address, Long> {
    @Override
    List<Address> findAll();
}
