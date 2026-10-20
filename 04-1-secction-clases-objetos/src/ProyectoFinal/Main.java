package ProyectoFinal;

public class Main {
    public static void main (String[]args){
        BankAccount bankAccount = new BankAccount("Miguel Aguilera",100000.0);
        BanKApp banKApp = new BanKApp(bankAccount);
        banKApp.start();
    }
}
