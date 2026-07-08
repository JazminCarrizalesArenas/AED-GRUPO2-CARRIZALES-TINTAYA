
public class TestHashO {

    public static void main(String[] args) {
        // Tabla de tamaño 7: pequeña a propósito para forzar varias colisiones
        HashO<String> tabla = new HashO<>(7);

        // Claves elegidas para que varias compartan el mismo residuo mod 7:
        // 10 % 7 = 3 ; 17 % 7 = 3 ; 24 % 7 = 3  -> tres colisiones en el índice 3
        // 5 % 7 = 5  ; 12 % 7 = 5               -> colisión en el índice 5
        // 1 % 7 = 1  (sin colisión)
        int[] claves     = {10, 17, 24, 5, 12, 1};
        String[] nombres = {"Diego", "Sofia", "Renzo", "Karla", "Bruno", "Elena"};

        System.out.println("================ INSERCIONES ================");
        for (int i = 0; i < claves.length; i++) {
            tabla.insert(new Register<>(claves[i], nombres[i])); // Se inserta cada registro
        }

        System.out.println("\n================ TABLA COMPLETA ================");
        tabla.printTable(); // Se muestra el contenido de todas las listas enlazadas

        System.out.println("\n================ BÚSQUEDA ================");
        tabla.search(24); // Clave existente, dentro de una lista con colisiones
        tabla.search(99); // Clave inexistente

        System.out.println("\n================ ELIMINACIÓN ================");
        tabla.delete(17); // Se elimina una clave que está en medio de una lista con colisiones

        System.out.println("\n================ TABLA DESPUÉS DE ELIMINAR ================");
        tabla.printTable(); // Se observa cómo la lista del índice 3 quedó con un nodo menos
    }
}
