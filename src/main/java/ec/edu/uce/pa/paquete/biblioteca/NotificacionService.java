package ec.edu.uce.pa.paquete.biblioteca;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotificacionService {

    public void enviarAviso(String correo, String mensaje) {
        System.out.println("Enviando correo a: " + correo);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo enviado con exito");
    }

}
