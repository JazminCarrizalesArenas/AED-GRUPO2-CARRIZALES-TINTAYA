package ejercicio5;

public class PruebaEjercicio5 {

    public static void main(String[] args) {
        HashRedimensionable tabla = new HashRedimensionable(7);

        int[] valores = {2, 9, 16, 23, 4, 11};

        for (int v : valores) {
            tabla.insertar(v);
        }

        System.out.println();
        System.out.println("Tabla final (tamano " + tabla.getTamano() + "):");
        tabla.mostrarTabla();
    }
}