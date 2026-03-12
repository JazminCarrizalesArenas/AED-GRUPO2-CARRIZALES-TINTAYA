package ZonaMineral;

public class ResultadoZona {

    public Terreno subregion;
    public String mineral;
    public double total;
    int n=0;
    int m=0;

    public ResultadoZona(Terreno terreno,double total, String mineral){
        this.mineral= mineral;
        this.subregion= terreno;
        this.total= total;
    }


    public void imprimir() { 
        int n=subregion.getFilas();
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.println(subregion.matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}