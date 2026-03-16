public class Main {

    public static void main(String[] args) {

        Bolsa<Chocolatina> bolsaCho = new Bolsa<>(3);

        Chocolatina c = new Chocolatina("Milka");
        Chocolatina c1 = new Chocolatina("Milka");
        Chocolatina c2 = new Chocolatina("Ferrero");

        bolsaCho.add(c);
        bolsaCho.add(c1);
        bolsaCho.add(c2);

        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }
    }
}