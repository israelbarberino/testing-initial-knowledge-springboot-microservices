package com.br.cars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTOResponse {

    private Long idChassi ;

    private String name;

    private String brand;

    private String color;

    private String fabricationYear;

}
