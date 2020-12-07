/**
 * Representa un lista ligada.
 *
 * @author Ervey Guerrero Gómez
 * @author David Hernandéz López
 * @author Daniel Sánchez Vázquez 
 * @author Alejandro Tonatiuh García Espinoza 
 */

package Modelo;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ListaLigada {
  private Nodo raiz;

  /** Regresa el primer {@link Boleto} con el folio buscado. */
  public Boleto buscarBoletoPorFolio(int folio) {
    Nodo aux = this.raiz;
    if (this.raiz == null) {
      return null;
    }
    while (aux != null) {
      if (aux.getInformacion().getFolio() == folio) {
        return aux.getInformacion();
      }
      aux = aux.getSiguiente();
    }
    return null;
  }

  /** Regresa el primer {@link Boleto} con el nombre buscado. */
  public Boleto buscarBoletoPorNombre(String nombre) {
    Nodo aux = this.raiz;
    if (this.raiz == null) {
      return null;
    }
    while (aux != null) {
      if (aux.getInformacion().getNombrePasajero().equals(nombre)) {
        return aux.getInformacion();
      }
      aux = aux.getSiguiente();
    }
    return null;
  }

  /** Elimina de la lista ligada el primer nodo con el folio dado. */
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

  /** Elimina de la lista ligada el primer nodo con el nombre dado. */
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

  /** Inserta un nuevo {@link Boleto} a la lista ligada. */
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

  /** 
   * Llena la lista ligada con los {@link Boleto} obtenidos de los archivos en
   * la carpeta indicada.
   *
   * @param dir la dirección de la carpeta.
  */
  public void insertarBoletosPorCarpeta(String dir) {
    File carpeta = new File(dir);
    FilenameFilter vueloFileFilter = new FilenameFilter() {
      public boolean accept(File dir, String name) {
        String lowerCaseName = name.toLowerCase();
        if (lowerCaseName.endsWith(".vuelo")) {
          return true;
        }
        return false;
      }
    };
    File listaArchivos[] = carpeta.listFiles(vueloFileFilter);
    if (listaArchivos != null) {
      for (File archivo : listaArchivos) {
        try {
          ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo));
          Boleto boleto = null;
          if (archivo.getName().contains("internacional")) {
            boleto = (BoletoInternacional) entrada.readObject();
            int ultimoFolioConocido = boleto.getFolio();
            Boleto.numBoletos = ++ultimoFolioConocido;
          } else if (archivo.getName().contains("nacional")) {
            boleto = (BoletoNacional) entrada.readObject();
            int ultimoFolioConocido = boleto.getFolio();
            Boleto.numBoletos = ++ultimoFolioConocido;
          }
          if (boleto != null) {
            this.insertarBoleto(boleto);
          }
          entrada.close();
        } catch (ClassNotFoundException e) {
          continue;
        } catch (FileNotFoundException e) {
          continue;
        } catch (IOException e) {
          continue;
        }
      }
    }
  }
}
