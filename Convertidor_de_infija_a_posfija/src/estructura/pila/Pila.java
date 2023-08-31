package estructura.pila;

import estructura.lista.t.TDAListaSimple;
/**
 * 
 * @author cesar
 *Esta clase sirve para trabajar con la estructura de datos Pila.
 * @param <T>
 */
public class Pila<T> {
	
	TDAListaSimple<T> pila= new TDAListaSimple<>(); 
	/**
	 * Se crea el constructor
	 */
	public Pila() {
	}
	/**
	 * Este método sirve para insertar un dato a la Pila.
	 * @param dato Es el dato que se agrega a la Pila.
	 */
	public void  insertar (T dato) {
		this.pila.insertarCola(dato);
	}
	/**
	 * Este método sirve para eliminar un dato de la Pila. 
	 * @return Retorna el dato que se saca.
	 */
	public T sacar() {
		return this.pila.eliminarCola(); 
    }
	/**
	 * Este método sirve para saber si la Pila está vacía.
	 * @return Retorna un boolean para saber si el procedimiento se llevo de manera correcta.
	 */
	public boolean vacia() {
		return this.pila.esVacia(); 
	}
	/**
	 * Este método sirve para ver el primer elemento de la Pila.
	 * @return Retorna el dato.
	 */
	public T verArriba() {
	T dato = this.pila.eliminarCola(); 
	this.insertar(dato); 
	return dato; 
    }
    
}
