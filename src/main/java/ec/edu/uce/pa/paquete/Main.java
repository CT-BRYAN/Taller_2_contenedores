package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private ProductoService productoService;

    @Override
    public int run(String... args) throws Exception {

        System.out.println("INICIANDO APLICACIÓN");

        this.productoService.procesarCompra("Laptop Titan 18 HX A14V");

        System.out.println("FIN DE LA APLICACIÓN");

        return 0;

    }

    public static void main(String... args) {
        Quarkus.run(Main.class, args);
    }

}
