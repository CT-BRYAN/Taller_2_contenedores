package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class VentaService {

    // Inyección por Atributo
    @Inject
    @Named("regular")
    CalculadoraDescuento descuentoRegular;

    @Inject
    @Named("vip")
    CalculadoraDescuento descuentoVip;

    private final Auditoria auditoria;

    // Inyección por Constructor
    @Inject
    public VentaService(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

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

        String mensaje = String.format("Venta %d | Tipo: %-7s | Monto: $%6.2f | Descuento: $%5.2f | Total: $%6.2f",
                numeroVenta, tipoCliente, monto, descuento, total);

        auditoria.registrar(mensaje);
    }

}
