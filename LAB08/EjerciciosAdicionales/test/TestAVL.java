

package test;

import productos.RegistroProductos;
import turnos.ClinicaTurnos;

public class TestAVL {

    public static void main(String[] args) {

        RegistroProductos productos =
                new RegistroProductos();

        productos.ejecutar();

        System.out.println(
                "\n========================");

        ClinicaTurnos turnos =
                new ClinicaTurnos();

        turnos.ejecutar();
    }
}