import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        registroPersonas registro = new registroPersonas();

        int opcion;

        do {
            System.out.println("Menu CRUD_______");
            System.out.println("1) Alta");
            System.out.println("2) Buscar");
            System.out.println("3) Baja");
            System.out.println("4) Listar");
            System.out.println("5) Actualizar");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                registro.alta(sc);
            } else if (opcion == 2) {
                registro.buscar(sc);
            } else if (opcion == 3) {
                registro.baja(sc);
            } else if (opcion == 4) {
                registro.listar();
            } else if (opcion == 5) {
                registro.actualizar(sc);
            }

        } while (opcion != 0);

        sc.close();
    }
}
