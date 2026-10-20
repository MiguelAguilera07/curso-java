package ProyectoFinal;

import java.util.Scanner;

public class BanKApp {

    private BankAccount cuenta;
    private Scanner scanner;


    public BanKApp(BankAccount cuenta) {
        this.cuenta = cuenta;
        this.scanner = new Scanner(System.in);
    }


    public void start(){
        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            processOption(option);

        }while (option != 4);
    }

    private void  displayMenu(){
        System.out.println(" \n Seleccionar Opciones");
        System.out.println(" \n 1-Depositar Dinero");
        System.out.println(" \n 2-Retirar Dinero");
        System.out.println(" \n 3-Mostrar Saldo");
        System.out.println(" \n 4-Salir");
    }

    private  int getUserOption(){
        return scanner.nextInt();
    }

    private  void handleDeposit(){
        System.out.println("Ingrese el monto a depositar");
        double depositAmount = scanner.nextDouble();
        cuenta.deposito(depositAmount);
    }

    private  void handleWithdrawal(){
        System.out.println("Ingrese el monto a retirar");
        double withdrawAmount = scanner.nextDouble();
        cuenta.retirar(withdrawAmount);
    }


    private void  processOption(int option){
        switch (option){
            case 1:{
                handleDeposit();
                break;
            }

            case 2: {
                handleWithdrawal();
                break;
            }

            case 3: {
                cuenta.saldoCuenta();
                break;

            }

            case 4: {
                System.out.println(" Gracias por utlizar Bancoamigo");
                break;
            }

            default:{
                System.out.println("Opcion incorrecta");
            }
        }
    }
}
