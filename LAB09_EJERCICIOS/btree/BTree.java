package btree;

import excepciones.ExcepcionArbolB;

public class BTree<E extends Comparable<E>> {

    private BNode<E> raiz;
    private int orden;

    // Variable de apoyo para la inserción: indica que hubo desbordamiento
    private boolean subio;
    // Nuevo nodo hermano creado tras una división
    private BNode<E> nDes;

    // Indica que el nodo hijo quedó con menos del mínimo de claves
    private boolean faltaClaveAbajo;

    public BTree(int orden) {
        this.orden = orden;
        this.raiz  = null;
    }

    public boolean estaVacio() {
        return this.raiz == null;
    }

    public BNode<E> getRaiz() {
        return this.raiz;
    }

    // INSERCIÓN

    public void insertar(E cl) throws ExcepcionArbolB {
        if (cl == null) throw new ExcepcionArbolB("No se puede insertar una clave nula.");
        subio = false;
        E mediana = empujar(this.raiz, cl);
        if (subio) {
            // La raíz se dividió: crear nueva raíz con la mediana
            BNode<E> nuevaRaiz = new BNode<>(this.orden);
            nuevaRaiz.count = 1;
            nuevaRaiz.keys.set(0, mediana);
            nuevaRaiz.childs.set(0, this.raiz);
            nuevaRaiz.childs.set(1, nDes);
            this.raiz = nuevaRaiz;
        }
    }

    // Desciende hasta la hoja adecuada e inserta, retorna mediana si hubo división
    private E empujar(BNode<E> actual, E cl) {
        int[] pos = new int[1];
        E mediana;

        if (actual == null) {
            subio = true;
            nDes  = null;
            return cl;
        }

        boolean encontrado = actual.buscarEnNodo(cl, pos);

        if (encontrado) {
            System.out.println("Clave duplicada '" + cl + "', no se inserta.");
            subio = false;
            return null;
        }

        mediana = empujar(actual.childs.get(pos[0]), cl);

        if (subio) {
            if (actual.nodoLleno(this.orden - 1)) {
                mediana = dividirNodo(actual, mediana, pos[0]);
            } else {
                subio = false;
                insertarEnNodo(actual, mediana, nDes, pos[0]);
            }
        }
        return mediana;
    }

    // Inserta la clave y puntero derecho en el nodo en la posición k
    private void insertarEnNodo(BNode<E> actual, E cl, BNode<E> rd, int k) {
        for (int i = actual.count - 1; i >= k; i--) {
            actual.keys.set(i + 1, actual.keys.get(i));
            actual.childs.set(i + 2, actual.childs.get(i + 1));
        }
        actual.keys.set(k, cl);
        actual.childs.set(k + 1, rd);
        actual.count++;
    }

    // Divide el nodo lleno, crea nDes con las claves mayores y sube la mediana
    private E dividirNodo(BNode<E> actual, E cl, int k) {
        BNode<E> rd = nDes;
        int posMed;

        posMed = (k <= this.orden / 2) ? this.orden / 2 : this.orden / 2 + 1;

        nDes = new BNode<>(this.orden);

        for (int i = posMed; i < this.orden - 1; i++) {
            nDes.keys.set(i - posMed, actual.keys.get(i));
            nDes.childs.set(i - posMed + 1, actual.childs.get(i + 1));
        }
        nDes.count   = (this.orden - 1) - posMed;
        actual.count = posMed;

        if (k <= this.orden / 2) {
            insertarEnNodo(actual, cl, rd, k);
        } else {
            insertarEnNodo(nDes, cl, rd, k - posMed);
        }

        E mediana = actual.keys.get(actual.count - 1);
        nDes.childs.set(0, actual.childs.get(actual.count));
        actual.count--;
        subio = true;
        return mediana;
    }

    // EJERCICIO 01 — BÚSQUEDA

    // Retorna true si la clave existe e imprime idNodo y posición
    public boolean search(E cl) throws ExcepcionArbolB {
        if (cl == null) throw new ExcepcionArbolB("No se puede buscar una clave nula.");
        if (estaVacio()) {
            System.out.println("El árbol está vacío.");
            return false;
        }
        return buscarRecursivo(this.raiz, cl);
    }

    private boolean buscarRecursivo(BNode<E> actual, E cl) {
        if (actual == null) return false;

        int[] pos = new int[1];
        boolean encontrado = actual.buscarEnNodo(cl, pos);

        if (encontrado) {
            System.out.println(cl + " se encuentra en el nodo " + actual.idNodo
                    + " en la posición " + pos[0] + ".");
            return true;
        }
        return buscarRecursivo(actual.childs.get(pos[0]), cl);
    }

