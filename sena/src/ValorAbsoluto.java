import java.util.Scanner;

public class ValorAbsoluto {

    public static void main(String[] args){
        System.out.println("Ingrese el numero");

        Scanner scanner = new Scanner(System.in);

        int numero = scanner.nextInt();
        int absoluto = Math.abs(numero);



        System.out.println(" El valor obsoluto de" + numero+ " es "+absoluto);

    }
}
