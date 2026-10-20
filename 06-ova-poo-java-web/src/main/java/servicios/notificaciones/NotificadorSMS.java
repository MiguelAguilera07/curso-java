package servicios.notificaciones;

public class NotificadorSMS extends NotificadorAbstracto {

    public NotificadorSMS(String apiKey) {
        super(apiKey);
    }

    @Override
    public boolean enviar(String msg) {
        ultimoEnvio = "Enviando SMS (key " + apiKey + "): " + msg;
        System.out.println(ultimoEnvio);
        return true;
    }
}
