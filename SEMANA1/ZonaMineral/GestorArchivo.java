package ZonaMineral;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class GestorArchivo {
    File archivo;
    public GestorArchivo(String ruta){
        this.archivo= new File(ruta);
        try {
            Scanner lector=new Scanner(archivo);
        } catch (FileNotFoundException ex) {
            System.getLogger(GestorArchivo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public Terreno leerArchivo(){
        try {
            Scanner lector=new Scanner(archivo);
            while(lector.hasNextLine()){
                int filas=lector.nextInt();
                int columnas=lector.nextInt();
                Terreno terreno= new Terreno(filas, columnas);
                for(int i=0; i<filas; i++){
                    for (int j=0; j<columnas; j++){
                        String mineral= lector.next();
                        int cantidad= lector.nextInt();
                        double pureza=lector.nextDouble();
                        Zona zona=new Zona(mineral, cantidad, pureza);
                        terreno.agregarZona(zona);
                    }
                }
                return terreno;
            }
            
        } catch (FileNotFoundException ex) {
            System.getLogger(GestorArchivo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }
}
