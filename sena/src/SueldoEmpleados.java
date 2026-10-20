import java.util.Scanner;

public class SueldoEmpleados {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        final double SMLV = 644336.0;
        final double AUX_TRANSPORTE = 74000.0;

        System.out.println(" Sistema de nomina Empresa MIGUELITO SAS.");
        for (int i = 1; i<=10;  i++){

            System.out.println("Cedula: ");
            int cedula = scanner.nextInt();

            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();
            scanner.nextLine();



            System.out.println("Codigo empleado");
            int codigo = scanner.nextInt();

            System.out.println("Salario Basico");
            double salarioBasico = scanner.nextDouble();

            System.out.println("Total de Ventas");
            double totalVentas = scanner.nextDouble();

            System.out.println("Total de prestamos");
            double prestamos = scanner.nextDouble();

            double auxilio = 0;

            if (salarioBasico >= SMLV && salarioBasico <= (3*SMLV))
                auxilio = AUX_TRANSPORTE;

            double comision = totalVentas * 0.02;

            double totalDevengado = salarioBasico + auxilio + comision;

            double deduccionObligatoria = salarioBasico * 0.05;
            double totalDeducciones = deduccionObligatoria + prestamos;
            double salarioNeto = totalDevengado - totalDeducciones;


            System.out.println( "\n --------------comprobantes de pago-------------------");

            System.out.println("Cedula"+ cedula);
            System.out.println("Nombre"+ nombre);
            System.out.println("Codigo"+ codigo);


            System.out.println("Salario Basico: "+salarioBasico);
            System.out.println("Auxilio: "+auxilio);
            System.out.println("Comision: "+comision);
            System.out.println("Ttotal devengado: "+totalDevengado);
            System.out.println("Deduccion prestamos: "+prestamos);
            System.out.println("Deduccion Legals: "+deduccionObligatoria);

            System.out.println("------!!!!!-------");

            System.out.println(" Estimad@ Ah continuacion le daremos el total de su salario " + nombre);
            System.out.println("SU SALARIO A RECIBIR ES :"+salarioNeto);
        }
        scanner.close();



    }

}
