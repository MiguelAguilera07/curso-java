package servicios.reportes;

public class ReportePDF extends GeneradorReporte {
    @Override
    public String generar() {
        return "Generando PDF... [Datos]";
    }
}
