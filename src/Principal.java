import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();

        while (true) {
            System.out.println("Sea bienvenido/a al Conversor de Moneda =");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");

            try {
                int opcion = Integer.parseInt(lectura.nextLine());
                double cantidad;
                double resultado;

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese la cantidad en Dólares: ");
                        cantidad = Double.parseDouble(lectura.nextLine());
                        resultado = conversor.convertirMoneda("USD", "ARS", cantidad);
                        System.out.println(cantidad + " USD equivale a " + resultado + " ARS.");
                        break;
                    case 2:
                        System.out.print("Ingrese la cantidad en Pesos argentinos: ");
                        cantidad = Double.parseDouble(lectura.nextLine());
                        resultado = conversor.convertirMoneda("ARS", "USD", cantidad);
                        System.out.println(cantidad + " ARS equivale a " + resultado + " USD.");
                        break;
                    case 3:
                        System.out.print("Ingrese la cantidad en Dólares: ");
                        cantidad = Double.parseDouble(lectura.nextLine());
                        resultado = conversor.convertirMoneda("USD", "BRL", cantidad);
                        System.out.println(cantidad + " USD equivale a " + resultado + " BRL.");
                        break;
                    case 4:
                        System.out.print("Ingrese la cantidad en Reales brasileños: ");
                        cantidad = Double.parseDouble(lectura.nextLine());
                        resultado = conversor.convertirMoneda("BRL", "USD", cantidad);
                        System.out.println(cantidad + " BRL equivale a " + resultado + " USD.");
                        break;
                    case 5:
                        System.out.print("Ingrese la cantidad en Dólares: ");
                        cantidad = Double.parseDouble(lectura.nextLine());
                        resultado = conversor.convertirMoneda("USD", "COP", cantidad);
                        System.out.println(cantidad + " USD equivale a " + resultado + " COP.");
                        break;
                    case 6:
                        System.out.print("Ingrese la cantidad en Pesos colombianos: ");
                        cantidad = Double.parseDouble(lectura.nextLine());
                        resultado = conversor.convertirMoneda("COP", "USD", cantidad);
                        System.out.println(cantidad + " COP equivale a " + resultado + " USD.");
                        break;
                    case 7:
                        System.out.println("Gracias por usar el Conversor de Moneda. ¡Hasta luego!");
                        return;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción del menú.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println(); // Espacio después de cada operación
        }
    }
}
