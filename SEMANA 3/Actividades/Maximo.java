public class Maximo {

    public static int max(int x, int y) {
        int result;

        if (x >= y) {
            result = x;
        } else {
            result = y;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(max(7, 3));
    }
}