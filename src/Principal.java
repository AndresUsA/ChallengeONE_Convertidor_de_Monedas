import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        ConsumoAPI consulta = new ConsumoAPI();
        DecimalFormat decimal = new DecimalFormat("#.##");

        String base_code = "", target_code = "";
        double cantidad = 0.0;

        while (true) {
            int opcion = 0;
            System.out.println("""
                Que operacion que desea realizar?
                    1. Dolares a Euros.               2. Euros a Dolares.
                    3. Dolares a Pesos Mexicanos.     4. Pesos Mexicanos a Dolares.
                    5. Dolares a Real Brasileño.      6. Real Brasileño a Dolares.
                    7. Dolares a Pesos Argentinos.    8. Pesos Argentinos a Dolares.
                    9. SALIR.              
                Digite su opción (del 1 al 9):
                """);
            try {
                opcion = Integer.parseInt(consola.nextLine());
                if (opcion >= 1 && opcion <= 9) {
                    switch (opcion) {
                        case 1:
                            base_code = "USD";
                            target_code = "EUR";
                            break;
                        case 2:
                            base_code = "EUR";
                            target_code = "USD";
                            break;
                        case 3:
                            base_code = "USD";
                            target_code = "MXN";
                            break;
                        case 4:
                            base_code = "MXN";
                            target_code = "USD";
                            break;
                        case 5:
                            base_code = "USD";
                            target_code = "BRL";
                            break;
                        case 6:
                            base_code = "BRL";
                            target_code = "USD";
                            break;
                        case 7:
                            base_code = "USD";
                            target_code = "ARS";
                            break;
                        case 8:
                            base_code = "ARS";
                            target_code = "USD";
                            break;
                        case 9:
                            System.out.println("Programa finalizado.");
                            return;
                    }
                    System.out.println("Digite la cantidad que desea convertir: ");
                    cantidad = Double.valueOf(consola.nextLine());

                    DatoMoneda moneda = consulta.convertir(base_code, target_code, cantidad);
                    System.out.println("**********************************************");
                    System.out.println("\nEl valor de " + cantidad + "[" + base_code + "] corresponde a " + decimal.format(moneda.conversion_result()) + "[" + target_code + "].");
                    System.out.println("\n**********************************************\n");
                }else {
                    System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida, digite un número entero.");
                System.out.println(e.getMessage());
            }
        }
    }
}
