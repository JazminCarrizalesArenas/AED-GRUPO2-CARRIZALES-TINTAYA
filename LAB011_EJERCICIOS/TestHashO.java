

public class Register<T> {

    private int key;   // Clave entera única que identifica al registro dentro de la tabla
    private T data;     // Dato genérico asociado a la clave (puede ser cualquier tipo de objeto)

    /**
     * Constructor que inicializa un registro con su clave y su dato genérico.
     *
     * @param key  clave entera del registro
     * @param data dato genérico asociado a la clave
     */
    public Register(int key, T data) {
        this.key = key;     // Se asigna la clave recibida al atributo interno "key"
        this.data = data;   // Se asigna el dato recibido al atributo interno "data"
    }

    /**
     * Retorna la clave entera del registro.
     *
     * @return clave del registro
     */
    public int getKey() {
        return key; // Devuelve el valor almacenado en el atributo key
    }

    /**
     * Retorna el dato genérico almacenado en el registro.
     *
     * @return dato genérico de tipo T
     */
    public T getData() {
        return data; // Devuelve el valor almacenado en el atributo data
    }

    /**
     * Permite modificar el dato genérico almacenado, sin tener que crear
     * un nuevo objeto Register (útil al actualizar una clave existente).
     *
     * @param data nuevo valor a almacenar
     */
    public void setData(T data) {
        this.data = data; // Reemplaza el dato actual por el nuevo valor recibido
    }

    /**
     * Representación en texto del registro, utilizada para depuración
     * e impresión del contenido de la tabla hash.
     */
    @Override
    public String toString() {
        return "(" + key + ", " + data + ")"; // Concatena clave y dato en formato (key, data)
    }
}
