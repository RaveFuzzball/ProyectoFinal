/**
 * GUI - Menú principal.
 *
 * @author Ervey Guerrero Gómez
 * @author David Hernandéz López
 * @author Daniel Sánchez Vázquez 
 * @author Alejandro Tonatiuh García Espinoza 
 */

package GUI;
import Controllers.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MenuView extends JFrame {
    private JMenuItem boletoInternacionalMenuItem;
    private JMenuItem boletoNacionalMenuItem;
    private JMenu buscarBoletoMenu;
    private JMenu fileMenu;
    private JLabel fondoLabel;
    private JMenuItem imprimirBoletoMenuItem;
    private JMenuItem cancelarBoletoMenuItem;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem4;
    private JMenu registrarBoletoMenu;
    private JMenuItem salirMenuItem;

    public MenuView() {
        initComponents();
    }

    private void initComponents() {

        jMenuItem4 = new JMenuItem();
        fondoLabel = new JLabel();
        jMenuBar1 = new JMenuBar();
        fileMenu = new JMenu();
        salirMenuItem = new JMenuItem();
        buscarBoletoMenu = new JMenu();
        imprimirBoletoMenuItem = new JMenuItem();
        cancelarBoletoMenuItem = new JMenuItem();
        registrarBoletoMenu = new JMenu();
        boletoInternacionalMenuItem = new JMenuItem();
        boletoNacionalMenuItem = new JMenuItem();
        this.setResizable(false);
        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido Al Sistema");
        URL iconURL = getClass().getResource("images/iconavion.png");
        ImageIcon icon = new ImageIcon(iconURL);
        setIconImage(icon.getImage());

        fondoLabel.setIcon(new javax.swing.ImageIcon(this.getClass().getResource("images/RegistrationN3.png")));

        fileMenu.setText("File");

        salirMenuItem.setText("Salir");
        salirMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                salirMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(salirMenuItem);

        jMenuBar1.add(fileMenu);

        buscarBoletoMenu.setText("Buscar Boleto");

        imprimirBoletoMenuItem.setText("Imprimir Boleto");
        cancelarBoletoMenuItem.setText("Cancelar Boleto");
        imprimirBoletoMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirBoletoMenuItemActionPerformed(evt);
            }
        });

        cancelarBoletoMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBoletoMenuItemActionPerformed(evt);
            }
        });

        buscarBoletoMenu.add(imprimirBoletoMenuItem);
        buscarBoletoMenu.add(cancelarBoletoMenuItem);

        jMenuBar1.add(buscarBoletoMenu);

        registrarBoletoMenu.setText("Registrar Boleto");
        registrarBoletoMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registrarBoletoMenuActionPerformed(evt);
            }
        });

        boletoInternacionalMenuItem.setText("Internacional");
        boletoInternacionalMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boletoInternacionalMenuItemActionPerformed(evt);
            }
        });
        registrarBoletoMenu.add(boletoInternacionalMenuItem);

        boletoNacionalMenuItem.setText("Nacional");
        boletoNacionalMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boletoNacionalMenuItemActionPerformed(evt);
            }
        });
        registrarBoletoMenu.add(boletoNacionalMenuItem);

        jMenuBar1.add(registrarBoletoMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(fondoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(fondoLabel, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );


        pack();
    }

    private void salirMenuItemActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void boletoInternacionalMenuItemActionPerformed(ActionEvent evt) {
        BoletoInternacionalView vista = new BoletoInternacionalView();
        Controller controller = new Controller(vista);
    }

    private void boletoNacionalMenuItemActionPerformed(ActionEvent evt) {
        BoletoNacionalView vista = new BoletoNacionalView();
        Controller controller = new Controller(vista);
    }

    private void imprimirBoletoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        BuscarBoletoView vista = new BuscarBoletoView("Imprimir boleto");
        Controller controller = new Controller(vista);
    }

    private void cancelarBoletoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        BuscarBoletoView vista = new BuscarBoletoView("Cancelar Boleto");
        Controller controller = new Controller(vista);
    }

    private void registrarBoletoMenuActionPerformed(java.awt.event.ActionEvent evt) {
    }
}
