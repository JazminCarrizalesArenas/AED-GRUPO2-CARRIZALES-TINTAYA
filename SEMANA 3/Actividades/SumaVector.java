public class SumaVector {

    public static int suma(int[] v, int tamaño) {
        int i, result;
        result = 0;

        for (i = 0; i < tamaño; i++) {
            result = result + v[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] vector = {1, 2, 3, 4, 5};
        System.out.println(suma(vector, vector.length));
    }
}