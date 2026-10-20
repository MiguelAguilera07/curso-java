package scannerExample;

import java.util.Scanner;

public class SimpleCalculator {
   public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int primerNumero = getNumber(scanner,"Ingrese el numero Uno");

       int segundoNumero = getNumber(scanner,"Ingrese el numero Dos");

       int suma = primerNumero + segundoNumero;
       int resta = primerNumero - segundoNumero;


       printArithmeticOperations(suma,resta);

 compareNumber(primerNumero,segundoNumero);

       System.out.println(" Fin de la consulta");

       scanner.close();
      }

      public static int getNumber(Scanner scanner, String message){
          System.out.println(message);

          int number = scanner.nextInt();
          return number;
      }

      public static void printArithmeticOperations(int suma, int resta){
          System.out.println(" La suma es "+suma);
          System.out.println("La resta es "+resta);
      }

      public static void compareNumber(int primerNumero, int segundoNumero){

       if(primerNumero>segundoNumero){
           System.out.println("El primer numero es mayor");
       }else{
           System.out.println("El segundo es mayor o igual");
       }

      }


   }

