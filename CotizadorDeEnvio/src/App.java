import java.util.Scanner;
public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double peso = leerDoubleEnRango(sc, "Ingresa el peso (0.1 a 50): ", 0.1, 50);
        int distancia = leerIntEnRango(sc, "Ingresa la distancia (1 a 2000): ", 1, 2000);
        int tipoServicio = leerIntEnRango(sc, "Servicio 1)Estandar 2)Express: ", 1, 2);
        boolean zona = leerBoolean(sc,"Es zona remota? true/false: ");

        ShippingCalculator calculadora = new ShippingCalculator();

        double sub = calculadora.calcularSubtotal(peso, distancia, tipoServicio, zona);
        double iva = calculadora.calcularIVA(sub);
        double total = calculadora.calcularTotal(sub, iva);

        imprimirTicket(peso, distancia, tipoServicio, zona, sub, iva, total);
        sc.close();
    }


    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double dato = 0;
        do {
            System.out.print(msg);
            dato = sc.nextDouble();
        } while (dato < min || dato > max);
        return dato;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int dato;
        do {
            System.out.print(msg);
            dato = sc.nextInt();
        } while (dato < min || dato > max);
        return dato;
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        System.out.print(msg);
        boolean valor = sc.nextBoolean();
        return valor;
    }


    public static void imprimirTicket(double peso, int distancia, int servicio, boolean zona, double subtotal, double iva, double total){

        if (servicio == 1) {
            System.out.println("Servicio: Estandar");
        }
        if (servicio == 2) {
            System.out.println("Servicio: Express");
        }

        System.out.println("Peso: " + peso);
        System.out.println("Distancia: " + distancia);
        System.out.println("Zona remota: " + zona);
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("IVA: $" + iva);
        System.out.println("Total: $" + total);
    }
}
