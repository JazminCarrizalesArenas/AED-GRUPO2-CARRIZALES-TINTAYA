package ejercicios;
public class ContainerRect {
    Rectangulo[] rectangulos;
    double[] areas;
    double[] distancias;
    int n;
    int numRectangulos;
    public ContainerRect(int n){
        this.n=n;
        this.rectangulos= new Rectangulo[n];
        this.areas= new double[n];
        this.distancias=new double[n];
        this.numRectangulos=0;
    }
    public void addRectangulo(Rectangulo r){

            rectangulos[numRectangulos]=r;
            areas[numRectangulos]=r.area();
            distancias[numRectangulos]=r.getEsquina1().distancia(r.getEsquina2());
            numRectangulos++;
    }
    public void mostrarRectangulos(){
        System.out.println("Rectangulo              Coordenadas                  distancia           area");
        for (int i=0; i<numRectangulos; i++){
            System.out.println((i+1)+ "               "+ rectangulos[i].toString() + "       "+ distancias[i] + "       "+ areas[i]);
        }
    }

    public int getCantidadAgregada(){
        return this.numRectangulos;
    }
}

