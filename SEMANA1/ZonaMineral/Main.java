package ZonaMineral;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Terreno anterior = null;

        while (true) {

            System.out.println("Menu:");
            System.out.println("1. Leer archivo");
            System.out.println("2. Calcular zona con mayor cantidad de mineral");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opcion: ");

            int opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese la ruta del archivo: ");
                    String ruta = entrada.next();

                    GestorArchivo gestorArchivo = new GestorArchivo(ruta);
                    anterior = gestorArchivo.leerArchivo();
                    break;

                case 2:
                    if(anterior == null){
                        System.out.println("Primero debes leer un archivo.");
                        break;
                    }
                    System.out.print("zona k x k: ");
                    int k = entrada.nextInt();

                    ResultadoZona resultado = calcularZonaMayorMineral(k, anterior);

                    if (resultado != null) {
                        resultado.imprimir();
                        System.out.println("Total mineral: " + resultado.total);
                        System.out.println("Mineral más frecuente: " + resultado.mineral);
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    return;

                default:
                    System.out.println("Opcion invalida. Por favor, intente de nuevo.");
            }
        }
    }

    public static ResultadoZona calcularZonaMayorMineral(int k, Terreno terreno) {

        double mayorTotal = 0;
        int filas = terreno.getFilas();
        int columnas = terreno.getColumnas();

        ResultadoZona resultado = null;

        if (k <= filas && k <= columnas) {

            for (int i = 0; i <= filas - k; i++) {

                for (int j = 0; j <= columnas - k; j++) {

                    Terreno subregion = new Terreno(k, k);
                    double total = 0;

                    java.util.HashMap<String, Integer> contador =
                            new java.util.HashMap<>();

                    for (int x = i; x < i + k; x++) {

                        for (int y = j; y < j + k; y++) {

                            Zona zona = terreno.matriz[x][y];
                            subregion.agregarZona(zona);

                            total += zona.calcularValor();

                            String mineral = zona.getMineral();

                            contador.put(
                                    mineral,
                                    contador.getOrDefault(mineral, 0) + 1
                            );
                        }
                    }

                    String masFrecuente = "";
                    int max = 0;

                    for (String m : contador.keySet()) {

                        if (contador.get(m) > max) {
                            max = contador.get(m);
                            masFrecuente = m;
                        }
                    }

                    if (total > mayorTotal) {
                        mayorTotal = total;
                        resultado =
                                new ResultadoZona(subregion, total, masFrecuente);
                    }
                }
            }

        } else {
            System.out.println("k es mayor que el terreno");
        }

        return resultado;
    }
}