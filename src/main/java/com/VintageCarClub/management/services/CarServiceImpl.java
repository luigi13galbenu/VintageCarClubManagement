package com.VintageCarClub.management.services;

import com.VintageCarClub.management.models.dtos.CarRequestDto;
import com.VintageCarClub.management.models.dtos.CarResponseDto;
import com.VintageCarClub.management.models.entities.Car;
import com.VintageCarClub.management.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarResponseDto saveCar(CarRequestDto carDto) {
        Car car = new Car();
        car.setMake(carDto.getMake());
        car.setModel(carDto.getModel());
        car.setYear(carDto.getYear());

        Car savedCar = carRepository.save(car);
        return convertToDto(savedCar);
    }

    @Override
    public CarResponseDto findCarById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        return convertToDto(car);
    }

    @Override
    public CarResponseDto updateCar(Long id, CarRequestDto carDto) {
        Car existingCar = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
        existingCar.setMake(carDto.getMake());
        existingCar.setModel(carDto.getModel());
        existingCar.setYear(carDto.getYear());


        Car updatedCar = carRepository.save(existingCar);
        return convertToDto(updatedCar);
    }

    @Override
    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car not found with id: " + id);
        }
        carRepository.deleteById(id);
    }

    @Override
    public List<CarResponseDto> findAllCars() {
        return carRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    private CarResponseDto convertToDto(Car car) {
        CarResponseDto dto = new CarResponseDto();
        dto.setId(car.getId());
        dto.setMake(car.getMake());
        dto.setModel(car.getModel());
        dto.setYear(car.getYear());

        return dto;
    }
}