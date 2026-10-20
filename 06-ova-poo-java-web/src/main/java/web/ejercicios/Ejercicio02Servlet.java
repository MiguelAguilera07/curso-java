package web.ejercicios;

import controladores.ClienteController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import web.Ejercicio;
import web.EjercicioServlet;

/** Ejercicio 02 — Controlador de Clientes. */
@WebServlet("/ejercicio/2")
public class Ejercicio02Servlet extends EjercicioServlet {

    @Override
    protected Ejercicio getEjercicio() {
        return Ejercicio.CLIENTE_CONTROLLER;
    }

    @Override
    protected String procesar(HttpServletRequest req) {
        int id = entero(req, "id", "ID del cliente");

        ClienteController controller = new ClienteController();
        return "new ClienteController().verPerfil(" + id + ")\n"
                + controller.verPerfil(id);
    }
}
