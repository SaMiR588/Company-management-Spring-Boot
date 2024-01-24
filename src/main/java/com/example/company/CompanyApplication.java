package com.example.company;


import com.example.company.Entity.Employee;
import com.example.company.Entity.Stagiaire;
import com.example.company.Repository.EmployeeRepository;
import com.example.company.Repository.StagiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompanyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);
    }

    @Autowired
    private StagiaireRepository stagiaireRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void run(String... args) throws Exception {
    //    Stagiaire stagiaire1=new Stagiaire("Med Amine","Brahmi","Mohamedamine.brahmi@esprit.tn",1);
     //   stagiaireRepository.save(stagiaire1);
    //    Stagiaire stagiaire2=new Stagiaire("Med Iheb","Issaoui","Mohamediheb.Issaoui@esprit.tn",2);
    //    stagiaireRepository.save(stagiaire2);
    //    Stagiaire stagiaire3=new Stagiaire("Ikbel","Ben Mrad","ikbel.Benmrad@esprit.tn",3);
    //    stagiaireRepository.save(stagiaire3);
       // Stagiaire stagiaire4=new Stagiaire("Yassine","Messoudi","Yassine.Messoudi@esprit.tn",2);
    //    stagiaireRepository.save(stagiaire4);
       // Employee employee1=new Employee("Med Amine","Brahmi","Mohamedamine.brahmi@esprit.tn",1);
    //    employeeRepository.save(employee1);
    }

}
