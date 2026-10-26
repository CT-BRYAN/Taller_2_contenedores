package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    VentaService ventaService;

    @Override
    public int run(String... args) throws Exception {

        System.out.println("\nSIMULADOR DE DESCUENTOS CON QUARKUS");

        ventaService.procesarVenta(1, "REGULAR", 100);
        ventaService.procesarVenta(2, "VIP", 200);
        ventaService.procesarVenta(3, "REGULAR", 300);
        ventaService.procesarVenta(4, "VIP", 500);

        System.out.println("FIN DEL PROGRAMA\n");

        return 0;

    }

    public static void main(String... args) {
        Quarkus.run(Main.class, args);
    }

}
