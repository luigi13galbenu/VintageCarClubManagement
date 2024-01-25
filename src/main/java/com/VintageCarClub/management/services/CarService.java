package com.VintageCarClub.management.services;

import com.VintageCarClub.management.models.dtos.CarRequestDto;
import com.VintageCarClub.management.models.dtos.CarResponseDto;

import java.util.List;

public interface CarService {
    CarResponseDto saveCar(CarRequestDto carDto);
    CarResponseDto findCarById(Long id);
    CarResponseDto updateCar(Long id, CarRequestDto carDto);
    void deleteCar(Long id);
    List<CarResponseDto> findAllCars();

}