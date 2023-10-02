package tarea2;

public class Banco {
    private ASFIAsesor asfiAsesor;

    public Banco(ASFIAsesor asfiAsesor) {
        this.asfiAsesor = asfiAsesor;
    }

    public String getMaximoPrestamo(String ci) {
        String categoria = getCategoria(ci);
        if (categoria.equals("A")) {
            return "maximo a prestar 200000";
        } else if (categoria.equals("B")) {
            return "maximo a prestar 100000";
        } else {
            return "no se puede prestar ningún monto ALERTA!";
        }
    }

    public String getCategoria(String ci) {
        return asfiAsesor.consultarCategoria(ci);
    }
}

