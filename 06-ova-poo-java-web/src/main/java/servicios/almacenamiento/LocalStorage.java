package servicios.almacenamiento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** Guarda los archivos en una carpeta local usando java.nio.file. */
public class LocalStorage implements StorageInterface {

    // Carpeta temporal del sistema, para no tener problemas de permisos en Tomcat
    private final Path carpeta = Path.of(System.getProperty("java.io.tmpdir"), "ova-poo-archivos");

    @Override
    public boolean save(String nombre, String contenido) {
        try {
            Files.createDirectories(carpeta);
            Files.writeString(carpeta.resolve(nombre), contenido);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean delete(String nombre) {
        try {
            return Files.deleteIfExists(carpeta.resolve(nombre));
        } catch (IOException e) {
            return false;
        }
    }
}
