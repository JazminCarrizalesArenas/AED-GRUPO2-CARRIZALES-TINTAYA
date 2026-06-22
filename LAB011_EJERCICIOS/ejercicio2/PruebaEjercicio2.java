package ejercicio2;

public class PruebaEjercicio2 {

    public static void main(String[] args) {
        int[] valores = {10, 17, 24, 31, 4};

        System.out.println("Sondeo lineal");
        HashLineal lineal = new HashLineal(7);
        for (int v : valores) {
            lineal.insertar(v);
        }
        System.out.println("Tabla con sondeo lineal:");
        lineal.mostrarTabla();

        System.out.println();

        System.out.println("Sondeo cuadratico");
        HashCuadratico cuadratico = new HashCuadratico(7);
        for (int v : valores) {
            cuadratico.insertar(v);
        }
        System.out.println("Tabla con sondeo cuadratico:");
        cuadratico.mostrarTabla();

      
    }
}
