package Modelo;

public class PasajeroPrimeraClase extends Pasajero {
    private final Maleta[] maletas;
    private int numMaletasDocumentadas = 0;

    /**
     * Constructor de la clase.
     *
     * @param boleto	el boleto asociado al pasajero.
     */
    public PasajeroPrimeraClase(Boleto boleto) {
        super(boleto);
        this.maletas = new Maleta[3];
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
        try {
            this.maletas[this.numMaletasDocumentadas] = maleta;
            this.numMaletasDocumentadas++;
        } catch (IndexOutOfBoundsException e) {
            throw new Exception("Número de maletas excedido.");
        }
    }

    /**
     * Obtiene las maleta asociadas al pasajero.
     *
     * @return las maletas asociadas al pasajero.
     * @see Maleta
     */
    public Maleta[] getMaletas() {
        return this.maletas;
    }
}