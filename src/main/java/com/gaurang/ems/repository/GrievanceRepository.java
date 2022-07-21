package com.gaurang.ems.repository;

import com.gaurang.ems.entity.Grievance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("grievanceRepository")
public interface GrievanceRepository extends JpaRepository<Grievance, Long> {
}
