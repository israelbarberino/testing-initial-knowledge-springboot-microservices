package com.br.cars.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class CarDTORequest {
    @NotNull
    private Long idChassi;

    @NotBlank
    @Size(max = 150)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String brand;

    @NotBlank
    @Size(max = 20)
    private String color;

    @NotBlank
    @Size(max = 4)
    private String fabricationYear;

    private static final Set<String> ALLOWED_BRANDS = Set.of("Ford", "Chevrolet", "BMW", "Volvo");

    public Long getIdChassi() {
        return idChassi;
    }

    public void setIdChassi(Long idChassi) {
        this.idChassi = idChassi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (!ALLOWED_BRANDS.contains(brand)) {
            throw new IllegalArgumentException("Invalid brand: " + brand);
        }
        this.brand = brand.toLowerCase();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color.toLowerCase();
    }

    public String getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(String fabricationYear) {
        this.fabricationYear = fabricationYear;
    }
}
