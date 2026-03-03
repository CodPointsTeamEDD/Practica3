/**
 * Clase concreta {@code MainConjuntos}
 * 
 * @author Luis Fernando Quintana López
 * @author Erick Xavier Martinez Briones
 * @version 1.0.0
 * @since 2026
 * 
 */

public class MainConjuntos {
    /** 
     * Metodo que almacena información en objetos de tipo ConjuntoArreglo
     * y muestra en terminal el resultado de la ejecución de las 
     * operaciones asociadas a los conjuntos
     * 
     * @param args parametros recibidos a través de la terminal
    */
    public static void main(String[] args) {
        // Prueba con Strings
        String[] frutas = {"Manzana", "Platano", "Naranja"};
        String[] otrasFrutas = {"Platano", "Kiwi"};

        // Creacion de objetos Conjuntos
        Conjunto<String> conjunto1 = new ConjuntoArreglo<String>(frutas);
        Conjunto<String> conjunto2 = new ConjuntoArreglo<String>(otrasFrutas);        // Creacion de objetos Conjuntos


        // Impresion de la verifcacion de la pertenencia de elemetnos
        System.out.println("Conjunto 1 tiene como elemento a 'Platano': " + conjunto1.pertenece("Platano"));
        System.out.println("Conjunto 1 contiene a 'Kiwi': " + conjunto1.pertenece("Kiwi"));
		
		System.out.println("____________________________________________________________");
        
        // Agrega un elemento y verifica la pertenencia nuevamente
        conjunto1.agregarElemento("Kiwi");
        System.out.println("Después de agregar 'Kiwi', conjunto 1 contiene a 'Kiwi': " + conjunto1.pertenece("Kiwi"));
        System.out.println("Conjunto 1 contiene a Conjunto 2: " + conjunto1.contieneConjunto(conjunto2));
        
        System.out.println("____________________________________________________________");

        // Imprime la uncion de conjunto 1 y conjunto 2
        System.out.println("Unión de conjunto1 y conjunto2:");
        System.out.println(conjunto1.union(conjunto2));

		System.out.println("____________________________________________________________");		
		
        // Imprime la interseccion de conjunto 1 y conjunto 2
        System.out.println("Intersección de conjunto1 y conjunto2:");
        System.out.println(conjunto1.interseccion(conjunto2));
		
		System.out.println("____________________________________________________________");
        
        // Compara si ambos conjunto son iguales
        System.out.println("¿conjunto1 es igual a conjunto2?: " + conjunto1.iguales(conjunto2));

        // Prueba con enteros
        Integer[] nums1 = {1, 2, 3};
        Integer[] nums2 = {3, 4, 5};

        Conjunto<Integer> intConj1 = new ConjuntoArreglo<Integer>(nums1);
        Conjunto<Integer> intConj2 = new ConjuntoArreglo<Integer>(nums2);

        // union de los enteros
        System.out.println("Unión de enteros:");
        System.out.println(intConj1.union(intConj2));
		
		System.out.println("____________________________________________________________");
        
        // interseccion de los enteros
        System.out.println("Intersección de enteros:");
        System.out.println(intConj1.interseccion(intConj2));

		System.out.println("____________________________________________________________");		
        
        // compara la igualdad entre conjunto de enteros
        System.out.println("¿Los conjuntos de enteros son iguales?: " + intConj1.iguales(intConj2));
        
        System.out.println("____________________________________________________________");	
        
        // Probando eliminar un elemento de la union
        
        Conjunto<String> union = conjunto1.union(conjunto2);
        union.eliminarElemento("Manzana");
        System.out.println("Unión de frutas después de eliminar 'Manzana': " + union);
    }
}
