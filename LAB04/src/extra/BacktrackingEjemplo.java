package extra;
import java.util.ArrayList;
import java.util.List;

public class BacktrackingEjemplo {

    public static void main(String[] args) {

        int[] conjunto = { 1, 2, 3, 4 }; // 🔹 CAMBIO: se agregó un elemento

        System.out.println("=== SUBCONJUNTOS ===");
        generarSubconjuntos(conjunto, 0, new ArrayList<>());

        System.out.println("\n=== PERMUTACIONES ===");
        generarPermutaciones(conjunto, 0);
    }

    public static void generarSubconjuntos(int[] arr, int index, List<Integer> actual) {

        if (index == arr.length) {
            System.out.println(actual);
            return;
        }

        // No incluir
        generarSubconjuntos(arr, index + 1, actual);

        // Incluir
        actual.add(arr[index]);
        generarSubconjuntos(arr, index + 1, actual);

        // Backtracking
        actual.remove(actual.size() - 1);
    }

    public static void generarPermutaciones(int[] arr, int index) {

        if (index == arr.length) {
            imprimirArreglo(arr);
            return;
        }

        for (int i = index; i < arr.length; i++) {

            intercambiar(arr, index, i);
            generarPermutaciones(arr, index + 1);
            intercambiar(arr, index, i); // backtracking
        }
    }

    public static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void imprimirArreglo(int[] arr) {
        for (int num : arr) {
            System.out.print(num);
        }
        System.out.println();
    }
}