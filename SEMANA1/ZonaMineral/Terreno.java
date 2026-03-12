package ZonaMineral;

public class Terreno {
    Zona[][] matriz;
    int filas;
    int columnas;
    int  n=0;
    int  m=0;
    public Terreno(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new Zona[filas][columnas];
    }
    public void agregarZona(Zona zona){
        for(int i=n; i<filas; i++){
            for(int j=m; j<columnas; j++){
                if(matriz[i][j]== null){
                    matriz[i][j]=zona;
                    if (m<columnas-1){
                        m++;
                        return;
                    }else{
                        m=0;
                        n++;
                        return;
                    }
                }
            }
        }
    }
    public Terreno getMatriz() {
        return this;}

    public int getFilas() {
        return filas;
    }
    public int getColumnas() {
        return columnas;
    }
}
