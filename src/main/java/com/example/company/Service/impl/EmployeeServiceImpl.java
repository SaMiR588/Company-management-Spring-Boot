package com.example.company.Service.impl;

import com.example.company.Entity.Employee;
import com.example.company.Repository.EmployeeRepository;
import com.example.company.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        // Vérifier si l'employé encadre un stagiaire avant de le supprimer
        if (isEmployeeUsedAsSupervisor(id)) {
            // Afficher le message d'erreur approprié
            throw new RuntimeException("Cet employé est un encadreur de stagiaires et ne peut pas être supprimé.");
        } else {
            // Supprimer l'employé s'il n'encadre aucun stagiaire
            employeeRepository.deleteById(id);
        }
    }

    @Override
    public boolean isEmployeeUsedAsSupervisor(Long id) {
        // Vérifier si l'employé encadre un stagiaire
        return employeeRepository.existsByIdAndStagiairesIsNotEmpty(id);
    }
}
