package ejercicios;

public class TestGen3 {
    public static void main(String[] args) {
        // Crear cajas
        Caja<Golosina> caja1 = new Caja<>("Rojo");
        Caja<Golosina> caja2 = new Caja<>("Azul");

        // Agregar golosinas (mínimo 5)
        caja1.add(new Golosina("Caramelo", 10));
        caja1.add(new Golosina("Chicle", 5));
        caja1.add(new Golosina("Gomita", 8));

        caja2.add(new Golosina("Chocolate", 20));
        caja2.add(new Golosina("Toffee", 15));

        // Crear cajonería
        Cajoneria cajoneria = new Cajoneria(5);
        cajoneria.add(caja1);
        cajoneria.add(caja2);

        // Buscar golosinas
        System.out.println(cajoneria.search(new Golosina("Chicle", 5))); // encontrado
        System.out.println(cajoneria.search(new Golosina("Limon", 3)));  // no encontrado

        // Eliminar
        System.out.println("Eliminado: " + 
            cajoneria.eliminar(new Golosina("Caramelo", 10)));

        // Mostrar todo
        System.out.println(cajoneria);
    }
}