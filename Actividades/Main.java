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
public class TestGen{
    public static void main(String [] args){
        
        String[] v={"Perez", "Sanchez", "Rodriguez"};
        Integer[] w={12,43,1};
        
        System.out.println(exist(v,"Sanchez"));
        System.out.println(exist(w,123));
        //System.out.printf(exist(w, "1")); //tipos incompatibles
        
    }
    
    public static <T> boolean exist(T[] arreglo, T elemento){
        for (int i=0; i<arreglo.length; i++){
            if (arreglo[i].equals(elemento)) {
                return true; // encontrado
            }
        }
        return false;
    }
}
