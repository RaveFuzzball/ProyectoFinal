package Modelo;

import java.io.*;

public abstract class Boleto {

    protected String nombrePasajero;
    protected int edadPasajero;
    protected String generoPasajero;
    protected EnumClase clasePasajero;
    protected int numAsiento;
    protected int numVuelo;
    protected String aerolinea;
    protected String destino;
    protected EnumVuelo tipoVuelo;


    public Boleto(String nombrePasajero, int edadPasajero, String generoPasajero, EnumClase clasePasajero,
                  int numAsiento, int numVuelo, String aerolinea, String destino) {
        this.nombrePasajero = nombrePasajero;
        this.edadPasajero = edadPasajero;
        this.generoPasajero = generoPasajero;
        this.clasePasajero = clasePasajero;
        this.numAsiento = numAsiento;
        this.numVuelo = numVuelo;
        this.aerolinea = aerolinea;
        this.destino = destino;
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

}

interface BoletoDao {
    void guardarBoleto(Boleto boleto);
    Boleto cargarBoleto(String nombrePasajero, EnumVuelo tipoVuelo);
}


class BoletoDaoImp implements BoletoDao {
    @Override
    public Boleto cargarBoleto(String nombrePasajero, EnumVuelo tipoVuelo) {
        int edadPasajero;
        String generoPasajero;
        EnumClase clasePasajero;
        int numAsiento;
        int numVuelo;
        String aerolinea;
        String destino;

        String vuelo = tipoVuelo.toString().toLowerCase();
        nombrePasajero = nombrePasajero.replaceAll(" ", "");
        String fichero = vuelo + '_' + nombrePasajero + ".vuelo";
        try {
            DataInputStream entrada = new DataInputStream(new BufferedInputStream(new FileInputStream(fichero)));
            nombrePasajero = entrada.readUTF();
            edadPasajero = entrada.readInt();
            generoPasajero = entrada.readUTF();
            clasePasajero = EnumClase.valueOf(entrada.readUTF());
            numAsiento = entrada.readInt();
            numVuelo = entrada.readInt();
            aerolinea = entrada.readUTF();
            destino = entrada.readUTF();

            switch (tipoVuelo) {
                case INTERNACIONAL:
                    int numPasaporte = entrada.readInt();
                    EnumVisa tipoVisa = EnumVisa.valueOf(entrada.readUTF());
                    int añosVigenciaVisa = entrada.readInt();

                    return new BoletoInternacional(nombrePasajero,
                            edadPasajero,
                            generoPasajero,
                            clasePasajero,
                            numAsiento,
                            numVuelo,
                            aerolinea,
                            destino,
                            numPasaporte,
                            tipoVisa,
                            añosVigenciaVisa);
                case NACIONAL:
                    String curp = entrada.readUTF();

                    return new BoletoNacional(nombrePasajero,
                            edadPasajero,
                            generoPasajero,
                            clasePasajero,
                            numAsiento,
                            numVuelo,
                            aerolinea,
                            destino,
                            curp);
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }
    @Override
    public void guardarBoleto(Boleto boleto) {
        String tipoVuelo = boleto.getTipoVuelo().toString().toLowerCase();
        String nombrePasajero = boleto.getNombrePasajero().replaceAll(" ", "");
        String fichero = tipoVuelo + '_' + nombrePasajero + ".vuelo";
        try {
            DataOutputStream salida = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)));

            salida.writeUTF(boleto.getNombrePasajero());
            salida.writeInt(boleto.getEdadPasajero());
            salida.writeUTF(boleto.getGeneroPasajero());
            salida.writeUTF(boleto.getClasePasajero().toString());
            salida.writeInt(boleto.getNumAsiento());
            salida.writeInt(boleto.getNumVuelo());
            salida.writeUTF(boleto.getAerolinea());
            salida.writeUTF(boleto.getDestino());

            switch (boleto.getTipoVuelo()) {
                case INTERNACIONAL:
                    salida.writeInt(((BoletoInternacional)boleto).getNumPasaporte());
                    salida.writeUTF(((BoletoInternacional)boleto).getTipoVisa().toString());
                    salida.writeInt(((BoletoInternacional)boleto).getAñosVigenciaVisa());
                    break;
                case NACIONAL:
                    salida.writeUTF(((BoletoNacional)boleto).getCurpPasajero());
                    break;

            }
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
