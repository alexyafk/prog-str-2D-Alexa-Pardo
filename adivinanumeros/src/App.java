import java.util.Random;
import java.util.Scanner;

public class App {

    static int fueraDeRango = 0;
    static int noNumerico = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int max = 100;
        int min = 1;
        int secreto = random.nextInt(100) + 1;
        int intentos = 0;
        int limiteIntentos = 7;
        boolean gano = false;

        System.out.println("Adivina el numero secreto (1-100)");

        while (intentos < limiteIntentos) {
            int numero = obtenerNumeroValido(sc, "Intento: " + (intentos + 1), min, max);
            intentos++;

            if (numero == secreto) {
                System.out.println("Ganaste en el intento " + intentos);
                gano = true;
                break;
            } else if (numero > secreto) {
                System.out.println("El numero que estas buscando es menor a " + numero);
            } else {
                System.out.println("El numero que estas buscando es mayor a " + numero);
            }
        }

        if (!gano) {
            System.out.println("Perdiste, el numero secreto es " + secreto);
        }

        System.out.println("Veces fuera de rango: " + fueraDeRango);
        System.out.println("Datos no numericos: " + noNumerico);
    }

    public static int obtenerNumeroValido(Scanner sc, String mensaje, int min, int max) {
        while (true) {
            System.out.println(mensaje);

            if (sc.hasNextInt()) { //comprobamos que sea un numero entero y que este en el rango
                int valor = sc.nextInt();

                if (valor >= min && valor <= max) {
                    return valor; //incrementamos el valor a los intentos feura del rango
                } else {
                    System.out.println("Fuera de rango (1-100)");
                    fueraDeRango++;

                }

            } else {
                System.out.println("Dato no numerico");
                noNumerico++;
                sc.next();
            }
        }
    }
}