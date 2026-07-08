# Laboratorio 11 – Hashing (Dispersión)
Algoritmos y Estructura de Datos – UCSM

## Estructura de carpetas

Cada actividad y cada ejercicio está en su **propia carpeta independiente**,
con su propio subdirectorio `src/<paquete>/` (tal como se vería al importar
cada carpeta como un proyecto distinto en Eclipse / IntelliJ / NetBeans).

```
Lab11_Hashing/
│
├── Actividad2_HashCerrado/              (Actividad IV.2 — HashC con sondeo lineal)
│   └── src/hash/
│       ├── Register.java                (clase genérica Register<T>)
│       ├── HashC.java                   (tabla hash cerrada, status int: EMPTY/OCCUPIED/DELETED)
│       └── TestHash.java                (clase de prueba: inserta 34,3,7,30,11,8,7,23,41,16,34)
│
├── Actividad3_HashAbierto/              (Actividad IV.3 — HashO con encadenamiento)
│   └── src/hash/
│       ├── Register.java                (clase genérica Register<T>, con equals/hashCode por clave)
│       ├── LinkedList.java              (lista enlazada PROPIA, no java.util.LinkedList)
│       ├── HashO.java                   (tabla hash abierta con encadenamiento)
│       └── TestHashO.java               (clase de prueba con colisiones forzadas)
│
├── Ejercicio1_TablaSinColisiones/       (Ejercicio V.1)
│   └── src/ejercicio1/
│       └── Ejercicio1.java              (tabla tamaño 11, h(x)=x%11, incluye análisis en comentario final)
│
├── Ejercicio2_ComparacionSondeo/        (Ejercicio V.2)
│   └── src/ejercicio2/
│       └── Ejercicio2.java              (sondeo lineal vs cuadrático en la misma clase de prueba)
│
├── Ejercicio3_HashAbiertoColisiones/    (Ejercicio V.3)
│   └── src/ejercicio3/
│       ├── Register.java
│       ├── LinkedList.java
│       ├── HashO.java
│       └── TestEjercicio3.java          (inserta los 6 pares (clave,nombre), busca 24, elimina 17)
│
├── Ejercicio4_EliminacionLogica/        (Ejercicio V.4)
│   └── src/ejercicio4/
│       ├── Entry.java                   (celda con enum Status: EMPTY/OCCUPIED/DELETED)
│       ├── HashCerrado.java             (sondeo lineal con eliminación lógica)
│       └── TestEjercicio4.java          (inserta 5,12,19,26; elimina 12; busca 19; reinserta 33)
│
├── Ejercicio5_FactorCarga/              (Ejercicio V.5)
│   └── src/ejercicio5/
│       ├── HashRedimensionable.java     (calcula α tras cada inserción y hace rehashing automático)
│       └── TestEjercicio5.java          (inserta 2,9,16,23,4,11 -> dispara rehashing a tamaño 17)
│
└── Ejercicio6_SessionCache/             (Ejercicio V.6 — caso real)
    └── src/sessioncache/
        ├── LinkedList.java              (lista propia, con método removeIf)
        ├── Session.java                 (token, username, role, expiresAt)
        ├── SessionCache.java            (login, validate, logout, cleanExpired — tabla con encadenamiento)
        └── TestSessionCache.java        (simula el flujo completo solicitado en el enunciado)
```

## Cómo compilar y ejecutar cada parte (línea de comandos)

Desde la carpeta `src` de cada actividad/ejercicio:

```bash
# Ejemplo con la Actividad 2 (HashC)
cd Actividad2_HashCerrado/src
javac -encoding UTF-8 hash/*.java
java hash.TestHash
```

El mismo patrón aplica para todas las demás carpetas, cambiando el nombre
del paquete y de la clase con `main()` (TestHashO, Ejercicio1, Ejercicio2,
TestEjercicio3, TestEjercicio4, TestEjercicio5, TestSessionCache).

> Todo el código de este paquete fue compilado y ejecutado exitosamente con
> JDK 21 antes de su entrega; la salida real de consola de cada programa se
> encuentra documentada en el informe (Lab11_Informe_Hashing.docx).
