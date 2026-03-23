package ejercicios;

public class TestGenChocolatina {
    public static void main(String[] args) {
        // Crear cajas de Chocolatinas
        Caja<Chocolatina> caja1 = new Caja<>("Dorado");
        Caja<Chocolatina> caja2 = new Caja<>("Plateado");

        // Agregar Chocolatinas a las cajas
        caja1.add(new Chocolatina("Milka"));
        caja1.add(new Chocolatina("Ferrero"));
        caja1.add(new Chocolatina("Sublime"));

        caja2.add(new Chocolatina("Milka"));
        caja2.add(new Chocolatina("Snickers"));

        // Crear cajonería con capacidad 3
        Cajoneria<Chocolatina> cajoneria = new Cajoneria<>(3);
        cajoneria.add(caja1);
        cajoneria.add(caja2);

        // Buscar Chocolatina
        System.out.println(cajoneria.search(new Chocolatina("Ferrero"))); // Encontrado
        System.out.println(cajoneria.search(new Chocolatina("KitKat")));  // No encontrado

        // Eliminar Chocolatina
        System.out.println("Eliminado: " + cajoneria.eliminar(new Chocolatina("Milka")));

        // Contar ocurrencias
        System.out.println("Repeticiones de Milka: " + 
            cajoneria.contarOcurrencias(new Chocolatina("Milka")));

        // Mostrar todo
        System.out.println(cajoneria);
    }
}