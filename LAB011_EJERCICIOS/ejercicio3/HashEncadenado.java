package ejercicio3;

// Tabla hash abierta (encadenamiento) usando listas enlazadas propias por cada celda
public class HashEncadenado {

    // Nodo simple para la lista enlazada de cada celda
    private static class Nodo {
        Registro dato;
        Nodo siguiente;

        Nodo(Registro dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo[] tabla;
    private int tamano;

    public HashEncadenado(int tamano) {
        this.tamano = tamano;
        tabla = new Nodo[tamano];
    }

    private int hash(int clave) {
        return clave % tamano;
    }

    public void insertar(Registro reg) {
        int pos = hash(reg.getClave());
        Nodo nuevo = new Nodo(reg);

        if (tabla[pos] == null) {
            tabla[pos] = nuevo;
        } else {
            Nodo actual = tabla[pos];
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    // Busca un registro e imprime en que posicion de tabla y en que nodo de la
    // cadena se encuentra (el primer nodo es el numero 1)
    public Registro buscar(int clave) {
        int pos = hash(clave);
        Nodo actual = tabla[pos];
        int numNodo = 1;

        while (actual != null) {
            if (actual.dato.getClave() == clave) {
                System.out.println("Clave " + clave + " encontrada en posicion " + pos
                        + ", nodo numero " + numNodo + " de la cadena");
                return actual.dato;
            }
            actual = actual.siguiente;
            numNodo++;
        }

        System.out.println("Clave " + clave + " no encontrada");
        return null;
    }

    public void eliminar(int clave) {
        int pos = hash(clave);
        Nodo actual = tabla[pos];
        Nodo anterior = null;

        while (actual != null) {
            if (actual.dato.getClave() == clave) {
                if (anterior == null) {
                    tabla[pos] = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                System.out.println("Clave " + clave + " eliminada de la posicion " + pos);
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        System.out.println("Clave " + clave + " no existe, no se elimino nada");
    }

    // Cuenta cuantos nodos hay en la cadena de una posicion dada
    public int contarNodos(int pos) {
        int cantidad = 0;
        Nodo actual = tabla[pos];
        while (actual != null) {
            cantidad++;
            actual = actual.siguiente;
        }
        return cantidad;
    }

    public void mostrarTabla() {
        for (int i = 0; i < tamano; i++) {
            StringBuilder linea = new StringBuilder(i + ": ");
            Nodo actual = tabla[i];
            if (actual == null) {
                linea.append("vacio");
            }
            while (actual != null) {
                linea.append(actual.dato.toString());
                if (actual.siguiente != null) {
                    linea.append(" -> ");
                }
                actual = actual.siguiente;
            }
            System.out.println(linea.toString());
        }
    }
}
