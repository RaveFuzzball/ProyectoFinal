import javax.swing.*;
import java.awt.*;

/*
Ervey Guerrero Gómez
David Hernández López
Daniel Sánchez Vázquez
Alejandro Tonatiuh García Espinoza
*/


public class MaletaView extends JPanel {
    private JLabel pesoMaletaLabel = new JLabel("Ingrese Peso");
    private JTextField pesoMaletaTextField = new JTextField(20);

    private double pesoMaletaEntrada = 0;

    public double getPesoMaletaEntrada() {
        return pesoMaletaEntrada = Integer.parseInt(pesoMaletaTextField.getText());
    }

    public MaletaView() {
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.decode("#2299f0"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(pesoMaletaLabel, constraints);

        constraints.gridx = 1;
        this.add(pesoMaletaTextField, constraints);

        this.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Registrar Maleta"));
    }

}
