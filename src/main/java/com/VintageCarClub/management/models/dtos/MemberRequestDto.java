package com.VintageCarClub.management.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDto {
    @NotBlank(message = "invalid id")
    private Long id;
    @NotBlank(message = "invalid name")
    private String name;
    @NotBlank(message = "invalid mail")
    private String email;
}