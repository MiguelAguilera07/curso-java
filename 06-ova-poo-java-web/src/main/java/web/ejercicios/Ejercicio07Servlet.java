package web.ejercicios;

import controladores.SubidaController;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import servicios.almacenamiento.LocalStorage;
import servicios.almacenamiento.S3Storage;
import servicios.almacenamiento.StorageInterface;
import web.Ejercicio;
import web.EjercicioServlet;

/** Ejercicio 07 — Almacenamiento de Archivos. */
@WebServlet("/ejercicio/7")
public class Ejercicio07Servlet extends EjercicioServlet {

    @Override
    protected Ejercicio getEjercicio() {
        return Ejercicio.ALMACENAMIENTO;
    }

    @Override
    protected String procesar(HttpServletRequest req) {
        // Solo letras, números, punto, guion y guion bajo: así nadie puede escribir fuera de la carpeta
        String nombre = obligatorio(req, "nombre", "Nombre del archivo")
                .replaceAll("[^A-Za-z0-9._-]", "_")
                .replaceAll("^\\.+", "");
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("Escribe un nombre de archivo válido.");
        }
        String contenido = texto(req, "contenido");

        // Inyección de dependencias: el controlador recibe la INTERFAZ
        StorageInterface storage = texto(req, "tipo").equals("s3") ? new S3Storage() : new LocalStorage();
        SubidaController controller = new SubidaController(storage);

        return "new SubidaController(new " + storage.getClass().getSimpleName() + "())\n"
                + controller.subir(nombre, contenido);
    }
}
