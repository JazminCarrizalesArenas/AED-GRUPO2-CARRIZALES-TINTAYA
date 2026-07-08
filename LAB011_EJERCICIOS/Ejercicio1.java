
/**
 * Clase de prueba para la tabla hash cerrada (HashC) con sondeo lineal.
 * Inserta la secuencia de claves solicitada en la guía: 34, 3, 7, 30, 11, 8,
 * 7, 23, 41, 16, 34 (con distintos nombres), muestra la tabla antes y
 * después de eliminar la clave 30, y finalmente busca la clave 23.
 */
public class TestHash {

    public static void main(String[] args) {
        // Se crea una tabla hash de tamaño 13 (número primo, suficiente para
        // las 11 inserciones de prueba, lo que permite observar colisiones
        // reales sin llenar por completo la tabla).
        HashC<String> tabla = new HashC<>(13);

        // Arreglo de claves a insertar (incluye dos claves repetidas: 7 y 34,
        // para comprobar que la inserción actualiza el dato en vez de duplicar).
        int[] claves   = {34, 3, 7, 30, 11, 8, 7, 23, 41, 16, 34};
        // Arreglo de nombres asociados a cada clave (dato genérico T = String)
        String[] nombres = {"Ana", "Luis", "Carla", "Pedro", "Maria", "Jose",
                             "PedroActualizado", "Rosa", "Juan", "Lucia", "AnaActualizada"};

        System.out.println("================ INSERCIONES ================");
        for (int i = 0; i < claves.length; i++) {
            // Se crea un nuevo Register<String> con la clave y el nombre correspondiente
            Register<String> registro = new Register<>(claves[i], nombres[i]);
            tabla.insert(registro); // Se inserta el registro en la tabla hash
        }

        System.out.println("\n========== TABLA ANTES DE ELIMINAR LA CLAVE 30 ==========");
        tabla.printTable(); // Se muestra el estado completo de la tabla

        System.out.println("\n================ ELIMINANDO LA CLAVE 30 ================");
        tabla.delete(30); // Eliminación lógica de la clave 30

        System.out.println("\n========== TABLA DESPUÉS DE ELIMINAR LA CLAVE 30 ==========");
        tabla.printTable(); // Se vuelve a mostrar la tabla para comparar el cambio

        System.out.println("\n================ BUSCANDO LA CLAVE 23 ================");
        tabla.search(23); // Se busca la clave 23 y se reporta el resultado
    }
}
