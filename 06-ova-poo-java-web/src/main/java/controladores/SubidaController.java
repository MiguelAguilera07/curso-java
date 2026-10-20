package controladores;

import servicios.almacenamiento.StorageInterface;

/**
 * Ejercicio 07 — Controlador de subida de archivos (Interfaces).
 * El atributo se tipa con la INTERFAZ, no con una clase concreta:
 * así se le puede "inyectar" LocalStorage o S3Storage sin cambiar este código.
 */
public class SubidaController {
    private final StorageInterface storage;

    public SubidaController(StorageInterface storage) {
        this.storage = storage;
    }

    public String subir(String nombre, String contenido) {
        String tipo = storage.getClass().getSimpleName();
        return storage.save(nombre, contenido)
                ? tipo + ": guardado " + nombre
                : tipo + ": error al guardar " + nombre;
    }
}
