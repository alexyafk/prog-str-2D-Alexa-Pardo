import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Escriba su edad:");
        int edad = scanner.nextInt();
        if (edad < 0 || edad > 120){
            System.out.println("Edad no valida");
            return;
        }
        System.out.print("Eres estudiante? Si - No :");
        String respuesta = scanner.next();
        boolean estudiante;
        if (respuesta.equalsIgnoreCase("si")){
            estudiante = true;
        }
        else {
            estudiante = false;
        }
        int tarifa;
        if (edad < 12){
            tarifa = 50;
        } else if (edad >= 12 && edad <= 17) {
            if (estudiante){
                tarifa = 60;
            }
            else {
                tarifa = 80;
            }
        }
        else {
            if (estudiante){
                tarifa = 90;
            }
            else {
                tarifa = 120;
            }
        }
        System.out.println("Edad: " + edad);
        System.out.println("Estudiante: " + (estudiante ? "Si" : "No"));
        System.out.println("Su tarifa: " + tarifa);
        scanner.close();
    }
}