package extra;

public class Moda1 {

    public static int frecuencia(int[] a, int x) {
        int cont = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x)
                cont++;
        }
        return cont;
    }

    public static int moda1(int[] a) {
        int maxFrecuencia = 0;
        int moda = a[0];

        for (int i = 0; i < a.length; i++) {
            int f = frecuencia(a, a[i]);
            if (f > maxFrecuencia) {
                maxFrecuencia = f;
                moda = a[i];
            }
        }
        return moda;
    }

    public static void main(String[] args) {

        int[] v = { 2, 2, 3, 3, 3, 4, 5, 5 }; // 🔹 CAMBIO

        System.out.println("Moda: " + moda1(v));
    }
}


