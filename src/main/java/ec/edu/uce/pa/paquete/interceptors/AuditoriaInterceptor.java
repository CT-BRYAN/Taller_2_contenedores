package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Auditoria
@Priority(Interceptor.Priority.APPLICATION + 300)
public class AuditoriaInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        System.out.println("[AUDITORIA]. Ejecutando auditoría (AuditoriaInterceptor)");
        Object resultado = context.proceed();
        return resultado;

    }

}
