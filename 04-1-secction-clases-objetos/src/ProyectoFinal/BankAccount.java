package ProyectoFinal;

public class BankAccount {
    private  String titularCuenta;
    private  double saldo;

    public BankAccount(String titularCuenta, double saldo) {
        this.titularCuenta = titularCuenta;
        this.saldo = saldo;
    }

    public  void deposito (double monto){
        if ( monto > 0){
            saldo += monto;
            System.out.println(" Deposito Exitosooo!!!");
        }else {
            System.out.println("Transaccion Errada");
        }
    }

    public void  retirar ( double monto){
        if ( monto > 0 && monto <= saldo){
            saldo -= monto;
            System.out.println(" Retiro Exitosoo!! ");
        }else{
            System.out.println(" Fondos Insuficientes!! ");
        }
    }

    public  void saldoCuenta(){
        System.out.println("Saldo"+ saldo);
    }
}
