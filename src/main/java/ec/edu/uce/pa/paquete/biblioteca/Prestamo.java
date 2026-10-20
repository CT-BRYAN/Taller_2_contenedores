package ec.edu.uce.pa.paquete.biblioteca;

public class Prestamo {

    private String nombrePersona;
    private String libro;
    private int dias;
    private String correo;

    public Prestamo(String nombrePersona, String libro, int dias, String correo) {
        this.nombrePersona = nombrePersona;
        this.libro = libro;
        this.dias = dias;
        this.correo = correo;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
