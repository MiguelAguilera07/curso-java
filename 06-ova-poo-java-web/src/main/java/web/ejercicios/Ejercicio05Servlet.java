package web.ejercicios;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import servicios.Calculadora;
import web.Ejercicio;
import web.EjercicioServlet;

/** Ejercicio 05 — Calculadora Flexible. */
@WebServlet("/ejercicio/5")
public class Ejercicio05Servlet extends EjercicioServlet {

    @Override
    protected Ejercicio getEjercicio() {
        return Ejercicio.CALCULADORA;
    }

    @Override
    protected String procesar(HttpServletRequest req) {
        double a = decimal(req, "a", "Número A");
        double b = decimal(req, "b", "Número B");
        Calculadora calc = new Calculadora();

        // Java elige la versión de operar() según cuántos argumentos le pasamos
        if (texto(req, "c").isEmpty()) {
            return "Firma usada: operar(double a, double b)  → suma\n"
                    + "operar(" + numero(a) + ", " + numero(b) + ") = " + numero(calc.operar(a, b));
        }
        double c = decimal(req, "c", "Número C");
        return "Firma usada: operar(double a, double b, double c)  → (a + b) × c\n"
                + "operar(" + numero(a) + ", " + numero(b) + ", " + numero(c) + ") = " + numero(calc.operar(a, b, c));
    }
}
