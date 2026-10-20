package servicios.almacenamiento;

/** Simula guardar en AWS S3 (solo imprime en consola). */
public class S3Storage implements StorageInterface {

    @Override
    public boolean save(String nombre, String contenido) {
        System.out.println("Simulando subida a S3...");
        return true;
    }

    @Override
    public boolean delete(String nombre) {
        System.out.println("Simulando borrado en S3...");
        return true;
    }
}
