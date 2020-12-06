package GUI;

/*
Ervey Guerrero Gómez
David Hernández López
Daniel Sánchez Vázquez
Alejandro Tonatiuh García Espinoza
*/

import Modelo.EnumVuelo;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class BuscarBoletoView extends JFrame {
    private JLabel folioLabel = new JLabel("Por Folio: ");
    private JLabel titulo1 = new JLabel("POR NOMBRE" +
            " Y TIPO DE VUELO");
    private JLabel nombreLabel = new JLabel("Nombre: ");
    private JLabel tipoVueloJLabel = new JLabel("Tipo de Vuelo: ");

    private JTextField folioTextField = new JTextField(20);
    private JTextField nombreTextField = new JTextField(20);
    JComboBox<String> tipoVueloComboBox = new
            JComboBox<String>(new String[]{"NACIONAL", "INTERNACIONAL"});

    public JButton enviarFolioBoton = new JButton("Enviar");
    public JButton enviarOpcion2Boton = new JButton("Enviar");

    public BuscarBoletoView(String titulo){
        this.setTitle(titulo);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#2299f0"));
        URL iconURL = getClass().getResource("images/iconavion.png");
        ImageIcon icon = new ImageIcon(iconURL);
        setIconImage(icon.getImage());

        JPanel contenedor = new JPanel(new GridBagLayout());
        contenedor.setBackground(Color.decode("#2299f0"));

        agregarComponente(contenedor,folioLabel,0,0);
        agregarComponente(contenedor,folioTextField,1,0);

        agregarComponente(contenedor,enviarFolioBoton,2,0);
        agregarComponente(contenedor,titulo1,0,1);

        agregarComponente(contenedor,nombreLabel,0,2);
        agregarComponente(contenedor,nombreTextField,1,2);

        agregarComponente(contenedor,tipoVueloJLabel,0,3);
        agregarComponente(contenedor, tipoVueloComboBox,1,3);

        agregarComponente(contenedor,enviarOpcion2Boton,1,4);

        getContentPane().add(contenedor,BorderLayout.NORTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        pack();
    }

    private void agregarComponente(JComponent padre, JComponent hijo, int x, int y) {
        GridBagConstraints contrains = new GridBagConstraints();
        contrains.insets = new Insets(10, 10, 10, 10);

        contrains.gridx = x;
        contrains.gridy = y;
        padre.add(hijo, contrains);
    }

    public int getFolio(){
        return Integer.parseInt(folioTextField.getText());
    }

    public String getNombre(){
        return nombreTextField.getText();
    }

    public EnumVuelo getTipoVuelo(){
        return EnumVuelo.valueOf((String)tipoVueloComboBox.getSelectedItem());
    }

    public JButton getEnviarFolioBoton() {
        return enviarFolioBoton;
    }

    public JButton getEnviarOpcion2Boton() {
        return enviarOpcion2Boton;
    }

}
