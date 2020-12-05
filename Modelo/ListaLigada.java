/**
 * Representa un lista ligada.
 *
 * @author Ervey Guerrero Gómez
 * @author David Hernandéz López
 * @author Daniel Sánchez Vázquez 
 * @author Alejandro Tonatiuh García Espinoza 
 */

package Modelo;

public class ListaLigada {
  private Nodo raiz;

  public Nodo buscarBoletoPorFolio(int folio) {
    Nodo aux = this.raiz;
    if (this.raiz == null) {
      return null;
    }
    while (aux != null) {
      if (aux.getInformacion().getFolio() == folio) {
        return aux;
      }
      aux = aux.getSiguiente();
    }
    return null;
  }

  public Nodo buscarBoletoPorNombre(String nombre) {
    Nodo aux = this.raiz;
    if (this.raiz == null) {
      return null;
    }
    while (aux != null) {
      if (aux.getInformacion().getNombrePasajero().equals(nombre)) {
        return aux;
      }
      aux = aux.getSiguiente();
    }
    return null;
  }

  public void eliminarBoletoPorFolio(int folio) {
    Nodo aux = this.raiz;
    Nodo ant = this.raiz;
    if (this.raiz != null) {
      return;
    }
    if (this.raiz.getInformacion().getFolio() == folio) {
      this.raiz = this.raiz.getSiguiente();
    } else {
      while (aux != null) {
        if (aux.getInformacion().getFolio() == folio) {
          ant.setSiguiente(aux.getSiguiente());
          break;
        }
        ant = aux;
        aux = aux.getSiguiente();
      }
    }
  }

  public void eliminarBoletoPorNombre(String nombre) {
    Nodo aux = this.raiz;
    Nodo ant = this.raiz;
    if (this.raiz != null) {
      return;
    }
    if (this.raiz.getInformacion().getNombrePasajero().equals(nombre)) {
      this.raiz = this.raiz.getSiguiente();
    } else {
      while (aux != null) {
        if (aux.getInformacion().getNombrePasajero().equals(nombre)) {
          ant.setSiguiente(aux.getSiguiente());
          break;
        }
        ant = aux;
        aux = aux.getSiguiente();
      }
    }
  }

  public void insertarBoleto(Boleto boleto) {
    Nodo nuevoNodo = new Nodo(boleto);
    Nodo aux;
    if (this.raiz == null) {
      this.raiz = nuevoNodo;
    } else {
      aux = this.raiz;
      while (aux.getSiguiente() != null) {
        aux = aux.getSiguiente();
      }
      aux.setSiguiente(nuevoNodo);
    }
  }
}
