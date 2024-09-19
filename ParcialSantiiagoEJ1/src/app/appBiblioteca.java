    package app;

import javax.swing.JOptionPane;

public class appBiblioteca {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();
        while (true) {            
            String[] opciones = {
                    "Agregar Libro", 
                    "Agregar Usuario",
                    "Reservar Libro",
                    "Prestar Libro",
                    "Devolver Libro",
                    "Listar Libros",
                    "Historial de Prestamos",
                    "Salir"
            }; 
            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccion una opcion", 
                    "Sistema de Biblioteca", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            
            if (seleccion == null || seleccion.equalsIgnoreCase("salir")) {
                break;
            }
            
            switch (seleccion) {
                case "Agregar Libro":
                    sistema.agregarLibro();
                    break;
                case "Agregar Usuario":
                    sistema.agregarUsuario();
                    break;
                case "Reservar Libro":
                    sistema.reservarLibro();
                    break;
                case "Prestar Libro":
                    sistema.prestarLibro();
                    break;
                case "Devolver Libro":
                    sistema.devolverLibro();
                    break;
                case "Listar Libros":
                    sistema.listarLibro();
                    break;
                case "Historial de Prestamos":
                    sistema.cargarHistorialPrestamos();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion NO valida");
            }
        }
        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema <3");
    }
}

