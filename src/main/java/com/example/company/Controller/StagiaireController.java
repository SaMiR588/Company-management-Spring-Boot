package com.example.company.Controller;

import com.example.company.Entity.Stagiaire;
import com.example.company.Entity.Employee;
import com.example.company.Service.StagiaireService;
import com.example.company.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StagiaireController {

    @Autowired
    private StagiaireService stagiaireService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/stagiaires")
    public String listStagiaires(Model model) {
        List<Stagiaire> stagiaires = stagiaireService.getAllStagiaires();
        model.addAttribute("stagiaires", stagiaires);
        return "stagiaires"; // Assuming there is a template named "stagiaires.html" in the templates folder
    }

    @GetMapping("/stagiaires/new")
    public String showStagiaireForm(Model model) {
        Stagiaire stagiaire = new Stagiaire();
        model.addAttribute("stagiaire", stagiaire);

        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        return "create_stagiaire"; // Assuming there is a template named "create_stagiaire.html" in the templates folder
    }

    @PostMapping("/stagiaires/new")
    public String saveStagiaire(@ModelAttribute("stagiaire") Stagiaire stagiaire) {
        stagiaireService.saveStagiaire(stagiaire);
        return "redirect:/stagiaires";
    }

    @GetMapping("/stagiaires/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Stagiaire stagiaire = stagiaireService.getStagiaireById(id);
        model.addAttribute("stagiaire", stagiaire);

        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        return "edit_stagiaire"; // Assuming there is a template named "edit_stagiaire.html" in the templates folder
    }

    @PostMapping("/stagiaires/edit/{id}")
    public String updateStagiaire(@PathVariable("id") Long id, @ModelAttribute("stagiaire") Stagiaire stagiaire) {
        Stagiaire existingStagiaire = stagiaireService.getStagiaireById(id);
        if (existingStagiaire != null) {
            existingStagiaire.setFirstName(stagiaire.getFirstName());
            existingStagiaire.setLastName(stagiaire.getLastName());
            existingStagiaire.setEmail(stagiaire.getEmail());
            existingStagiaire.setEncadrerPar(stagiaire.getEncadrerPar());

            stagiaireService.saveStagiaire(existingStagiaire);
        }
        return "redirect:/stagiaires";
    }

    @PostMapping("/stagiaires/delete/{id}")
    public String deleteStagiaire(@PathVariable("id") Long id) {
        stagiaireService.deleteStagiaireById(id);
        return "redirect:/stagiaires";
    }
}
