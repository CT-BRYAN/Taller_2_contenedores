package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Sms
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 30 )
public class SmsInterceptor {

    @AroundInvoke

    public Object interceptar(InvocationContext context) throws Exception {

        Object resultado = context.proceed();

        System.out.println("Interceptor sms: se envio un sms con exito");

        return resultado;
    }

}
