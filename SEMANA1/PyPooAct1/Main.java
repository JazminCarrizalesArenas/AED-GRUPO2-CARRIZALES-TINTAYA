package actividades;
import java.util.Scanner;
public class Main {
    private static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args){
       
        System.out.println("ingrese una esuina del rectangulo r1 (x y): ");
        double
            x1 = entrada.nextDouble(),
            y1 = entrada.nextDouble();
        System.out.println("ingrese una esuina opuesta del rectangulo r1 (x y): ");
        double
            x2 = entrada.nextDouble(),
            y2 = entrada.nextDouble();
    
        Coordenada c1 = new Coordenada(x1, y1);
        Coordenada c2 = new Coordenada(x2, y2);
        Rectangulo r1 = new Rectangulo(c1, c2);

        System.out.println("ingrese una esuina del rectangulo r2 (x y): ");
        double
            x3 = entrada.nextDouble(),
            y3 = entrada.nextDouble();
        System.out.println("ingrese una esuina opuesta del rectangulo r2 (x y): ");
        double
            x4 = entrada.nextDouble(),
            y4 = entrada.nextDouble();

        Coordenada c3 = new Coordenada(x3, y3);
        Coordenada c4 = new Coordenada(x4, y4);
        Rectangulo r2 = new Rectangulo(c3, c4);

        mostrarRectangulo(r1);
        System.out.println("");
        mostrarRectangulo(r2);

        if (Verificador.esSobrePos(r1, r2)){
            System.out.println("");
            System.out.println("r1 y r2 se sobreponen");
            Rectangulo r3= rectanguloSobre(r1, r2);
            System.out.println("El rectangulo que representa la sobreposicion es: " + r3.area());
        } else {
        System.out.println("");
        System.out.println("r1 y r2 son juntos? " + Verificador.esJunto(r1, r2));
        System.out.println("r1 y r2 son disjuntos? " + Verificador.esDisjunto(r1, r2));
    }
}

    public static void mostrarRectangulo(Rectangulo r){
        System.out.print(r);
    }

    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2){

    double x1 = Math.max(Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX()),
                         Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX()));

    double y1 = Math.max(Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY()),
                         Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY()));

    double x2 = Math.min(Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX()),
                         Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX()));

    double y2 = Math.min(Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY()),
                         Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY()));

    Coordenada c1 = new Coordenada(x1, y1);
    Coordenada c2 = new Coordenada(x2, y2);

    return new Rectangulo(c1, c2);
}
}

