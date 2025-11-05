package com.example.soporte.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClienteRequest(
    @NotBlank(message = "El nombre es obligatorio")
    String nombre,

    @NotBlank @Email(message = "Email inválido")
    String email,

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^[0-9]{9}$", message = "Teléfono debe tener exactamente 9 dígitos")
    String telefono
) {}
