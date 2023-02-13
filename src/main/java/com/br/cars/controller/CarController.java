package com.br.cars.controller;

import com.br.cars.dto.CarDTORequest;
import com.br.cars.dto.CarDTOResponse;
import com.br.cars.entities.CarEntity;
import com.br.cars.exception.CarNotFoundException;
import com.br.cars.repository.CarRepository;
import com.br.cars.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ModelMapper modelMapper;

    //METODO PARA SALVAR
    @PostMapping("/post")
    public ResponseEntity<CarDTOResponse> saveCar(@RequestBody @Valid CarDTORequest carDTORequest) {
        CarService.fieldValidation(carDTORequest);
        CarService.brandValidation(carDTORequest);
        CarDTOResponse carDTOResponse = carService.saveCar(carDTORequest);
        return ResponseEntity.ok(carDTOResponse);
    }

    //METODO PARA RETORNAR UM DADO DA BASE
    @GetMapping("/get/{idChassi}")
    public Object getById(@PathVariable Long idChassi){
        try {
            CarEntity carEntity = carRepository.findById(idChassi).orElseThrow(()
                    -> new CarNotFoundException("idChassi not found."));
            CarDTOResponse carDTOResponse = modelMapper.map(carEntity, CarDTOResponse.class);
            return ResponseEntity.ok(carDTOResponse);
        } catch (CarNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

}