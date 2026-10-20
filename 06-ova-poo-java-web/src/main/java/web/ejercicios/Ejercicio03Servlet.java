package web.ejercicios;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import modelos.Empleado;
import web.Ejercicio;
import web.EjercicioServlet;

/** Ejercicio 03 — Empleado Seguro. */
@WebServlet("/ejercicio/3")
public class Ejercicio03Servlet extends EjercicioServlet {

    @Override
    protected Ejercicio getEjercicio() {
        return Ejercicio.EMPLEADO;
    }

    @Override
    protected String procesar(HttpServletRequest req) {
        float nuevoSalario = (float) decimal(req, "salario", "Nuevo salario");

        Empleado empleado = new Empleado();
        try {
            empleado.ajustarSalario(nuevoSalario);
        } catch (IllegalArgumentException e) {
            // La excepción la lanza la clase Empleado: así protege su atributo privado
            throw new IllegalArgumentException(e.getMessage() + ": ajustarSalario(" + numero(nuevoSalario)
                    + ") fue rechazado. Debe estar entre 0 y 10 000.");
        }
        return "ajustarSalario(" + numero(nuevoSalario) + ")  ✔ aceptado\n"
                + "getSalario() = " + numero(empleado.getSalario());
    }
}
