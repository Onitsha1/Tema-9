import java.util.Scanner;

public class Pedidos {
    private int inventario = 1000;
    static Scanner lector = new Scanner(System.in);
    int numeroPedidos;

    public void procesarPedido(int pedido) throws ProductoNoDisponibleException {

        boolean error = true;
        /*
         * Pedimos al actor que nos indique cuántos pedidos consecutivos quiere realizar
         * para establecer el número de interaciones en el bucle for que representará
         * la realización de los pedidos.
         */

        do {
            try {
                System.out.println("¿Cuántos pedidos desea realizar?");
                numeroPedidos = Pedidos.lector.nextInt();

                if (numeroPedidos > 0) {
                    error = false;
                } else {
                    error = true;
                    System.out.println("Cantidad no válida.");
                }
            } catch (Exception e) {
                error = true;
                System.out.println("Valor inválido.");
            }
        } while (error);

        boolean fallo = true;

        for (int i = 1; i <= numeroPedidos; i++) {

            do {
                System.out.println("Confirmar pedido: ");
                pedido = lector.nextInt();
                /*
                 * Si se intenta pedir una cantidad mayor a la existente en el inventario,
                 * nos saltará la excepción personalizada y manejada indicando que no hay
                 * existencias.
                 */
                if (pedido > inventario || pedido == 0) {
                    fallo = true;
                    throw (new ProductoNoDisponibleException("No hay existencias para la cantidad solicitada \n" +
                            "o la cantidad debe ser mayor que 0."));

                } else {
                    fallo = false;
                    inventario = inventario - pedido;
                    System.out.println("Pedido realizado correctamente.");
                    /*
                     * El siguiente print no debería ser visible para el actor pero se usa como guia
                     * para ver el inventario y ver que el código funciona como debe.
                     */
                    System.out.println("El inventario es" + " " + inventario);
                }
            } while (fallo);

        }
    }
}