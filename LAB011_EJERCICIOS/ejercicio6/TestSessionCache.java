package ejercicio6;

public class TestSessionCache {

    public static void main(String[] args) throws InterruptedException {
        SessionCache cache = new SessionCache(7);

        // 1. Tres usuarios inician sesion
        cache.login("abc123", "mfernandez", "admin", 5000);
        cache.login("xyz789", "jrios", "user", 50); // expira muy rapido, para la prueba
        cache.login("qwe456", "lpaz", "user", 5000);

        System.out.println("Sesiones activas tras el login: " + cache.contarSesionesActivas());

        // Esperamos un poco para que el token de jrios expire
        Thread.sleep(150);

        // 2. Se validan los tokens
        System.out.println();
        System.out.println("Validando abc123:");
        Session s1 = cache.validate("abc123");
        System.out.println(s1 != null ? s1.toString() : "Token invalido o expirado");

        System.out.println("Validando xyz789:");
        Session s2 = cache.validate("xyz789");
        System.out.println(s2 != null ? s2.toString() : "Token invalido o expirado");

        System.out.println("Validando qwe456:");
        Session s3 = cache.validate("qwe456");
        System.out.println(s3 != null ? s3.toString() : "Token invalido o expirado");

        // 3. Un usuario cierra sesion explicitamente
        System.out.println();
        System.out.println("lpaz cierra sesion (logout qwe456)");
        cache.logout("qwe456");

        // 4. Limpieza de sesiones expiradas
        System.out.println();
        cache.cleanExpired();
        System.out.println("Se ejecuto cleanExpired()");
        System.out.println("Sesiones activas finales: " + cache.contarSesionesActivas());
    }
}