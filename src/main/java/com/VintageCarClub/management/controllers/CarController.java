package com.VintageCarClub.management.controllers;

import com.VintageCarClub.management.models.dtos.CarRequestDto;
import com.VintageCarClub.management.models.dtos.CarResponseDto;
import com.VintageCarClub.management.models.entities.Car;
import com.VintageCarClub.management.services.CarService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<CarResponseDto>> getAllCars() {
        return ResponseEntity.ok(carService.findAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDto> getCar(@PathVariable Long id) {
        CarResponseDto dto = carService.findCarById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<CarResponseDto> createCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.saveCar(car));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarResponseDto> updateCar(@PathVariable Long id, @RequestBody CarRequestDto carDto) {
        try {
            CarResponseDto updatedCar = carService.updateCar(id, carDto);
            return ResponseEntity.ok(updatedCar);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }
}