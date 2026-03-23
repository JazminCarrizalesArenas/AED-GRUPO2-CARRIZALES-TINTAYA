package ejercicios;

public class Main {
    public static void main(String[] args) {

        Caja<String> caja1 = new Caja<>("Rojo");
        caja1.add("Libro");
        caja1.add("Lapiz");

        Caja<Integer> caja2 = new Caja<>("Amarillo");
        caja2.add(100);
        caja2.add(200);

        Cajoneria cajoneria = new Cajoneria(5);
        cajoneria.add(caja1);
        cajoneria.add(caja2);

        // Buscar
        System.out.println(cajoneria.search("Libro"));

        // Eliminar
        System.out.println("Eliminado: " + cajoneria.eliminar("Lapiz"));

        // Mostrar
        System.out.println(cajoneria);

        //ejericio 6 y 7:........
        Cajoneria<Golosina> cajoneria2 = new Cajoneria<>(5);

        Caja<Golosina> caja3 = new Caja<>("Rojo");
        Caja<Golosina> caja4 = new Caja<>("Amarillo");

        caja3.add(new Golosina("Caramelo", 10));
        caja3.add(new Golosina("Chicle", 5));

        caja4.add(new Golosina("Caramelo", 10));
        caja4.add(new Golosina("Gomita", 8));
        caja4.add(new Golosina("Caramelo", 10));

        cajoneria2.add(caja3);
        cajoneria2.add(caja4);

        // Buscar
        System.out.println(cajoneria2.search(new Golosina("Chicle", 5)));

        // Eliminar
        System.out.println("Eliminado: " + 
            cajoneria2.eliminar(new Golosina("Caramelo", 10)));

        // Contar ocurrencias
        System.out.println("Repeticiones: " + 
            cajoneria2.contarOcurrencias(new Golosina("Caramelo", 10)));

        // Mostrar
        System.out.println(cajoneria2);

    }
}

