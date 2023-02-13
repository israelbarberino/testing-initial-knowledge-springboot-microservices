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

    //METODO PARA SALVAR NA BASE
    public CarDTOResponse saveCar(CarDTORequest carRequest) {
        CarEntity carEntity = modelMapper.map(carRequest, CarEntity.class);
        carRepository.save(carEntity);
        CarDTOResponse carDTOResponse = modelMapper.map(carEntity, CarDTOResponse.class);
        return carDTOResponse;
    }

    // METODO PARA BUSCA DO IDCHASSI NA BASE DE DADOS
    public CarDTOResponse getById(Long idChassi) {
        Optional<CarEntity> repositoryById = carRepository.findById(idChassi);
        if (!repositoryById.isPresent()) {
            throw new CarNotFoundException("Chassi number: " + idChassi + " not found.");
        }
        CarDTOResponse carDTOResponse = modelMapper.map(repositoryById.get(), CarDTOResponse.class);
        return carDTOResponse;
    }

    // VALIDANDO OS CAMPOS = NÃO PODEM SER NULL (NULL) OU EMPTY (EM BRANCO)
    public static CarDTOResponse fieldValidation(@Valid CarDTORequest carDTORequest)
    {
        if (carDTORequest.getName() == null || carDTORequest.getName().isEmpty()                                    // NOME
                || carDTORequest.getBrand() == null || carDTORequest.getBrand().isEmpty()                           // MARCA
                || carDTORequest.getColor() == null || carDTORequest.getColor().isEmpty()                           // COR
                || carDTORequest.getFabricationYear() == null || carDTORequest.getFabricationYear().isEmpty()) {    //ANO DE FABRICAÇÃO
            throw new BadRequestException("All fields are required. Please, fill correctly and try again.");
        }
        return null;
    }

    // VALIDANDO A BRAND (MARCA - NÃO PODE SER OUTRA ALÉM DE FORD, CHEVROLET, BMW E VOLVO)
    public static CarDTOResponse brandValidation(@Valid CarDTORequest carDTORequest) {
        List<String> validBrands = Arrays.asList("Ford", "Chevrolet", "BMW", "Volvo");
        if (!validBrands.contains(carDTORequest.getBrand())) {
            throw new BadRequestException("Invalid brand: " + carDTORequest.getBrand());
        }
        return null;
    }

}
