package com.fabo.aplication.showWindow;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.fabo.aplication.crudwindow.CrudVideoWindow;
import com.fabo.aplication.models.Video;
import com.fabo.aplication.services.VideoService;
import com.fabo.aplication.utils.Constants;
import com.fabo.aplication.utils.CustomButton;
import com.fabo.aplication.utils.CustomFormat;
import com.fabo.aplication.utils.ImagePanel;
import com.fabo.aplication.utils.Reproductor;

public class ShowVideoWindow {
  private ImagePanel imagePanel;
  private JLabel codigoLabel, nombreLabel, descripcionLabel, urlLabel, idProyLabel;
  private JTextField codigoField, nombreField, urlField, idProyField;
  private JTextArea descripcionArea;
  private CustomButton cargarImagenBtn, abrirBtn, activarBtn, guardarBtn, volverBtn;
  private boolean editado;
  private Video archivo;
  private VideoService videoReg;

  public ShowVideoWindow(Video archivo) {
    imagePanel = ImagePanel.getInstance();
    this.archivo = archivo;
    this.editado = false;
    this.videoReg = new VideoService();
    imagePanel.setLayout(null);
    initComponentes();
    imagePanel.repaint();
    imagePanel.revalidate();
  }

  private void initComponentes() {
    initCodigo();
    initNombre();
    initDescripcion();
    initUrl();
    initProy();
    initBack();
    initData();
  }

  private void initCodigo() {
    codigoLabel = new JLabel("CODIGO DE LA VIDEO:");
    codigoLabel.setBounds((int) (Constants.WIDTH * 0.05), (int) (Constants.HEIGHT * 0.085),
        (int) (Constants.WIDTH * 0.45), (int) (Constants.HEIGHT * 0.055));
    CustomFormat.formato(codigoLabel, 1, (float) (Constants.HEIGHT * 0.045));
    imagePanel.add(codigoLabel);

    codigoField = new JTextField();
    codigoField.setBounds((int) (codigoLabel.getX() + Constants.WIDTH * 0.025),
        (int) (codigoLabel.getY() + codigoLabel.getHeight() + Constants.HEIGHT * 0.025), (int) (Constants.WIDTH * 0.35),
        (int) (codigoLabel.getHeight()));
    CustomFormat.formato(codigoField, 0, (float) (Constants.HEIGHT * 0.035));
    imagePanel.add(codigoField);

    JLabel contorno = new JLabel();
    contorno.setBounds((int) (codigoField.getX() - Constants.WIDTH * 0.004),
        (int) (codigoField.getY() - Constants.WIDTH * 0.004),
        (int) (codigoField.getWidth() + Constants.WIDTH * 0.008),
        (int) (codigoField.getHeight() + Constants.WIDTH * 0.008));
    contorno.setOpaque(false);
    contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    imagePanel.add(contorno);

  }

