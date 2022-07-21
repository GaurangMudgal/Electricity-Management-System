package com.gaurang.ems.services;

import com.gaurang.ems.entity.Customer;
import com.gaurang.ems.entity.Grievance;
import org.springframework.http.ResponseEntity;

public interface MyService {

    public ResponseEntity<String> registerCustomer(Customer customer);
    public ResponseEntity<String> getBillAmount(int unit);
    public ResponseEntity<String> submitGrievance(Grievance grievance);

}
