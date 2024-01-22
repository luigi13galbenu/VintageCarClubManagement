package com.VintageCarClub.management.models.dtos;

import lombok.Data;

@Data
public class CarResponseDto {
    private Long id;
    private String make;
    private String model;
    private Integer year;
}