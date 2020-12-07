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
    private double calcularExceso ()throws Exception {
            if (this.peso > 23 && this.peso <= 43)
                return this.peso - 23;
            else if (this.peso > 43)
                throw new Exception("¡Asegurese que ninguna de sus maletas pese mas de 43kg!");
        return 0;
    }

    /**
     * Calcula el total a pagar dependiendo del exceso de peso.
     *
     * @return el total a pagar por el exceso de peso.
     */
    public double obtenerTotal() throws Exception {
        double exceso = this.calcularExceso();
        if (exceso <= 10)
            return exceso * 300;
        return exceso * 500;
    }
}
