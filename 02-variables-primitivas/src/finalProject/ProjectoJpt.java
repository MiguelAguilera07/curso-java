package finalProject;

import java.util.Scanner;

public class ProjectoJpt {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        int inventarioNinja = 9;
        int inventarioKtm = 12;
        int inventarioPulsar = 22;


        double precioKtm = 12000;
        double precioPulsar = 90000;
        double precioNinja = 140000;

        int opcion;

        System.out.println("=================================");
        System.out.println("   CONSECIONARIO BR   ");
        System.out.println("=================================");
        System.out.println("Bienvenido al sistema");

        do {
            System.out.println("\n========= MENÚ =========");
            System.out.println("1. Comprar Moto");
            System.out.println("2. Consultar inventario");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion){

                case 1:
                    System.out.println("\n----- CATÁLOGO -----");
                    System.out.println("1.  PRECIO KTM $" + precioKtm);
                    System.out.println("2. PRECIO PULSAR $" + precioPulsar);
                    System.out.println("3. PRECIO NINJA - $" + precioNinja);

                    System.out.print("Seleccione una moto: ");
                    int opcionMoto = scanner.nextInt();

                    switch (opcionMoto){
                        case 1:
                            if (inventarioKtm > 0){
                                inventarioKtm--;
                                System.out.println("Compraste una ktm");
                                System.out.println("Valor $ "+precioKtm);
                            }else{
                                System.out.println("Unidad no disponible");
                            }
                            break;


                        case 2:
                            if (inventarioPulsar > 0){
                                inventarioPulsar--;
                                System.out.println("Compraste una ktm");
                                System.out.println("Valor $ "+precioPulsar);
                            }else{
                                System.out.println("Unidad no disponible");
                            }
                            break;


                        case 3:
                            if (inventarioNinja > 0){
                                inventarioNinja--;
                                System.out.println("Compraste una ktm");
                                System.out.println("Valor $ "+precioNinja);
                            }else{
                                System.out.println("Unidad no disponible");
                            }
                            break;


                        default:
                            System.out.println("Moto no valida");
                    }

                    break;

                case 2:
                    System.out.println(" |||| INVENTARIO MOTOS ||||");
                    System.out.println(" |||| KTM ||||"+inventarioKtm);
                    System.out.println(" ||||  Pulsar ||||" +inventarioPulsar);
                    System.out.println(" |||| Ninjaa ||||" +inventarioNinja);

                    break;



                case 3:
                    System.out.println("Gracias por compra, disfruta tu sueño");

                    break;


                default:
                    System.out.println("Opcion invalida");
            }





        }while (opcion != 3);

        scanner.close();



    }







}
