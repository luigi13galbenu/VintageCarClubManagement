package com.VintageCarClub.management.repositories;

import com.VintageCarClub.management.models.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByMake(String make);

    List<Car> findByModel(String model);

    List<Car> findByYear(int year);
}
