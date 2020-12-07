/**
 * Controladores para la vista.
 *
 * @author Ervey Guerrero Gómez
 * @author David Hernandéz López
 * @author Daniel Sánchez Vázquez 
 * @author Alejandro Tonatiuh García Espinoza 
 */

package Controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.*;
import Modelo.*;

public class Controller{
    public static ListaLigada lista = new ListaLigada();
    public Controller(BoletoInternacionalView vista){
        InternacionalController c1 = new InternacionalController(vista);
    }
    public Controller(BoletoNacionalView vista){
        NacionalController c2 = new NacionalController(vista);
    }
    public Controller(BuscarBoletoView vista){
        if(vista.getTitle().equals("Cancelar Boleto")){
            CancelarController c3 = new CancelarController(vista);
        }else {
            ImprimirController c4 = new ImprimirController(vista);
        }
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
                RegistroController registro;
                Pasajero pasajero;
                BoletoInternacional b1 = new BoletoInternacional(vistaInternacional.getNombrePasajero(), vistaInternacional.getEdadPasajero(), vistaInternacional.getGeneroPasajero(), vistaInternacional.getClasePasajero(), vistaInternacional.getNumAsiento(), vistaInternacional.getNumVuelo(), vistaInternacional.getAeroLinea(), vistaInternacional.getDestino(), vistaInternacional.getNumPasaporte(), vistaInternacional.getTipoVisa(), vistaInternacional.getVigencia());
                if(JOptionPane.showConfirmDialog(null,"¿Son correctos los datos?") == 0) {
                    Controller.lista.insertarBoleto(b1);
                    b1.guardar("Boletos");
                    int opcion = JOptionPane.showConfirmDialog(null, "Desea Registrar Maleta");

                    if (opcion == 0) {
                        switch (b1.getClasePasajero()) {
                            case TURISTA:
                                pasajero = new PasajeroTurista(b1);
                                reg = new RegistroEquipajeView(1);
                                registro = new RegistroController(reg, pasajero);
                                break;
                            case EJECUTIVO:
                                pasajero = new PasajeroEjecutivo(b1);
                                reg = new RegistroEquipajeView(((PasajeroEjecutivo) pasajero).getMaletas().length);
                                registro = new RegistroController(reg, pasajero);
                                break;
                            case PRIMERA_CLASE:
                                pasajero = new PasajeroPrimeraClase(b1);
                                reg = new RegistroEquipajeView(((PasajeroPrimeraClase) pasajero).getMaletas().length);
                                registro = new RegistroController(reg, pasajero);
                        }
                    }
                    vistaInternacional.dispose();
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
                RegistroController registro;
                if(JOptionPane.showConfirmDialog(null,"¿Son correctos los datos?") == 0) {
                    Controller.lista.insertarBoleto(b1);
                    b1.guardar("Boletos");
                    int opcion = JOptionPane.showConfirmDialog(null, "Desea Registrar Maleta");

                    if (opcion == 0) {
                        switch (b1.getClasePasajero()) {
                            case TURISTA:
                                pasajero = new PasajeroTurista(b1);
                                reg = new RegistroEquipajeView(1);
                                registro = new RegistroController(reg, pasajero);
                                break;
                            case EJECUTIVO:
                                pasajero = new PasajeroEjecutivo(b1);
                                reg = new RegistroEquipajeView(((PasajeroEjecutivo) pasajero).getMaletas().length);
                                registro = new RegistroController(reg, pasajero);
                                break;
                            case PRIMERA_CLASE:
                                pasajero = new PasajeroPrimeraClase(b1);
                                reg = new RegistroEquipajeView(((PasajeroPrimeraClase) pasajero).getMaletas().length);
                                registro = new RegistroController(reg, pasajero);
                        }
                    }
                    vistaNacional.dispose();
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

class CancelarController implements ActionListener{
    private BuscarBoletoView vista;
    public CancelarController(BuscarBoletoView vista){
        this.vista = vista;
        eventos();
    }

    public void eventos(){
        vista.enviarFolioBoton.addActionListener(this);
        vista.enviarOpcion2Boton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        if(evt.equals(vista.enviarFolioBoton)){
            try {
                Boleto b1 = Controller.lista.buscarBoletoPorFolio(vista.getFolio());
                b1.eliminar("Boletos/");
                Controller.lista.eliminarBoletoPorFolio(vista.getFolio());
                vista.dispose();
            }catch (Exception a){
                JOptionPane.showMessageDialog(null,"NO se encontro archivo");
            }
        }else if(evt.equals(vista.enviarOpcion2Boton)){
            try {
                Boleto b1 = Controller.lista.buscarBoletoPorNombre(vista.getNombre());
                b1.eliminar("Boletos/");
                Controller.lista.eliminarBoletoPorNombre(vista.getNombre());
                vista.dispose();
            }catch (Exception a){
                a.printStackTrace();
                JOptionPane.showMessageDialog(null,"NO se encontro archivo");
            }
        }
    }
}
class ImprimirController implements ActionListener{

    private BuscarBoletoView vista;

    public ImprimirController(BuscarBoletoView vista){
        this.vista = vista;
        eventos();
    }
    public void eventos(){
        vista.enviarOpcion2Boton.addActionListener(this);
        vista.enviarFolioBoton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        if(evt.equals(vista.enviarFolioBoton)){
            try {
                Boleto b1 = Controller.lista.buscarBoletoPorFolio(vista.getFolio());
                JOptionPane.showMessageDialog(null,b1.mostrar());
                vista.dispose();
            }catch (Exception a){
                JOptionPane.showMessageDialog(null,"NO se encontro archivo");
            }
        }else if(evt.equals(vista.enviarOpcion2Boton)){
            try {
                Boleto b1 = Controller.lista.buscarBoletoPorNombre(vista.getNombre());
                JOptionPane.showMessageDialog(null,b1.mostrar());
            }catch (Exception a){
                JOptionPane.showMessageDialog(null,"NO se encontro archivo");
            }
        }
    }
}

class RegistroController implements ActionListener{
    RegistroEquipajeView vista;
    Pasajero pasajero;
    Maleta[] maletas;
    public RegistroController(RegistroEquipajeView vista,Pasajero pasajero){
        this.vista = vista;
        this.pasajero = pasajero;
        maletas = new Maleta[3];
        eventos();
    }
    public void eventos(){
        vista.botonEnviar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        int i;
        if(evt.equals(vista.botonEnviar)){
            try {
                double Peso[] = vista.getPesoMaleta();
                for (i = 0; i < Peso.length; i++) {
                    System.out.println(Peso[i]);
                    maletas[i] = new Maleta(Peso[i]);
                    pasajero.documentarMaleta(maletas[i]);

                    JOptionPane.showMessageDialog(null, "Su maleta tiene un conto por exceso de: " + maletas[i].obtenerTotal());
                }
            }catch (NumberFormatException a){
                JOptionPane.showMessageDialog(null,"Error, en los datos");
            }catch (Exception b){
                JOptionPane.showMessageDialog(null,b.getMessage());
            }
            vista.mainFrame.dispose();
        }
    }
}

