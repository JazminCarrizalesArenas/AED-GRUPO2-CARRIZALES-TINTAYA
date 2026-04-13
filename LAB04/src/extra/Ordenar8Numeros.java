package extra;

public class Ordenar8Numeros {

    static void ordenar(int[] a, int inicio, int fin) {

        if (inicio >= fin)
            return;

        int medio = (inicio + fin) / 2;

        ordenar(a, inicio, medio);
        ordenar(a, medio + 1, fin);

        combinar(a, inicio, medio, fin);
    }

    static void combinar(int[] a, int inicio, int medio, int fin) {

        int[] temp = new int[fin - inicio + 1];

        int i = inicio, j = medio + 1, k = 0;

        while (i <= medio && j <= fin) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= medio)
            temp[k++] = a[i++];
        while (j <= fin)
            temp[k++] = a[j++];

        for (int t = 0; t < temp.length; t++) {
            a[inicio + t] = temp[t];
        }
    }

    public static void main(String[] args) {

        int[] nums = { 50, 12, 89, 3, 45, 27, 91, 8 }; // 🔹 CAMBIO

        ordenar(nums, 0, nums.length - 1);

        System.out.println("Arreglo ordenado:");
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}


