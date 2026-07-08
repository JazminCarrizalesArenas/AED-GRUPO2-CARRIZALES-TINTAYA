
public class HashO<T> {

    private LinkedList<Register<T>>[] table; // Arreglo de listas enlazadas: una por cada índice de la tabla
    private int size;                         // Tamaño fijo de la tabla hash (cantidad de índices)

    @SuppressWarnings("unchecked")
    public HashO(int size) {
        this.size = size;                       // Se guarda el tamaño indicado
        this.table = new LinkedList[size];       // Se reserva el arreglo de listas (tipo crudo por restricción de Java con genéricos)
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();        // Cada posición inicia con una lista enlazada propia y vacía
        }
    }

    /**
     * Función hash: método del residuo de la división.
     * h(x) = x mod size
     */
    private int hash(int key) {
        return key % size; // Aplica el método de residuo de la división
    }

    /**
     * Inserta un registro en la lista enlazada correspondiente a su índice
     * hash. Si la clave ya existía, se reemplaza su valor (se elimina el
     * registro anterior y se agrega el nuevo al final de la lista).
     */
    public void insert(Register<T> reg) {
        int idx = hash(reg.getKey()); // Se calcula el índice (celda) donde debe ir el registro
        Register<T> dummy = new Register<>(reg.getKey(), null); // Registro "de referencia" solo con la clave, para buscar/eliminar por equals()

        if (table[idx].search(dummy) != null) {
            table[idx].remove(dummy); // Si la clave ya existía en esa lista, se elimina la versión anterior
            System.out.println("La clave " + reg.getKey() + " ya existía en el índice " + idx + "; se actualizó su valor.");
        }
        table[idx].addLast(reg); // Se agrega el registro al final de la lista enlazada de la celda correspondiente
        System.out.println("Insertado " + reg + " -> índice " + idx + " (elementos en esa lista: " + table[idx].size() + ").");
    }

    /**
     * Busca un registro por su clave dentro de la lista enlazada
     * correspondiente a su índice hash.
     */
    public Register<T> search(int key) {
        int idx = hash(key); // Se calcula el índice donde debería estar la clave
        Register<T> dummy = new Register<>(key, null); // Registro de referencia para comparar solo por clave
        Register<T> encontrado = table[idx].search(dummy); // Se delega la búsqueda a la lista enlazada de esa celda

        if (encontrado != null) {
            System.out.println("Clave " + key + " encontrada en el índice " + idx + ": " + encontrado);
        } else {
            System.out.println("Clave " + key + " NO encontrada (índice " + idx + ").");
        }
        return encontrado;
    }

    /**
     * Elimina un registro de la tabla, buscándolo en la lista enlazada
     * correspondiente a su índice hash y desenlazándolo de la lista.
     */
    public void delete(int key) {
        int idx = hash(key); // Índice donde debería encontrarse la clave
        Register<T> dummy = new Register<>(key, null); // Registro de referencia (solo clave) para buscar/eliminar
        boolean eliminado = table[idx].remove(dummy);    // Se delega la eliminación a la lista enlazada de esa celda

        if (eliminado) {
            System.out.println("Clave " + key + " eliminada del índice " + idx + " (elementos restantes en la lista: " + table[idx].size() + ").");
        } else {
            System.out.println("No se pudo eliminar: la clave " + key + " no existe (índice " + idx + ").");
        }
    }

    /**
     * Imprime el contenido completo de la tabla hash: cada índice junto
     * con su lista enlazada de registros (o "[vacía]" si no tiene elementos).
     */
    public void printTable() {
        System.out.println("---------- Estado actual de la tabla hash (HashO) ----------");
        for (int i = 0; i < size; i++) {
            System.out.println("[" + i + "]  " + table[i]); // toString() de LinkedList ya formatea la cadena de nodos
        }
        System.out.println("--------------------------------------------------------------");
    }
}
