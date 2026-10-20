package ec.edu.uce.pa.paquete.biblioteca;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BibliotecaService {

    @Inject
    private NotificacionService notificacionService;

    public void registrarPrestamo(Prestamo prestamo) {
        System.out.println("Registrando prestamo...");
        System.out.println("Persona: " + prestamo.getNombrePersona());
        System.out.println("Libro: " + prestamo.getLibro());
        System.out.println("Días: " + prestamo.getDias());
        System.out.println("Préstamo registrado con exito");

        String mensaje = prestamo.getNombrePersona() + ", ha retirado el libro '" +
                prestamo.getLibro() + "' por un plazo de " + prestamo.getDias() + " dias.";

        this.notificacionService.enviarAviso(prestamo.getCorreo(), mensaje);
    }

}
