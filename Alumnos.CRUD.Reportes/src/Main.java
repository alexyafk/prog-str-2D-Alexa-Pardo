import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();
        int opcion;

        do {
            System.out.println("Menu (seleccione una opción)");
            System.out.println("1- Alta alumno");
            System.out.println("2- Buscar alumno");
            System.out.println("3- Actualizar");
            System.out.println("4- Baja alumno");
            System.out.println("5- Lista de alumnos");
            System.out.println("6- Reportes");
            System.out.println("0- Salir");
            System.out.println("___________________________");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    sistema.alta();
                    break;

                case 2:
                    sistema.buscarAlumno();
                    break;

                case 3:
                    sistema.actualizar();
                    break;

                case 4:
                    sistema.baja();
                    break;

                case 5:
                    sistema.listar();
                    break;

                case 6:
                    sistema.reportes();
                    break;

                case 0:
                    System.out.println("Saliendo  del programa");
                    break;

                default:
                    System.out.println("Opcion invalida :(");
            }

        } while (opcion != 0);
    }
}