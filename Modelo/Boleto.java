/**
 * Representa un Boleto.
 *
 * @author Ervey Guerrero Gómez
 * @author David Hernandéz López
 * @author Daniel Sánchez Vázquez 
 * @author Alejandro Tonatiuh García Espinoza 
 */

package Modelo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Boleto implements Serializable {
    public static int numBoletos;
    
    protected EnumClase clasePasajero;
    protected EnumVuelo tipoVuelo;
    protected int edadPasajero;
    protected int folio;
    protected int numAsiento;
    protected int numVuelo;
    protected String aerolinea;
    protected String destino;
    protected String generoPasajero;
    protected String nombrePasajero;

    /**
     * Constructor de la clase.
     *
     * @param nombrePasajero  el nombre del pasajero.
     * @param edadPasajero  la edad del pasajero.
     * @param generoPasajero  el género del pasajero.
     * @param clasePasajero   la clase en la que vuela el pasajero.
     * @param numAsiento  el asiento asignado al pasajero.
     * @param numVuelo  el número de vuelo.
     * @param aerolinea   la aerolínea.
     * @param destino el destino del pasajero.
     */
    public Boleto(String nombrePasajero,
        int edadPasajero,
        String generoPasajero,
        EnumClase clasePasajero,
        int numAsiento,
        int numVuelo,
        String aerolinea,
        String destino) {
        this.clasePasajero = clasePasajero;
        this.edadPasajero = edadPasajero;
  this.folio = ++Boleto.numBoletos;
        this.numAsiento = numAsiento;
        this.numVuelo = numVuelo;
        this.aerolinea = aerolinea;
        this.destino = destino;
        this.generoPasajero = generoPasajero;
        this.nombrePasajero = nombrePasajero;
    }

    /**
     * Da formato a los datos del boleto para su impresión.
     *
     * @return una cadena con formato conteniendo los datos a mostrar.
     */
    public abstract String mostrar();

    /**
     * Obtiene el nombre del pasajero.
     *
     * @return el nombre del pasajero.
     */
    public String getNombrePasajero() {
        return this.nombrePasajero;
    }

    /**
     * Obtiene la edad del pasajero.
     *
     * @return la edad del pasajero.
     */
    public int getEdadPasajero() {
        return this.edadPasajero;
    }

    /**
     * Obtiene el genero del pasajero.
     *
     * @return el genero del pasajero.
     */
    public String getGeneroPasajero() {
        return this.generoPasajero;
    }

    /**
     * Obtiene la clase del pasajero asociado al boleto.
     *
     * @return la clase del pasajero asociado al boleto.
     */
    public EnumClase getClasePasajero() {
        return this.clasePasajero;
    }

    /**
     * Obtiene el numero de asiento del pasajero.
     *
     *  @return el numero de asiento del pasajero.
     */
    public int getNumAsiento() {
        return this.numAsiento;
    }

    /**
     * Obtiene el numero de vuelo.
     *
     * @return el numero de vuelo.
     */
    public int getNumVuelo() {
        return this.numVuelo;
    }

    /**
     * Obtiene la aerolinea.
     *
     * @return la aerolinea.
     */
    public String getAerolinea() {
        return this.aerolinea;
    }

    /**
     * Obtiene el destino del vuelo.
     *
     * @return el destino del vuelo.
     */
    public String getDestino() {
        return this.destino;
    }

    /**
     * Obtiene el tipo de vuelo del boleto.
     *
     * @return el tipo de vuelo del boleto.
     */
    public EnumVuelo getTipoVuelo() {
        return this.tipoVuelo;
    }

    /** Regresa el folio del boleto.  */
    public int getFolio() {
      return this.folio;
    }

    /**
     * Guarda el boleto en un archivo en la carpeta actual.
     *
     * @throws Exception si no se pudo guardar.
     */
    public void guardar() throws Exception {
      this.guardar("./"); // "./" es la dirección relativa a la carpeta actual.
    }

    /**
     * Guarda el boleto en un archivo en la carpeta con la dirección dada.
     *
     * @throws Exception si no se pudo guardar.
     */
    public void guardar(String dir) throws Exception {
      if (!dir.endsWith("/")) {
        dir += "/";
      }
      String archivo = String.format("%s%s_%s.vuelo",
          dir,
          this.tipoVuelo.toString().toLowerCase(),
          this.nombrePasajero.replaceAll(" ", ""));
      try {
        ObjectOutputStream salida = new ObjectOutputStream(
            new FileOutputStream(archivo));
        salida.writeObject(this);
        salida.close();
      } catch (FileNotFoundException e) {
        throw new Exception("¡Error! La carpeta indicada no existe.");
      } catch (IOException e) {
        throw new Exception("¡Error! No se ha podido guardar.");
      }
    }
}

