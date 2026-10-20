package finalProject;

import java.util.Scanner;

public class GradeCalcutaortwo {

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        boolean repeat;
        do{
            System.out.println("Ingresa la edad");
            int edad = scanner.nextInt();

            System.out.println("Ingresa tres calificaciones");
            int nota1 = scanner.nextInt();
            int nota2 = scanner.nextInt();
            int nota3 = scanner.nextInt();

            int suma = nota1+nota2+nota3;
            double promedio = suma/3.0;

            if (promedio>=6){
                System.out.println("Aprovado" + "Edad"+edad);
            }else {
                System.out.println("Desaprovado" + "Edad" + edad);
            }
            System.out.println("Desea ingresar nuevos datos (1 si, 2 No");

            int opcion = scanner.nextInt();
            repeat = opcion == 1;

        }while (repeat);

        System.out.println("Programa Finalizado");
        scanner.close();
    }
}
