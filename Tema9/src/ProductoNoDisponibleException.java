public class ProductoNoDisponibleException extends Exception {

    public ProductoNoDisponibleException(String mensaje) {
        super(mensaje);
        System.out.println(mensaje);
    }

}
