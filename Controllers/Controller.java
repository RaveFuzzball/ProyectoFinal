package Controllers;


import Modelo.*;
import GUI.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller{
    public static ListaLigada lista = new ListaLigada();
    public Controller(BoletoInternacionalView vista){
        InternacionalController c1 = new InternacionalController(vista);
    }
    public Controller(BoletoNacionalView vista){
        NacionalController c2 = new NacionalController(vista);
    }
}
/*Controlador de la vista internacional*/
class InternacionalController implements ActionListener{
    private BoletoInternacionalView vistaInternacional;

    public InternacionalController(BoletoInternacionalView vista){
        this.vistaInternacional = vista;
        eventos();
    }
    public void eventos(){ ;
        vistaInternacional.panelBotones.enviarBoton.addActionListener(this);
        vistaInternacional.panelBotones.cancelarBoton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        if(evt.equals(vistaInternacional.panelBotones.enviarBoton)){
            try {
                BoletoInternacional b1 = new BoletoInternacional(vistaInternacional.getNombrePasajero(), vistaInternacional.getEdadPasajero(), vistaInternacional.getGeneroPasajero(), EnumClase.valueOf(vistaInternacional.getClasePasajero()), vistaInternacional.getNumAsiento(), vistaInternacional.getNumVuelo(), vistaInternacional.getAeroLinea(), vistaInternacional.getDestino(), vistaInternacional.getNumPasaporte(), EnumVisa.valueOf(vistaInternacional.getTipoVisa()), vistaInternacional.getVigencia());
                Controller.lista.insertarBoleto(b1);
                b1.guardar("Boletos");
                JOptionPane.showMessageDialog(null,b1.mostrar());
            }catch (NumberFormatException a){
                JOptionPane.showMessageDialog(null,"Hay datos incorrectos, por favor cambielos");
                a.printStackTrace();
            }catch (Exception b){
                b.printStackTrace();
            }
        }else if(evt.equals(vistaInternacional.panelBotones.cancelarBoton)){
            System.exit(1);
        }
    }
}
/*Controlador vista nacional*/
class NacionalController implements ActionListener{
    private BoletoNacionalView vistaNacional;

    public NacionalController(BoletoNacionalView vista){
        this.vistaNacional = vista;
        eventos();
    }
    public void eventos(){ ;
        vistaNacional.panelBotones1.enviarBoton.addActionListener(this);
        vistaNacional.panelBotones1.cancelarBoton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        if(evt.equals(vistaNacional.panelBotones1.enviarBoton)){
            try {
                BoletoNacional b1 = new BoletoNacional(vistaNacional.getNombrePasajero(), vistaNacional.getEdadPasajero(), vistaNacional.getGeneroPasajero(), EnumClase.valueOf(vistaNacional.getClasePasajero()), vistaNacional.getNumAsiento(), vistaNacional.getNumVuelo(), vistaNacional.getAeroLinea(), vistaNacional.getDestino(),vistaNacional.getCurp());
                Controller.lista.insertarBoleto(b1);
                b1.guardar("Boletos");
                JOptionPane.showMessageDialog(null,b1.mostrar());
            }catch (NumberFormatException a){
                JOptionPane.showMessageDialog(null,"Hay datos incorrectos, por favor cambielos");
                a.printStackTrace();
            }catch (Exception b){
                b.printStackTrace();
            }
        }else if(evt.equals(vistaNacional.panelBotones1.cancelarBoton)){
            System.exit(1);
        }
    }
}
/*Funcionalidad maleta*/

class MaletaViewController {

    private MaletaView vista;

    public Maleta creaMaleta(double peso) {

        return new Maleta(peso);
    }

    public Maleta creaMaleta() {

        return new Maleta(this.vista.getPesoMaletaEntrada());
    }

    public void mostrarVista() throws Exception {

        this.vista = new MaletaView();

    }

}

//Fin cuncionaldiad maleta