    // EJERCICIO 02 — BÚSQUEDA POR RANGO

    // Muestra en orden ascendente las claves entre min y max inclusive
    public void searchRange(E min, E max) throws ExcepcionArbolB {
        if (min == null || max == null)
            throw new ExcepcionArbolB("Los límites del rango no pueden ser nulos.");
        if (min.compareTo(max) > 0) {
            System.out.println("Rango inválido: min (" + min + ") es mayor que max (" + max + ").");
            return;
        }
        if (estaVacio()) {
            System.out.println("El árbol está vacío.");
            return;
        }

        System.out.print("Claves en [" + min + ", " + max + "]: ");
        StringBuilder resultado = new StringBuilder();
        rangoRecursivo(this.raiz, min, max, resultado);

        if (resultado.length() == 0) {
            System.out.println("(ninguna clave en ese rango)");
        } else {
            System.out.println(resultado.substring(0, resultado.length() - 2));
        }
    }

    // Recorre el árbol acumulando claves dentro del rango, descartando ramas innecesarias
    private void rangoRecursivo(BNode<E> actual, E min, E max, StringBuilder sb) {
        if (actual == null) return;

        for (int i = 0; i < actual.count; i++) {
            if (actual.keys.get(i).compareTo(min) >= 0) {
                rangoRecursivo(actual.childs.get(i), min, max, sb);
            }
            E clave = actual.keys.get(i);
            if (clave.compareTo(min) >= 0 && clave.compareTo(max) <= 0) {
                sb.append(clave).append(", ");
            }
            if (clave.compareTo(max) > 0) return;
        }
        rangoRecursivo(actual.childs.get(actual.count), min, max, sb);
    }

    // EJERCICIO 03 — ELIMINACIÓN

    public void remove(E cl) throws ExcepcionArbolB {
        if (cl == null) throw new ExcepcionArbolB("No se puede eliminar una clave nula.");
        if (estaVacio()) throw new ExcepcionArbolB("El árbol está vacío.");

        faltaClaveAbajo = false;
        eliminarRecursivo(this.raiz, cl);

        // Si la raíz quedó vacía tras una fusión, bajar de nivel
        if (this.raiz != null && this.raiz.count == 0) {
            this.raiz = this.raiz.childs.get(0);
        }
    }

    private boolean eliminarRecursivo(BNode<E> actual, E cl) throws ExcepcionArbolB {
        if (actual == null) {
            System.out.println("Clave '" + cl + "' no encontrada en el árbol.");
            return false;
        }

        int[] pos = new int[1];
        boolean encontrado = actual.buscarEnNodo(cl, pos);

        if (encontrado) {
            if (esHoja(actual)) {
                // Eliminar directamente de la hoja
                quitarDeNodo(actual, pos[0]);
                faltaClaveAbajo = actual.count < minimoClaves();
            } else {
                // Nodo interno: reemplazar por sucesor
                E sucesor = obtenerSucesor(actual.childs.get(pos[0] + 1));
                actual.keys.set(pos[0], sucesor);
                eliminarRecursivo(actual.childs.get(pos[0] + 1), sucesor);
                if (faltaClaveAbajo) {
                    restaurarNodo(actual, pos[0] + 1);
                }
            }
            return true;
        }

        boolean resultado = eliminarRecursivo(actual.childs.get(pos[0]), cl);
        if (faltaClaveAbajo) {
            restaurarNodo(actual, pos[0]);
        }
        return resultado;
    }

    // Obtiene el menor elemento del subárbol (sucesor inmediato)
    private E obtenerSucesor(BNode<E> nodo) {
        if (esHoja(nodo)) return nodo.keys.get(0);
        return obtenerSucesor(nodo.childs.get(0));
    }

