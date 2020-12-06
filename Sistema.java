/*
Ervey Guerrero Gómez
David Hernández López
Daniel Sánchez Vázquez
Alejandro Tonatiuh García Espinoza
*/
import Controllers.Controller;
import GUI.MenuView;
import Modelo.ListaLigada;

public class Sistema {
    public static void main(String[] args) {
        Controller.lista.insertarBoletosPorCarpeta("Boletos");
        MenuView menu = new MenuView();
        menu.setVisible(true);
    }
}
