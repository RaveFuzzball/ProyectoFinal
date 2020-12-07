/*
Ervey Guerrero Gómez
David Hernández López
Daniel Sánchez Vázquez
Alejandro Tonatiuh García Espinoza
*/
import Controllers.Controller;
import GUI.MenuView;

import java.io.File;

public class Sistema {
    public static void main(String[] args) {
        File boletosDir = new File("Boletos/");
        if (!boletosDir.exists()) {
          boletosDir.mkdir();
        }
        Controller.lista.insertarBoletosPorCarpeta(boletosDir.getPath());
        MenuView menu = new MenuView();
        menu.setVisible(true);
    }
}
