package actividades;

public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;

    public Rectangulo(Coordenada c1, Coordenada c2){
        this.esquina1=c1;
        this.esquina2=c2;
    }

    //getters
    public Coordenada getEsquina1(){return this.esquina1;}
    public Coordenada getEsquina2(){return this.esquina2;}

    //setters
    public void setEsquina1(Coordenada esquina1){this.esquina1=esquina1;}
    public void setEsquina2(Coordenada esquina2){this.esquina2=esquina2;}

    public String toString(){
        return "Rectangulo: Esquina 1: "+ this.esquina1.toString()+ "- Esquina 2: "+ this.esquina2.toString();
    }
    public double area(){
        return Math.abs((esquina2.getX() - esquina1.getX()) * (esquina2.getY() - esquina1.getY()));
    }
}
