package com.fabo;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.fabo.aplication.InitialWindow;
import com.fabo.aplication.utils.ImagePanel;

public class Main {

    public static void initApp() {
        JFrame ventana = new JFrame();
        ventana.setSize(1280, 720);
        ventana.setTitle("Gestor de direcciones - MySQL");
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ImagePanel panel = ImagePanel.getInstance();
        panel.setImage("src/main/resources/images/fondo.webp");
        ventana.add(panel);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                int option = JOptionPane.showConfirmDialog(ventana, "¿Estás seguro de que quieres salir?",
                        "Confirmar salida", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.out.println("Cerrando programa");
                    System.exit(0);
                }
            }
        });
        ventana.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                ImagePanel.getInstance().setSize(ventana.getWidth(), ventana.getHeight());
            }
        });
        ventana.setVisible(true);
        new InitialWindow();
    }

    public static void main(String[] args) {
        initApp();
    }
}