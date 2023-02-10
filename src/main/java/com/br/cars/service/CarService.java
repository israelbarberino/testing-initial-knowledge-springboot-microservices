package com.br.cars.service;

import com.br.cars.dto.CarDTORequest;
import com.br.cars.dto.CarDTOResponse;
import com.br.cars.entities.CarEntity;
import com.br.cars.exception.CarNotFoundException;
import com.br.cars.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
