import java.util.Scanner;

public class ActividadSwitchCalculadora {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opción:");
        System.out.println("1- Sumar");
        System.out.println("2- Restar");
        System.out.println("3- Multiplicar");
        System.out.println("4- Dividir");

        System.out.print("Ingrese la opción: ");
        int opcion = scanner.nextInt();

        double valorA, valorB, resultado;

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el valor A: ");
                valorA = scanner.nextDouble();
                System.out.print("Ingrese el valor B: ");
                valorB = scanner.nextDouble();

                resultado = valorA + valorB;
                System.out.println("Operación elegida: Sumar");
                System.out.println("Resultado: " + resultado);
                break;

            case 2:
                System.out.print("Ingrese el valor A: ");
                valorA = scanner.nextDouble();
                System.out.print("Ingrese el valor B: ");
                valorB = scanner.nextDouble();

                resultado = valorA - valorB;
                System.out.println("Operación elegida: Restar");
                System.out.println("Resultado: " + resultado);
                break;

            case 3:
                System.out.print("Ingrese el valor A: ");
                valorA = scanner.nextDouble();
                System.out.print("Ingrese el valor B: ");
                valorB = scanner.nextDouble();

                resultado = valorA * valorB;
                System.out.println("Operación elegida: Multiplicar");
                System.out.println("Resultado: " + resultado);
                break;

            case 4:
                System.out.print("Ingrese el valor A: ");
                valorA = scanner.nextDouble();
                System.out.print("Ingrese el valor B: ");
                valorB = scanner.nextDouble();

                if (valorB == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = valorA / valorB;
                    System.out.println("Operación elegida: Dividir");
                    System.out.println("Resultado: " + resultado);
                }
                break;

            default:
                System.out.println("Opción inválida");
                break;
        }

        scanner.close();
    }
}

