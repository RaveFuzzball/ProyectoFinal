package Modelo;

public class Maleta {
    private final double peso;

    /**
     * Constructor de la clase.
     *
     * @param peso de la maleta.
     */
    public Maleta(double peso) {
        this.peso = peso;
    }

    /**
     * Calcula el exceso de peso (si hay) de la maleta.
     *
     * @return el exceso de peso.
     */
    private double calcularExceso() {
        if (this.peso > 23)
            return this.peso - 23;
        return 0;
    }

    /**
     * Calcula el total a pagar dependiendo del exceso de peso.
     *
     * @return el total a pagar por el exceso de peso.
     */
    public double obtenerTotal() {
        double exceso = this.calcularExceso();
        if (exceso <= 10) return exceso * 300;
        return exceso * 500;
    }
}
