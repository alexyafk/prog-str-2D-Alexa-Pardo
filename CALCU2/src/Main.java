import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        int total = 0;

        int cAF = 0;
        int fAC = 0;
        int kmAM = 0;
        int mAKm = 0;

        do {
            System.out.println("--------------");
            System.out.println("1- C° a F°");
            System.out.println("2- F° a C°");
            System.out.println("3- Km a Millas");
            System.out.println("4- Millas a Km");
            System.out.println("5- Salir");
            System.out.print("Elige una opcion: ");

            if (!sc.hasNextInt()) {
                System.out.println("Debe ser un numero.");
                sc.next();
                continue;
            }

            opcion = sc.nextInt();

            if (opcion < 1 || opcion > 5) {
                System.out.println("Opcion fuera de rango.");
                continue;
            }

            if (opcion == 5) break;

            System.out.print("Ingresa el valor a convertir: ");

            if (!sc.hasNextDouble()) {
                System.out.println("Dato no numerico.");
                sc.next();
                continue;
            }

            double valor = sc.nextDouble();
            double resultado;

            switch (opcion) {
                case 1:
                    resultado = (valor * 9 / 5) + 32;
                    System.out.println(valor + "° C = " + resultado + "° F");
                    cAF++;
                    break;

                case 2:
                    resultado = (valor - 32) * 5 / 9;
                    System.out.println(valor + "° F = " + resultado + "° C");
                    fAC++;
                    break;

                case 3:
                    resultado = valor * 0.621371;
                    System.out.println(valor + " Km = " + resultado + " Millas");
                    kmAM++;
                    break;

                case 4:
                    resultado = valor / 0.621371;
                    System.out.println(valor + " Millas = " + resultado + " Km");
                    mAKm++;
                    break;
            }

            total++;

        } while (true);

        System.out.println("Total de conversiones: " + total);
        System.out.println("C° a F°: " + cAF);
        System.out.println("F° a C°: " + fAC);
        System.out.println("Km a Millas: " + kmAM);
        System.out.println("Millas a Km: " + mAKm);

    }
}