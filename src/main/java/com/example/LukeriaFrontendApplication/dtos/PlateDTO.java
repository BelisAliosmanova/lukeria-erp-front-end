package com.example.LukeriaFrontendApplication.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlateDTO {
    private Long id;
    @NotBlank(message = "Моля въведете име на тарелката")
    private String name;
    @Min(value = 1, message = "Наличните бройки трябва да бъдат по-големи от 0!")
    private Integer availableQuantity;
    private MultipartFile photo;
    @Min(value = 1, message = "Цената трябва да бъде по-голяма от 0!")
    private double price;
}
