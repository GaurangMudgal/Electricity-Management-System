package com.gaurang.ems.services;

import com.gaurang.ems.entity.Customer;
import com.gaurang.ems.entity.Grievance;
import com.gaurang.ems.repository.CustomerRepository;
import com.gaurang.ems.repository.GrievanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Optional;

@Service
public class Implementation implements MyService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private GrievanceRepository grievanceRepository;

    @Override
    public ResponseEntity<String> registerCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
            return ResponseEntity.of(Optional.of("Customer registered!"));
        } catch (Exception e) {
            return ResponseEntity.of(Optional.of("Sorry! Some error occurred"));
        }
    }

    @Override
    public ResponseEntity<String> getBillAmount(int unit) {
        try {
            float amount = 0.0f;
            if (unit <= 0) {
                return ResponseEntity.of(Optional.of("Units consumed are either 0 or invalid"));
            } else if (unit > 0 && unit <= 100) {
                amount = unit * 5;
            } else if (unit > 100 && unit <= 400) {
                amount = unit * 6;
            } else if (unit > 400) {
                amount = unit * 8;
            }
            double finalAmt = amount - (amount * 0.03);
            finalAmt += (finalAmt * 0.18);
            return ResponseEntity.of(Optional.of("Bill Amount is: " + new DecimalFormat("0.00")
                    .format(finalAmt)));
        } catch (Exception e) {
            return ResponseEntity.of(Optional.of("Sorry! Some error occurred"));
        }

    }

    @Override
    public ResponseEntity<String> submitGrievance(Grievance grievance) {
        try {
            grievanceRepository.save(grievance);
            return ResponseEntity.of(Optional.of("Query submitted!"));
        } catch (Exception e) {
            return ResponseEntity.of(Optional.of("Sorry! Some error occurred"));
        }
    }

}
