package finalProject;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su edad por favor: ");
        int edad = scanner.nextInt();

        System.out.println("Ingrese Sus 3 calificaciones: ");

        int notaUno = scanner.nextInt();
        int notaDos = scanner.nextInt();
        int notaTres = scanner.nextInt();


        double promedio = notaUno + notaDos + notaTres /3;

        if(promedio >= 60 && edad >=18) {
            System.out.println(" El alumno aprovo:"+promedio +" Y es mayor de edad ");
        }else if (promedio >= 60 || edad<18){
            System.out.println(" El alumno aprovo:"+promedio +" Pero no es mayor de edad ");
        }else if (promedio < 60 || edad<18){
            System.out.println(" El alumno no aprovo:"+promedio +" Pero  es mayor de edad ");
        }else{
            System.out.println("El estudiante no presento");
        }







System.out.println("FIN DEL PROGRAMA");
scanner.close();
    }
}
