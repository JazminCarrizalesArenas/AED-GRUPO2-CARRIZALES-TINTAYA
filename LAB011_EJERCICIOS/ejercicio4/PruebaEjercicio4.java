package ejercicio4;

public class PruebaEjercicio4 {

    public static void main(String[] args) {
        HashConBorrado tabla = new HashConBorrado(7);

        tabla.insertar(5);
        tabla.insertar(12);
        tabla.insertar(19);
        tabla.insertar(26);

        System.out.println();
        System.out.println("Tabla inicial:");
        tabla.mostrarTabla();

        System.out.println();
        System.out.println("Eliminando logicamente la clave 12:");
        tabla.eliminar(12);

        System.out.println();
        System.out.println("Tabla despues de eliminar 12:");
        tabla.mostrarTabla();

        System.out.println();
        System.out.println("Buscando la clave 19 despues de la eliminacion:");
        tabla.buscar(19);

        System.out.println();
        System.out.println("Reinsertando la clave 33:");
        tabla.insertar(33);

        System.out.println();
        System.out.println("Tabla final:");
        tabla.mostrarTabla();
    }
}