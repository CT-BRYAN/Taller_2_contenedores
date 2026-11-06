package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Log
@Priority(Interceptor.Priority.APPLICATION + 100)
public class LogInterceptor {
    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        System.out.println("[LOG]. Entrando (LogInterceptor)");
        Object resultado = context.proceed();
        System.out.println("[LOG]. Saliendo (LogInterceptor)");
        return resultado;
    }

}
