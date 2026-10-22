package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@ApplicationScoped // delego el control al contenedor ARC
// @RequestScoped // para aplicaciones web
// @Singleton
public class PedidoService {
    @Inject
    @Named("mail") 
    private Notificacion notificacionCorreo;
    @Inject
    @Named("sms") 
    private Notificacion notificacionSMS;

    public void realizar(Pedido pedido) {

        System.out.println("Realizando pedido......");
        System.out.println("Pedido realizado para el cliente: " + pedido.getCliente());
        System.out.println("Producto:" + pedido.getProducto());
        System.out.println("Total:" + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con éxito");

        String cuerpo = "Estimado" + pedido.getCliente() + " su pedido de " +
                pedido.getProducto() + " por un  total de $" + pedido.getTotal()
                + "ha sido realizado con exito.";

        this.notificacionCorreo.enviar(pedido.getCorreo(), cuerpo);

        this.notificacionSMS.enviar(pedido.getTelefono(), cuerpo);
    }

}
