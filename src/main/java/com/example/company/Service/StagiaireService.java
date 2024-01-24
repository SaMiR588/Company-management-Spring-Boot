package com.example.company.Service;

import com.example.company.Entity.Stagiaire;

import java.util.List;

public interface StagiaireService {
    List<Stagiaire> getAllStagiaires();
    Stagiaire saveStagiaire(Stagiaire stagiaire);
    Stagiaire getStagiaireById(Long id);
    Stagiaire updateStagiaire(Stagiaire stagiaire);
    void deleteStagiaireById(Long id);
}
