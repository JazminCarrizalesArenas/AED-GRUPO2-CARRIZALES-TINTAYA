package extra;

public class Moda2 {

    public static void mergeSort(int[] a, int izq, int der) {
        if (izq < der) {
            int mid = (izq + der) / 2;
            mergeSort(a, izq, mid);
            mergeSort(a, mid + 1, der);
            merge(a, izq, mid, der);
        }
    }

    public static void merge(int[] a, int izq, int mid, int der) {

        int[] temp = new int[a.length];
        int i = izq, j = mid + 1, k = izq;

        while (i <= mid && j <= der) {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i <= mid)
            temp[k++] = a[i++];
        while (j <= der)
            temp[k++] = a[j++];

        for (i = izq; i <= der; i++)
            a[i] = temp[i];
    }

    public static int moda2(int[] a) {

        mergeSort(a, 0, a.length - 1);

        int moda = a[0];
        int maxCont = 1, cont = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                cont++;
            } else {
                if (cont > maxCont) {
                    maxCont = cont;
                    moda = a[i - 1];
                }
                cont = 1;
            }
        }

        if (cont > maxCont)
            moda = a[a.length - 1];

        return moda;
    }

    public static void main(String[] args) {

        int[] v = { 4, 4, 4, 2, 2, 3, 3, 3, 3 }; // 🔹 CAMBIO

        System.out.println("Moda: " + moda2(v));
    }
}