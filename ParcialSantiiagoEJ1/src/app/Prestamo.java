package app;

import java.time.LocalDate;

public record Prestamo(String  idPrestamo, Libro libro, Usuario usuario, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {}