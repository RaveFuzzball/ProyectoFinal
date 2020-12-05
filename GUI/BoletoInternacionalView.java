package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BoletoInternacionalView extends BoletoView {
    private JLabel numPasaporteLabel = new JLabel("Número de Pasaporte: ");
    private JLabel tipoVisaLabel = new JLabel("Tipo de Visa: ");
    private JLabel vigenciaLabel = new JLabel("Vigencia: ");

    private JTextField numPasaporteTextField = new JTextField(20);
    private JComboBox<String> tipoVisaComboBox =
            new JComboBox<String>(new String[]{"TURISTA","TRABAJO","ATENCION_MEDICA"});
    private JTextField vigenciaTextField = new JTextField(20);

    public BoletoInternacionalView(){
        JPanel contenedor = new JPanel(new GridBagLayout());
        contenedor.setBackground(Color.decode("#2299f0"));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        agregarComponente(contenedor,numPasaporteLabel,0,0);
        agregarComponente(contenedor,numPasaporteTextField,1,0);

        agregarComponente(contenedor,vigenciaLabel,0,1);
        agregarComponente(contenedor,vigenciaTextField,1,1);

        agregarComponente(contenedor,tipoVisaLabel,0,2);
        agregarComponente(contenedor,tipoVisaComboBox,1,2);

        JPanel panelSouth = new JPanel(new GridLayout(1,2));
        PanelBotones panelBotones = new PanelBotones();

        panelSouth.add(contenedor);
        panelSouth.add(panelBotones);
        //JLabel backgroundLabel = new JLabel(new ImageIcon(
          //      this.getClass().getResource("images\\RegistrationN1_Parejo_Fondo.png")));

        getContentPane().add(panelSouth,BorderLayout.SOUTH);
        //getContentPane().add(backgroundLabel, BorderLayout.WEST);
        setTitle("Registro de Boleto Internacional");
        pack();
    }

    public int getNumPasaporte(){
        return Integer.parseInt(numPasaporteTextField.getText());
    }

    //MODIFICAR PARA ENUMVISA
    public String getTipoVisa(){
        return (String)tipoVisaComboBox.getSelectedItem();
    }

    public int getVigencia(){
        return Integer.parseInt(vigenciaTextField.getText());
    }

}
