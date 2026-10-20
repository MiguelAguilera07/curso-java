package web.ejercicios;

import controladores.ReporteController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import servicios.reportes.GeneradorReporte;
import servicios.reportes.ReporteExcel;
import servicios.reportes.ReportePDF;
import web.Ejercicio;
import web.EjercicioServlet;

/** Ejercicio 04 — Reportes Polimórficos. */
@WebServlet("/ejercicio/4")
public class Ejercicio04Servlet extends EjercicioServlet {

    @Override
    protected Ejercicio getEjercicio() {
        return Ejercicio.REPORTES;
    }

    @Override
    protected String procesar(HttpServletRequest req) {
        // La lista se tipa con la clase BASE: puede guardar cualquier hijo
        List<GeneradorReporte> reportes = new ArrayList<>();
        String[] tipos = req.getParameterValues("tipo");
        if (tipos != null) {
            for (String tipo : tipos) {
                if (tipo.equals("pdf")) reportes.add(new ReportePDF());
                if (tipo.equals("excel")) reportes.add(new ReporteExcel());
            }
        }
        if (reportes.isEmpty()) {
            throw new IllegalArgumentException("Marca al menos un tipo de reporte.");
        }

        List<String> salida = new ReporteController().generarTodos(reportes);
        return "for (GeneradorReporte r : reportes) → r.generar()\n" + String.join("\n", salida);
    }
}
