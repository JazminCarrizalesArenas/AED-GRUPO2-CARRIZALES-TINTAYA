package ejercicios;

import java.util.ArrayList;

public class Caja<T> {
    private String color;
    private ArrayList<T> objetos;

    public Caja(String color) {
        this.color = color;
        this.objetos = new ArrayList<>();
    }

    public void add(T obj) {
        objetos.add(obj);
    }

    public String getColor() {
        return color;
    }

    public ArrayList<T> getObjetos() {
        return objetos;
    }
}
