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
    // DELETE AVL
    // =================================================
    public void delete(E data) throws ExceptionIsEmpty {

        System.out.println("\n====================");
        System.out.println("ELIMINANDO " + data);
        System.out.println("====================");

        root = deleteAVL(
                (NodeAVL<E>) root,
                data
        );

        System.out.println("\nÁRBOL AVL:");

        printTree();
    }

    // =================================================
    // DELETE AVL RECURSIVO
    // =================================================
    private NodeAVL<E> deleteAVL(
            NodeAVL<E> node,
            E data) {

        if (node == null)
            return null;

        int cmp = data.compareTo(node.data);

        // =============================================
        // IZQUIERDA
        // =============================================
        if (cmp < 0) {

            node.left = deleteAVL(
                    (NodeAVL<E>) node.left,
                    data
            );
        }

        // =============================================
        // DERECHA
        // =============================================
        else if (cmp > 0) {

            node.right = deleteAVL(
                    (NodeAVL<E>) node.right,
                    data
            );
        }

        // =============================================
        // ENCONTRÓ NODO
        // =============================================
        else {

            System.out.println(
                    "Nodo encontrado: "
                            + node.data
            );

            // HOJA
            if (node.left == null
                    && node.right == null) {

                System.out.println(
                        "Caso BST: Nodo hoja"
                );

                return null;
            }

            // SOLO HIJO DERECHO
            if (node.left == null) {

                System.out.println(
                        "Caso BST: Un hijo derecho"
                );

                return (NodeAVL<E>) node.right;
            }

            // SOLO HIJO IZQUIERDO
            if (node.right == null) {

                System.out.println(
                        "Caso BST: Un hijo izquierdo"
                );

                return (NodeAVL<E>) node.left;
            }

            // DOS HIJOS
            NodeAVL<E> sucesor =
                    getMin(
                            (NodeAVL<E>) node.right
                    );

            System.out.println(
                    "Caso BST: Dos hijos"
            );

            System.out.println(
                    "Sucesor usado: "
                            + sucesor.data
            );

            node.data = sucesor.data;

            node.right =
                    deleteAVL(
                            (NodeAVL<E>) node.right,
                            sucesor.data
                    );
        }

        // =============================================
        // ACTUALIZAR BF
        // =============================================
        node.bf =
                altura((NodeAVL<E>) node.right)
                        -
                        altura((NodeAVL<E>) node.left);

        // =============================================
        // REBALANCEAR
        // =============================================
        if (node.bf < -1) {

            System.out.println(
                    "Nodo desbalanceado: "
                            + node.data
            );

            return balancearDerecha(node);
        }

        if (node.bf > 1) {

            System.out.println(
                    "Nodo desbalanceado: "
                            + node.data
            );

            return balancearIzquierda(node);
        }

        return node;
    }
    // =================================================
    // ALTURA AVL
    // =================================================
    private int altura(NodeAVL<E> node) {

        if (node == null)
            return 0;

        int izq =
                altura((NodeAVL<E>) node.left);

        int der =
                altura((NodeAVL<E>) node.right);

        return Math.max(izq, der) + 1;
    }
   
    // =================================================
    // OBTENER MENOR
    // =================================================
    private NodeAVL<E> getMin(NodeAVL<E> nodo) {
    
        while (nodo.left != null) {
            nodo = (NodeAVL<E>) nodo.left;
        }
    
        return nodo;
    }
    // =================================================
    // RECORRIDO POR NIVELES
    // =================================================
    public void recorridoPorNiveles() {
    
        int h = altura((NodeAVL<E>) root);
    
        for(int i = 0; i < h; i++) {
    
            System.out.print("Nivel " + i + ": ");
    
            imprimirNivel(root, i);
    
            System.out.println();
        }
    }
    //ejerciocio 5:
    // =================================================
    // RECORRIDO POR AMPLITUD (BFS RECURSIVO)
    // =================================================
    public void recorridoAmplitud() {
    
        int h = altura((NodeAVL<E>) root);
    
        for(int i = 0; i < h; i++) {
            imprimirNivel(root, i);
        }
        System.out.println();
    }
    
    // =================================================
    // IMPRIMIR NODOS DE UN NIVEL
    // =================================================
    private void imprimirNivel(Node<E> node,int nivel) {
    
        if(node == null)
            return;
    
        // Si llegó al nivel
        if(nivel == 0) {
            System.out.print( node.data + ", ");
        }
    
        else {
    
            imprimirNivel(node.left,nivel - 1);
            imprimirNivel(node.right,nivel - 1 );
        }
    }
    
}