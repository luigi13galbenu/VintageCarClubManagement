package com.VintageCarClub.management.controllers;

import com.VintageCarClub.management.models.dtos.CarRequestDto;
import com.VintageCarClub.management.models.dtos.CarResponseDto;
import com.VintageCarClub.management.services.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CarController {

    private final CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDto> getCarById(@PathVariable Long id) {
        CarResponseDto car = carService.findCarById(id);
        return ResponseEntity.ok(car);
    }

    @PostMapping
    public ResponseEntity<CarResponseDto> createCar(@Valid @RequestBody CarRequestDto carRequestDto) {
        CarResponseDto newCar = carService.saveCar(carRequestDto);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarResponseDto> updateCar(@PathVariable Long id, @Valid @RequestBody CarRequestDto carRequestDto) {
        CarResponseDto updatedCar = carService.updateCar(id, carRequestDto);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CarResponseDto>> getAllCars() {
        List<CarResponseDto> cars = carService.findAllCars();
        return ResponseEntity.ok(cars);
    }
}