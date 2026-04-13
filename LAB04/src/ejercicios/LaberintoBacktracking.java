package ejercicios;

public class LaberintoBacktracking {

    static int N = 4;

    static boolean resolver(int[][] lab, int i, int j, int[][] sol) {

        // CASO BASE
        if (i == N - 1 && j == N - 1) {
            sol[i][j] = 1;
            return true;
        }

        if (esValido(lab, i, j)) {

            sol[i][j] = 1;

            // Derecha
            if (resolver(lab, i, j + 1, sol))
                return true;

            // Abajo
            if (resolver(lab, i + 1, j, sol))
                return true;

            // Izquierda
            if (resolver(lab, i, j - 1, sol))
                return true;

            // Arriba
            if (resolver(lab, i - 1, j, sol))
                return true;

            // BACKTRACKING
            sol[i][j] = 0;
        }

        return false;
    }

    static boolean esValido(int[][] lab, int i, int j) {
        return (i >= 0 && j >= 0 && i < N && j < N && lab[i][j] == 0);
    }

    public static void main(String[] args) {

        int[][] lab = {
                { 0, 1, 0, 0 },
                { 0, 0, 0, 1 },
                { 1, 0, 0, 0 },
                { 1, 1, 0, 0 }
        };

        int[][] sol = new int[N][N];

        if (resolver(lab, 0, 0, sol)) {

            System.out.println("Camino encontrado:");
            for (int[] fila : sol) {
                for (int val : fila)
                    System.out.print(val + " ");
                System.out.println();
            }

        } else {
            System.out.println("No hay solución");
        }
    }
}