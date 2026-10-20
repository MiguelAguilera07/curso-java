package bloqueStatic;

public class BlockExample {
    // Se Ejecuta primero
    static {
        System.out.println("Bloque ene ejecucion");
    }

    public static void main(String[] args){
        System.out.println("Hola Brad Pit");
    }
}
