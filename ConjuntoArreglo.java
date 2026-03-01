import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConjuntoArreglo<T> extends Conjunto<T>{

    /** 
     * Metodo iterador que devuelve un objeto de tipo Iterador
     * @return Devuelve un objeto Iterador<T>
    */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int indice = 0;

            @Override
            public boolean hasNext() {
                return indice < ConjuntoArreglo.this.elementos.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return elementos[indice++];
            }
        };
    }

    private T[] elementos;

    /** 
     * Constructor por omisión
    */
    public ConjuntoArreglo() {
        this.elementos = (T[]) new Object[0];
    }

    /** 
     * Constructor por parametros
     * @param elementos arreglo de elementos de tipo T
    */
    public ConjuntoArreglo(T[] elementos) {
        if (elementos == null) {
            this.elementos = (T[]) new Object[0];
        } else if (UtilArreglos.tieneDuplicados(elementos)) {
            throw new IllegalArgumentException("El arreglo contiene elementos duplicados.");
        } else if (UtilArreglos.contieneNull(elementos)) {
            throw new IllegalArgumentException("El arreglo contiene elementos nulos.");
        } else {
            this.elementos = UtilArreglos.copiaArregloGenerico(elementos);
        }
    }

    /** 
     * Metodo que determina si un elemento está contenido en un conjunto
     * @param elemento un elemento de tipo T
     * @return booleano que indica si el elemento está o no contenido
    */
    @Override
    public boolean pertenece(T elemento) {
        for (T aux : elementos) {
            if (aux.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    /** 
     * Metodo que toma un elemento de tipo T y lo agrega al conjunto 
     * siempre que no esté ya contenido
     * 
     * @param elemento un elemento de tipo T
    */
    public void agregarElemento(T elemento) {
        if (pertenece(elemento)) {
            return;
        }

        int n = elementos.length;

        T[] elementosNuevo = (T[]) new Object[n + 1];

        for (int i = 0; i < n; i++) {
            elementosNuevo[i] = elementos[i];
        }

        elementosNuevo[n] = elemento;

        elementos = elementosNuevo;
    }

    /** 
     * Metodo que toma un elemento de tipo T y lo elimina del conjunto 
     * @param elemento un elemento de tipo T
     * 
    */    
    @Override
    public void eliminarElemento(T elemento){
        if(!pertenece(elemento)){
            return;
        }

        int n =  elementos.length;

        T[] nuevoArr =  (T[]) new Object[n - 1];

        int j = 0;

        for (int i = 0; i < n; i++) {
            if(!elementos[i].equals(elemento)){
                nuevoArr[j] = elementos[i];
                j++;
            }
        }
        
        elementos = nuevoArr;

    }

    public boolean contieneConjunto(Conjunto<T> c) {
        // el conjunto "pequeño" es el que se pasa como parametro
        // 1. Si c es vacío, entonces true
        // 2- Para cada bicho en "c" hacer
        //    3- Si this.pertenece(c) es falso entonces 
        //       4- respuesta <- false
        // 5- Devolver respuesta
        if (c.obtenerCardinalidad() == 0) {
            return true;
        }
        boolean resp = true;

        for (T elem : c) {
            if (!this.pertenece(elem)) {
                resp = false;
            }
        }
        return resp;
    }

    public Conjunto<T> union(Conjunto<T> c) {
        ConjuntoArreglo<T> c3 = new ConjuntoArreglo();

        for (T aux : this) {
            c3.agregarElemento(aux);
        }

        for(T aux2 : c){
            c3.agregarElemento(aux2);
        }

        return c3;
    }


    /** 
     * Metodo que recibe un conjunto "A" de tipo Conjunto<T> y retorna
     * los elementos que están contenidos al mismo tiempo en si mismo y en "A" 
     * @param c conjunto de tipo Conjunto<T>
     * @return nuevo conjunto que contiene los elementos que comparten ambos cojuntos
    */
    public Conjunto<T> interseccion(Conjunto<T> c) {

        ConjuntoArreglo<T> interseccion = new ConjuntoArreglo();

        for (T elem : c) {
            if (this.pertenece(elem)) {
                interseccion.agregarElemento(elem);
            }
        }

        return interseccion;
    }

    public boolean iguales(Conjunto<T> c) {
        if (this.obtenerCardinalidad() == 0 && c.obtenerCardinalidad() == 0) {
            return true;
        }

        if (c.contieneConjunto(this) && this.contieneConjunto(c)) {
            return true;
        }
        return false;
    }

    public int obtenerCardinalidad(){
        // 1- Si this.elementos.length == 0 entonces devolver 0
        // 2- sea counter <- 0
        // 3- para cada bicho en This hacer
        //      4- counter++
        // 5- Return counter
        if (this.elementos.length == 0) {
            return 0;
        } 
        int counter = 0;
        for (T elem : this) {
            counter++;
        }
        return counter;
    }

}
