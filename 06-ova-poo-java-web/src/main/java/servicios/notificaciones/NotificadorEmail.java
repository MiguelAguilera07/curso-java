package servicios.notificaciones;

public class NotificadorEmail extends NotificadorAbstracto {

    public NotificadorEmail(String apiKey) {
        super(apiKey);
    }

    @Override
    public boolean enviar(String msg) {
        ultimoEnvio = "Enviando email (key " + apiKey + "): " + msg;
        System.out.println(ultimoEnvio);
        return true;
    }
}
