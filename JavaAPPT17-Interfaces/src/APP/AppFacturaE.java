package APP;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AppFacturaE {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
            String[] opciones = {"Residencial", "Comercial", "Industrial"};
            String tipoCliente = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de cliente",
                    "Tipo de Cliente", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            double tarifaBase = 0;
            switch (tipoCliente) {
                case "Residencial":
                    String[] estratos = {"Estrato 1-2", "Estrato 3", "Estrato 4", "Estrato 5-6"};
                    String estrato = (String) JOptionPane.showInputDialog(null, "Seleccione su estrato",
                            "Estrato", JOptionPane.QUESTION_MESSAGE, null, estratos, estratos[0]);

                    switch (estrato) {
                        case "Estrato 1-2":
                            tarifaBase =550;
                            break;
                        case "Estrato 3":
                            tarifaBase =750;
                            break;
                        case "Estrato 4":
                            tarifaBase =850;
                            break;
                        case "Estrato 5-6":
                            tarifaBase =950;
                            break;
                    }
                    
                    clientes.add(new ClienteResidencial(nombre, tarifaBase));
                    break;
                    
                case "Comercial":

                    tarifaBase = 1100;
                    double cargoExtra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el cargo extra por exceso (COP/KWH):"));
                    clientes.add(new ClienteComercial(nombre, tarifaBase, cargoExtra));
                    break;
                    
                case "Industrial":
                    
                    tarifaBase = 900;
                    double cargoDemando = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el cargo por alta demanda (COP):"));
                    clientes.add(new ClienteIndustrial(nombre, tarifaBase, cargoDemando));
                    break;
            }
            int repuesta = JOptionPane.showConfirmDialog(null, "Desea agregar otro cliente?", "Continuar", JOptionPane.YES_NO_OPTION);
            continuar = (repuesta == JOptionPane.YES_OPTION);
            
            for (Cliente cliente : clientes) {
                double consumoKWH = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el consumo de energia para " + cliente.toString() + ":"));
                double descuento = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el % de descuento para " + cliente.toString() + ":"));
                double impuesto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el % de impuesto para" + cliente.toString() + ":"));
                
                double pago = cliente.calcularPago(consumoKWH, descuento, impuesto);
                JOptionPane.showMessageDialog(null, cliente.toString() 
                        + "\nPago de la factura: $" + pago + "COP");
            }
            
        }

    }

}
