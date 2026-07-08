

public class Register<T> {

    private int key;   // Clave entera única que identifica al registro dentro de la tabla
    private T data;     // Dato genérico asociado a la clave (puede ser cualquier tipo de objeto)

    public Register(int key, T data) {
        this.key = key;     // Se asigna la clave recibida al atributo interno "key"
        this.data = data;   // Se asigna el dato recibido al atributo interno "data"
    }

    public int getKey() {
        return key; // Devuelve el valor almacenado en el atributo key
    }

    public T getData() {
        return data; // Devuelve el valor almacenado en el atributo data
    }

    public void setData(T data) {
        this.data = data; // Reemplaza el dato actual por el nuevo valor recibido
    }
    @Override
    public String toString() {
        return "(" + key + ", " + data + ")"; // Concatena clave y dato en formato (key, data)
    }
}
