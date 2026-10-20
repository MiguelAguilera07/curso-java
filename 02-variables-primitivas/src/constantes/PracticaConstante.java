package constantes;

public class PracticaConstante {
    public static void main (String[] args){

        int x = 10;
        x = 23;
        x = 45;

        final double ANNUAL_INTEREST_RATE = 0.10;


        final double TAX_RATE = 0.10;
        int grossSalary = 3000;
        double netSalary = grossSalary * (1 - TAX_RATE);
        System.out.println("netSalary ="+ netSalary);



    }
}
