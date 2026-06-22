package ejercicio4;

// Tabla hash cerrada con sondeo lineal y eliminacion logica (EMPTY, OCCUPIED, DELETED)
public class HashConBorrado {

    private Entry[] tabla;
    private int tamano;

    public HashConBorrado(int tamano) {
        this.tamano = tamano;
        tabla = new Entry[tamano];
        for (int i = 0; i < tamano; i++) {
            tabla[i] = new Entry();
        }
    }

    private int hash(int x) {
        return x % tamano;
    }

    public void insertar(int clave) {
        int home = hash(clave);
        int pos = home;
        int intentos = 0;

        // Avanza mientras la celda este OCCUPIED. Una celda DELETED se puede reutilizar.
        while (tabla[pos].getEstado() == Entry.OCCUPIED) {
            intentos++;
            pos = (home + intentos) % tamano;
            if (intentos > tamano) {
                System.out.println("No se pudo insertar " + clave + ", tabla llena");
                return;
            }
        }

        tabla[pos].setClave(clave);
        tabla[pos].setEstado(Entry.OCCUPIED);
        System.out.println("Insertado " + clave + " en posicion " + pos);
    }

    // Eliminacion logica: solo cambia el estado a DELETED
    public void eliminar(int clave) {
        int home = hash(clave);
        int pos = home;
        int intentos = 0;

        while (tabla[pos].getEstado() != Entry.EMPTY) {
            if (tabla[pos].getEstado() == Entry.OCCUPIED && tabla[pos].getClave() == clave) {
                tabla[pos].setEstado(Entry.DELETED);
                System.out.println("Clave " + clave + " marcada como DELETED en posicion " + pos);
                return;
            }
            intentos++;
            pos = (home + intentos) % tamano;
            if (intentos > tamano) {
                break;
            }
        }
        System.out.println("Clave " + clave + " no encontrada para eliminar");
    }

    // La busqueda no se detiene en una celda DELETED, solo se detiene en EMPTY
    public int buscar(int clave) {
        int home = hash(clave);
        int pos = home;
        int intentos = 0;

        while (tabla[pos].getEstado() != Entry.EMPTY) {
            if (tabla[pos].getEstado() == Entry.OCCUPIED && tabla[pos].getClave() == clave) {
                System.out.println("Clave " + clave + " encontrada en posicion " + pos);
                return pos;
            }
            intentos++;
            pos = (home + intentos) % tamano;
            if (intentos > tamano) {
                break;
            }
        }
        System.out.println("Clave " + clave + " no encontrada");
        return -1;
    }

    public void mostrarTabla() {
        for (int i = 0; i < tamano; i++) {
            Entry e = tabla[i];
            if (e.getEstado() == Entry.OCCUPIED) {
                System.out.println(i + ": " + e.getClave() + " (" + e.nombreEstado() + ")");
            } else {
                System.out.println(i + ": -- (" + e.nombreEstado() + ")");
            }
        }
    }
}
