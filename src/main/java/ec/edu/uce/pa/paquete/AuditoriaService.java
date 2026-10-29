package ec.edu.uce.pa.paquete;

import java.time.LocalDateTime;

import jakarta.inject.Singleton;

@Singleton
public class AuditoriaService {

    public void guardarEnLaBase(String cliente, double total, String correo) {

        System.out.println("Guar5dando en la base de datos la auditoria: Cliente: " + cliente + ", total: " + total
                + ", correo: " + correo);
        System.out.println("Con fecha y hora: " + LocalDateTime.now());

    }
}
