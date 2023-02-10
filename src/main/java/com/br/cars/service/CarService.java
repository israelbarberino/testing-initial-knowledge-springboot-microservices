package com.br.cars.service;

import com.br.cars.dto.CarDTORequest;
import com.br.cars.dto.CarDTOResponse;
import com.br.cars.entities.CarEntity;
import com.br.cars.exception.BadRequestException;
import com.br.cars.exception.CarNotFoundException;
import com.br.cars.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CarRepository carRepository;


    public CarDTOResponse saveCar(CarDTORequest carRequest) {
        CarEntity carEntity = modelMapper.map(carRequest, CarEntity.class);
        carRepository.save(carEntity);
        CarDTOResponse carDTOResponse = modelMapper.map(carEntity, CarDTOResponse.class);
        return carDTOResponse;
    }

    public CarDTOResponse getById(Long idChassi) {
        Optional<CarEntity> repositoryById = carRepository.findById(idChassi);
        if (!repositoryById.isPresent()) {
            throw new CarNotFoundException("Car Chassi number: " + idChassi + " not found.");
        }
        CarDTOResponse carDTOResponse = modelMapper.map(repositoryById.get(), CarDTOResponse.class);
        return carDTOResponse;
    }

    public static CarDTOResponse carValidation(@Valid CarDTORequest carDTORequest) {

        // VALIDANDO A BRAND (MARCA)
        List<String> validBrands = Arrays.asList("Ford", "Chevrolet", "BMW", "Volvo");
        if (!validBrands.contains(carDTORequest.getBrand())) {
            throw new BadRequestException("Invalid brand: " + carDTORequest.getBrand());
        }

        // VALIDANDO OS CAMPOS QUE NÃO PODEM SER NULOS
        if (carDTORequest.getName() == null
                || carDTORequest.getBrand() == null
                || carDTORequest.getColor() == null
                || carDTORequest.getFabricationYear() == null) {
            throw new BadRequestException("All fields are required");
        }
        return null;
    }
}