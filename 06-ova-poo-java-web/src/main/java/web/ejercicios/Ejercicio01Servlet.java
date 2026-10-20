package web.ejercicios;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import modelos.Cliente;
import web.Ejercicio;
import web.EjercicioServlet;

/** Ejercicio 01 — Clase Cliente. */
@WebServlet("/ejercicio/1")
public class Ejercicio01Servlet extends EjercicioServlet {

    @Override
    protected Ejercicio getEjercicio() {
        return Ejercicio.CLIENTE;
    }

    @Override
    protected String procesar(HttpServletRequest req) {
        int id = entero(req, "id", "ID");
        String nombre = obligatorio(req, "nombre", "Nombre");
        String email = obligatorio(req, "email", "Email");
        LocalDate fechaRegistro = fecha(req, "fecha", "Fecha de registro");
        if (fechaRegistro.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de registro no puede estar en el futuro.");
        }

        Cliente cliente = new Cliente(id, email, nombre, fechaRegistro);

        long dias = ChronoUnit.DAYS.between(cliente.getFechaRegistro(), LocalDate.now());
        return "new Cliente(" + id + ", \"" + email + "\", \"" + nombre + "\", " + fechaRegistro + ")\n"
                + "Registrado hace " + dias + " día(s)\n"
                + "esNuevo() = " + cliente.esNuevo()
                + (cliente.esNuevo() ? "   → cliente NUEVO (menos de 30 días)" : "   → cliente ANTIGUO (30 días o más)");
    }
}
