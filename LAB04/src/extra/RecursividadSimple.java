package extra;


public class RecursividadSimple {

    // Método recursivo para calcular factorial
    static int factorial(int n) {

        // Caso base
        if (n <= 1) {
            return 1;
        }

        // Caso recursivo
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {

        int numero = 7; // 🔹 CAMBIO: antes era 5, ahora probamos con 7

        int resultado = factorial(numero);

        System.out.println("Factorial de " + numero + " es: " + resultado);
    }
}

