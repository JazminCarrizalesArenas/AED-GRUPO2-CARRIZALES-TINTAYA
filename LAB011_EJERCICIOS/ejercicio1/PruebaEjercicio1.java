package ejercicio1;


public class PruebaEjercicio1 {

    public static void main(String[] args) {
        TablaHash tabla = new TablaHash(11);

        int[] valores = {3, 14, 25, 36, 47, 58};

        System.out.println("Direcciones hash calculadas:");
        for (int v : valores) {
            System.out.println("h(" + v + ") = " + (v % 11));
        }

        System.out.println();
        System.out.println("Insertando valores...");
        for (int v : valores) {
            tabla.insertar(v);
        }

        System.out.println();
        System.out.println("Tabla hash final:");
        tabla.mostrarTabla();

        System.out.println();
        System.out.println("Posiciones vacias:");
        for (int i = 0; i < tabla.getTamano(); i++) {
            if (tabla.get(i) == -1) {
                System.out.println("Posicion " + i);
            }
        }

      
    }
}
