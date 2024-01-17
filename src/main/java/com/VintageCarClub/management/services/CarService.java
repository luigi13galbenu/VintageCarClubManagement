package com.VintageCarClub.management.services;

import com.VintageCarClub.management.exceptions.ResourceNotFoundException;
import com.VintageCarClub.management.models.entities.Car;
import com.VintageCarClub.management.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car saveCar(Car car) {
        validateCar(car);
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car car) {
        validateCar(car);
        if (!carRepository.existsById(id)) {
            throw new ResourceNotFoundException("Car not found with id " + id);
        }
        car.setId(id);
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new ResourceNotFoundException("Car not found with id " + id);
        }
        carRepository.deleteById(id);
    }

    private void validateCar(Car car) {
        if (car == null || !StringUtils.hasText(car.getMake()) || !StringUtils.hasText(car.getModel())) {
            throw new IllegalArgumentException("Car make and model must not be empty");
        }
    }
}
