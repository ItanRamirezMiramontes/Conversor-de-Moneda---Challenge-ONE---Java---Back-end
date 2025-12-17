import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ConsultaApi api = new ConsultaApi();

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("\n===== Conversor de Monedas =====");
            System.out.println("1. USD a ARS");
            System.out.println("2. USD a BRL");
            System.out.println("3. USD a EUR");
            System.out.println("4. ARS a USD");
            System.out.println("5. BRL a USD");
            System.out.println("6. EUR a USD");
            System.out.println("7. Salir");
            System.out.print("Elija una opción válida: ");

            opcion = scanner.nextInt();

            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor");
                break;
            }

            System.out.print("Ingrese el monto a convertir: ");
            double monto = scanner.nextDouble();

            double tasa;
            double resultado;

            switch (opcion) {
                case 1 -> {
                    tasa = api.obtenerTasa("ARS");
                    resultado = Conversor.convertir(monto, tasa);
                    System.out.println("Resultado: " + resultado + " ARS");
                }
                case 2 -> {
                    tasa = api.obtenerTasa("BRL");
                    resultado = Conversor.convertir(monto, tasa);
                    System.out.println("Resultado: " + resultado + " BRL");
                }
                case 3 -> {
                    tasa = api.obtenerTasa("EUR");
                    resultado = Conversor.convertir(monto, tasa);
                    System.out.println("Resultado: " + resultado + " EUR");
                }
                case 4 -> {
                    tasa = api.obtenerTasa("ARS");
                    resultado = monto / tasa;
                    System.out.println("Resultado: " + resultado + " USD");
                }
                case 5 -> {
                    tasa = api.obtenerTasa("BRL");
                    resultado = monto / tasa;
                    System.out.println("Resultado: " + resultado + " USD");
                }
                case 6 -> {
                    tasa = api.obtenerTasa("EUR");
                    resultado = monto / tasa;
                    System.out.println("Resultado: " + resultado + " USD");
                }
                default -> System.out.println("Opción inválida");
            }
        }

        scanner.close();
    }
}
