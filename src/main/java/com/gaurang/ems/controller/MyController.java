package com.gaurang.ems.controller;

import com.gaurang.ems.entity.Customer;
import com.gaurang.ems.entity.Grievance;
import com.gaurang.ems.services.Implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private Implementation implementation;

    @PostMapping("/registerUser")
    public ResponseEntity<String > registerUser(@RequestBody Customer customer) {
        try {
            return implementation.registerCustomer(customer);
        } catch (Exception e) {
            return ResponseEntity.of(Optional.of("Sorry! Some error occurred"));
        }
    }

    @GetMapping("/getBill")
    public ResponseEntity<String> getBillAmount(@RequestParam(name = "unit") int unit) {
        try {
            return implementation.getBillAmount(unit);
        } catch (Exception e) {
            return ResponseEntity.of(Optional.of("Sorry! Some error occurred"));
        }
    }

    @PostMapping("/grievance")
    public ResponseEntity<String> grievance(@RequestBody Grievance grievance) {
        try {
            return implementation.submitGrievance(grievance);
        } catch (Exception e) {
            return ResponseEntity.of(Optional.of("Sorry! Some error occurred"));
        }
    }

}
