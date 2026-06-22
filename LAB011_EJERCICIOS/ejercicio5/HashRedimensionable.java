package ejercicio5;

// Tabla hash cerrada con sondeo lineal que se redimensiona automaticamente
// cuando el factor de carga supera 0.75
public class HashRedimensionable {

    private int[] tabla;
    private int tamano;
    private int cantidadElementos;
    private static final double FACTOR_MAXIMO = 0.75;

    public HashRedimensionable(int tamanoInicial) {
        this.tamano = tamanoInicial;
        tabla = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            tabla[i] = -1;
        }
        cantidadElementos = 0;
    }

    private int hash(int x, int tam) {
        return x % tam;
    }

    public double factorCarga() {
        return (double) cantidadElementos / tamano;
    }

    public void insertar(int valor) {
        int home = hash(valor, tamano);
        int pos = home;
        int intentos = 0;

        while (tabla[pos] != -1) {
            intentos++;
            pos = (home + intentos) % tamano;
            if (intentos > tamano) {
                System.out.println("No se pudo insertar " + valor + ", tabla llena");
                return;
            }
        }

        tabla[pos] = valor;
        cantidadElementos++;
        System.out.println("Insertado " + valor + " en posicion " + pos
                + ". Factor de carga actual: " + redondear(factorCarga()));

        if (factorCarga() > FACTOR_MAXIMO) {
            rehash();
        }
    }

    // Crea una tabla nueva del siguiente numero primo a partir del doble
    // del tamano actual, y reinserta todos los elementos existentes
    private void rehash() {
        int nuevoTamano = siguientePrimo(tamano * 2);
        System.out.println("Factor de carga supero " + FACTOR_MAXIMO + ", se hace rehashing a tamano " + nuevoTamano);

        int[] tablaVieja = tabla;
        tabla = new int[nuevoTamano];
        for (int i = 0; i < nuevoTamano; i++) {
            tabla[i] = -1;
        }
        int tamanoViejo = tamano;
        tamano = nuevoTamano;
        cantidadElementos = 0;

        for (int i = 0; i < tamanoViejo; i++) {
            if (tablaVieja[i] != -1) {
                insertarSinRehash(tablaVieja[i]);
            }
        }
    }

    // Insercion auxiliar usada durante el rehash, para no disparar otro rehash
    // mientras se esta reconstruyendo la tabla
    private void insertarSinRehash(int valor) {
        int home = hash(valor, tamano);
        int pos = home;
        int intentos = 0;

        while (tabla[pos] != -1) {
            intentos++;
            pos = (home + intentos) % tamano;
        }

        tabla[pos] = valor;
        cantidadElementos++;
    }

    private boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private int siguientePrimo(int n) {
        int candidato = n;
        while (!esPrimo(candidato)) {
            candidato++;
        }
        return candidato;
    }

    private double redondear(double valor) {
        return Math.round(valor * 1000.0) / 1000.0;
    }

    public void mostrarTabla() {
        for (int i = 0; i < tamano; i++) {
            if (tabla[i] == -1) {
                System.out.println(i + ": vacio");
            } else {
                System.out.println(i + ": " + tabla[i]);
            }
        }
    }

    public int getTamano() {
        return tamano;
    }
}
