import java.util.Scanner;

public class Sistema {

    Alumno[] alumnos = new Alumno[25];
    Scanner sc = new Scanner(System.in);

    public void alta() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) {
            System.out.println("ID invalido : ");
            System.out.println("____________________");
            return;
        }

        if (buscar(id) != -1) {
            System.out.println("ID repetido");
            System.out.println("____________________");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        if (nombre.isEmpty()) {
            System.out.println("Nombre vacio");
            System.out.println("____________________");
            return;
        }

        System.out.print("Promedio: ");
        double promedio = sc.nextDouble();
        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio invalido");
            System.out.println("____________________");
            return;
        }

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nombre, promedio);
                System.out.println("Alumno dado de alta");
                System.out.println("____________________");
                return;
            }
        }
    }

    public int buscar(int id) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].id == id && alumnos[i].activo) {
                return i;
            }
        }
        return -1;
    }

    public void buscarAlumno() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        int pos = buscar(id);

        if (pos != -1) {
            System.out.println(alumnos[pos].id + " " +
                    alumnos[pos].nombre + " " +
                    alumnos[pos].promedio);
        } else {
            System.out.println("Alumno no encontrado");
            System.out.println("____________________");
        }
    }

    public void actualizar() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        int pos = buscar(id);

        if (pos == -1) {
            System.out.println("Alumno no encontrado");
            System.out.println("____________________");
            return;
        }

        System.out.print("Nuevo promedio: ");
        double nuevo = sc.nextDouble();

        if (nuevo >= 0 && nuevo <= 10) {
            alumnos[pos].promedio = nuevo;
            System.out.println("Actualizado");
            System.out.println("____________________");
        } else {
            System.out.println("Promedio invalido");
            System.out.println("____________________");
        }
    }

    public void baja() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        int pos = buscar(id);

        if (pos != -1) {
            alumnos[pos].activo = false;
            System.out.println("Alumno dado de baja");
            System.out.println("___________________");
        } else {
            System.out.println("Alumno no encontrado");
            System.out.println("____________________");
        }
    }

    public void listar() {
        for (Alumno a : alumnos) {
            if (a != null && a.activo) {
                System.out.println(a.id + " " + a.nombre + " " + a.promedio);
            }
        }
    }

    public void reportes() {
        double suma = 0;
        int cont = 0;
        Alumno mayor = null;
        Alumno menor = null;
        int promede8 = 0;

        for (Alumno a : alumnos) {
            if (a != null && a.activo) {
                suma += a.promedio;
                cont++;

                if (mayor == null || a.promedio > mayor.promedio)
                    mayor = a;

                if (menor == null || a.promedio < menor.promedio)
                    menor = a;

                if (a.promedio >= 8.0)
                    promede8++;
            }
        }

        if (cont > 0) {
            System.out.println("Promedio general: " + (suma / cont));
            System.out.println("Mayor: " + mayor.id + " " + mayor.nombre + " " + mayor.promedio);
            System.out.println("Menor: " + menor.id + " " + menor.nombre + " " + menor.promedio);
            System.out.println("Alumnos con promedio arriba de 8.0: " + promede8);
            System.out.println("____________________________");
        } else {
            System.out.println("No hay alumnos dados de alta");
            System.out.println("____________________________");
        }
    }
}