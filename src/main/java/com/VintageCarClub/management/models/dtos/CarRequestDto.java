package com.VintageCarClub.management.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRequestDto {
    @NotBlank(message = "invalid make")
    private String make;
    @NotBlank(message = "invalid model")
    private String model;
    @NotBlank(message = "invalid year")
    private Integer year;
}