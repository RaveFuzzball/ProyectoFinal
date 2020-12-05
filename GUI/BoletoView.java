package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class BoletoView extends JFrame {
    protected JLabel nombreLabel = new JLabel("Nombre: ");
    protected JLabel edadLabel = new JLabel("Edad: ");
    protected JLabel generoLabel = new JLabel("Genero: ");
    protected JLabel claseLabel = new JLabel("Clase: ");
    protected JLabel numAsientoLabel = new JLabel("Numero de Asiento: ");
    protected JLabel numVueloLabel = new JLabel("Numero de Vuelo: ");
    protected JLabel aerolineaLabel = new JLabel("Aerolinea: ");
    protected JLabel destinoLabel = new JLabel("Destino: ");

    protected JTextField nombreTextField = new JTextField(20);
    protected JTextField edadTextField = new JTextField(20);
    protected JTextField generoTextField = new JTextField(20);
    protected JComboBox<String> claseComboBox = new JComboBox<String>
            (new String[]{"TURISTA","EJECUTIVO","PRIMERA_CLASE"});
    protected JTextField numAsientoTextField = new JTextField(20);
    protected JTextField numVueloTextField = new JTextField(20);
    protected JTextField aerolineaTextField = new JTextField(20);
    protected JTextField destinoTextField = new JTextField(20);



    public BoletoView(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode("#2299f0"));

        JPanel contenedor = new JPanel(new GridBagLayout());
        contenedor.setBackground(Color.decode("#2299f0"));

        agregarComponente(contenedor,nombreLabel,0,0);
        agregarComponente(contenedor,nombreTextField,1,0);

        agregarComponente(contenedor,edadLabel,0,1);
        agregarComponente(contenedor,edadTextField,1,1);

        agregarComponente(contenedor,generoLabel,0,2);
        agregarComponente(contenedor,generoTextField,1,2);

        agregarComponente(contenedor,claseLabel,0,3);
        agregarComponente(contenedor,claseComboBox,1,3);

        agregarComponente(contenedor,numAsientoLabel,0,4);
        agregarComponente(contenedor,numAsientoTextField,1,4);

        agregarComponente(contenedor,numVueloLabel,2,0);
        agregarComponente(contenedor,numVueloTextField,3,0);

        agregarComponente(contenedor,aerolineaLabel,2,1);
        agregarComponente(contenedor,aerolineaTextField,3,1);

        agregarComponente(contenedor,destinoLabel,2,2);
        agregarComponente(contenedor,destinoTextField,3,2);

        getContentPane().add(contenedor,BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        pack();
    }

    protected void agregarComponente(JComponent padre, JComponent hijo, int x, int y) {
        GridBagConstraints contrains = new GridBagConstraints();
        contrains.insets = new Insets(10, 10, 10, 10);

        contrains.gridx = x;
        contrains.gridy = y;
        padre.add(hijo, contrains);
    }

    public String getNombrePasajero(){
        return nombreTextField.getText();
    }

    public int getEdadPasajero(){
        return Integer.parseInt(edadTextField.getText());
    }

    public String getGeneroPasajero(){
        return generoTextField.getText();
    }

    //MODIFICAR A ENUMCLASE EN VEZ DE STRING
    public String getClasePasajero(){
        return (String)claseComboBox.getSelectedItem();
    }

    public int getNumAsiento(){
        return Integer.parseInt(numAsientoTextField.getText());
    }

    public int getNumVuelo(){
        return Integer.parseInt(numVueloLabel.getText());
    }

    public String getAeroLinea(){
        return aerolineaTextField.getText();
    }

    public String getDestino(){
        return destinoTextField.getText();
    }

}
