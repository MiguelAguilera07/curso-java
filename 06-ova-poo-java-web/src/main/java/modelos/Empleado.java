package modelos;

/**
 * Ejercicio 03 — Empleado seguro (Encapsulamiento).
 * El salario es private: solo se cambia con ajustarSalario(), que lo valida.
 */
public class Empleado {
    private float salario;

    public void ajustarSalario(float nuevoSalario) {
        if (nuevoSalario < 0 || nuevoSalario > 10000) {
            throw new IllegalArgumentException("Salario inválido");
        }
        this.salario = nuevoSalario;
    }

    public float getSalario() { return salario; }
}
