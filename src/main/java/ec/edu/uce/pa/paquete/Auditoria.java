package ec.edu.uce.pa.paquete;

import java.util.UUID;

import jakarta.enterprise.context.Dependent;

@Dependent
public class Auditoria {

    private final String id;

    public Auditoria() {
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public void registrar(String mensaje) {
        System.out.printf("[AUDITORÍA - Instancia UUID: %s] %s%n", id, mensaje);
    }

}
