
package avl;

public class ArbolAVL {

    public NodoAVL raiz;

    // Obtener altura
    public int altura(NodoAVL nodo) {

        if (nodo == null) {
            return 0;
        }

        return nodo.altura;
    }

    // Obtener máximo
    public int maximo(int a, int b) {
        return Math.max(a, b);
    }

    // Obtener balance
    public int obtenerBalance(NodoAVL nodo) {

        if (nodo == null) {
            return 0;
        }

        return altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    // Rotación derecha
    public NodoAVL rotarDerecha(NodoAVL y) {

        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        y.altura = maximo(altura(y.izquierdo),
                           altura(y.derecho)) + 1;

        x.altura = maximo(altura(x.izquierdo),
                           altura(x.derecho)) + 1;

        return x;
    }

    // Rotación izquierda
    public NodoAVL rotarIzquierda(NodoAVL x) {

        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        x.altura = maximo(altura(x.izquierdo),
                           altura(x.derecho)) + 1;

        y.altura = maximo(altura(y.izquierdo),
                           altura(y.derecho)) + 1;

        return y;
    }

    // Insertar nodo
    public NodoAVL insertar(NodoAVL nodo, int dato) {

        if (nodo == null) {
            return new NodoAVL(dato);
        }

        if (dato < nodo.dato) {
            nodo.izquierdo = insertar(nodo.izquierdo, dato);
        }

        else if (dato > nodo.dato) {
            nodo.derecho = insertar(nodo.derecho, dato);
        }

        else {
            return nodo;
        }

        nodo.altura = 1 + maximo(
                altura(nodo.izquierdo),
                altura(nodo.derecho));

        int balance = obtenerBalance(nodo);

        // Caso Izquierda-Izquierda
        if (balance > 1 && dato < nodo.izquierdo.dato) {
            return rotarDerecha(nodo);
        }

        // Caso Derecha-Derecha
        if (balance < -1 && dato > nodo.derecho.dato) {
            return rotarIzquierda(nodo);
        }

        // Caso Izquierda-Derecha
        if (balance > 1 && dato > nodo.izquierdo.dato) {

            nodo.izquierdo =
                    rotarIzquierda(nodo.izquierdo);

            return rotarDerecha(nodo);
        }

        // Caso Derecha-Izquierda
        if (balance < -1 && dato < nodo.derecho.dato) {

            nodo.derecho =
                    rotarDerecha(nodo.derecho);

            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // Buscar nodo
    public boolean buscar(NodoAVL nodo, int dato) {

        if (nodo == null) {
            return false;
        }

        if (dato == nodo.dato) {
            return true;
        }

        if (dato < nodo.dato) {
            return buscar(nodo.izquierdo, dato);
        }

        return buscar(nodo.derecho, dato);
    }

    // Nodo mínimo
    public NodoAVL nodoMinimo(NodoAVL nodo) {

        NodoAVL actual = nodo;

        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }

        return actual;
    }

    // Eliminar nodo
    public NodoAVL eliminar(NodoAVL raiz, int dato) {

        if (raiz == null) {
            return raiz;
        }

        if (dato < raiz.dato) {

            raiz.izquierdo =
                    eliminar(raiz.izquierdo, dato);
        }

        else if (dato > raiz.dato) {

            raiz.derecho =
                    eliminar(raiz.derecho, dato);
        }

        else {

            // Nodo con un hijo o sin hijos
            if ((raiz.izquierdo == null)
                    || (raiz.derecho == null)) {

                NodoAVL temp;

                if (raiz.izquierdo != null) {
                    temp = raiz.izquierdo;
                } else {
                    temp = raiz.derecho;
                }

                // Sin hijos
                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                }

                // Un hijo
                else {
                    raiz = temp;
                }
            }

            // Nodo con dos hijos
            else {

                NodoAVL temp =
                        nodoMinimo(raiz.derecho);

                raiz.dato = temp.dato;

                raiz.derecho =
                        eliminar(raiz.derecho,
                                temp.dato);
            }
        }

        if (raiz == null) {
            return raiz;
        }

        raiz.altura = maximo(
                altura(raiz.izquierdo),
                altura(raiz.derecho)) + 1;

        int balance = obtenerBalance(raiz);

        // Izquierda-Izquierda
        if (balance > 1
                && obtenerBalance(raiz.izquierdo) >= 0) {

            return rotarDerecha(raiz);
        }

        // Izquierda-Derecha
        if (balance > 1
                && obtenerBalance(raiz.izquierdo) < 0) {

            raiz.izquierdo =
                    rotarIzquierda(raiz.izquierdo);

            return rotarDerecha(raiz);
        }

        // Derecha-Derecha
        if (balance < -1
                && obtenerBalance(raiz.derecho) <= 0) {

            return rotarIzquierda(raiz);
        }

        // Derecha-Izquierda
        if (balance < -1
                && obtenerBalance(raiz.derecho) > 0) {

            raiz.derecho =
                    rotarDerecha(raiz.derecho);

            return rotarIzquierda(raiz);
        }

        return raiz;
    }

    // Recorrido Inorden
    public void inorden(NodoAVL nodo) {

        if (nodo != null) {

            inorden(nodo.izquierdo);

            System.out.print(nodo.dato + " ");

            inorden(nodo.derecho);
        }
    }
}