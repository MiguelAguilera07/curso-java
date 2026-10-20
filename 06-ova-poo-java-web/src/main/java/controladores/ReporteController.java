package controladores;

import java.util.ArrayList;
import java.util.List;
import servicios.reportes.GeneradorReporte;

/**
 * Ejercicio 04 — Controlador de reportes (Polimorfismo).
 * Recibe una lista del tipo base y cada objeto responde a su manera.
 */
public class ReporteController {

    public List<String> generarTodos(List<GeneradorReporte> reportes) {
        List<String> resultados = new ArrayList<>();
        for (GeneradorReporte reporte : reportes) {
            resultados.add(reporte.generar());
        }
        return resultados;
    }
}
