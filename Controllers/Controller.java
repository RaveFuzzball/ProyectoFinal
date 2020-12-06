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
    private RegistroEquipajeView reg;
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
              
                Pasajero pasajero;
                BoletoInternacional b1 = new BoletoInternacional(vistaInternacional.getNombrePasajero(), vistaInternacional.getEdadPasajero(), vistaInternacional.getGeneroPasajero(), vistaInternacional.getClasePasajero(), vistaInternacional.getNumAsiento(), vistaInternacional.getNumVuelo(), vistaInternacional.getAeroLinea(), vistaInternacional.getDestino(), vistaInternacional.getNumPasaporte(), vistaInternacional.getTipoVisa(), vistaInternacional.getVigencia());

                Controller.lista.insertarBoleto(b1);
                b1.guardar("Boletos");
                int opcion = JOptionPane.showConfirmDialog(null,"Desea Registrar Maleta");

                if(opcion == 0){
                    switch (b1.getClasePasajero()){
                        case TURISTA:
                            pasajero = new PasajeroTurista(b1);
                            reg = new RegistroEquipajeView(1);
                            break;
                        case EJECUTIVO:
                            pasajero = new PasajeroEjecutivo(b1);
                            reg = new RegistroEquipajeView(((PasajeroEjecutivo)pasajero).getMaletas().length);
                            break;
                        case PRIMERA_CLASE:
                            pasajero = new PasajeroPrimeraClase(b1);
                            reg = new RegistroEquipajeView(((PasajeroPrimeraClase)pasajero).getMaletas().length);
                    }
                }
            }catch (NumberFormatException a){
                JOptionPane.showMessageDialog(null,"Hay datos incorrectos, por favor cambielos");
                a.printStackTrace();
            }catch (Exception b){
                b.printStackTrace();
            }
        }else if(evt.equals(vistaInternacional.panelBotones.cancelarBoton)){
            vistaInternacional.dispose();
        }
    }
}
/*Controlador vista nacional*/
class NacionalController implements ActionListener{
    private BoletoNacionalView vistaNacional;
    private RegistroEquipajeView reg;
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

                Pasajero pasajero;
                BoletoNacional b1 = new BoletoNacional(vistaNacional.getNombrePasajero(), vistaNacional.getEdadPasajero(), vistaNacional.getGeneroPasajero(), vistaNacional.getClasePasajero(), vistaNacional.getNumAsiento(), vistaNacional.getNumVuelo(), vistaNacional.getAeroLinea(), vistaNacional.getDestino(),vistaNacional.getCurp());

                Controller.lista.insertarBoleto(b1);
                b1.guardar("Boletos");
                int opcion = JOptionPane.showConfirmDialog(null,"Desea Registrar Maleta");

                if(opcion == 0){
                    switch (b1.getClasePasajero()){
                        case TURISTA:
                            pasajero = new PasajeroTurista(b1);
                            reg = new RegistroEquipajeView(1);
                            break;
                        case EJECUTIVO:
                            pasajero = new PasajeroEjecutivo(b1);
                            reg = new RegistroEquipajeView(((PasajeroEjecutivo)pasajero).getMaletas().length);
                            break;
                        case PRIMERA_CLASE:
                            pasajero = new PasajeroPrimeraClase(b1);
                            reg = new RegistroEquipajeView(((PasajeroPrimeraClase)pasajero).getMaletas().length);
                    }
                }



            }catch (NumberFormatException a){
                JOptionPane.showMessageDialog(null,"Hay datos incorrectos, por favor cambielos");
            }catch (Exception b){
                b.printStackTrace();
            }
        }else if(evt.equals(vistaNacional.panelBotones1.cancelarBoton)){
            vistaNacional.dispose();
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
