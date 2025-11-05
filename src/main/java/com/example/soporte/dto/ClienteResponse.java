package com.example.soporte.dto;

public record ClienteResponse(
    Long id,
    String nombre,
    String email,
    String telefono
) {}