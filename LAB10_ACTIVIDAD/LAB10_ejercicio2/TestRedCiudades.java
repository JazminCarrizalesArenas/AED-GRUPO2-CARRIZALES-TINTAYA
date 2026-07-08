package ejercicio2;


public class TestRedCiudades {

    public static void main(String[] args) {

        RedCiudades red = new RedCiudades();

        //  Agregar ciudades (vértices) 
        red.agregarCiudad("Cusco");
        red.agregarCiudad("Puno");
        red.agregarCiudad("Tacna");
        red.agregarCiudad("Moquegua");

        //  Agregar carreteras con distancia (aristas) 
        red.agregarCarretera("Arequipa", "Cusco",    510);
        red.agregarCarretera("Arequipa", "Moquegua", 230);
        red.agregarCarretera("Moquegua", "Tacna",    160);
        red.agregarCarretera("Cusco",    "Puno",     390);
        red.agregarCarretera("Puno",     "Tacna",    420);

        //  Mostrar ciudades y carreteras 
        red.mostrarCarreteras();

        //  Caminos más cortos con Dijkstra 
        red.caminoMasCorto("Arequipa", "Tacna");
        red.caminoMasCorto("Arequipa", "Puno");
        red.caminoMasCorto("Cusco",    "Tacna");
    }
}


