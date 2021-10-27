package com.crocusoft.courseApp.repository;

import com.crocusoft.courseApp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
