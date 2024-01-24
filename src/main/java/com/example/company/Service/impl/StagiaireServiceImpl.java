package com.example.company.Service.impl;

import com.example.company.Entity.Stagiaire;
import com.example.company.Repository.StagiaireRepository;
import com.example.company.Service.StagiaireService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public  class StagiaireServiceImpl implements StagiaireService {
private StagiaireRepository stagiaireRepository;
    public StagiaireServiceImpl(StagiaireRepository stagiaireRepository) {
        super();
        this.stagiaireRepository = stagiaireRepository;
    }
    @Override
    public List<Stagiaire> getAllStagiaires(){

        return stagiaireRepository.findAll();
}
    @Override
    public Stagiaire saveStagiaire(Stagiaire stagiaire){
        return stagiaireRepository.save(stagiaire);
    }
    @Override
    public Stagiaire getStagiaireById(Long id){
        return stagiaireRepository.findById(id).get();
    }
    @Override
    public Stagiaire updateStagiaire(Stagiaire stagiaire){
        return stagiaireRepository.save(stagiaire);
    }
    @Override
    public void deleteStagiaireById(Long id){
        stagiaireRepository.deleteById(id);
    }

}
