package tarea_en_clase_1;

public class Lottery {

    Service service = new Service();

    public int getPremio(int edad) throws IllegalArgumentException{
        if (edad < 0){
            throw new IllegalArgumentException("Natural number required");
        }

        if (edad <= 10){
            return service.isPrime(edad) ? edad*100 : edad;
        } else {
            return service.isPrime(edad) ? edad*80 : 0;
        }
    }

}
