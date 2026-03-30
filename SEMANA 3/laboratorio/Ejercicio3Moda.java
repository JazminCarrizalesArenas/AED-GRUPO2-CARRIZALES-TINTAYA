package laboratorio;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio3Moda {

    // Método que calcula la moda del arreglo
    public static int calcularModa(int[] v) {
        Map<Integer, Integer> frecuencia = new HashMap<>();
        int maxFrecuencia = 0;
        int moda = v[0];

        // Recorre el arreglo y cuenta frecuencias
        for (int num : v) {
            int f = frecuencia.getOrDefault(num, 0) + 1;
            frecuencia.put(num, f);

            // Actualiza la moda si encuentra mayor frecuencia
            if (f > maxFrecuencia) {
                maxFrecuencia = f;
                moda = num;
            }
        }
        return moda;
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 3, 2, 3, 4, 3};

        // Llamada al método
        int resultado = calcularModa(arreglo);

        // Mostrar resultado
        System.out.println("La moda es: " + resultado);
    }
}