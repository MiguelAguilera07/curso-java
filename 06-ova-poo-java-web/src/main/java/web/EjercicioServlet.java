package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Plantilla común de los 7 ejercicios (¡también es POO: una clase abstracta!).
 *
 *   GET  → muestra la página con el formulario vacío.
 *   POST → llama a procesar() del ejercicio y muestra el resultado o el error.
 *
 * Cada ejercicio solo implementa getEjercicio() y procesar().
 * El HTML no se escribe aquí: lo arma la vista /WEB-INF/vistas/ejercicio.jsp.
 */
public abstract class EjercicioServlet extends HttpServlet {

    private static final String VISTA = "/WEB-INF/vistas/ejercicio.jsp";

    /** Qué ejercicio atiende este servlet (título, enunciado, diagrama...). */
    protected abstract Ejercicio getEjercicio();

    /**
     * Usa las clases del ejercicio con los datos del formulario y devuelve el texto del resultado.
     * Si un dato no sirve, lanza IllegalArgumentException con un mensaje para el usuario.
     */
    protected abstract String procesar(HttpServletRequest req);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mostrar(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("resultado", procesar(req));
        } catch (IllegalArgumentException e) {
            req.setAttribute("error", e.getMessage());
        }
        mostrar(req, resp);
    }

    private void mostrar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ejercicio", getEjercicio());
        req.getRequestDispatcher(VISTA).forward(req, resp);
    }

    // ---------- Ayudas para leer el formulario ----------

    /** Texto opcional: si no viene, devuelve "". */
    protected String texto(HttpServletRequest req, String campo) {
        String valor = req.getParameter(campo);
        return valor == null ? "" : valor.trim();
    }

    /** Texto obligatorio. */
    protected String obligatorio(HttpServletRequest req, String campo, String etiqueta) {
        String valor = texto(req, campo);
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("El campo «" + etiqueta + "» es obligatorio.");
        }
        return valor;
    }

    protected int entero(HttpServletRequest req, String campo, String etiqueta) {
        try {
            return Integer.parseInt(obligatorio(req, campo, etiqueta));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El campo «" + etiqueta + "» debe ser un número entero.");
        }
    }

    protected double decimal(HttpServletRequest req, String campo, String etiqueta) {
        try {
            return Double.parseDouble(obligatorio(req, campo, etiqueta));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El campo «" + etiqueta + "» debe ser un número.");
        }
    }

    protected LocalDate fecha(HttpServletRequest req, String campo, String etiqueta) {
        try {
            return LocalDate.parse(obligatorio(req, campo, etiqueta));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("El campo «" + etiqueta + "» no es una fecha válida.");
        }
    }

    /** 5.0 → "5"   y   2.5 → "2.5" (para que los números se lean mejor). */
    protected static String numero(double valor) {
        return valor == Math.rint(valor) && !Double.isInfinite(valor)
                ? String.valueOf((long) valor)
                : String.valueOf(valor);
    }
}
