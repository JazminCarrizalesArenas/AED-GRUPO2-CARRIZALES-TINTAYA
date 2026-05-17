class AVLTree<E extends Comparable<E>> extends LinkedBST<E> {

    // Indica si la altura cambió
    private boolean cambioAltura;

    // =================================================
    // INSERTAR
    // =================================================
    @Override
    public void insert(E dato) throws ItemDuplicated {

        cambioAltura = false;

        System.out.println("\n=================================");
        System.out.println("INSERTANDO " + dato);
        System.out.println("=================================");

        root = insertarAVL(dato, (NodeAVL<E>) root);

        System.out.println("\nÁRBOL ACTUAL:");
        printTree();
    }

    protected Node<E> insertarAVL(E dato,NodeAVL<E> nodoActual)throws ItemDuplicated {

        NodeAVL<E> nodoPadre = nodoActual;

        // =================================================
        // SI EL NODO ES NULL
        // =================================================
        if (nodoActual == null) {

            cambioAltura = true;
            nodoPadre = new NodeAVL<>(dato);
        }

        else {

            // Comparar
            int comparacion =nodoActual.data.compareTo(dato);
            // =================================================
            // DATO DUPLICADO
            // =================================================
            if (comparacion == 0) {
                throw new ItemDuplicated("Dato duplicado");
            }

            // =================================================
            // INSERTAR POR DERECHA
            // =================================================
            if (comparacion < 0) {
                System.out.println(dato + " es mayor que "+ nodoActual.data + ".");
                System.out.println( "Se inserta a la derecha.");
                nodoPadre.right =insertarAVL(dato,(NodeAVL<E>) nodoActual.right);

                // =================================================
                // VERIFICAR BALANCE
                // =================================================
                if (cambioAltura) {
                    switch (nodoPadre.bf) {
                        case -1:
                            nodoPadre.bf = 0;
                            cambioAltura = false;
                            break;

                        case 0:
                            nodoPadre.bf = 1;
                            cambioAltura = true;
                            break;

                        // =================================================
                        // DESBALANCE DERECHA
                        // =================================================
                        case 1:
                            nodoPadre =balancearIzquierda(nodoPadre);
                            cambioAltura = false;
                            break;
                    }
                }
            }

            // =================================================
            // INSERTAR POR IZQUIERDA
            // =================================================
            else {
                System.out.println(dato + " es menor que "+ nodoActual.data + ".");
                System.out.println("Se inserta a la izquierda.");

                nodoPadre.left =insertarAVL(dato,(NodeAVL<E>) nodoActual.left);

                // =================================================
                // VERIFICAR BALANCE
                // =================================================
                if (cambioAltura) {
                    switch (nodoPadre.bf) {
                        case 1:
                            nodoPadre.bf = 0;
                            cambioAltura = false;
                            break;

                        case 0:
                            nodoPadre.bf = -1;
                            cambioAltura = true;
                            break;

                        // =================================================
                        // DESBALANCE IZQUIERDA
                        // =================================================
                        case -1:
                            nodoPadre =balancearDerecha( nodoPadre);
                            cambioAltura = false;
                            break;
                    }
                }
            }
        }

        return nodoPadre;
    }

    // =================================================
    // BALANCEAR IZQUIERDA
    // =================================================
    private NodeAVL<E> balancearIzquierda(NodeAVL<E> nodoDesbalanceado) {
        NodeAVL<E> hijoDerecho =(NodeAVL<E>) nodoDesbalanceado.right;

        switch (hijoDerecho.bf) {

            // =================================================
            // CASO DERECHA - DERECHA
            // =================================================
            case 1:
                System.out.println("Se genera desbalance DERECHA-DERECHA.");
                System.out.println("Se aplica rotación simple izquierda.");
                nodoDesbalanceado.bf = 0;
                hijoDerecho.bf = 0;
                nodoDesbalanceado =rotacionSimpleIzquierda(nodoDesbalanceado);
                break;

            // =================================================
            // CASO DERECHA - IZQUIERDA
            // =================================================
            case -1:
                System.out.println("Se genera desbalance DERECHA-IZQUIERDA.");
                System.out.println("Se aplica rotación doble.");

                NodeAVL<E> nieto =(NodeAVL<E>) hijoDerecho.left;

                switch (nieto.bf) {
                    case -1:
                        nodoDesbalanceado.bf = 0;
                        hijoDerecho.bf = 1;
                        break;

                    case 0:
                        nodoDesbalanceado.bf = 0;
                        hijoDerecho.bf = 0;
                        break;

                    case 1:
                        nodoDesbalanceado.bf = -1;
                        hijoDerecho.bf = 0;
                        break;
                }

                nieto.bf = 0;

                nodoDesbalanceado.right =rotacionSimpleDerecha( hijoDerecho );
                nodoDesbalanceado =rotacionSimpleIzquierda( nodoDesbalanceado);
                break;
        }
        return nodoDesbalanceado;
    }

    // =================================================
    // BALANCEAR DERECHA
    // =================================================
    private NodeAVL<E> balancearDerecha(NodeAVL<E> nodoDesbalanceado) {

        NodeAVL<E> hijoIzquierdo =(NodeAVL<E>) nodoDesbalanceado.left;

        switch (hijoIzquierdo.bf) {
            // =================================================
            // CASO IZQUIERDA - IZQUIERDA
            // =================================================
            case -1:
                System.out.println( "Se genera desbalance IZQUIERDA-IZQUIERDA.");
                System.out.println("Se aplica rotación simple derecha.");

                nodoDesbalanceado.bf = 0;
                hijoIzquierdo.bf = 0;
                nodoDesbalanceado =rotacionSimpleDerecha( nodoDesbalanceado);
                break;

            // =================================================
            // CASO IZQUIERDA - DERECHA
            // =================================================
            case 1:
                System.out.println( "Se genera desbalance IZQUIERDA-DERECHA.");
                System.out.println( "Se aplica rotación doble.");

                NodeAVL<E> nieto =(NodeAVL<E>) hijoIzquierdo.right;

                switch (nieto.bf) {
                    case 1:
                        nodoDesbalanceado.bf = 0;
                        hijoIzquierdo.bf = -1;
                        break;

                    case 0:
                        nodoDesbalanceado.bf = 0;
                        hijoIzquierdo.bf = 0;
                        break;

                    case -1:
                        nodoDesbalanceado.bf = 1;
                        hijoIzquierdo.bf = 0;
                        break;
                }

                nieto.bf = 0;

                nodoDesbalanceado.left =rotacionSimpleIzquierda(hijoIzquierdo);
                nodoDesbalanceado =rotacionSimpleDerecha(nodoDesbalanceado);
                break;
        }

        return nodoDesbalanceado;
    }

    // =================================================
    // ROTACIÓN SIMPLE IZQUIERDA
    // =================================================
    private NodeAVL<E> rotacionSimpleIzquierda(NodeAVL<E> nodo) {
        NodeAVL<E> nuevoPadre =(NodeAVL<E>) nodo.right;
        nodo.right = nuevoPadre.left;
        nuevoPadre.left = nodo;
        return nuevoPadre;
    }

    // =================================================
    // ROTACIÓN SIMPLE DERECHA
    // =================================================
    private NodeAVL<E> rotacionSimpleDerecha(NodeAVL<E> nodo) {

        NodeAVL<E> nuevoPadre =(NodeAVL<E>) nodo.left;
        nodo.left = nuevoPadre.right;
        nuevoPadre.right = nodo;
        return nuevoPadre;
    }

    // =================================================
    // IMPRIMIR ÁRBOL
    // =================================================
    public void printTree() {
        printTreeRec(root, 0);
    }

    private void printTreeRec(Node<E> node,int nivel) {
        if (node == null)
            return;

        // Mostrar derecha
        printTreeRec(node.right, nivel + 1);

        // Espacios
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        // Mostrar nodo
        System.out.println(node);
        // Mostrar izquierda
        printTreeRec(node.left, nivel + 1);
    }
    // =================================================
    // ELIMINAR EN AVL
    // =================================================
    public void delete(E dato) throws ExceptionIsEmpty {
    
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Árbol vacío");
        }
    
        System.out.println("\n=================================");
        System.out.println("ELIMINANDO " + dato);
        System.out.println("=================================");
    
        root = eliminarAVL((NodeAVL<E>) root, dato);
    
        System.out.println("\nÁRBOL ACTUAL:");
        printTree();
    }
    
    private NodeAVL<E> eliminarAVL(NodeAVL<E> nodo, E dato) {
    
        // Si no existe
        if (nodo == null) {
            System.out.println("Dato no encontrado.");
            return null;
        }
    
        // Comparar
        int comparacion = dato.compareTo(nodo.data);
    
        // =================================================
        // BUSCAR POR IZQUIERDA
        // =================================================
        if (comparacion < 0) {
    
            System.out.println(dato + " es menor que "
                    + nodo.data + ".");
    
            nodo.left = eliminarAVL(
                    (NodeAVL<E>) nodo.left,
                    dato
            );
        }
    
        // =================================================
        // BUSCAR POR DERECHA
        // =================================================
        else if (comparacion > 0) {
    
            System.out.println(dato + " es mayor que "
                    + nodo.data + ".");
    
            nodo.right = eliminarAVL(
                    (NodeAVL<E>) nodo.right,
                    dato
            );
        }
    
        // =================================================
        // NODO ENCONTRADO
        // =================================================
        else {
    
            System.out.println("Se encontró el nodo "
                    + dato + ".");
    
            // =============================================
            // CASO 1: SIN HIJOS
            // =============================================
            if (nodo.left == null &&
                    nodo.right == null) {
    
                System.out.println(
                        "El nodo es hoja. Se elimina."
                );
    
                return null;
            }
    
            // =============================================
            // CASO 2: SOLO HIJO DERECHO
            // =============================================
            if (nodo.left == null) {
    
                System.out.println(
                        "El nodo tiene hijo derecho."
                );
    
                return (NodeAVL<E>) nodo.right;
            }
    
            // =============================================
            // CASO 3: SOLO HIJO IZQUIERDO
            // =============================================
            if (nodo.right == null) {
    
                System.out.println(
                        "El nodo tiene hijo izquierdo."
                );
    
                return (NodeAVL<E>) nodo.left;
            }
    
            // =============================================
            // CASO 4: DOS HIJOS
            // =============================================
            NodeAVL<E> sucesor =
                    obtenerMenor(
                            (NodeAVL<E>) nodo.right
                    );
    
            System.out.println(
                    "El nodo tiene dos hijos."
            );
    
            System.out.println(
                    "Se reemplaza por el sucesor "
                            + sucesor.data
            );
    
            nodo.data = sucesor.data;
    
            nodo.right = eliminarAVL(
                    (NodeAVL<E>) nodo.right,
                    sucesor.data
            );
        }
    
        return nodo;
    }
    
    // =================================================
    // OBTENER MENOR
    // =================================================
    private NodeAVL<E> obtenerMenor(NodeAVL<E> nodo) {
    
        while (nodo.left != null) {
            nodo = (NodeAVL<E>) nodo.left;
        }
    
        return nodo;
    }
}