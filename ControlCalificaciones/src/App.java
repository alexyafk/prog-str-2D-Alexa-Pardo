import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nombre = leerTextoNoVacio(sc,"Nombre del alumno: ");

        double p1 = leerDoubleEnRango(sc,"Calificación de parcial 1 (0 a 100): ", 0, 100);
        double p2 = leerDoubleEnRango(sc,"Calificación de parcial 2 (0 a 100): ", 0, 100);
        double p3 = leerDoubleEnRango(sc,"Calificación de parcial 3 (0 a 100): ", 0, 100);

        int asistencia = leerIntEnRango(sc,"Asistencia (0 a 100): ", 0, 100);

        boolean entregoProyecto = leerBoolean(sc,"Entrego proyecto? (true/false): ");

        GradeService gs = new GradeService();

        double promedio = gs.calcularPromedio(p1, p2, p3);
        double finalCalif = gs.calcularFinal(promedio, asistencia);
        String estado = gs.determinarEstado(finalCalif, asistencia, entregoProyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio,
                asistencia, entregoProyecto, finalCalif, estado);

        sc.close();
    }

    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto = "";
        do {
            System.out.print(msg);
            texto = sc.nextLine();
        } while (texto.length() == 0);
        return texto;
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double dato;
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


    public static void imprimirReporte(String nombre, double p1, double p2, double p3, double promedio, int asistencia, boolean proyecto, double finalCalif, String estado) {

        System.out.println("Reporte de alumno:");
        System.out.println("Alumno: " + nombre);
        System.out.println("Parciales: " + p1 + ", " + p2 + ", " + p3);
        System.out.println("Promedio: " + promedio);
        System.out.println("Asistencia: " + asistencia);
        System.out.println("Proyecto entregado: " + proyecto);
        System.out.println("Calificacion final: " + finalCalif);
        System.out.println("Estado: " + estado);
    }
}