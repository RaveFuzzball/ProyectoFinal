import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelBotones extends JPanel {
    JButton enviarBoton = new JButton("Enviar");
    JButton cancelarBoton = new JButton("Cancelar");

    public PanelBotones(){
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.decode("#2299f0"));
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(enviarBoton, constraints);
        constraints.gridy = 1;
        this.add(cancelarBoton, constraints);
        this.setBackground(Color.decode("#2299f0"));
    }

    public void addEnviarBoton(ActionListener listenForEnviarBoton) {
        enviarBoton.addActionListener(listenForEnviarBoton);
    }

    public void addCancelarBoton(ActionListener cancelarBotonListener) {
        this.cancelarBoton.addActionListener(cancelarBotonListener);
    }

    public void mostrarError(String mensajeError) {
        JOptionPane.showMessageDialog(this, mensajeError);
    }

    public JButton getEnviarBoton() {
        return enviarBoton;
    }

    public JButton getCancelarBoton() {
        return cancelarBoton;
    }

}
