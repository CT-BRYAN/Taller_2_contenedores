package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Mail
@Priority(Interceptor.Priority.APPLICATION + 40 )
public class MailInterceptor {

    @AroundInvoke

    public Object interceptar(InvocationContext context) throws Exception {

        Object resultado = context.proceed();

        System.out.println("Interceptor mail: se envio un mail con exito");

        return resultado;
    }

}
