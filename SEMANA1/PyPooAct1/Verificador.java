package actividades;

public class Verificador {
    public static boolean esJunto(Rectangulo r1, Rectangulo r2){
        double r1x1 = r1.getEsquina1().getX();
        double r1y1 = r1.getEsquina1().getY();
        double r1x2 = r1.getEsquina2().getX();
        double r1y2 = r1.getEsquina2().getY();

        double r2x1 = r2.getEsquina1().getX();
        double r2y1 = r2.getEsquina1().getY();
        double r2x2 = r2.getEsquina2().getX();
        double r2y2 = r2.getEsquina2().getY();

    if (r1x2 == r2x1 || r2x2 == r1x1) {
        return true;
    }

    return r1y2 == r2y1 || r2y2 == r1y1;
    }
    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2){

    double r1x1 = r1.getEsquina1().getX();
    double r1y1 = r1.getEsquina1().getY();
    double r1x2 = r1.getEsquina2().getX();
    double r1y2 = r1.getEsquina2().getY();

    double r2x1 = r2.getEsquina1().getX();
    double r2y1 = r2.getEsquina1().getY();
    double r2x2 = r2.getEsquina2().getX();
    double r2y2 = r2.getEsquina2().getY();

    if (r1x1 > r1x2) {
        double t = r1x1;
        r1x1 = r1x2;
        r1x2 = t;
    }

    if (r1y1 > r1y2) {
        double t = r1y1;
        r1y1 = r1y2;
        r1y2 = t;
    }

    if (r2x1 > r2x2) {
        double t = r2x1;
        r2x1 = r2x2;
        r2x2 = t;
    }

    if (r2y1 > r2y2) {
        double t = r2y1;
        r2y1 = r2y2;
        r2y2 = t;
    }

    return r1x2 < r2x1 || r2x2 < r1x1 || r1y2 < r2y1 || r2y2 < r1y1;
    }

    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2){
        return !(esDisjunto(r1, r2) || esJunto(r1, r2));
    }
}
