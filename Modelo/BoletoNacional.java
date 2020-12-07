/**
 * Representa un Boleto de clase Nacional.
 *
 * @author Ervey Guerrero Gómez
 * @author David Hernandéz López
 * @author Daniel Sánchez Vázquez 
 * @author Alejandro Tonatiuh García Espinoza 
 */

package Modelo;

public class BoletoNacional extends Boleto {
    private final String curpPasajero;

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
     * @param curpPasajero	el curp del pasajero.
     */
    public BoletoNacional(String nombrePasajero,
                          int edadPasajero,
                          String generoPasajero,
                          EnumClase clasePasajero,
                          int numAsiento,
                          int numVuelo,
                          String aerolinea,
                          String destino,
                          String curpPasajero) {
        super(nombrePasajero,
                edadPasajero,
                generoPasajero,
                clasePasajero,
                numAsiento,
                numVuelo,
                aerolinea,
                destino);
        this.curpPasajero = curpPasajero;
        this.tipoVuelo = EnumVuelo.NACIONAL;
    }

    /**
     * Obtiene el curp del pasajero.
     *
     * @return el curp del pasajero.
     */
    public String getCurpPasajero() {
        return this.curpPasajero;
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
        String datosFormato = "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s\n";
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
                "CURP",
                this.curpPasajero,
                "Su FOLIO",
                this.folio);
    }
}
