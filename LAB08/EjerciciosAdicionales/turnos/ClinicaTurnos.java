

package turnos;

import avl.ArbolAVL;

public class ClinicaTurnos {

    private ArbolAVL turnos;

    public ClinicaTurnos() {

        turnos = new ArbolAVL();
    }

    public void ejecutar() {

        System.out.println("\n===== TURNOS =====");

        turnos.raiz =
                turnos.insertar(turnos.raiz, 30);

        turnos.raiz =
                turnos.insertar(turnos.raiz, 20);

        turnos.raiz =
                turnos.insertar(turnos.raiz, 40);

        turnos.raiz =
                turnos.insertar(turnos.raiz, 10);

        turnos.raiz =
                turnos.insertar(turnos.raiz, 50);

        System.out.println("Turnos registrados:");

        turnos.inorden(turnos.raiz);

        boolean encontrado =
                turnos.buscar(turnos.raiz, 20);

        if (encontrado) {

            System.out.println(
                    "\nTurno encontrado");
        }

        else {

            System.out.println(
                    "\nTurno no encontrado");
        }

        turnos.raiz =
                turnos.eliminar(turnos.raiz, 10);

        System.out.println(
                "\nDespués de eliminar:");

        turnos.inorden(turnos.raiz);

        System.out.println();
    }
}