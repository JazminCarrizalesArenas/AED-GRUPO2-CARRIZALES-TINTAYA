package laboratorio;

public class Ejercicio8Fibonacci {

    // Método recursivo para calcular Fibonacci
    public static int fibonacci(int n) {

        // Caso base
        if (n <= 1)
            return n;

        // Llamadas recursivas
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        int n = 6;

        // Mostrar resultado
        System.out.println("Fibonacci de " + n + ": " + fibonacci(n));
    }
}



