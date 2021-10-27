package com.crocusoft.courseApp.service.implementation;

import com.crocusoft.courseApp.repository.AddressRepo;
import com.crocusoft.courseApp.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    final
    AddressRepo addressRepo;

}
