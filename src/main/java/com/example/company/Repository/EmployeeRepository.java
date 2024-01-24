package com.example.company.Repository;

import com.example.company.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Vérifier si l'employé est utilisé comme encadreur de stagiaires
    boolean existsByIdAndStagiairesIsNotEmpty(Long id);
}
