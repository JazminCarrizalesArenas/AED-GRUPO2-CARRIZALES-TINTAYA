package ejercicios;

public class ViajeRio {

    public static void costoMinimo(int[][] T) {

        int n = T.length;
        int[][] C = new int[n][n];

        // Inicialización
        for (int i = 0; i < n; i++) {
            C[i][i] = 0;
        }

        for (int i = 0; i < n - 1; i++) {
            C[i][i + 1] = T[i][i + 1];
        }

        // Programación dinámica
        for (int d = 2; d < n; d++) {
            for (int i = 0; i < n - d; i++) {

                int j = i + d;
                C[i][j] = T[i][j];

                for (int k = i + 1; k < j; k++) {
                    if (T[i][k] + C[k][j] < C[i][j]) {
                        C[i][j] = T[i][k] + C[k][j];
                    }
                }
            }
        }

        System.out.println("Costo mínimo: " + C[0][n - 1]);
    }

    public static void main(String[] args) {

        int[][] T = {
                { 0, 2, 8, 9 },
                { 0, 0, 3, 7 },
                { 0, 0, 0, 1 },
                { 0, 0, 0, 0 }
        };

        costoMinimo(T);
    }
}