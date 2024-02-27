package com.fabo.aplication.crudwindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import com.fabo.aplication.utils.Constants;
import com.fabo.aplication.utils.CustomButton;
import com.fabo.aplication.utils.CustomFormat;
import com.fabo.aplication.utils.ImagePanel;

public class CrudPdfWindow {
  private ImagePanel imagePanel;

  public CrudPdfWindow() {
    imagePanel = ImagePanel.getInstance();
    imagePanel.setLayout(null);
    initContent();
    imagePanel.repaint();
    imagePanel.revalidate();
  }

  private void initContent() {
    initLabels();
    initButtonAgregar();
    initButtonModificar();
    initButtonBack();
  }

  private void initLabels() {
    JLabel Text = new JLabel("CRUD DE IMAGENES");
    Text.setHorizontalAlignment(JLabel.CENTER);
    Text.setBounds((int) (Constants.WIDTH * 0.05), (int) (Constants.HEIGHT * 0.09), (int) (Constants.WIDTH * 0.9),
        (int) (Constants.HEIGHT * 0.1));
    CustomFormat.formato(Text, 0, (int) (Constants.WIDTH * 0.0375));
    imagePanel.add(Text);

    JLabel Text2 = new JLabel("Seleccione una opción:");
    Text2.setHorizontalAlignment(JLabel.CENTER);
    Text2.setBounds((int) (Constants.WIDTH * 0.175), (int) (Constants.HEIGHT * 0.23), (int) (Constants.WIDTH * 0.65),
        (int) (Constants.HEIGHT * 0.1));
    CustomFormat.formato(Text2, 0, (int) (Constants.WIDTH * 0.02625));
    imagePanel.add(Text2);
  }

  private void initButtonAgregar() {
    CustomButton buttonAgregar = new CustomButton();
    buttonAgregar.setBounds((Constants.WIDTH * 11 / 17) / 2, (int) (Constants.HEIGHT * 0.37),
        (int) (Constants.WIDTH * 6 / 17), (int) (Constants.HEIGHT * 7 / 72));
    CustomFormat.formato(buttonAgregar, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    buttonAgregar.setText("AGREGAR");
    buttonAgregar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
      }
    });
    imagePanel.add(buttonAgregar);
  }

  private void initButtonModificar() {
    CustomButton buttonModificar = new CustomButton();
    buttonModificar.setBounds((Constants.WIDTH * 11 / 17) / 2, (int) (Constants.HEIGHT * 0.49),
        (int) (Constants.WIDTH * 6 / 17), (int) (Constants.HEIGHT * 7 / 72));
    CustomFormat.formato(buttonModificar, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    buttonModificar.setText("MODIFICAR");
    buttonModificar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {

      }
    });
    imagePanel.add(buttonModificar);
  }

  private void initButtonBack() {
    CustomButton buttonBack = new CustomButton();
    buttonBack.setBounds((Constants.WIDTH * 11 / 17) / 2, (int) (Constants.HEIGHT * 0.61),
        (int) (Constants.WIDTH * 6 / 17), (int) (Constants.HEIGHT * 7 / 72));
    CustomFormat.formato(buttonBack, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    buttonBack.setText("VOLVER");
    buttonBack.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {

      }
    });
    imagePanel.add(buttonBack);
  }
}