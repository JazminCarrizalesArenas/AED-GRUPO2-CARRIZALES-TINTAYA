public class AnalisisPotencia {

    // Contador de llamadas recursivas
    static int contador = 0;

    // Función recursiva
    static double potencia(double x, int y) {
        contador++; // contamos cada llamada

        if (y == 0) // O(1)
            return 1.0;

        if (y % 2 == 1) // O(1)
            return x * potencia(x, y - 1); // T(y-1)

        else {
            double t = potencia(x, y / 2); // T(y/2)
            return t * t; // O(1)
        }
    }

    public static void main(String[] args) {

        // Casos de prueba
        int[] valores = {5, 10, 20, 30};

        for (int y : valores) {
            contador = 0; // reiniciamos contador

            double resultado = potencia(2, y);

            System.out.println("=================================");
            System.out.println("Calculando 2^" + y);
            System.out.println("Resultado: " + resultado);
            System.out.println("Número de llamadas: " + contador);
        }

        System.out.println("=================================");
        System.out.println("INTERPRETACIÓN:");
        System.out.println("- Cuando y es par → menos llamadas (log n)");
        System.out.println("- Cuando y es impar → más llamadas (lineal)");
        System.out.println("- Peor caso → O(n)");
        System.out.println("- Mejor caso → O(log n)");
    }
}