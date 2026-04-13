package extra;


public class Hanoi {

    public static void main(String[] args) {

        int n = 4; // 🔹 CAMBIO

        System.out.println("Torres de Hanoi con " + n + " discos");

        torresHanoi(n, "Origen", "Auxiliar", "Destino");
    }

    public static void torresHanoi(int discos, String origen, String auxiliar, String destino) {

        if (discos == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
        } else {

            torresHanoi(discos - 1, origen, destino, auxiliar);

            System.out.println("Mover disco " + discos + " de " + origen + " a " + destino);

            torresHanoi(discos - 1, auxiliar, origen, destino);
        }
    }
}