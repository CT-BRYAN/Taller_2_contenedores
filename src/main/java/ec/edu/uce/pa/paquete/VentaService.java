package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.interceptors.AuditarVenta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class VentaService {

    // Inyección por Atributo
    @Inject
    @Named("regular")
     private CalculadoraDescuento descuentoRegular;

    @Inject
    @Named("vip")
    private CalculadoraDescuento descuentoVip;

    @AuditarVenta
    public void procesarVenta(int numeroVenta, String tipoCliente, double monto) {
        CalculadoraDescuento calculadorDescuento;

        if ("REGULAR".equalsIgnoreCase(tipoCliente)) {
            calculadorDescuento = descuentoRegular;
        } else if ("VIP".equalsIgnoreCase(tipoCliente)) {
            calculadorDescuento = descuentoVip;
        } else {
            throw new IllegalArgumentException("Tipo de cliente no encontrado: " + tipoCliente);
        }

        double descuento = calculadorDescuento.calcular(monto);
        double total = monto - descuento;

        System.out.printf("Venta %d | Tipo: %-7s | Monto: $%6.2f | Descuento: $%5.2f | Total: $%6.2f%n",
                numeroVenta, tipoCliente, monto, descuento, total);
    }

}
