package ejercicio6;

// Tabla hash con encadenamiento que simula un cache de sesiones activas,
// indexado por el token de sesion
public class SessionCache {

    private static class Nodo {
        Session sesion;
        Nodo siguiente;

        Nodo(Session sesion) {
            this.sesion = sesion;
        }
    }

    private Nodo[] tabla;
    private int tamano;

    public SessionCache(int tamano) {
        this.tamano = tamano;
        tabla = new Nodo[tamano];
    }

    private int hash(String token) {
        // Math.abs evita indices negativos, ya que hashCode puede ser negativo
        return Math.abs(token.hashCode()) % tamano;
    }

    public void login(String token, String username, String role, long ttlMs) {
        long expiresAt = System.currentTimeMillis() + ttlMs;
        Session nuevaSession = new Session(token, username, role, expiresAt);
        int pos = hash(token);

        // Si ya existe una sesion con el mismo token se reemplaza
        Nodo actual = tabla[pos];
        while (actual != null) {
            if (actual.sesion.getToken().equals(token)) {
                actual.sesion = nuevaSession;
                return;
            }
            actual = actual.siguiente;
        }

        Nodo nuevoNodo = new Nodo(nuevaSession);
        nuevoNodo.siguiente = tabla[pos];
        tabla[pos] = nuevoNodo;
    }

    public Session validate(String token) {
        int pos = hash(token);
        Nodo actual = tabla[pos];

        while (actual != null) {
            if (actual.sesion.getToken().equals(token)) {
                if (actual.sesion.estaExpirada()) {
                    return null;
                }
                return actual.sesion;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void logout(String token) {
        int pos = hash(token);
        Nodo actual = tabla[pos];
        Nodo anterior = null;

        while (actual != null) {
            if (actual.sesion.getToken().equals(token)) {
                if (anterior == null) {
                    tabla[pos] = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }

    // Recorre toda la tabla y elimina las sesiones cuyo expiresAt ya paso
    public void cleanExpired() {
        for (int i = 0; i < tamano; i++) {
            Nodo actual = tabla[i];
            Nodo anterior = null;

            while (actual != null) {
                if (actual.sesion.estaExpirada()) {
                    if (anterior == null) {
                        tabla[i] = actual.siguiente;
                        actual = tabla[i];
                    } else {
                        anterior.siguiente = actual.siguiente;
                        actual = anterior.siguiente;
                    }
                } else {
                    anterior = actual;
                    actual = actual.siguiente;
                }
            }
        }
    }

    public int contarSesionesActivas() {
        int cantidad = 0;
        for (int i = 0; i < tamano; i++) {
            Nodo actual = tabla[i];
            while (actual != null) {
                cantidad++;
                actual = actual.siguiente;
            }
        }
        return cantidad;
    }
}
