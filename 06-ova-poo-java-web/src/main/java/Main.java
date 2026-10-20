import controladores.ClienteController;
import controladores.ReporteController;
import controladores.SubidaController;
import java.time.LocalDate;
import java.util.List;
import modelos.Cliente;
import modelos.Empleado;
import servicios.Calculadora;
import servicios.almacenamiento.LocalStorage;
import servicios.almacenamiento.S3Storage;
import servicios.notificaciones.NotificadorAbstracto;
import servicios.notificaciones.NotificadorEmail;
import servicios.notificaciones.NotificadorSMS;
import servicios.reportes.GeneradorReporte;
import servicios.reportes.ReporteExcel;
import servicios.reportes.ReportePDF;

/**
 * Punto de entrada en CONSOLA (OVA, módulo 02).
 * Ejecuta los 7 ejercicios sin necesidad de Tomcat.
 * La versión web está en el paquete "web".
 */
public class Main {

    public static void main(String[] args) {
        titulo("Ejercicio 01 - Clase Cliente");
        Cliente cliente = new Cliente(1, "luis@mail.com", "Luis", LocalDate.now().minusDays(5));
        System.out.println(cliente.getNombre() + " esNuevo() = " + cliente.esNuevo());

        titulo("Ejercicio 02 - ClienteController");
        int id = args.length > 0 ? Integer.parseInt(args[0]) : 7;   // como si llegara desde args[0]
        new ClienteController().verPerfil(id);

        titulo("Ejercicio 03 - Empleado seguro");
        Empleado empleado = new Empleado();
        empleado.ajustarSalario(5000);
        System.out.println("Salario: " + empleado.getSalario());
        try {
            empleado.ajustarSalario(20000);
        } catch (IllegalArgumentException e) {
            System.out.println("ajustarSalario(20000) -> " + e.getMessage());
        }

        titulo("Ejercicio 04 - Reportes polimórficos");
        List<GeneradorReporte> reportes = List.of(new ReportePDF(), new ReporteExcel());
        for (String linea : new ReporteController().generarTodos(reportes)) {
            System.out.println(linea);
        }

        titulo("Ejercicio 05 - Calculadora (sobrecarga)");
        Calculadora calc = new Calculadora();
        System.out.println("operar(2, 3)    = " + calc.operar(2, 3));
        System.out.println("operar(2, 3, 4) = " + calc.operar(2, 3, 4));

        titulo("Ejercicio 06 - Notificaciones abstractas");
        List<NotificadorAbstracto> canales = List.of(new NotificadorEmail("KEY-123"), new NotificadorSMS("KEY-123"));
        for (NotificadorAbstracto canal : canales) {
            canal.enviar("Hola desde Java");
        }

        titulo("Ejercicio 07 - Almacenamiento con interfaz");
        System.out.println(new SubidaController(new LocalStorage()).subir("prueba.txt", "Hola"));
        System.out.println(new SubidaController(new S3Storage()).subir("prueba.txt", "Hola"));
    }

    private static void titulo(String texto) {
        System.out.println("\n=== " + texto + " ===");
    }
}
