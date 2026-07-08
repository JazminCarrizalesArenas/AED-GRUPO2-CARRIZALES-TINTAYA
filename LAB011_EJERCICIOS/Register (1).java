
public class HashC<T> {

    // ---- Constantes que representan los 3 posibles estados de una celda ----
    private static final int EMPTY = 0;
    private static final int OCCUPIED = 1;
    private static final int DELETED = 2;

    /**
     * Clase interna que representa una celda (slot) de la tabla hash.
     * Contiene el registro guardado y su estado actual.
     */
    private static class Element<T> {
        Register<T> register; // Registro guardado en la celda (null si la celda está EMPTY)
        int status;            // Estado de la celda: 0=EMPTY, 1=OCCUPIED, 2=DELETED

        // Constructor: toda celda nace vacía (EMPTY) y sin registro asociado
        public Element() {
            this.register = null; // Inicialmente no hay ningún registro guardado
            this.status = EMPTY;  // Inicialmente el estado es EMPTY (0)
        }
    }

    private Element<T>[] table; // Arreglo de celdas (slots) que conforma la tabla hash
    private int size;           // Tamaño fijo de la tabla hash

    /**
     * Constructor de la clase HashC.
     * Inicializa el arreglo "table" con "size" celdas vacías (status = EMPTY).
     *
     * @param size tamaño fijo de la tabla hash
     */
    @SuppressWarnings("unchecked")
    public HashC(int size) {
        this.size = size;                  // Se guarda el tamaño indicado por el usuario
        this.table = new Element[size];    // Se reserva el arreglo de celdas (tipo crudo: Java no permite arreglos genéricos directos)
        for (int i = 0; i < size; i++) {   // Se recorre cada posición del arreglo recién creado
            table[i] = new Element<>();    // Se inicializa cada celda como un Element<> vacío (EMPTY)
        }
    }

    /**
     * Función hash: método del residuo de la división.
     * h(x) = x mod size
     *
     * @param key clave entera a dispersar
     * @return índice base dentro del rango [0, size-1]
     */
    private int hash(int key) {
        return key % size; // Aplica el método de residuo de la división
    }

    /**
     * Inserta un nuevo registro en la tabla usando sondeo lineal.
     * - Si la clave ya existe en una celda OCCUPIED, se actualiza su dato (no se duplica).
     * - Si se recorre toda la tabla y no hay espacio disponible, se informa el error.
     * - Las celdas DELETED se reutilizan, ya que están lógicamente libres.
     *
     * @param reg registro a insertar
     */
    public void insert(Register<T> reg) {
        int posInit = hash(reg.getKey()); // Posición inicial calculada por la función hash
        int pos = posInit;                // Posición actual de exploración durante el sondeo
        int firstDeleted = -1;            // Recuerda la primera celda DELETED encontrada en el camino
        int probes = 0;                   // Contador de posiciones exploradas (con fines didácticos)

        do {
            // Caso 1: la celda está ocupada por la MISMA clave -> se actualiza el dato
            if (table[pos].status == OCCUPIED && table[pos].register.getKey() == reg.getKey()) {
                table[pos].register = reg; // Se reemplaza el registro existente por el nuevo (mismo key)
                System.out.println("La clave " + reg.getKey() + " ya existía; se actualizó su valor en la posición " + pos + ".");
                return; // Se concluye el método: no se inserta un duplicado
            }
            // Caso 2: la celda está completamente vacía -> aquí se puede insertar
            if (table[pos].status == EMPTY) {
                int destino = (firstDeleted != -1) ? firstDeleted : pos; // Se prefiere reutilizar una celda DELETED si se encontró antes
                table[destino].register = reg;     // Se guarda el nuevo registro en la celda destino
                table[destino].status = OCCUPIED;  // Se marca la celda como OCCUPIED
                System.out.println("Insertado " + reg + " -> hash inicial=" + posInit + ", posición final=" + destino + " (sondeos=" + (probes + 1) + ").");
                return; // Inserción completada con éxito
            }
            // Caso 3: la celda está DELETED -> se recuerda para una posible reutilización
            if (table[pos].status == DELETED && firstDeleted == -1) {
                firstDeleted = pos;
            }
            pos = (pos + 1) % size; // SONDEO LINEAL: se avanza circularmente a la siguiente posición
            probes++;                // Se incrementa el número de sondeos realizados
        } while (pos != posInit);    // Se repite hasta volver a la posición inicial (tabla recorrida por completo)

        // Si se salió del ciclo sin insertar, se revisa si hubo una celda DELETED disponible
        if (firstDeleted != -1) {
            table[firstDeleted].register = reg;
            table[firstDeleted].status = OCCUPIED;
            System.out.println("Insertado " + reg + " en la posición " + firstDeleted + " (celda DELETED reutilizada).");
        } else {
            System.out.println("ERROR: la tabla está llena. No se pudo insertar la clave " + reg.getKey() + ".");
        }
    }

