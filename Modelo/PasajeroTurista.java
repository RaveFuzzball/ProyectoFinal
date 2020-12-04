package Modelo;

public class PasajeroTurista extends Pasajero {
    private Maleta maleta;

    /**
     * Constructor de la clase.
     *
     * @param boleto	el boleto asociado al pasajero.*/
    public PasajeroTurista(Boleto boleto) {
        super(boleto);
    }

    /**
     * Asocia una nueva maleta al pasajero.
     *
     * @param maleta	la maleta a asociar con el pasajero.
     * @throws Exception	si el pasajero ya cuenta con el máximo número de
     * maletas asociadas.
     */
    @Override
    public void documentarMaleta(Maleta maleta) throws Exception {
        if (this.maleta != null) throw new Exception("Número de maletas excedido.");
        this.maleta = maleta;
    }

    /**
     * Obtiene la maleta asociada con el pasajero.
     *
     * @return la maleta asociada al pasajero.
     * @see Maleta
     */
    public Maleta getMaleta() {
        return this.maleta;
    }
}