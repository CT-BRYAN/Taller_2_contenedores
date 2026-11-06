package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import ec.edu.uce.pa.paquete.interceptors.Log;
import ec.edu.uce.pa.paquete.interceptors.Seguridad;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class ProductoService {

    @Log
    @Seguridad
    @Auditoria
    public void procesarCompra(String producto) {
        System.out.println("[NEGOCIO] Ejecutando lógica para: " + producto);
    }

}
