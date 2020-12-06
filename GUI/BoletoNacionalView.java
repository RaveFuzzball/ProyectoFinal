package GUI;
import javax.swing.*;
import java.awt.*;

public class BoletoNacionalView extends BoletoView{
    private JLabel curpLabel = new JLabel("Ingrese su Curp:      ");
    private JTextField curpTextField = new JTextField(20);
    public PanelBotones panelBotones1;
    public BoletoNacionalView(){
        JPanel contenedor = new JPanel(new GridBagLayout());
        contenedor.setBackground(Color.decode("#2299f0"));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        agregarComponente(contenedor,curpLabel,0,0);
        agregarComponente(contenedor,curpTextField,1,0);

        JPanel panelSouth = new JPanel(new GridLayout(1,2));
        panelBotones1 = new PanelBotones();

        panelSouth.add(contenedor);
        panelSouth.add(panelBotones1);


        getContentPane().add(panelSouth,BorderLayout.SOUTH);

        setTitle("Registro de Boleto Nacional");
        pack();
    }

    public String getCurp(){
        return curpTextField.getText();
    }

}
