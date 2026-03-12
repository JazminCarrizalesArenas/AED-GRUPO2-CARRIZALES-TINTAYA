package ejercicios;
import java.util.Scanner;
public class Main {
    private static Scanner entrada= new Scanner(System.in);
    public static void main(String[] args){

        System.out.print("cantidad n del arreglo contenedor: ");
        int n= entrada.nextInt();
        ContainerRect contenedor=  new ContainerRect(n);

        while (true) { 
           System.out.println("Menu:");
           System.out.println("1. Agregar rectangulo");
           System.out.println("2. mostrar arreglo");
           System.out.println("3. Salir");
           int opcion= entrada.nextInt();
           if (opcion ==1 && contenedor.getCantidadAgregada() < n){
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
               contenedor.addRectangulo(r1);
               System.out.println("rectangulo agregado");
           }else {
            System.out.println("No se pueden agregar mas rectangulos");
        }
           if (opcion ==2){
                contenedor.mostrarRectangulos();
           }
           if (opcion ==3){
               System.out.println("saliendo...");
               break;
           }

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

