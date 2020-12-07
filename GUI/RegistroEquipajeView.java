package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/*
Ervey Guerrero Gómez
David Hernández López
Daniel Sánchez Vázquez
Alejandro Tonatiuh García Espinoza
*/


public class RegistroEquipajeView {
    public JFrame mainFrame;
    private JPanel panelNorthEast;
    private JPanel panelSouthEast;
    private JPanel panelEast;
    private JLabel backgroundLabel;
    public JButton botonEnviar = new JButton("Enviar");
    public JButton botonAgregarMaleta = new JButton("Agregar Maleta");
    private MaletaView[] maletaViews;
    private int maletaCount = 0;

    private double[] pesoMaleta;

    public RegistroEquipajeView(int maletas) {
        maletaViews = new MaletaView[maletas];
        pesoMaleta = new double[maletas];
        mainFrame = new JFrame();

        URL iconURL = getClass().getResource("images/iconavion.png");
        ImageIcon icon = new ImageIcon(iconURL);
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setTitle("Registro de Equipaje");

        panelNorthEast = new JPanel(new GridLayout(3, 1));
        panelNorthEast.setBackground(Color.decode("#2299f0"));
        panelNorthEast.add(maletaViews[maletaCount] = new MaletaView());

        panelSouthEast = new JPanel(new GridBagLayout());
        panelSouthEast.setBackground(Color.decode("#2299f0"));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        panelSouthEast.add(botonAgregarMaleta, constraints);
        constraints.gridy = 1;
        panelSouthEast.add(botonEnviar, constraints);

        botonAgregarMaleta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                botonAgregarMaletaActionPerformed(evt);
            }
        });

        if (maletas == 1) {
            botonAgregarMaleta.setEnabled(false);
        }

        panelEast = new JPanel(new GridLayout(2, 1));
        panelEast.add(panelNorthEast);
        panelEast.add(panelSouthEast);

        backgroundLabel = new JLabel(new ImageIcon(this.getClass().getResource("images/RegistroEquipajeViewFondoPanel.png")));

        mainFrame.getContentPane().add(panelEast, BorderLayout.EAST);
        mainFrame.getContentPane().add(backgroundLabel, BorderLayout.WEST);
        mainFrame.getContentPane().setBackground(Color.decode("#2299f0"));
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.pack();
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public MaletaView[] getMaletaViews() {
        return maletaViews;
    }

    //genera excepción
    private void setMaletas() {
        for (int i = 0; i < maletaCount; i++) {
            pesoMaleta[i] = maletaViews[i].getPesoMaletaEntrada();
        }
    }

    //genera IndexOutOfBoundsException
    public double[] getPesoMaleta() {
        setMaletas();
        return pesoMaleta;
    }

    public void botonAgregarMaletaActionPerformed(ActionEvent event) {
        try {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.insets = new Insets(10, 10, 10, 10);
            constraints.gridx = 0;
            constraints.gridy = maletaCount;

            if (maletaCount + 2 == maletaViews.length) {
                RegistroEquipajeView.this.botonAgregarMaleta.setEnabled(false);
            }

            panelNorthEast.add(maletaViews[++maletaCount] = new MaletaView(), constraints);
            panelNorthEast.revalidate();
            panelNorthEast.repaint();
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Numero de maletas excedido!");
        }
    }


    public void mostrarError(String mensajeError) {
        JOptionPane.showMessageDialog(mainFrame, mensajeError);
    }

}