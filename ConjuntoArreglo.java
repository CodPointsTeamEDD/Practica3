import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConjuntoArreglo<T> extends Conjunto<T>{

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

    public ConjuntoArreglo() {
        this.elementos = (T[]) new Object[0];
    }

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

    public boolean pertenece(T elemento) {
        for (T aux : elementos) {
            if (aux.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public void agregarElemento(T elemento) {
        if (pertenece(elemento)) {
            return this;
        }

        int n = elementos.length;

        T[] elementosNuevo = new Object[n + 1];

        for (int i = 0; i < n; i++) {
            elementosNuevo[i] = elementos[i];
        }

        elementosNuevo[n] = elemento;

        elementos = elementosNuevo;
    }
    
    public void eliminarElemento(T elemento){
    	/*Aquí va tu código*/
    }

    public boolean contieneConjunto(Conjunto<T> c) {
        /*Aquí va tu código*/
    }

    public Conjunto<T> union(Conjunto<T> c) {
        /*Aquí va tu código*/
    }

    public Conjunto<T> interseccion(Conjunto<T> c) {
        /*Aquí va tu código*/
    }

    public boolean iguales(Conjunto<T> c) {
        /*Aquí va tu código*/
    }

    public int obtenerCardinalidad(){
        /*Aquí va tu código*/
    }

}
