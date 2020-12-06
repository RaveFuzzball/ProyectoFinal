package Controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.MenuView;
import GUI.BoletoInternacionalView;
import GUI.BoletoNacionalView;
import GUI.BoletoView;
import GUI.MaletaView;

import Modelo.Boleto;
import Modelo.BoletoInternacional;
import Modelo.BoletoNacional;
import Modelo.Pasajero;
import Modelo.PasajeroTurista;
import Modelo.PasajeroEjecutivo;
import Modelo.PasajeroPrimeraClase;
import Modelo.EnumVisa;
import Modelo.EnumVuelo;
import Modelo.EnumClase;
import Modelo.Maleta;


public class Controller {

/*Funcionalidad maleta*/

    public class MaletaViewController {

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
  
  /*Fin cuncionaldiad maleta




}
