package bucles;

public class Bucle {

    public static void main(String[] args){

        // Tiene una cantidad de ejecuciones determinadas
        final int MAX_COUNT = 5;

        for( int currentNumber = 0; currentNumber<=MAX_COUNT; currentNumber+=5){

            System.out.println("Valor: " + currentNumber);
        }
        System.out.println("Termina");








//Bucle contadorr
        int counter=0;;
        int acumulador=0;

        // Ingresa si la condicion es verdadera
        while (counter<5){
            System.out.println(counter);
            counter++;
            acumulador=acumulador+counter;
        }

        System.out.println("Acumulador :"+acumulador);

        int counter2 =0;


        //Ejecuta 1 ves.
        // No evalua al principio si no al salir.
        do{
            System.out.println("Counter 2: "+counter2);
            counter2++;

        }while (counter2<=5);
    }
}