    // Restaura el mínimo de claves: intenta redistribución, si no fusiona
    private void restaurarNodo(BNode<E> padre, int indicePosHijo) throws ExcepcionArbolB {
        BNode<E> hijoDeficiente = padre.childs.get(indicePosHijo);

        if (indicePosHijo < padre.count) {
            BNode<E> hermanoDer = padre.childs.get(indicePosHijo + 1);
            if (hermanoDer != null && hermanoDer.count > minimoClaves()) {
                redistribuirDesdeHermanoDerecho(padre, indicePosHijo, hijoDeficiente, hermanoDer);
                faltaClaveAbajo = false;
                return;
            }
        }

        if (indicePosHijo > 0) {
            BNode<E> hermanoIzq = padre.childs.get(indicePosHijo - 1);
            if (hermanoIzq != null && hermanoIzq.count > minimoClaves()) {
                redistribuirDesdeHermanoIzquierdo(padre, indicePosHijo, hijoDeficiente, hermanoIzq);
                faltaClaveAbajo = false;
                return;
            }
        }

        if (indicePosHijo < padre.count) {
            BNode<E> hermanoDer = padre.childs.get(indicePosHijo + 1);
            fusionar(padre, indicePosHijo, hijoDeficiente, hermanoDer);
        } else {
            BNode<E> hermanoIzq = padre.childs.get(indicePosHijo - 1);
            fusionar(padre, indicePosHijo - 1, hermanoIzq, hijoDeficiente);
        }

        faltaClaveAbajo = padre.count < minimoClaves();
    }

    // Redistribución desde hermano derecho: la clave separadora baja y la primera del hermano sube
    private void redistribuirDesdeHermanoDerecho(BNode<E> padre, int pos,
            BNode<E> hijoIzq, BNode<E> hijoDer) {
        hijoIzq.keys.set(hijoIzq.count, padre.keys.get(pos));
        hijoIzq.childs.set(hijoIzq.count + 1, hijoDer.childs.get(0));
        hijoIzq.count++;

        padre.keys.set(pos, hijoDer.keys.get(0));

        for (int i = 0; i < hijoDer.count - 1; i++) {
            hijoDer.keys.set(i, hijoDer.keys.get(i + 1));
            hijoDer.childs.set(i, hijoDer.childs.get(i + 1));
        }
        hijoDer.childs.set(hijoDer.count - 1, hijoDer.childs.get(hijoDer.count));
        hijoDer.childs.set(hijoDer.count, null);
        hijoDer.keys.set(hijoDer.count - 1, null);
        hijoDer.count--;
    }

    // Redistribución desde hermano izquierdo: la clave separadora baja y la última del hermano sube
    private void redistribuirDesdeHermanoIzquierdo(BNode<E> padre, int pos,
            BNode<E> hijoDer, BNode<E> hijoIzq) {
        for (int i = hijoDer.count; i > 0; i--) {
            hijoDer.keys.set(i, hijoDer.keys.get(i - 1));
            hijoDer.childs.set(i + 1, hijoDer.childs.get(i));
        }
        hijoDer.childs.set(1, hijoDer.childs.get(0));

        hijoDer.keys.set(0, padre.keys.get(pos - 1));
        hijoDer.childs.set(0, hijoIzq.childs.get(hijoIzq.count));
        hijoDer.count++;

        padre.keys.set(pos - 1, hijoIzq.keys.get(hijoIzq.count - 1));
        hijoIzq.keys.set(hijoIzq.count - 1, null);
        hijoIzq.childs.set(hijoIzq.count, null);
        hijoIzq.count--;
    }

    // Fusión: une el hijo izquierdo y derecho bajando la clave separadora del padre
    private void fusionar(BNode<E> padre, int posIzq,
            BNode<E> hijoIzq, BNode<E> hijoDer) {
        hijoIzq.keys.set(hijoIzq.count, padre.keys.get(posIzq));
        hijoIzq.childs.set(hijoIzq.count + 1, hijoDer.childs.get(0));
        hijoIzq.count++;

        for (int i = 0; i < hijoDer.count; i++) {
            hijoIzq.keys.set(hijoIzq.count, hijoDer.keys.get(i));
            hijoIzq.childs.set(hijoIzq.count + 1, hijoDer.childs.get(i + 1));
            hijoIzq.count++;
        }

        for (int i = posIzq; i < padre.count - 1; i++) {
            padre.keys.set(i, padre.keys.get(i + 1));
            padre.childs.set(i + 1, padre.childs.get(i + 2));
        }
        padre.keys.set(padre.count - 1, null);
        padre.childs.set(padre.count, null);
        padre.count--;
    }

    private boolean esHoja(BNode<E> nodo) {
        return nodo.childs.get(0) == null;
    }

    private int minimoClaves() {
        return (int) Math.ceil(orden / 2.0) - 1;
    }

