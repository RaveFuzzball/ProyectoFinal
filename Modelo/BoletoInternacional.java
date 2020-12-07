/**
 * Representa un Boleto de clase Internacional.
 *
 * @author Ervey Guerrero Gómez
 * @author David Hernandéz López
 * @author Daniel Sánchez Vázquez 
 * @author Alejandro Tonatiuh García Espinoza 
 */

package Modelo;

public class BoletoInternacional extends Boleto {
    private final EnumVisa tipoVisa;
    private final int numPasaporte;
    private final int añosVigenciaVisa;

    /**
     * Constructor de la clase.
     *
     * @param nombrePasajero	el nombre del pasajero.
     * @param edadPasajero	la edad del pasajero.
     * @param generoPasajero	el género del pasajero.
     * @param clasePasajero		la clase en la que vuela el pasajero.
     * @param numAsiento	el asiento asignado al pasajero.
     * @param numVuelo	el número de vuelo.
     * @param aerolinea		la aerolínea.
     * @param destino	el destino del pasajero.
     * @param numPasaporte	el número de pasaporte del pasajero.
     * @param tipoVisa	el tipo de visa del pasajero.
     * @param añosVigenciaVisa	la vigencia en años de la visa del pasajero.
     */
    public BoletoInternacional(String nombrePasajero,
                               int edadPasajero,
                               String generoPasajero,
                               EnumClase clasePasajero,
                               int numAsiento,
                               int numVuelo,
                               String aerolinea,
                               String destino,
                               int numPasaporte,
                               EnumVisa tipoVisa,
                               int añosVigenciaVisa) {
        super(nombrePasajero,
                edadPasajero,
                generoPasajero,
                clasePasajero,
                numAsiento,
                numVuelo,
                aerolinea,
                destino);
        this.numPasaporte = numPasaporte;
        this.tipoVisa = tipoVisa;
        this.añosVigenciaVisa = añosVigenciaVisa;
        this.tipoVuelo = EnumVuelo.INTERNACIONAL;
    }

    /**
     * Obtiene el número de pasaporte del pasajero.
     *
     * @return el número de pasaporte del pasajero.
     */
    public int getNumPasaporte() {
        return this.numPasaporte;
    }

    /**
     * Obtiene el tipo de visa del pasajero.
     *
     * @return el tipo de visa del pasajero.
     */
    public EnumVisa getTipoVisa() {
        return this.tipoVisa;
    }

    /**
     * Obtiene los años de vigencia de la visa del pasajero.
     *
     * @return los años de vigencia de la visa del pasajero.
     */
    public int getAñosVigenciaVisa() {
        return this.añosVigenciaVisa;
    }

    /**
     * Da formato a los datos del boleto para su impresión.
     *
     * @return una cadena con formato conteniendo los datos a mostrar.
     */
    public String mostrar() {
        String linea = "-------------------------------------------------------------------------------------------------------------------------------------------------\n";
        String encabezado = "\t\t\t\t\t\t\t\t\tBoleto\n";
        //String datosFormato = "%10s%10s%10s%10s%15s%10s%10s%10s%25s\n";
        String datosFormato = "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n";
        return String.format(
                linea + encabezado + linea + datosFormato,
                "Nombre",
                this.nombrePasajero,
                "Edad",
                this.edadPasajero,
                "Genero",
                this.generoPasajero,
                "Clase",
                this.clasePasajero,
                "No. Asiento",
                this.numAsiento,
                "No. Vuelo",
                this.numAsiento,
                "Aerolínea",
                this.aerolinea,
                "Destino",
                this.destino,
                "Tipo de VISA",
                this.tipoVisa,
                "No. Pasaporte",
                this.numPasaporte,
                "Años de Vigencia de VISA",
                this.añosVigenciaVisa,
                "SU FOLIO",
                this.folio);
    }
}
