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
     * @param curp	el curp del pasajero.
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
        String datosFormato = "%10s%10s%10s%10s%15s%10s%10s%10s%25s\n";
        return String.format(
                linea + encabezado + linea + datosFormato + datosFormato,
                "Nombre",
                "Edad",
                "Genero",
                "Clase",
                "No. Asiento",
                "No. Vuelo",
                "Aerolínea",
                "Destino",
                "CURP",
                this.nombrePasajero,
                this.edadPasajero,
                this.generoPasajero,
                this.clasePasajero,
                this.numAsiento,
                this.numVuelo,
                this.aerolinea,
                this.destino,
                this.curpPasajero);
    }
}