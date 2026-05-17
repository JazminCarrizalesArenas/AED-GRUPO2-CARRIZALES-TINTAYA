// ===============================
// PAQUETE: productos
// CLASE: RegistroProductos.java
// ===============================

package productos;

import avl.ArbolAVL;

public class RegistroProductos {

    private ArbolAVL productos;

    public RegistroProductos() {

        productos = new ArbolAVL();
    }

    public void ejecutar() {

        System.out.println("===== PRODUCTOS =====");

        productos.raiz =
                productos.insertar(productos.raiz, 30);

        productos.raiz =
                productos.insertar(productos.raiz, 20);

        productos.raiz =
                productos.insertar(productos.raiz, 40);

        productos.raiz =
                productos.insertar(productos.raiz, 10);

        productos.raiz =
                productos.insertar(productos.raiz, 25);

        System.out.println("Recorrido inorden:");

        productos.inorden(productos.raiz);

        boolean encontrado =
                productos.buscar(productos.raiz, 25);

        if (encontrado) {

            System.out.println(
                    "\nProducto encontrado");
        }

        else {

            System.out.println(
                    "\nProducto no encontrado");
        }

        productos.raiz =
                productos.eliminar(productos.raiz, 20);

        System.out.println(
                "\nDespués de eliminar:");

        productos.inorden(productos.raiz);

        System.out.println();
    }
}