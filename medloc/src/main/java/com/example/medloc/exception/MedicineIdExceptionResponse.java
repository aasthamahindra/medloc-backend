package com.example.medloc.exception;

public class MedicineIdExceptionResponse {
    private Long id;

    public MedicineIdExceptionResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
