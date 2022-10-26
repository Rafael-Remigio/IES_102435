package com.ies.lab3_2;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{


    
  List<Employee> findByEmailId (String emailId);

}