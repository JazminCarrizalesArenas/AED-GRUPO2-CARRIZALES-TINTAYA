
public class Register<T> {

    private int key; // Clave entera única que identifica al registro
    private T data;   // Dato genérico asociado a la clave

    public Register(int key, T data) {
        this.key = key;   // Se guarda la clave recibida
        this.data = data; // Se guarda el dato recibido
    }

    public int getKey() {
        return key; // Devuelve el atributo key
    }
    public T getData() {
        return data; // Devuelve el atributo data
    }

    /**
     * Representación en texto del registro, usada al imprimir las listas
     * enlazadas de cada celda de la tabla.
     */
    @Override
    public String toString() {
        return "(" + key + ", " + data + ")"; // Formato (key, data)
    }

    /**
     * Dos registros se consideran iguales si tienen la MISMA CLAVE,
     * sin importar el dato que almacenen. Esto permite que la LinkedList
     * propia pueda buscar/eliminar un registro a partir de un "registro
     * de referencia" creado solo con la clave (ver HashO.java).
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                  // Es el mismo objeto en memoria
        if (!(obj instanceof Register)) return false;   // No es un Register: no son iguales
        Register<?> otro = (Register<?>) obj;           // Se castea para comparar la clave
        return this.key == otro.key;                    // Igualdad basada únicamente en la clave
    }

    /**
     * hashCode coherente con equals(): registros con la misma clave deben
     * producir el mismo hashCode (buena práctica de Java).
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(key); // Se basa únicamente en la clave
    }
}