    private void quitarDeNodo(BNode<E> nodo, int pos) {
        for (int i = pos; i < nodo.count - 1; i++) {
            nodo.keys.set(i, nodo.keys.get(i + 1));
            nodo.childs.set(i + 1, nodo.childs.get(i + 2));
        }
        nodo.keys.set(nodo.count - 1, null);
        nodo.childs.set(nodo.count, null);
        nodo.count--;
    }

    // Representación en tabla del árbol B
    @Override
    public String toString() {
        if (estaVacio()) return "BTree is empty...";
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-25s %-12s %s%n",
                "Id.Nodo", "Claves Nodo", "Id.Padre", "Id.Hijos"));
        sb.append("-".repeat(65)).append("\n");
        return writeTree(this.raiz, -1, sb).toString();
    }

    private StringBuilder writeTree(BNode<E> actual, int idPadre, StringBuilder sb) {
        if (actual == null) return sb;

        StringBuilder claves = new StringBuilder("(");
        for (int i = 0; i < actual.count; i++) {
            claves.append(actual.keys.get(i));
            if (i < actual.count - 1) claves.append(", ");
        }
        claves.append(")");

        StringBuilder hijos = new StringBuilder("[");
        boolean tieneHijos = false;
        for (int i = 0; i <= actual.count; i++) {
            if (actual.childs.get(i) != null) {
                hijos.append(actual.childs.get(i).idNodo);
                if (i < actual.count) hijos.append(", ");
                tieneHijos = true;
            }
        }
        hijos.append("]");

        String strPadre = (idPadre == -1) ? "--" : "[" + idPadre + "]";
        String strHijos = tieneHijos ? hijos.toString() : "--";

        sb.append(String.format("%-10d %-25s %-12s %s%n",
                actual.idNodo, claves.toString(), strPadre, strHijos));

        for (int i = 0; i <= actual.count; i++) {
            writeTree(actual.childs.get(i), actual.idNodo, sb);
        }
        return sb;
    }

    public int altura() {
        if (estaVacio()) return 0;
        int h = 0;
        BNode<E> nodo = this.raiz;
        while (nodo != null) {
            h++;
            nodo = nodo.childs.get(0);
        }
        return h;
    }

    public int totalClaves() {
        return contarClaves(this.raiz);
    }

    private int contarClaves(BNode<E> actual) {
        if (actual == null) return 0;
        int total = actual.count;
        for (int i = 0; i <= actual.count; i++) {
            total += contarClaves(actual.childs.get(i));
        }
        return total;
    }

    // Búsqueda mostrando el camino recorrido nodo a nodo (para ejercicio 04)
    public boolean searchConCamino(E cl) throws ExcepcionArbolB {
        if (cl == null) throw new ExcepcionArbolB("La clave de búsqueda no puede ser nula.");
        if (estaVacio()) {
            System.out.println("El árbol está vacío.");
            return false;
        }
        System.out.println("Camino de búsqueda para '" + cl + "':");
        return buscarConCamino(this.raiz, cl, 0);
    }

    private boolean buscarConCamino(BNode<E> actual, E cl, int nivel) {
        if (actual == null) {
            System.out.println("-> Clave no encontrada.");
            return false;
        }

        // Mostrar claves del nodo actual con sangría según nivel
        String sangria = "  ".repeat(nivel);
        StringBuilder claves = new StringBuilder("(");
        for (int i = 0; i < actual.count; i++) {
            claves.append(actual.keys.get(i));
            if (i < actual.count - 1) claves.append(", ");
        }
        claves.append(")");
        System.out.println(sangria + "Nodo[id=" + actual.idNodo + "] claves: " + claves);

        int[] pos = new int[1];
        boolean encontrado = actual.buscarEnNodo(cl, pos);

        if (encontrado) {
            System.out.println(sangria + "-> Encontrada en nodo " + actual.idNodo
                    + ", posición " + pos[0] + ".");
            return true;
        }
        return buscarConCamino(actual.childs.get(pos[0]), cl, nivel + 1);
    }

    // Recolecta todas las claves en orden ascendente
    public void recolectarInOrden(java.util.List<E> lista) {
        recolectarRecursivo(this.raiz, lista);
    }

    private void recolectarRecursivo(BNode<E> actual, java.util.List<E> lista) {
        if (actual == null) return;
        for (int i = 0; i < actual.count; i++) {
            recolectarRecursivo(actual.childs.get(i), lista);
            lista.add(actual.keys.get(i));
        }
        recolectarRecursivo(actual.childs.get(actual.count), lista);
    }
}
