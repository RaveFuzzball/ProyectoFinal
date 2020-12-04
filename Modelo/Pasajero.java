package Modelo;

public abstract class Pasajero {
    protected Boleto boleto;

    /**
     * Constructor de la clase.
     *
     * @param boleto	el boleto asociado al pasajero.
     */
    public Pasajero(Boleto boleto) {
        this.boleto = boleto;
    }

    /**
     * Asocia una nueva maleta al pasajero.
     *
     * @param maleta	la maleta a asociar con el pasajero.
     * @throws Exception	 si el pasajero ya cuenta con el máximo número de
     * maletas asociadas.
     */
    public abstract void documentarMaleta(Maleta maleta) throws Exception;

    /**
     * Retorna el boleto asociado con el pasajero.
     *
     * @return boleto	el boleto asociado con el pasajero.
     */
    public Boleto getBoleto() {
        return this.boleto;
    }
}