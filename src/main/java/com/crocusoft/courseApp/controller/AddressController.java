package com.crocusoft.courseApp.controller;

import com.crocusoft.courseApp.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {
    final
    AddressService addressService;

}
