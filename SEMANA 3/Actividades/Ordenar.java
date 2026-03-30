public class Ordenar {

    public static void ordenar(int[] v, int tamaño) {
        int i, j, aux;

        for (i = 0; i < tamaño - 1; i++) {
            for (j = 0; j < tamaño - 1; j++) {
                if (v[j] > v[j + 1]) {
                    aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] vector = {5, 3, 8, 1, 2};

        ordenar(vector, vector.length);

        for (int num : vector) {
            System.out.print(num + " ");
        }
    }
}