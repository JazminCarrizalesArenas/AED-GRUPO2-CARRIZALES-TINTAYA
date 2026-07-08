package ejercicio1;

/**
 * EJERCICIO 1: Tabla hash sin colisiones - análisis de función hash.
 *
 * Se crea una tabla hash de tamaño 11 (número primo) para almacenar
 * números enteros, usando la función h(x) = x % 11.
 * La tabla se implementa como un arreglo de enteros inicializado en -1
 * (que representa una posición vacía).
 */
public class Ejercicio1 {

    // Tamaño de la tabla: 11 es un número primo, tal como recomienda la teoría
    private static final int TAMANO = 11;

    public static void main(String[] args) {
        // Se crea el arreglo que representará la tabla hash
        int[] tabla = new int[TAMANO];

        // Se inicializan todas las posiciones en -1 para indicar "posición vacía"
        for (int i = 0; i < TAMANO; i++) {
            tabla[i] = -1;
        }

        // Valores a insertar, según lo solicitado en el enunciado
        int[] valores = {3, 14, 25, 36, 47, 58};

        System.out.println("================ CÁLCULO MANUAL DE LA FUNCIÓN HASH ================");
        System.out.println("Función utilizada: h(x) = x % " + TAMANO);
        // Se recorre cada valor a insertar
        for (int valor : valores) {
            int direccion = hash(valor); // Se calcula la dirección hash del valor actual
            System.out.println("h(" + valor + ") = " + valor + " % " + TAMANO + " = " + direccion);

            if (tabla[direccion] == -1) {
                // La posición está libre: se inserta directamente (sin colisión)
                tabla[direccion] = valor;
            } else {
                // En este ejercicio, dado el tamaño de tabla elegido, no deberían
                // producirse colisiones; si ocurriera, se reporta para análisis.
                System.out.println("  -> COLISIÓN detectada en la posición " + direccion +
                        " (ya ocupada por " + tabla[direccion] + ").");
            }
        }

        // Se muestra el estado final de la tabla con sus índices
        System.out.println("\n================ TABLA HASH FINAL ================");
        for (int i = 0; i < TAMANO; i++) {
            String contenido = (tabla[i] == -1) ? "(vacío)" : String.valueOf(tabla[i]);
            System.out.println("Índice " + i + " : " + contenido);
        }

        // Se listan las posiciones que quedaron vacías
        System.out.println("\n================ POSICIONES VACÍAS ================");
        StringBuilder vacias = new StringBuilder();
        for (int i = 0; i < TAMANO; i++) {
            if (tabla[i] == -1) {
                vacias.append(i).append(" ");
            }
        }
        System.out.println("Índices vacíos: " + (vacias.length() == 0 ? "ninguno" : vacias.toString().trim()));
    }

    /**
     * Función hash: método del residuo de la división.
     * @param x clave entera a dispersar
     * @return índice dentro del rango [0, TAMANO-1]
     */
    private static int hash(int x) {
        return x % TAMANO; // h(x) = x mod 11
    }
}

/*
 * ================================================================
 * ANÁLISIS - Pregunta 3: ¿Por qué se recomienda que el tamaño de la
 * tabla sea un número primo?
 * ================================================================
 *
 * Con h(x) = x % 11 y los valores 3, 14, 25, 36, 47, 58, se observa que
 * cada valor adicional es exactamente 11 unidades mayor que el anterior
 * (14 = 3+11, 25 = 14+11, 36 = 25+11, 47 = 36+11, 58 = 47+11). Como 11 es
 * primo y además coincide con el incremento entre claves, TODOS los
 * valores producen el MISMO residuo (3 % 11 = 3, 14 % 11 = 3, 25 % 11 = 3,
 * etc.), generando colisiones consecutivas en la posición 3.
 *
 * Esto ilustra un punto importante: ningún tamaño de tabla evita
 * colisiones si las claves guardan una relación aritmética exacta con
 * dicho tamaño. Sin embargo, en la práctica las claves NO suelen seguir
 * un patrón aritmético tan regular, y allí es donde el tamaño primo
 * demuestra su ventaja: al no compartir factores comunes con las claves
 * (ni con patrones típicos como múltiplos de 2, 5, 10 o 16, muy
 * frecuentes en datos reales), un módulo primo distribuye las claves de
 * forma mucho más uniforme a lo largo de toda la tabla. Si el tamaño
 * fuera, por ejemplo, una potencia de 2, la función hash solo tomaría en
 * cuenta los bits menos significativos de la clave, lo que provoca
 * agrupamientos cuando las claves comparten esos bits (algo común en
 * direcciones de memoria, IDs autoincrementales, etc.). Por ello, el
 * método del residuo de la división recomienda explícitamente que M sea
 * un número primo cercano al tamaño deseado de la tabla.
 */
