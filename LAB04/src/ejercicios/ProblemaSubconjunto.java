package ejercicios;

public class ProblemaSubconjunto {

    static boolean backtracking(int[] arr, int index, int suma, int objetivo) {

        // CASO BASE
        if (index == arr.length) {
            return suma == objetivo;
        }

        int actual = arr[index];

        // Si es múltiplo de 3 → obligatorio
        if (actual % 3 == 0) {
            return backtracking(arr, index + 1, suma + actual, objetivo);
        }

        // No incluir
        if (backtracking(arr, index + 1, suma, objetivo))
            return true;

        // Incluir (validando pares consecutivos)
        if (!(actual % 2 == 0 && index + 1 < arr.length && arr[index + 1] % 2 == 0)) {
            if (backtracking(arr, index + 1, suma + actual, objetivo))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = { 3, 2, 6, 4 };
        int objetivo = 11;

        System.out.println("¿Existe solución? " + backtracking(arr, 0, 0, objetivo));
    }
}