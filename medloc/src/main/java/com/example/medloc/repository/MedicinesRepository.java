package com.example.medloc.repository;

import com.example.medloc.domain.Medicines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicinesRepository extends JpaRepository<Medicines, Long> {

    Optional<Medicines> findByMedicineName(String medicineName);
}
