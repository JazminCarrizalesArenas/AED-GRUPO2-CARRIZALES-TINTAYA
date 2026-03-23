package ejercicios;
import java.util.ArrayList;

public class Cajoneria<T> {
    private ArrayList<Caja<T>> lista = new ArrayList<>();
    private int tope;
    
    public Cajoneria(int tope){
        this.tope = tope; 
    }
    
    public void add(Caja<T> objeto){
        if (lista.size() < tope){
            lista.add(objeto);
        } else {
            System.out.println("no caben mas");
        }
    }

    public String search(T obj){
        for(int i = 0; i < lista.size(); i++){
            Caja<T> caja = lista.get(i);
            if (caja.getObjetos().contains(obj)){
                return "POSICION: " + (i+1) + 
                       " | Caja: " + caja.getColor() + 
                       " | Objeto: " + obj;
            }
        }
        return "no se encontro el objeto";
    }

    public T eliminar(T obj){
        for(int i = 0; i < lista.size(); i++){
            Caja<T> caja = lista.get(i);
            if (caja.getObjetos().contains(obj)){
                caja.getObjetos().remove(obj);
                return obj;
            }
        }
        return null;
    }

    // MÉTODO PEDIDO ejercicio 6 - contar ocurrencias de un elemento en todas las cajas
    public int contarOcurrencias(T elemento){
        int contador = 0;

        for (Caja<T> caja : lista){
            for (T obj : caja.getObjetos()){
                if (obj.equals(elemento)){
                    contador++;
                }
            }
        }

        return contador;
    }

    @Override
    public String toString() {
        String resultado = "Posición\tColor Caja\tObjeto\n";
        for (int i = 0; i < lista.size(); i++) {
            Caja<T> caja = lista.get(i);
            for (T obj : caja.getObjetos()) {
                resultado += (i+1) + "\t\t" + caja.getColor() + "\t" + obj + "\n";
            }
        }
        return resultado;
    }
}