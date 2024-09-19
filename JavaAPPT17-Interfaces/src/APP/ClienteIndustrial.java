package APP;

public class ClienteIndustrial implements Cliente {

    private String nombre;
    private double tarifaBase;
    private double cargoAltaDemanda;

    public ClienteIndustrial(String nombre, double tarifaBase, double cargoAltaDemanda) {
        this.nombre = nombre;
        this.tarifaBase = tarifaBase;
        this.cargoAltaDemanda = cargoAltaDemanda;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public double calcularPago(double consumoKWH, double descuento, double impuestos) {
        double pago = (consumoKWH * tarifaBase) + cargoAltaDemanda;
        pago -= pago * descuento;
        pago += pago * impuestos;
        return pago;
    }

    @Override
    public String toString() {
        return "ClienteIndustrial{" 
                + "nombre=" + nombre 
                + ", tarifaBase=" + tarifaBase 
                + ", cargoAltaDemanda=" + cargoAltaDemanda + '}';
    }
    
    

}
