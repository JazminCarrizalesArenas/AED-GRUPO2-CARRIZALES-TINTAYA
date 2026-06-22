package ejercicio2;

// Tabla hash cerrada con resolucion de colisiones por sondeo cuadratico: f(i) = i^2
public class HashCuadratico {

    private int[] tabla;
    private int tamano;

    public HashCuadratico(int tamano) {
        this.tamano = tamano;
        tabla = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            tabla[i] = -1;
        }
    }

    private int hash(int x) {
        return x % tamano;
    }

    public void insertar(int valor) {
        int home = hash(valor);
        int pos = home;
        int intentos = 0;

        while (tabla[pos] != -1) {
            intentos++;
            pos = (home + intentos * intentos) % tamano;
            if (intentos > tamano) {
                System.out.println("No se pudo insertar " + valor + ", tabla llena");
                return;
            }
        }

        tabla[pos] = valor;
        System.out.println("Insertado " + valor + " en posicion " + pos + " (posiciones exploradas: " + intentos + ")");
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
}
