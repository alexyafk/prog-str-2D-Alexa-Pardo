import java.util.Scanner;

public class registroPersonas {

    persona[] personas = new persona[20];
    int contador = 0;

    //dar de altaa
    public void alta(Scanner sc) {

        if (contador >= personas.length) {
            System.out.println("arreglo lleno :(");
            return;
        }

        System.out.print("ID (>0): ");
        int id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) {
            System.out.println("ID invalido");
            return;
        }

        if (existeId(id)) {
            System.out.println("ID repetido");
            return;
        }

        System.out.print("nombre: ");
        String nombre = sc.nextLine();

        if (nombre.length() == 0) {
            System.out.println("nombre vacio");
            return;
        }

        personas[contador] = new persona(id, nombre);
        contador++;

        System.out.println("alta correcta");
    }

    // busqueda
    public void buscar(Scanner sc) {

        System.out.print("ID a buscar: ");
        int id = sc.nextInt();

        for (int i = 0; i < contador; i++) {
            if (personas[i].id == id && personas[i].activa == true) {
                System.out.println("ID: " + personas[i].id);
                System.out.println("nombre: " + personas[i].nombre);
                return;
            }
        }

        System.out.println("persona inactiva/no encontrada");
    }

    // dar de baja
    public void baja(Scanner sc) {

        System.out.print("ID para baja: ");
        int id = sc.nextInt();

        for (int i = 0; i < contador; i++) {
            if (personas[i].id == id && personas[i].activa == true) {
                personas[i].activa = false;
                System.out.println("baja realizada");
                return;
            }
        }

        System.out.println("persona no encontrada");
    }

    //enlistar
    public void listar() {

        boolean hay = false;

        for (int i = 0; i < contador; i++) {
            if (personas[i].activa == true) {
                System.out.println(personas[i].id + " - " + personas[i].nombre);
                hay = true;
            }
        }

        if (hay == false) {
            System.out.println("no hay personas activas");
        }
    }

    //act
    public void actualizar(Scanner sc) {

        System.out.print("ID a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < contador; i++) {
            if (personas[i].id == id && personas[i].activa == true) {

                System.out.print("nuevo nombre: ");
                String nuevoNombre = sc.nextLine();

                if (nuevoNombre.length() == 0) {
                    System.out.println("nombre vacio");
                    return;
                }

                personas[i].nombre = nuevoNombre;
                System.out.println("nombre actualizado");
                return;
            }
        }

        System.out.println("persona no encontrada");
    }

    public boolean existeId(int id) {

        for (int i = 0; i < contador; i++) {
            if (personas[i].id == id) {
                return true;
            }
        }
        return false;
    }
}
