package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Seguridad
@Priority(Interceptor.Priority.APPLICATION + 200)
public class SeguridadInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        System.out.println("[SEGURIDAD]. Entrando (SeguridadInterceptor)");
        Object resultado = context.proceed();
        System.out.println("[SEGURIDAD]. Saliendo (SeguridadInterceptor)");
        return resultado;
    }

}
