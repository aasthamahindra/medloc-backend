package com.example.medloc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Medicines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Medicine name is required")
    private String medicineName;

    @NotBlank(message = "Description is required")
    @Size(max = 100000)
    private String medicineDescription;

    @NotBlank(message = "Type is required")
    private String medicineType;

    @NotBlank(message = "Catergory is required")
    private String medicineCategory;

    //Constructors
    public Medicines() {
    }

    public Medicines(Long id, String medicineName, String medicineDescription, String medicineType, String medicineCategory) {
        this.id = id;
        this.medicineName = medicineName;
        this.medicineDescription = medicineDescription;
        this.medicineType = medicineType;
        this.medicineCategory = medicineCategory;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineDescription() {
        return medicineDescription;
    }

    public void setMedicineDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public String getMedicineCategory() {
        return medicineCategory;
    }

    public void setMedicineCategory(String medicineCategory) {
        this.medicineCategory = medicineCategory;
    }
}
