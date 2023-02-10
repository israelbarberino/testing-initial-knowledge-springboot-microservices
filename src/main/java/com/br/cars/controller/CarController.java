package com.br.cars.controller;

import com.br.cars.dto.CarDTORequest;
import com.br.cars.dto.CarDTOResponse;
import com.br.cars.entities.CarEntity;
import com.br.cars.exception.CarNotFoundException;
import com.br.cars.repository.CarRepository;
import com.br.cars.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/post")
    public ResponseEntity<CarDTOResponse> saveCar(@RequestBody @Valid CarDTORequest carDTORequest) {
        CarService.carValidation(carDTORequest);
        CarDTOResponse carDTOResponse = carService.saveCar(carDTORequest);
        return ResponseEntity.ok(carDTOResponse);
    }


    @GetMapping("/get/{idChassi}")
    public ResponseEntity<CarDTOResponse> getById(@PathVariable Long idChassi){
        CarEntity carEntity = carRepository.findById(idChassi).orElseThrow(()
                -> new CarNotFoundException("Car Chassi number: " + idChassi + " please retype and try again."));
        CarDTOResponse carDTOResponse = modelMapper.map(carEntity, CarDTOResponse.class);
        return ResponseEntity.ok(carDTOResponse);
    }
}