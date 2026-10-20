package web.ejercicios;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import servicios.notificaciones.NotificadorAbstracto;
import servicios.notificaciones.NotificadorEmail;
import servicios.notificaciones.NotificadorSMS;
import web.Ejercicio;
import web.EjercicioServlet;

/** Ejercicio 06 — Notificaciones Abstractas. */
@WebServlet("/ejercicio/6")
public class Ejercicio06Servlet extends EjercicioServlet {

    @Override
    protected Ejercicio getEjercicio() {
        return Ejercicio.NOTIFICACIONES;
    }

    @Override
    protected String procesar(HttpServletRequest req) {
        String apiKey = obligatorio(req, "apikey", "API Key");
        String mensaje = obligatorio(req, "msg", "Mensaje");

        // La variable es del tipo ABSTRACTO; el objeto real es Email o SMS
        NotificadorAbstracto notificador = texto(req, "canal").equals("sms")
                ? new NotificadorSMS(apiKey)
                : new NotificadorEmail(apiKey);

        boolean enviado = notificador.enviar(mensaje);
        return "Objeto creado: new " + notificador.getClass().getSimpleName() + "(\"" + apiKey + "\")\n"
                + notificador.getUltimoEnvio() + "\n"
                + "enviar() = " + enviado;
    }
}
