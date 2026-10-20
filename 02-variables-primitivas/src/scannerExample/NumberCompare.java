package scannerExample;

import java.util.Scanner;

public class NumberCompare {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese sus ingresos mensuales");

        int primerNumero = scanner.nextInt();

        System.out.println("Ingrese sus ingresos extras");

        int segundoNumero = scanner.nextInt();

        int suma = primerNumero + segundoNumero;
        int resta = primerNumero - segundoNumero;

        System.out.println("La suma es: "+suma);
        System.out.println("La resta es: "+resta);


        if(suma>=30){
            System.out.println("Credito aprovado");
        }else
            System.out.println("Credito denegado");


        System.out.println(" Fin de la consulta");

        scanner.close();
    }




}
