/**
 * Representa un nodo de una lista ligada.
 *
 * @author Ervey Guerrero Gómez
 * @author David Hernandéz López
 * @author Daniel Sánchez Vázquez 
 * @author Alejandro Tonatiuh García Espinoza 
 */

package Modelo;

public class Nodo {
  private Boleto informacion;
  private Nodo siguiente;

  /** Constructor de la clase.  */
  public Nodo() {
    this(null);
  }

  /**
   * Constructor de la clase.
   *
   * @param informacion la información del nodo.
  */
  public Nodo(Boleto informacion) {
    this(informacion, null);
  }

  /**
   * Constructor de la clase.
   *
   * @param informacion la información del nodo.
   * @param siguiente el siguiente nodo en la lista ligada.
  */
  public Nodo(Boleto informacion, Nodo siguiente) {
    this.informacion = informacion;
    this.siguiente = siguiente;
  }

  /** Regresa la información del nodo. */
  public Boleto getInformacion() {
    return this.informacion;
  }

  /** Regresa el siguiente nodo.  */
  public Nodo getSiguiente() {
    return this.siguiente;
  }

  /** Establece la información del nodo.  */
  public void setInformacion(Boleto informacion) {
    this.informacion = informacion;
  }

  /** Establece el siguiente nodo.  */
  public void setSiguiente(Nodo siguiente) {
    this.siguiente = siguiente;
  }
}

