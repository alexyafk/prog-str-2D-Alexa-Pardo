import java.util.Scanner;

public class Main{
    public static void Main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular area de rectangulo");
            System.out.println("3. Calcular celsius a Fahrenheit");
            System.out.println("4. calcular area de circulo");
            System.out.print("Elige una opcion: ");

            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Peso (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Estatura (m): ");
                    double estatura = scanner.nextDouble();
                    System.out.println("IMC = " + calcularIMC(peso, estatura));
                    break;

                case 2:
                    System.out.print("Base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Altura: ");
                    double altura = scanner.nextDouble();
                    System.out.println("Area = " + areaRectangulo(base, altura));
                    break;

                case 3:
                    System.out.print("Grados Celsius: ");
                    double c = scanner.nextDouble();
                    System.out.println("Fahrenheit = " + celsiusAFahrenheit(c));
                    break;

                case 4:
                    System.out.print("Radio: ");
                    double r = scanner.nextDouble();
                    System.out.println("Area = " + areaCirculo(r));
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Elija otro opcion");
            }

            System.out.println();

        } while (opcion != 5);

        scanner.close();
    }

    /**
     * Calcula el IMC usando peso y estatura.
     *
     * @param peso peso en kilogramos
     * @param estatura estatura en metros
     * @return valor del IMC
     */
    public static double calcularIMC(double peso, double estatura) {
        return peso / (estatura * estatura);
    }

    /**
     * Calcula el area de un rectangulo.
     *
     * @param base base del rectangulo
     * @param altura altura del rectangulo
     * @return area del rectangulo
     */
    public static double areaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Convierte grados Celsius a Fahrenheit.
     *
     * @param c grados celsius
     * @return grados fahrenheit
     */
    public static double celsiusAFahrenheit(double c) {
        return (c * 1.8) + 32;
    }

    /**
     * Calcula el area de un circulo.
     *
     * @param r radio del circulo
     * @return area del circulo
     */
    public static double areaCirculo(double r) {
        return 3.1416 * r * r;
    }
}

