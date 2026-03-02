/**
 * Clase abstracta {@code Conjunto}
 * Implementa la interfaz {@link Itetarable}
 * 
 * @author Luis Fernando Quintana López
 * @author Erick Xavier Martinez Briones
 * @version 1.0.0
 * @since 2026
 * 
 */

public abstract class Conjunto<T> implements Iterable<T> {

    /**
     * Metodo asbtracto que determina si un elemento pertenece a un conjunto
     * 
     * @param elemento elemento a determinar
     * @return True en caso de que pertenezca, False en otro caso
     */
    public abstract boolean pertenece(T elemento);

    /**
     * Metodo abstracto que agrega un elemento a un conjunto
     * 
     * @param elemento elemento a agregar
     */
    public abstract void agregarElemento(T elemento);

    /**
     * Metodo abstracto que elimina un elemento de un conjunto
     * 
     * @param elemento elemento a eliminar
     */
    public abstract void eliminarElemento(T elemento);

    /**
     * Metodo abstracto que determino si un conjunto esta contenido en otro conjunto
     * dado
     * 
     * @param c Conjunto dado
     * @return True en caso de estar contenido. False en otro caso
     */
    public abstract boolean contieneConjunto(Conjunto<T> c);

    /**
     * Metodo asbtracto que realliza la union de un conjunto dado con otro conjunto
     * 
     * @param c conjunto de tipo Conjunto<T>
     * @return Un conjunto que representa la union de ambos conjuntos
     */
    public abstract Conjunto<T> union(Conjunto<T> c);

    /**
     * Metodo asbtracto que realliza la interseccion de un conjunto dado con otro
     * conjunto
     * 
     * @param c conjunto de tipo Conjunto<T>
     * @return Un conjunto que representa la interseccion de ambos conjuntos
     */
    public abstract Conjunto<T> interseccion(Conjunto<T> c);

    /**
     * Metodo abstracto que determino si un conjunto es igual a otro conjunto dado
     * 
     * @param c conjunto de tipo Conjunto<T>
     * @return True en caso de ser iguales. False en otro caso
     */
    public abstract boolean iguales(Conjunto<T> c);

    /**
     * Metodo abstracto que determina el numero de elementos que contiene un
     * conjunto
     * 
     * @return el numero de elementos de un conjunto
     */
    public abstract int obtenerCardinalidad();

    /**
     * Metodo toString que devuelve una representación en cadena del conjunto
     * 
     * @return una cadena que representa los elementos del conjunto
     */
    @Override
    public String toString() {
        if (this.obtenerCardinalidad() == 0) {
            return "{}";
        }
        String resultado = "{";

        // Se iteran los elementos de un conjunto sin importar como se defina el
        // iterador en cada implementación de la interfaz
        int i = 0;
        for (T e : this) {
            resultado += e.toString();
            if (i < this.obtenerCardinalidad() - 1) {
                resultado += ", ";
            }
            i++;
        }
        resultado += "}";
        return resultado;
    }
}
