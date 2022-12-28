package com.example.medloc.service;

import com.example.medloc.domain.Medicines;
import com.example.medloc.repository.MedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicineService {

    @Autowired
    private MedicinesRepository medicinesRepository;

    public List<Medicines> listAll(){
        return medicinesRepository.findAll();
    }

    public void addMedicine(Medicines medicines){

        medicinesRepository.save(medicines);
    }

    public Optional<Medicines> getMedicineById(Long id){
        return medicinesRepository.findById(id);
    }

    public void deleteMedicine(Long id){
            medicinesRepository.deleteById(id);
    }
}
