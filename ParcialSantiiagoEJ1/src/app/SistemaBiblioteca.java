    package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class SistemaBiblioteca {
    private static SistemaBiblioteca instance;
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;
    private List<Biblioteca> bibliotecas;

    public SistemaBiblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        prestamos = new ArrayList<>();
        bibliotecas = new ArrayList<>();
    }
    public static SistemaBiblioteca getInstance() {
        if (instance == null) {
            instance = new SistemaBiblioteca();
        }
        return instance;
    }
    public void agregarLibro() {
        String idLibro = JOptionPane.showInputDialog("Ingrese el ID del libro");
        String titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro");
        String autor = JOptionPane.showInputDialog("Ingrese el autor del libro");
        String estado = JOptionPane.showInputDialog("Ingrese el estado del libro (Disponible-Reservado-Prestado)");
        
        Libro libro = new Libro(idLibro, titulo, autor, estado);
        libros.add(libro);
        JOptionPane.showMessageDialog(null, "Libro agregado exitosamente");
    }
    public void agregarUsuario() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del Usuario");
        String tipoUsuario = JOptionPane.showInputDialog("Ingrese el tipo de Usuario(Normal-Premium)");
        
        Usuario usuario = new Usuario(nombre,   tipoUsuario, libros);
        usuarios.add(usuario);
        JOptionPane.showMessageDialog(null, "Usuario agregado Exitosamente");
    }
    public void reservarLibro(){
        String idPrestamo = JOptionPane.showInputDialog("Ingrese el ID del prestamo");
        String 
                
                titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro");
        String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre del Usuario");
        LocalDate fechaPrestamo = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha del prestamo (AAAA-MM-DD): "));
        LocalDate fechaDevolucion = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de la devolucion (AAAA-MM-DD): "));
        
        Optional<Libro> libroOpt = libros.stream().filter(l -> l.titulo().equalsIgnoreCase(titulo)).findFirst();
        Optional<Usuario> usuarioOpt = usuarios.stream().filter(u -> u.nombre().equalsIgnoreCase(nombreUsuario)).findFirst();
        
        if (libroOpt.isPresent() && usuarioOpt.isPresent()) {
            Prestamo prestamo = new Prestamo(idPrestamo, libroOpt.get(), usuarioOpt.get(), fechaPrestamo, fechaDevolucion);
            prestamos.add(prestamo);
            JOptionPane.showMessageDialog(null, "Reserva realizada Exitosamente: \n");
        } else {
            JOptionPane.showMessageDialog(null, "Error: Libro o Usuario no encontrado");
        }

    }
    public void prestarLibro() {
        String idPrestamo = JOptionPane.showInputDialog("Ingrese el ID del prestamo");
        String 
                
                titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro");
        String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre del Usuario");
        LocalDate fechaPrestamo = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha del prestamo (AAAA-MM-DD): "));
        LocalDate fechaDevolucion = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de la devolucion (AAAA-MM-DD): "));
        
        Optional<Libro> libroOpt = libros.stream().filter(l -> l.titulo().equalsIgnoreCase(titulo)).findFirst();
        Optional<Usuario> usuarioOpt = usuarios.stream().filter(u -> u.nombre().equalsIgnoreCase(nombreUsuario)).findFirst();
        
        if (libroOpt.isPresent() && usuarioOpt.isPresent()) {
            Prestamo prestamo = new Prestamo(idPrestamo, libroOpt.get(), usuarioOpt.get(), fechaPrestamo, fechaDevolucion);
            prestamos.add(prestamo);
            JOptionPane.showMessageDialog(null, "Prestamo realizado Exitosamente: \n");
        } else {
            JOptionPane.showMessageDialog(null, "Error: Libro o Usuario no encontrado");
        }

    }
    public void devolverLibro() {
        
        String nombre =  ("Ingrese el nombre del libro a devuelto: ");
        boolean devolver = libros.removeIf(libro -> libro.titulo().equalsIgnoreCase(nombre));

        if (devolver) {
            JOptionPane.showMessageDialog(null, "Se devolvio el libro: \n" + nombre + ", exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Libro NO encontrado\n");
        }

    }
    public void listarLibro() {
        if (libros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay libros en la lista");
            return;
        }

        StringBuilder info = new StringBuilder();
        for (int i = 0; i < libros.size(); i++) {
            info.append("Libro (").append(i + 1).append(")\n");
            info.append(" id: ").append(libros.get(i).idLibro()).append("\n");
            info.append(" Titulo: ").append(libros.get(i).titulo()).append("\n");
            info.append(" Autor: ").append(libros.get(i).autor()).append("\n");
            info.append(" Estado: ").append(libros.get(i).estado()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, info.toString());
    }
    public void cargarHistorialPrestamos(){
        if (prestamos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO hay prestamos en la lista\n");
            return;
        }
        
        StringBuilder reporte = new StringBuilder();
        reporte.append("Historial de prestamos: \n");
        reporte.append("---------------------------------\n");
        reporte.append("Total de titulos: ").append(libros.size()).append("\n");

        for (Prestamo prestamo : prestamos) {
            reporte.append("ID Prestamo: ").append(prestamo.idPrestamo()).append("\n");
            reporte.append("Libro: ").append(prestamo.libro()).append("\n");
            reporte.append("Usuario: ").append(prestamo.usuario()).append("\n");
            reporte.append("Fecha Prestamo: ").append(prestamo.fechaPrestamo()).append("\n");
            reporte.append("Fecha devolucion: ").append(prestamo.fechaDevolucion()).append("\n");
        
        }
        JOptionPane.showMessageDialog(null, reporte.toString());
    }
}
