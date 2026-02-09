public class GradeService {

    public double calcularPromedio(double a, double b, double c) {
        double prom = (a + b + c) / 3;
        return prom;
    }

    public double calcularFinal(double promedio, int asistencia) {
        double finalCalif = (promedio * 0.7) + (asistencia * 0.3);
        return finalCalif;
    }

    public String determinarEstado(double finalCalif,
                                   int asistencia,
                                   boolean entregoProyecto) {

        String estado = "";

        if (asistencia < 80) {
            estado = "REPROBADO por asistencia";
        } else if (entregoProyecto == false) {
            estado = "REPROBADO por proyecto";
        } else {
            if (finalCalif >= 70) {
                estado = "APROBADO";
            } else {
                estado = "REPROBADO por calificacion";
            }
        }

        return estado;
    }
}