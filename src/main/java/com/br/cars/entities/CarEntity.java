package com.br.cars.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Table(name="cars")
@Entity

public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Convert(converter = IdChassiGenerator.class)        // Classe de geração de ID, porém não consigo chama-la
    private Long idChassi;

    @Column(name = "name")
    private String name;
    @Column(name = "brand")
    private String brand;
    @Column(name = "color")
    private String color;
    @Column(name = "fabricationYear")
    private String fabricationYear;

    // GETTERS E SETTERS

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
