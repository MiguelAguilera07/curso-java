package servicios.notificaciones;

/**
 * Ejercicio 06 — Notificaciones abstractas (Abstracción).
 * No se puede hacer "new NotificadorAbstracto(...)": solo sirve de molde para los hijos.
 */
public abstract class NotificadorAbstracto {
    protected final String apiKey;        // configuración común que reciben todos los hijos
    protected String ultimoEnvio = "";    // texto del último envío (para mostrarlo en la web)

    public NotificadorAbstracto(String apiKey) {
        this.apiKey = apiKey;
    }

    public abstract boolean enviar(String msg);

    public String getUltimoEnvio() { return ultimoEnvio; }
}
