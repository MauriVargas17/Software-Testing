package tarea2;

public class Banco {
    private ASFIAsesor asfiAsesor;

    public Banco(ASFIAsesor asfiAsesor) {
        this.asfiAsesor = asfiAsesor;
    }

    public int getMaximoPrestamo(String ci) {
        String categoria = getCategoria(ci);
        if (categoria.equals("A")) {
            return 200000;
        } else if (categoria.equals("B")) {
            return 100000;
        } else {
            return 0;
        }
    }

    public String getCategoria(String ci) {
        return asfiAsesor.consultarCategoria(ci);
    }
}

