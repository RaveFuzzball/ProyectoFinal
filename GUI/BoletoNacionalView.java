import javax.swing.*;
import java.awt.*;

public class BoletoNacionalView extends BoletoView{
    private JLabel curpLabel = new JLabel("Ingrese su Curp:      ");
    private JTextField curpTextField = new JTextField(20);

    public BoletoNacionalView(){
        JPanel contenedor = new JPanel(new GridBagLayout());
        contenedor.setBackground(Color.decode("#2299f0"));

        agregarComponente(contenedor,curpLabel,0,0);
        agregarComponente(contenedor,curpTextField,1,0);

        JPanel panelSouth = new JPanel(new GridLayout(1,2));
        PanelBotones panelBotones = new PanelBotones();

        panelSouth.add(contenedor);
        panelSouth.add(panelBotones);
        //JLabel backgroundLabel = new JLabel(new ImageIcon(
        //      this.getClass().getResource("images\\RegistrationN1_Parejo_Fondo.png")));

        getContentPane().add(panelSouth,BorderLayout.SOUTH);
        //getContentPane().add(backgroundLabel, BorderLayout.WEST);
        setTitle("Registro de Boleto Nacional");
        pack();
    }

    public String getCurp(){
        return curpTextField.getText();
    }

}
