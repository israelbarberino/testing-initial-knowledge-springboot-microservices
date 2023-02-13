package com.br.cars.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CarDTORequest {

    @NotBlank
    @Size(min=1, message = "Car name must have at least 1 characters")
    @Size(max=50, message = "Car name it too long! Maximum 50 characters")
    private String name;

    @NotBlank
    @Size(min=1, message = "Brand must have at least 1 characters")
    @Size(max=50, message = "Brand too long! Maximum 50 characters")
    private String brand;

    @NotBlank
    @Size(min=3, message = "Hey! There is no color with less than 3 characters!")
    @Size(max=20, message = "Color too long! Maximum 20 characters")
    private String color;

    @NotBlank
    @Size(min=9, message = "Fabrication Yer needs must be in this format: 0000/0000")
    @Size(max=9, message = "Fabrication Yer needs must be in this format: 0000/0000")
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

