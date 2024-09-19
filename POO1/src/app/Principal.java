
package app;

public class Principal {
    public static void main(String[] args) {
                System.out.println("Objeto 1");
        Carro car1 = new Carro();
        car1.marca = "Renault";
        car1.modelo = "Twingo";
        car1.Anio = "2006";
        car1.combustible = "Gasolina";
        car1.puerta = "3";
        car1.mostraR();
        System.out.println("");
        System.out.println("Objeto 2");
        Bus bus1 = new Bus();
        bus1.numVehiculo = "145 225";
        bus1.placa = "SJM 425";
        bus1.servicio = "Transporte publico";
        bus1.nombreConductor = "Marco Antonio Solis";
        bus1.mostrarBus();
        System.out.println("");
        Persona per1 = new Persona();
        per1.setId_Persona(1);
        per1.setNombre("Carlos");
        per1.setApellido("Valderrama");
        per1.setEstadoCivil("Casado");
        per1.setDireccion("Santa Marta");
        per1.setTelefono("31125416");
        System.out.println("Id: " + per1.getId_Persona() + "\nNombre: " + 
                per1.getNombre() + "\nApellido" + per1.getApellido() + 
                "\nEstado Civil: " + per1.getEstadoCivil() + 
                "\nDireccion: " + per1.getDireccion() +
                "\nCelular: " + per1.getTelefono());
        System.out.println("");
        Producto pro = new Producto(1, "Pastas", "250", 2000);
        System.out.println("Id: " + pro.getId_producto() + "\nNombre: " + 
                pro.getNombre() + "\nCantidad" + pro.getCantidad()
                + "\nPrecio: " + pro.getPrecio());
        System.out.println("");
        Equipo eq = new Equipo(2, "ADSO", "CIIM", "Sogamoso", "32054653");
        System.out.println("Id: " + eq.getId_equipo() + 
                "\nNombre: " + eq.getNombre() + "\nSede: " + eq.getSede() + 
                "\nDireccion: " + eq.getDireccion() + "\nCelular: " + eq.getCelular());
    }
 
}
