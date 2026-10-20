package servicios.almacenamiento;

/** Ejercicio 07 — Contrato de almacenamiento (Interfaces): dice QUÉ hacer, no CÓMO. */
public interface StorageInterface {
    boolean save(String nombre, String contenido);
    boolean delete(String nombre);
}
