package condicionales;

public class Condicionales {
public static void main (String[] args){

    int edad = 20;

    if( edad >= 12){
        System.out.println("Es Mayor a 20");
    }else if (edad == 2){
        System.out.println("Es igual a 20");
    }else{
        System.out.println("Es Menor a 20");
    }


    int day = 4;

    switch (day){
        case 1:
            System.out.println("Lunes");
            break;
        case 2:
            System.out.println("Martes");
            break;
        case 3:
            System.out.println("Miercoles");
            break;
        default:
            System.out.println("No existe");
    }

}

}
