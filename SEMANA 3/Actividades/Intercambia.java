public class Intercambia {

    public static void intercambia(int[] x, int[] y) {
        int aux;
        aux = x[0];
        x[0] = y[0];
        y[0] = aux;
    }

    public static void main(String[] args) {
        int[] a = {5};
        int[] b = {10};

        intercambia(a, b);

        System.out.println("a: " + a[0] + ", b: " + b[0]);
    }
}