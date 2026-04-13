package ejercicios;

public class KesimoMayor {

    public static int particionar(int[] arr, int izq, int der) {

        int pivote = arr[der];
        int i = izq;

        for (int j = izq; j < der; j++) {
            if (arr[j] > pivote) { // mayor para k-ésimo mayor
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[der];
        arr[der] = temp;

        return i;
    }

    public static int quickSelect(int[] arr, int izq, int der, int k) {

        if (izq <= der) {

            int pos = particionar(arr, izq, der);

            if (pos == k)
                return arr[pos];

            if (pos > k)
                return quickSelect(arr, izq, pos - 1, k);

            return quickSelect(arr, pos + 1, der, k);
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = { 10, 4, 5, 8, 6, 11 };
        int k = 2;

        System.out.println("K-ésimo mayor: " + quickSelect(arr, 0, arr.length - 1, k - 1));
    }
}