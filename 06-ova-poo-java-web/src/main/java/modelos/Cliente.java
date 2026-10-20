package modelos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Ejercicio 01 — Clase Cliente (Clases y Objetos).
 * Modelo simple (POJO): guarda datos y una regla de negocio: esNuevo().
 */
public class Cliente {
    private int id;
    private String email;
    private String nombre;
    private LocalDate fechaRegistro;

    public Cliente(int id, String email, String nombre, LocalDate fechaRegistro) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
    }

    /** true si se registró hace menos de 30 días. */
    public boolean esNuevo() {
        return ChronoUnit.DAYS.between(fechaRegistro, LocalDate.now()) < 30;
    }

    public int getId() { return id; }
    public String getEmail() { return email; }
    public String getNombre() { return nombre; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }
}