    /**
     * Busca un registro por su clave, usando sondeo lineal.
     * El recorrido se detiene únicamente al encontrar una celda EMPTY,
     * ya que una celda DELETED no garantiza que la clave no exista más adelante.
     *
     * @param key clave a buscar
     * @return el Register encontrado, o null si la clave no existe
     */
    public Register<T> search(int key) {
        int posInit = hash(key); // Posición inicial según la función hash
        int pos = posInit;       // Posición actual de exploración
        int probes = 0;          // Contador de sondeos realizados

        do {
            if (table[pos].status == EMPTY) {
                // Una celda EMPTY indica que, de haber existido la clave, ya habría sido hallada
                System.out.println("Búsqueda de la clave " + key + ": NO encontrada (sondeos=" + (probes + 1) + ").");
                return null;
            }
            if (table[pos].status == OCCUPIED && table[pos].register.getKey() == key) {
                System.out.println("Búsqueda de la clave " + key + ": encontrada en la posición " + pos + " (sondeos=" + (probes + 1) + ").");
                return table[pos].register;
            }
            // Si la celda está DELETED, o está OCCUPIED con otra clave, se continúa el sondeo
            pos = (pos + 1) % size;
            probes++;
        } while (pos != posInit);

        System.out.println("Búsqueda de la clave " + key + ": NO encontrada tras recorrer toda la tabla.");
        return null;
    }

    /**
     * Elimina lógicamente un registro de la tabla (cambia su estado a DELETED).
     * El objeto Element no se destruye físicamente; solo se marca su estado.
     *
     * @param key clave del registro a eliminar
     */
    public void delete(int key) {
        int posInit = hash(key);
        int pos = posInit;

        do {
            if (table[pos].status == EMPTY) {
                // Si se llega a una celda EMPTY, la clave nunca fue insertada
                System.out.println("No se pudo eliminar: la clave " + key + " no existe en la tabla.");
                return;
            }
            if (table[pos].status == OCCUPIED && table[pos].register.getKey() == key) {
                table[pos].status = DELETED; // Eliminación LÓGICA: solo se cambia el estado de la celda
                System.out.println("Clave " + key + " eliminada lógicamente de la posición " + pos + " (status -> DELETED).");
                return;
            }
            pos = (pos + 1) % size; // Se continúa el sondeo lineal
        } while (pos != posInit);

        System.out.println("No se pudo eliminar: la clave " + key + " no existe en la tabla.");
    }

    /**
     * Imprime el estado actual completo de la tabla hash, mostrando
     * el contenido (o vacío) de cada una de sus posiciones.
     */
    public void printTable() {
        System.out.println("---------- Estado actual de la tabla hash (HashC) ----------");
        for (int i = 0; i < size; i++) {
            String estado;
            switch (table[i].status) {
                case EMPTY:
                    estado = "EMPTY";
                    break;
                case OCCUPIED:
                    estado = "OCCUPIED -> " + table[i].register;
                    break;
                case DELETED:
                    estado = "DELETED";
                    break;
                default:
                    estado = "?";
            }
            System.out.println("[" + i + "]  " + estado);
        }
        System.out.println("--------------------------------------------------------------");
    }
}
