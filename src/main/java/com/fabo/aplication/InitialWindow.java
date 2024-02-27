package com.fabo.aplication;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import com.fabo.aplication.crudwindow.CrudImageWindow;
import com.fabo.aplication.crudwindow.CrudPdfWindow;
import com.fabo.aplication.crudwindow.CrudVideoWindow;
import com.fabo.aplication.tableWindow.TableAuditoryWindow;
import com.fabo.aplication.utils.Constants;
import com.fabo.aplication.utils.CustomButton;
import com.fabo.aplication.utils.CustomFormat;
import com.fabo.aplication.utils.ImagePanel;

public class InitialWindow {
  private ImagePanel imagePanel;

  public InitialWindow() {
    imagePanel = ImagePanel.getInstance();
    imagePanel.setLayout(null);
    initContenido();
    imagePanel.repaint();
    imagePanel.revalidate();
  }

  private void initContenido() {
    initLabels();
    initButtonVideo();
    initButtonPdf();
    initButtonImage();
    initButtonAuditoria();
  }

  private void initLabels() {
    JLabel Text = new JLabel("BIENVENIDO A FISITUBE");
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

  private void initButtonVideo() {
    CustomButton videoButton = new CustomButton();
    videoButton.setBounds((Constants.WIDTH * 11 / 17) / 2, (int) (Constants.HEIGHT * 0.37),
        (int) (Constants.WIDTH * 6 / 17),
        (int) (Constants.HEIGHT * 7 / 72));
    videoButton.setText("VIDEOS");
    CustomFormat.formato(videoButton, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    videoButton.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        imagePanel.removeAll();
        new CrudVideoWindow();
        imagePanel.repaint();
        imagePanel.revalidate();
      }
    });
    imagePanel.add(videoButton);
  }

  private void initButtonPdf() {
    CustomButton buttonPDF = new CustomButton();
    buttonPDF.setBounds((Constants.WIDTH * 11 / 17) / 2, (int) (Constants.HEIGHT * 0.49),
        (int) (Constants.WIDTH * 6 / 17), (int) (Constants.HEIGHT * 7 / 72));
    CustomFormat.formato(buttonPDF, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    buttonPDF.setText("PDF");
    buttonPDF.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        imagePanel.removeAll();
        new CrudPdfWindow();
        imagePanel.repaint();
        imagePanel.revalidate();
      }
    });
    imagePanel.add(buttonPDF);
  }

  private void initButtonImage() {
    CustomButton buttonImage = new CustomButton();
    buttonImage.setBounds((Constants.WIDTH * 11 / 17) / 2, (int) (Constants.HEIGHT * 0.61),
        (int) (Constants.WIDTH * 6 / 17),
        (int) (Constants.HEIGHT * 7 / 72));
    CustomFormat.formato(buttonImage, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    buttonImage.setText("IMÁGENES");
    buttonImage.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        imagePanel.removeAll();
        new CrudImageWindow();
        imagePanel.repaint();
        imagePanel.revalidate();
      }
    });
    imagePanel.add(buttonImage);
  }

  private void initButtonAuditoria() {
    CustomButton buttonAuditoria = new CustomButton();
    buttonAuditoria.setBounds((Constants.WIDTH * 11 / 17) / 2, (int) (Constants.HEIGHT * 0.73),
        (int) (Constants.WIDTH * 6 / 17),
        (int) (Constants.HEIGHT * 7 / 72));
    CustomFormat.formato(buttonAuditoria, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    buttonAuditoria.setText("AUDITORÍA");
    buttonAuditoria.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        imagePanel.removeAll();
        new TableAuditoryWindow();
        imagePanel.repaint();
        imagePanel.revalidate();
      }
    });
    imagePanel.add(buttonAuditoria);
  }
}
