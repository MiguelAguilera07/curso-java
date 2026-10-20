package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/** Página de inicio: el menú con los 7 ejercicios. ("" = raíz del proyecto) */
@WebServlet("")
public class InicioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ejercicios", Ejercicio.values());
        req.getRequestDispatcher("/WEB-INF/vistas/inicio.jsp").forward(req, resp);
    }
}
