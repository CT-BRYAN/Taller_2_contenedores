package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.Auditoria;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@AuditarVenta
public class AuditarVentaInterceptor {

    @Inject
    private Auditoria auditoria;

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        Object[] parametros = context.getParameters();
        int numeroVenta = (int) parametros[0];
        String tipoCliente = (String) parametros[1];
        double monto = (double) parametros[2];

        System.out.println("INTERCEPTOR: Iniciando ejecución del método de venta");

        Object resultado = context.proceed();

        String mensaje = String.format("Auditoría por Interceptor | Venta ID: %d | Cliente: %s | Monto Base: $%.2f",
                numeroVenta, tipoCliente, monto);
        auditoria.registrar(mensaje);
        System.out.println("INTERCEPTOR: Método finalizado y auditado con éxito.\n");

        return resultado;

    }

}
