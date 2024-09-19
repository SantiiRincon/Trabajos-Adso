package APP;

public class ClienteComercial implements Cliente {

    private String nombre;
    private double tarifaBase;
    private double cargoExtraExceso;

    public ClienteComercial(String nombre, double tarifaBase, double cargoExtraExceso) {
        this.nombre = nombre;
        this.tarifaBase = tarifaBase;
        this.cargoExtraExceso = cargoExtraExceso;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public double calcularPago(double consumoKWH, double descuento, double impuestos) {
        
        double pago = consumoKWH + tarifaBase;
        if (consumoKWH > 1000) {
            pago +=(consumoKWH - 1000) * cargoExtraExceso;
        }
        
        pago -= pago * descuento;
        pago += pago * impuestos;
        return pago;
    }

    @Override
    public String toString() {
        return "ClienteComercial{" 
                + "nombre=" + nombre 
                + ", tarifaBase=" + tarifaBase 
                + ", cargoExtraExceso=" + cargoExtraExceso + '}';
    }
    
    

}
