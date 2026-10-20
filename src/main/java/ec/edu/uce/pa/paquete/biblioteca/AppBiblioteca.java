package ec.edu.uce.pa.paquete.biblioteca;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class AppBiblioteca implements QuarkusApplication {

    @Inject
    private BibliotecaService bibliotecaService;

    public static void main(String[] args) {
        Quarkus.run(AppBiblioteca.class, args);
    }

    @Override
    public int run(String... args) {
        System.out.println("Iniciando la aplicacion de Biblioteca...");

        Prestamo prestamo = new Prestamo("Ana", "Pedro Paramo", 15, "ana@gmail.com");

        this.bibliotecaService.registrarPrestamo(prestamo);

        return 0;
    }

}
