package com.VintageCarClub.management.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventRequestDto {
    @Size(min = 3, max = 100, message = "Event name must be between 3 and 100 characters")
    @NotBlank(message = "invalid name")
    private String name;
    @NotBlank(message = "invalid date")
    private LocalDate date;
    @NotBlank(message = "invalid location")
    private String location;
}