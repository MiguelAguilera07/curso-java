import java.util.Scanner;

public class DescuentoSuperMercado {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        int numero = scanner.nextInt();

        System.out.println(" Ingrese el valor de su cuenta");

        double valorCuenta = scanner.nextInt();

        double descuento;

        if(numero < 74){
            descuento = valorCuenta * 0.15;
        }else{
            descuento = valorCuenta* 0.20;
        }
        double total = valorCuenta - descuento;

        System.out.println("El valor de su compra es $"+ valorCuenta +"  el descueto que le aplica es $"+ descuento);
        System.out.println("Y valor a pagar"+ total);


    }






}