  private void initNombre() {
    nombreLabel = new JLabel("NOMBRE DE LA VIDEO:");
    nombreLabel.setBounds((int) (codigoLabel.getX()),
        (int) (codigoField.getY() + codigoField.getHeight() + Constants.HEIGHT * 0.05), (int) (codigoLabel.getWidth()),
        (int) (codigoLabel.getHeight()));
    CustomFormat.formato(nombreLabel, 1, (float) (Constants.HEIGHT * 0.045));
    imagePanel.add(nombreLabel);

    nombreField = new JTextField();
    nombreField.setBounds((int) (nombreLabel.getX() + Constants.WIDTH * 0.025),
        (int) (nombreLabel.getY() + nombreLabel.getHeight() + Constants.HEIGHT * 0.025), (int) (codigoField.getWidth()),
        (int) (codigoField.getHeight()));
    CustomFormat.formato(nombreField, 0, (float) (Constants.HEIGHT * 0.035));

    MouseAdapter editNombre = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        nombreField.setEditable(true);
        nombreField.setFocusable(true);
      }
    };

    nombreField.addMouseListener(editNombre);
    imagePanel.add(nombreField);

    JLabel contorno = new JLabel();
    contorno.setBounds((int) (nombreField.getX() - Constants.WIDTH * 0.004),
        (int) (nombreField.getY() - Constants.WIDTH * 0.004),
        (int) (nombreField.getWidth() + Constants.WIDTH * 0.008),
        (int) (nombreField.getHeight() + Constants.WIDTH * 0.008));
    contorno.setOpaque(false);
    contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    imagePanel.add(contorno);
  }

  private void initDescripcion() {
    descripcionLabel = new JLabel("DESCRIPCION:");
    descripcionLabel.setBounds((int) (nombreLabel.getX()),
        (int) (nombreField.getY() + nombreField.getHeight() + Constants.HEIGHT * 0.05), (int) (nombreLabel.getWidth()),
        (int) (nombreLabel.getHeight()));
    CustomFormat.formato(descripcionLabel, 1, (float) (Constants.HEIGHT * 0.045));
    imagePanel.add(descripcionLabel);

    descripcionArea = new JTextArea();
    descripcionArea.setBounds((int) (descripcionLabel.getX() + Constants.WIDTH * 0.025),
        (int) (descripcionLabel.getY() + descripcionLabel.getHeight() + Constants.HEIGHT * 0.025),
        (int) (nombreField.getWidth()),
        (int) (4.25 * nombreField.getHeight()));
    CustomFormat.formato(descripcionArea, 0, (float) (Constants.HEIGHT * 0.035));
    MouseAdapter editDescrpcion = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        descripcionArea.setEditable(true);
        descripcionArea.setFocusable(true);
      }
    };

    descripcionArea.addMouseListener(editDescrpcion);
    imagePanel.add(descripcionArea);

    JScrollPane descripcionScroll = new JScrollPane(descripcionArea);
    descripcionScroll.setBounds(descripcionArea.getX(), descripcionArea.getY(), descripcionArea.getWidth(),
        descripcionArea.getHeight());
    imagePanel.add(descripcionScroll);

    JLabel contorno = new JLabel();
    contorno.setBounds((int) (descripcionArea.getX() - Constants.WIDTH * 0.004),
        (int) (descripcionArea.getY() - Constants.WIDTH * 0.004),
        (int) (descripcionArea.getWidth() + Constants.WIDTH * 0.008),
        (int) (descripcionArea.getHeight() + Constants.WIDTH * 0.008));
    contorno.setOpaque(false);
    contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    imagePanel.add(contorno);
  }

  private void initUrl() {
    urlLabel = new JLabel("URL:");
    urlLabel.setBounds((int) (Constants.WIDTH * 0.55), (int) (Constants.HEIGHT * 0.085), (int) (Constants.WIDTH * 0.4),
        (int) (Constants.HEIGHT * 0.055));
    CustomFormat.formato(urlLabel, 1, (float) (Constants.HEIGHT * 0.045));
    imagePanel.add(urlLabel);

    urlField = new JTextField();
    urlField.setBounds((int) (urlLabel.getX() + Constants.WIDTH * 0.025),
        (int) (urlLabel.getY() + codigoLabel.getHeight() + Constants.HEIGHT * 0.025), (int) (Constants.WIDTH * 0.35),
        (int) (urlLabel.getHeight()));
    CustomFormat.formato(urlField, 0, (float) (Constants.HEIGHT * 0.035));
    MouseAdapter editUrl = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        urlField.setEditable(true);
        urlField.setFocusable(true);
      }
    };

    urlField.addMouseListener(editUrl);
    imagePanel.add(urlField);

    JLabel contorno = new JLabel();
    contorno.setBounds((int) (urlField.getX() - Constants.WIDTH * 0.004),
        (int) (urlField.getY() - Constants.WIDTH * 0.004),
        (int) (urlField.getWidth() + Constants.WIDTH * 0.008), (int) (urlField.getHeight() + Constants.WIDTH * 0.008));
    contorno.setOpaque(false);
    contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    imagePanel.add(contorno);

    cargarImagenBtn = new CustomButton();
    cargarImagenBtn.setText("CARGAR IMAGEN");
    cargarImagenBtn.setBounds(urlField.getX(), nombreLabel.getY(), (int) (urlField.getWidth() * 0.6),
        (int) (urlField.getHeight() * 2.25));
    CustomFormat.formato(cargarImagenBtn, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    MouseAdapter cargarImagen = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        urlField.setEditable(true);
        JFileChooser buscador = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos PNG", "png");
        buscador.setFileFilter(filter);

        int result = buscador.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
          File selectedFile = buscador.getSelectedFile();
          urlField.setText(selectedFile.getAbsolutePath());
        }
      }
    };
    cargarImagenBtn.addMouseListener(cargarImagen);
    imagePanel.add(cargarImagenBtn);

    abrirBtn = new CustomButton();
    abrirBtn.setText("ABRIR");
    abrirBtn.setBounds((int) (cargarImagenBtn.getX() + cargarImagenBtn.getWidth() + Constants.WIDTH * 0.01),
        (int) (cargarImagenBtn.getY()), (int) (urlField.getWidth() * 0.37), (int) (urlField.getHeight() * 2.25));
    CustomFormat.formato(abrirBtn, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    MouseAdapter abrirImagen = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (archivo.getVisualizacion() == 1) {
          String[] options = { "Galeria" };
          int op = JOptionPane.showOptionDialog(null, "Elija el reproductor", "Clickea una opcion",
              JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
          switch (op) {
            case 0:
              Reproductor.AbrirDOC(urlField.getText());
              break;
          }
        } else
          JOptionPane.showMessageDialog(null, "Archivo no habilitado");
      }
    };
    abrirBtn.addMouseListener(abrirImagen);
    imagePanel.add(abrirBtn);
  }

  private void initProy() {
    idProyLabel = new JLabel("ID DEL PROYECTO:");
    idProyLabel.setBounds((int) (urlLabel.getX()), (int) (descripcionLabel.getY()), (int) (Constants.WIDTH * 0.4),
        (int) (Constants.HEIGHT * 0.055));
    CustomFormat.formato(idProyLabel, 1, (float) (Constants.HEIGHT * 0.045));
    imagePanel.add(idProyLabel);

    idProyField = new JTextField();
    idProyField.setBounds((int) (idProyLabel.getX() + Constants.WIDTH * 0.025),
        (int) (idProyLabel.getY() + codigoLabel.getHeight() + Constants.HEIGHT * 0.025), (int) (Constants.WIDTH * 0.35),
        (int) (idProyLabel.getHeight()));
    CustomFormat.formato(idProyField, 0, (float) (Constants.HEIGHT * 0.035));
    imagePanel.add(idProyField);

    JLabel contorno = new JLabel();
    contorno.setBounds((int) (idProyField.getX() - Constants.WIDTH * 0.004),
        (int) (idProyField.getY() - Constants.WIDTH * 0.004),
        (int) (idProyField.getWidth() + Constants.WIDTH * 0.008),
        (int) (idProyField.getHeight() + Constants.WIDTH * 0.008));
    contorno.setOpaque(false);
    contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    imagePanel.add(contorno);

    activarBtn = new CustomButton();
    if (archivo.getVisualizacion() == 1)
      activarBtn.setText("DESACTIVAR");
    else
      activarBtn.setText("ACTIVAR");
    activarBtn.setBounds((int) (idProyField.getX() + idProyField.getWidth() * 0.1),
        (int) (descripcionArea.getY() + descripcionArea.getHeight() / 2), (int) (idProyField.getWidth() * 0.8),
        (int) (idProyLabel.getHeight() * 1.75));
    CustomFormat.formato(activarBtn, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    MouseAdapter activarArchivo = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int opt;
        if (archivo.getVisualizacion() == 1) {
          opt = JOptionPane.showConfirmDialog(null, "Desactivar archivo?", "Desactivacion", JOptionPane.YES_NO_OPTION);
          if (opt == JOptionPane.YES_OPTION) {
            archivo.setVisualizacion(0);
            JOptionPane.showMessageDialog(null, "Archivo: DESACTIVADO CON EXITO!");
            activarBtn.setText("ACTIVAR");
            editado = true;
          }
        } else {
          opt = JOptionPane.showConfirmDialog(null, "Activar archivo?", "Activacion", JOptionPane.YES_NO_OPTION);
          if (opt == JOptionPane.YES_OPTION) {
            archivo.setVisualizacion(1);
            JOptionPane.showMessageDialog(null, "Archivo: ACTIVADO CON EXITO!");
            activarBtn.setText("DEACTIVAR");
            editado = true;
          }
        }
      }
    };

    activarBtn.addMouseListener(activarArchivo);
    imagePanel.add(activarBtn);

    guardarBtn = new CustomButton();
    guardarBtn.setText("GUARDAR");
    guardarBtn.setBounds((int) (idProyField.getX() + idProyField.getWidth() * 0.1),
        (int) (activarBtn.getY() + activarBtn.getHeight() + Constants.HEIGHT * 0.05),
        (int) (idProyField.getWidth() * 0.8),
        (int) (idProyLabel.getHeight() * 1.75));
    CustomFormat.formato(guardarBtn, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    MouseAdapter actualizarArchivo = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        String nombre = nombreField.getText().toUpperCase();
        String descripcion = descripcionArea.getText().toUpperCase();
        String url = urlField.getText();
        if (!nombre.equals(archivo.getTitulo())) {
          editado = true;
          archivo.setTitulo(nombre);

        }
        if (!descripcion.equals(archivo.getDescripcion())) {
          editado = true;
          archivo.setDescripcion(descripcion);

        }
        if (!url.equals(archivo.getUrl())) {
          editado = true;
          archivo.setUrl(url);

        }

        if (editado) {
          int opt = JOptionPane.showConfirmDialog(null, "Actualizar datos?", "Modificacion", JOptionPane.YES_NO_OPTION);
          if (opt == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Archivo: ACTUALIZADO CON EXITO!");
            editado = false;
            videoReg.update(archivo);
            nombreField.setEditable(editado);
            nombreField.setFocusable(editado);
            descripcionArea.setEditable(editado);
            descripcionArea.setFocusable(editado);
            urlField.setEditable(editado);
            urlField.setFocusable(editado);
            videoReg.update(archivo);
          }
        }
      }
    };

    guardarBtn.addMouseListener(actualizarArchivo);
    imagePanel.add(activarBtn);
    imagePanel.add(guardarBtn);

  }

  private void initBack() {
    volverBtn = new CustomButton();
    volverBtn.setText("VOLVER");
    volverBtn.setBounds((int) (descripcionArea.getX() + descripcionArea.getWidth() * 0.1),
        (int) (descripcionArea.getY() + descripcionArea.getHeight() + Constants.HEIGHT * 0.05),
        (int) (descripcionArea.getWidth() * 0.7), (int) (descripcionLabel.getHeight() * 1.75));
    CustomFormat.formato(volverBtn, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    MouseAdapter volver = new MouseAdapter() {

      @Override
      public void mouseClicked(MouseEvent e) {
        imagePanel.removeAll();
        new CrudVideoWindow();
        imagePanel.repaint();
        imagePanel.revalidate();
      }
    };
    volverBtn.addMouseListener(volver);
    imagePanel.add(volverBtn);
  }

  private void initData() {
    codigoField.setText(String.valueOf(archivo.getId()));
    nombreField.setText(archivo.getTitulo());
    descripcionArea.setText(archivo.getDescripcion());
    urlField.setText(archivo.getUrl());
    idProyField.setText(String.valueOf(archivo.getId_proy()));
  }
}
