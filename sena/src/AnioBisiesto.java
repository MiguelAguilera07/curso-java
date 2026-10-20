import java.util.Scanner;

public class MatrizAlumnos {

    public static void main(String[] args) {

        final int TOTAL_ALUMNOS = 50;
        double[][] M = new double[TOTAL_ALUMNOS][5];

        int aprobados = 0;
        int recuperacion = 0;
        int maximos = 0;

        try (Scanner scanner = new Scanner(System.in)) {

            for (int i = 0; i < TOTAL_ALUMNOS; i++) {

                System.out.println("\n===== ALUMNO " + (i + 1) + " =====");

                // Código del alumno
                int codigo;
                do {
                    System.out.print("Ingrese el código del alumno: ");
                    codigo = scanner.nextInt();
                    if (codigo <= 0) {
                        System.out.println("Error: el código debe ser positivo.");
                    }
                } while (codigo <= 0);
                M[i][0] = codigo;

                // Tres calificaciones, cada una validada entre 1.0 y 5.0
                double nota1 = leerNota(scanner, "Ingrese la nota 1 (1.0 - 5.0): ");
                double nota2 = leerNota(scanner, "Ingrese la nota 2 (1.0 - 5.0): ");
                double nota3 = leerNota(scanner, "Ingrese la nota 3 (1.0 - 5.0): ");

                double notaFinal = (nota1 + nota2 + nota3) / 3;

                M[i][1] = nota1;
                M[i][2] = nota2;
                M[i][3] = nota3;
                M[i][4] = notaFinal;

                // Clasificación según la nota final
                if (notaFinal >= 3.0 && notaFinal <= 5.0) {
                    aprobados++;
                }
                if (notaFinal >= 2.0 && notaFinal < 3.0) {
                    recuperacion++;
                }
                if (notaFinal == 5.0) {
                    maximos++;
                }
            }

            // Salida de resultados
            System.out.println("\n===== RESULTADOS =====");
            System.out.println("Cantidad de alumnos aprobados: " + aprobados);
            System.out.println("Cantidad con derecho a recuperación: " + recuperacion);
            System.out.println("Cantidad con nota máxima (5.0): " + maximos);
        }
    }

    // Valida que la nota esté en el rango [1.0, 5.0]
    private static double leerNota(Scanner sc, String mensaje) {
        double nota;
        do {
            System.out.print(mensaje);
            nota = sc.nextDouble();
            if (nota < 1.0 || nota > 5.0) {
                System.out.println("Error: la nota debe estar entre 1.0 y 5.0.");
            }
        } while (nota < 1.0 || nota > 5.0);
        return nota;
    }
}