package ejercicio1;

// Tabla hash de tamano fijo para almacenar enteros, usando h(x) = x % tamano
public class TablaHash {

    private int[] tabla;
    private int tamano;

    public TablaHash(int tamano) {
        this.tamano = tamano;
        tabla = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            tabla[i] = -1; // -1 representa posicion vacia
        }
    }

    private int hash(int x) {
        return x % tamano;
    }

    // Inserta el valor en su posicion hash. Si la posicion ya esta ocupada
    // se reporta la colision (no se implementa manejo de colisiones aqui).
    public void insertar(int valor) {
        int pos = hash(valor);
        if (tabla[pos] == -1) {
            tabla[pos] = valor;
        } else {
            System.out.println("Colision al insertar " + valor + ": la posicion " + pos
                    + " ya esta ocupada por " + tabla[pos] + ", se mantiene el valor original");
        }
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

    public int get(int pos) {
        return tabla[pos];
    }
}
