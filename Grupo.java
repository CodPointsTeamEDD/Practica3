import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase concreta {@code Grupo}
 * 
 * @author Luis Fernando Quintana López
 * @author Erick Xavier Martinez Briones
 * @version 1.0.0
 * @since 2026
 * 
 */
public class Grupo {

    /** 
     * Metodo que lee el archivo Alumnos.txt, almacena la información en objetos
     * de tipo ConjuntoArreglo y muestra en terminal el resultado de la ejecución
     * de las operaciones asociadas a los conjuntos
     */
    public static void metodoCoordinacion() {
        ConjuntoArreglo<String> robotica = new ConjuntoArreglo<>();
        ConjuntoArreglo<String> programacionWeb = new ConjuntoArreglo<>();
        ConjuntoArreglo<String> ciberseguridad = new ConjuntoArreglo<>();

        try (BufferedReader br = new BufferedReader((new FileReader("Alumnos.txt")))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(":");

                String nombreAlumno = datos[0].trim();
                String materia = datos[1].trim();

                /** Ir clasificando segun nombre y materia */
                if (materia.equals("Robotica")) {
                    robotica.agregarElemento(nombreAlumno);
                } else if (materia.equals("Programacion Web")) {
                    programacionWeb.agregarElemento(nombreAlumno);
                } else if (materia.equals("Ciberseguridad")) {
                    ciberseguridad.agregarElemento(nombreAlumno);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Alumnos inscritos simultaneamente en las materias Programacion Web y Robotica.");
        System.out.println("--------------------------------------------------------------------------------");
        Conjunto<String> interseccion = programacionWeb.interseccion(robotica);
        for (String alumno : interseccion) {
            System.out.println(alumno);
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Alumnos inscritos en Programacion Web, pero que no esten inscritos en Ciberseguridad.");
        System.out.println("--------------------------------------------------------------------------------");
        Conjunto<String> noCiberseguridad = new ConjuntoArreglo<>();

        for (String alumno : programacionWeb) {
            if (!ciberseguridad.pertenece(alumno)) {
                noCiberseguridad.agregarElemento(alumno);
            }
        }

        for (String alumno : noCiberseguridad) {
            System.out.println(alumno);
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Alumnos inscritos en al menos una de las materias optativas");
        System.out.println("--------------------------------------------------------------------------------");
        Conjunto<String> almenosUna = programacionWeb.union(robotica).union(ciberseguridad);

        for (String alumno : almenosUna) {
            System.out.println(alumno);
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Alumnos inscritos en al menos dos materias optativas");
        System.out.println("--------------------------------------------------------------------------------");
        Conjunto<String> webyrobo = programacionWeb.interseccion(robotica);
        Conjunto<String> webyciber = programacionWeb.interseccion(ciberseguridad);
        Conjunto<String> roboyciber = robotica.interseccion(ciberseguridad);

        Conjunto<String> almenosDos = webyrobo.union(webyciber.union(roboyciber));

        for (String alumno : almenosDos) {
            System.out.println(alumno);
        }

    }
    /** 
     * Metodo principal que ejecuta el metodo metodoCoordinación para resolver
     * el problema planteado
     * @param args parametros recibidos a través de la terminal
    */
    public static void main(String[] args) {
        System.out.println("=== Coordinacion de Ciencias de la Computacion ===");
        metodoCoordinacion();
    }

}
