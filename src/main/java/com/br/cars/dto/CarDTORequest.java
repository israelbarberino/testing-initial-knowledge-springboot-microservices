package com.br.cars.dto;

import javax.validation.constraints.NotBlank;

public class CarDTORequest {

    @NotBlank
    private String name;

    @NotBlank
    private String brand;

    @NotBlank
    private String color;

    @NotBlank
    private String fabricationYear;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(String fabricationYear) {
        this.fabricationYear = fabricationYear;
    }
}

