package ejercicio3;


public class PruebaEjercicio3 {

    public static void main(String[] args) {
        HashEncadenado tabla = new HashEncadenado(7);

        tabla.insertar(new Registro(10, "Juan"));
        tabla.insertar(new Registro(17, "Ana"));
        tabla.insertar(new Registro(24, "Luis"));
        tabla.insertar(new Registro(31, "Rosa"));
        tabla.insertar(new Registro(5, "Pedro"));
        tabla.insertar(new Registro(12, "Carla"));

        System.out.println("Tabla hash abierta:");
        tabla.mostrarTabla();

        System.out.println();
        System.out.println("Claves que colisionan en la posicion 3: 10, 17, 24, 31");
        System.out.println("Claves que colisionan en la posicion 5: 5, 12");

        System.out.println();
        System.out.println("Buscando la clave 24:");
        tabla.buscar(24);

        System.out.println();
        System.out.println("Eliminando la clave 17:");
        tabla.eliminar(17);

        System.out.println();
        System.out.println("Tabla despues de eliminar:");
        tabla.mostrarTabla();

        int nodosRestantes = tabla.contarNodos(3);
        System.out.println();
        System.out.println("Nodos restantes en la cadena de la posicion 3: " + nodosRestantes);
    }
}
