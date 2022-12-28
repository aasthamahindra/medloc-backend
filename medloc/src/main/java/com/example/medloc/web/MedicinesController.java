package com.example.medloc.web;

import com.example.medloc.domain.Medicines;
import com.example.medloc.exception.MedicineIdException;
import com.example.medloc.repository.MedicinesRepository;
import com.example.medloc.service.MapValidationErrorService;
import com.example.medloc.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping("/medicines")
public class MedicinesController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private MedicinesRepository medicinesRepository;

    @GetMapping("/allMedicines")
    public List<Medicines> getAllComments() {
        return medicineService.listAll();
    }

    @PostMapping("/addMedicine")
    public  ResponseEntity<?> addMedicine(@RequestBody Medicines medicines, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!= null){
            return errorMap;
        }
        medicineService.addMedicine(medicines);
        return new ResponseEntity<>(medicines, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Medicines>> getMedicineById(@PathVariable(value = "id") Long id) {
        try{
            Optional<Medicines> medicines =medicineService.getMedicineById(id);
            return new ResponseEntity<>(medicines, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMedicine(@PathVariable(value = "id") Long id, @RequestBody Medicines medicines, BindingResult result) {
        try{
            ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
            if(errorMap!= null){
                return errorMap;
            }
            Optional<Medicines> getMedicine = medicineService.getMedicineById(id);
            Medicines medicine = getMedicine.get();
            medicineService.addMedicine(medicines);
            return new ResponseEntity<>("Updated Successfully\n" + medicine,HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMedicine(@PathVariable(value = "id") Long id) {
        medicineService.deleteMedicine(id);
        return new ResponseEntity<>("Medicine ID: " + id + " deleted", HttpStatus.OK);
    }
}
