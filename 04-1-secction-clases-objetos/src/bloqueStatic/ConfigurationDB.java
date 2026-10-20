package bloqueStatic;

public class ConfigurationDB {
   static final String URL;
   static final String USER;
    static {
        URL = "www.papirico.org";
        USER = "Admin";
        System.out.println("Configuracion Cargada");
    }

    public static void main(String[] args) {
        System.out.println(URL);
        System.out.println(USER);
    }

}

