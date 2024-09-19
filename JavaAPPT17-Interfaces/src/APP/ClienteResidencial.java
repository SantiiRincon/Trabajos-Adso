package APP;

public class ClienteResidencial implements Cliente {

    private String nombre;
    private double tarifaBase;

    public ClienteResidencial(String nombre, double tarifaBase) {
        this.nombre = nombre;
        this.tarifaBase = tarifaBase;
    }

    public String getNombre() {
        return nombre;
    }

    
    
    @Override
    public double calcularPago(double consumoKWH, double descuento, double impuestos) {
        double pago = consumoKWH * tarifaBase;
        pago -= pago * descuento;
        pago += pago * impuestos;
        return pago;
    }

    @Override
    public String toString() {
        return "ClienteResidencial{" 
                + "nombre=" + nombre 
                + ", tarifaBase=" + tarifaBase + '}';
    }
    
    

}
