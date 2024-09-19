package app;

import java.util.List;

public record Usuario(String  nombre, String tipoUsuario, List<Libro>listaLibrosPrestados) {}