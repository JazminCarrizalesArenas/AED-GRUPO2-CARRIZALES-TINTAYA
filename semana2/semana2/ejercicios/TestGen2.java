//====================
//    ejercicio 1 (determinar si un elemento se encuentra en un arreglo de un tipo dado)
//==================== 
package ejercicios;
import actividades.*;
public class TestGen2 {
    public static void main(String[] args) {

        // Chocolatinas
        Chocolatina[] chocos = {
            new Chocolatina("Milka"),
            new Chocolatina("Ferrero"),
            new Chocolatina("Sublime")
        };

        System.out.println(exist(chocos, new Chocolatina("Ferrero"))); // true
        System.out.println(exist(chocos, new Chocolatina("Snickers"))); // false


        // Golosinas
        Golosina[] golos = {
            new Golosina("Caramelo", 10),
            new Golosina("Chicle", 5),
            new Golosina("Gomita", 8)
        };

        System.out.println(exist(golos, new Golosina("Chicle", 5))); // true
        System.out.println(exist(golos, new Golosina("Chocolate", 20))); // false
    }

    public static <T> boolean exist(T[] arreglo, T elemento) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }
}