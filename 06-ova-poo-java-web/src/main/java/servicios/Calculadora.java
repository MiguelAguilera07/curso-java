package servicios;

/**
 * Ejercicio 05 — Calculadora flexible (Sobrecarga).
 * Dos métodos con el mismo nombre y distinta cantidad de parámetros.
 */
public class Calculadora {

    // Firma 1: suma de dos números
    public double operar(double a, double b) {
        return a + b;
    }

    // Firma 2: la suma de a y b se multiplica por c (reutiliza la firma 1)
    public double operar(double a, double b, double c) {
        return operar(a, b) * c;
    }
}
