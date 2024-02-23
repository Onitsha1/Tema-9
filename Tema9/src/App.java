public class App {
    public static void main(String[] args) throws Exception {

        Pedidos gestor1 = new Pedidos();

        boolean incorrecto = true;
        int pedido;

        /*
         * Se crea un bucle do while para conseguir el argumento del método
         * procesarPedido.
         * Hace una prueba inicial para ver si el pedido es un entero >= 1. Si el input
         * no es válido,
         * (por ejemplo, introduciendo un string) nos saltará una excepción que estará
         * manejada,
         * y si no es >= 1, nos indicará que es una cantida inválida.
         */
        do {
            try {

                System.out.println("Escriba la cantidad del pedido: ");
                pedido = Pedidos.lector.nextInt();

                if (pedido >= 1) {
                    incorrecto = false;
                    gestor1.procesarPedido(pedido);
                } else {
                    incorrecto = true;
                    System.out.println("Cantidad no válida.");
                }
            }

            catch (Exception e) {
                incorrecto = true;
                Pedidos.lector.next();

                System.out.println("Valor inválido.");
                /*
                 * Se añade el .next(), para descartar la entrada inválidad del usuario, sino,
                 * se produce un bucle infinito ya que se estaría leyendo esa entrada todo el
                 * rato.
                 */

            }
        } while (incorrecto);

    }
}
