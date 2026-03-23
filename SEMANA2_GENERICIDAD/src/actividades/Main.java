package actividades;
public class Main {

    public static void main(String[] args) {

        Bolsa<Chocolatina> bolsaCho = new Bolsa<>(3);

        Chocolatina c = new Chocolatina("Milka");
        Chocolatina c1 = new Chocolatina("Milka");
        Chocolatina c2 = new Chocolatina("Ferrero");

        bolsaCho.add(c);
        bolsaCho.add(c1);
        bolsaCho.add(c2);
        Bolsa<Golosina> bolsaGol = new Bolsa<>(3);
        bolsaGol.add(new Golosina("Caramelo", 10));
        bolsaGol.add(new Golosina("Chicle", 5));


        bolsaCho.add(new Chocolatina("Sublime"));
        imprimirBolsa(bolsaCho);
        imprimirBolsa(bolsaGol);
        
    }

    //ejercicio 2: método genérico para imprimir los elementos de una bolsa
    public static <T> void imprimirBolsa (Bolsa<T> bolsa){
        for (T elemento: bolsa) {
            System.out.println(elemento);
        }
    }
}