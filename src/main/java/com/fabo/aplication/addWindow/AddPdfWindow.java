package com.fabo.aplication.addWindow;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.fabo.aplication.crudwindow.CrudPdfWindow;
import com.fabo.aplication.models.Pdf;
import com.fabo.aplication.models.Project;
import com.fabo.aplication.services.PdfService;
import com.fabo.aplication.services.ProjectService;
import com.fabo.aplication.utils.Constants;
import com.fabo.aplication.utils.CustomButton;
import com.fabo.aplication.utils.CustomFormat;
import com.fabo.aplication.utils.ImagePanel;

public class AddPdfWindow {

  private ImagePanel imagePanel;
  private JTextField fieldNombre, urlField;
  private JTextArea descripcionArea;
  private PdfService pdfReg;
  private ProjectService proyReg;
  private Project proy;
  private JComboBox<String> comboBox;

  public AddPdfWindow() {
    imagePanel = ImagePanel.getInstance();
    pdfReg = new PdfService();
    proyReg = new ProjectService();
    imagePanel.setLayout(null);
    initContent();
    imagePanel.repaint();
    imagePanel.revalidate();
  }

  private void initContent() {
    initLabels();
    initLabelNombre();
    initLabelDescripcion();
    initLabelUrl();
    initLabelProy();
    initButtonBack();
  }

  private void initLabels() {
    JLabel text = new JLabel("AGREGAR");
    text.setBounds((int) (Constants.WIDTH * 0.095), (int) (Constants.HEIGHT * 0.085), (int) (Constants.WIDTH * 0.45),
        (int) (Constants.HEIGHT * 0.055));
    CustomFormat.formato(text, 1, (float) (Constants.HEIGHT * 0.055));
    text.setForeground(new Color(255, 102, 196));
    imagePanel.add(text);

    JLabel text2 = new JLabel("PDF");
    text2.setBounds((int) (text.getX() + text.getWidth() / 2 - Constants.WIDTH * 0.05),
        (int) (text.getY() + text.getHeight() + Constants.HEIGHT * 0.005), (int) (Constants.WIDTH * 0.45),
        (int) (Constants.HEIGHT * 0.055));
    CustomFormat.formato(text2, 1, (float) (Constants.HEIGHT * 0.055));
    text2.setForeground(new Color(255, 102, 196));
    imagePanel.add(text2);
  }

  private void initLabelNombre() {
    JLabel labelNombre = new JLabel("NOMBRE DEL PDF:");
    labelNombre.setBounds((int) (Constants.WIDTH * 0.075), (int) (Constants.HEIGHT * 0.275),
        (int) ((int) (Constants.WIDTH * 0.45)),
        (int) (Constants.HEIGHT * 0.055));
    CustomFormat.formato(labelNombre, 1, (float) (Constants.HEIGHT * 0.045));
    imagePanel.add(labelNombre);

    fieldNombre = new JTextField();
    fieldNombre.setBounds((int) (labelNombre.getX() + Constants.WIDTH * 0.025),
        (int) (labelNombre.getY() + labelNombre.getHeight() + Constants.HEIGHT * 0.025), (int) (Constants.WIDTH * 0.35),
        (int) (labelNombre.getHeight()));
    CustomFormat.formato(fieldNombre, 0, (float) (Constants.HEIGHT * 0.035));
    fieldNombre.setEditable(true);
    fieldNombre.setFocusable(true);
    fieldNombre.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        fieldNombre.setEditable(true);
        fieldNombre.setFocusable(true);
      }
    });
    imagePanel.add(fieldNombre);

    JLabel contorno = new JLabel();
    contorno.setBounds((int) (fieldNombre.getX() - Constants.WIDTH * 0.004),
        (int) (fieldNombre.getY() - Constants.WIDTH * 0.004),
        (int) (fieldNombre.getWidth() + Constants.WIDTH * 0.008),
        (int) (fieldNombre.getHeight() + Constants.WIDTH * 0.008));
    contorno.setOpaque(false);
    contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    imagePanel.add(contorno);
  }

  private void initLabelDescripcion() {
    JLabel descripcionLabel = new JLabel("DESCRIPCION:");
    descripcionLabel.setBounds((int) (Constants.WIDTH * 0.075),
        (int) (fieldNombre.getY() + fieldNombre.getHeight() + Constants.HEIGHT * 0.05),
        (int) ((int) (Constants.WIDTH * 0.45)),
        (int) (Constants.HEIGHT * 0.055));
    CustomFormat.formato(descripcionLabel, 1, (float) (Constants.HEIGHT * 0.045));
    imagePanel.add(descripcionLabel);

    descripcionArea = new JTextArea();
    descripcionArea.setBounds((int) (descripcionLabel.getX() + Constants.WIDTH * 0.025),
        (int) (descripcionLabel.getY() + descripcionLabel.getHeight() + Constants.HEIGHT * 0.025),
        (int) (fieldNombre.getWidth()), (int) (4.25 * fieldNombre.getHeight()));
    CustomFormat.formato(descripcionArea, 0, (float) (Constants.HEIGHT * 0.035));
    descripcionArea.setEditable(true);
    descripcionArea.setFocusable(true);
    descripcionArea.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        descripcionArea.setEditable(true);
        descripcionArea.setFocusable(true);
      }
    });
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

  private void initLabelUrl() {
    JLabel urlLabel = new JLabel("URL:");
    urlLabel.setBounds((int) (Constants.WIDTH * 0.55), (int) (Constants.HEIGHT * 0.085), (int) (Constants.WIDTH * 0.45),
        (int) (Constants.HEIGHT * 0.055));
    CustomFormat.formato(urlLabel, 1, (float) (Constants.HEIGHT * 0.045));
    imagePanel.add(urlLabel);

    urlField = new JTextField();
    urlField.setBounds((int) (urlLabel.getX() + Constants.WIDTH * 0.025),
        (int) (urlLabel.getY() + urlLabel.getHeight() + Constants.HEIGHT * 0.025), (int) (Constants.WIDTH * 0.35),
        (int) (urlLabel.getHeight()));
    CustomFormat.formato(urlField, 0, (float) (Constants.HEIGHT * 0.035));
    urlField.setEditable(true);
    urlField.setFocusable(true);
    urlField.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        urlField.setEditable(true);
        urlField.setFocusable(true);
      }
    });
    imagePanel.add(urlField);

    JLabel contorno = new JLabel();
    contorno.setBounds((int) (urlField.getX() - Constants.WIDTH * 0.004),
        (int) (urlField.getY() - Constants.WIDTH * 0.004),
        (int) (urlField.getWidth() + Constants.WIDTH * 0.008), (int) (urlField.getHeight() + Constants.WIDTH * 0.008));
    contorno.setOpaque(false);
    contorno.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    imagePanel.add(contorno);

    CustomButton cargarImagenBtn = new CustomButton();
    cargarImagenBtn.setText("CARGAR PDF");
    cargarImagenBtn.setBounds((int) (urlField.getX() + urlField.getWidth() * 0.1), (int) (Constants.HEIGHT * 0.275),
        (int) (urlField.getWidth() * 0.8), (int) (urlField.getHeight() * 1.75));
    CustomFormat.formato(cargarImagenBtn, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    cargarImagenBtn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        JFileChooser buscador = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos MP4", "mp4");
        buscador.setFileFilter(filter);

        int result = buscador.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
          File selectedFile = buscador.getSelectedFile();
          urlField.setText(selectedFile.getAbsolutePath());
        }
      }
    });
    imagePanel.add(cargarImagenBtn);
  }

  private void initLabelProy() {
    JLabel idProyLabel = new JLabel("ID DEL PROYECTO:");
    idProyLabel.setBounds((int) (Constants.WIDTH * 0.55),
        (int) (fieldNombre.getY() + fieldNombre.getHeight() + Constants.HEIGHT * 0.05),
        (int) (Constants.WIDTH * 0.4),
        (int) (Constants.HEIGHT * 0.055));
    CustomFormat.formato(idProyLabel, 1, (float) (Constants.HEIGHT * 0.045));
    imagePanel.add(idProyLabel);

    ArrayList<Project> proys = proyReg.extraerProyectos();
    proy = proys.get(0);
    String[] opciones = new String[proys.size()];
    for (int i = 0; i < opciones.length; i++) {
      opciones[i] = proys.get(i).getNomPyto();
    }
    comboBox = new JComboBox<>(opciones);
    comboBox.setBounds((int) (idProyLabel.getX() + Constants.WIDTH * 0.025),
        (int) (idProyLabel.getY() + (int) (Constants.HEIGHT * 0.055) + Constants.HEIGHT * 0.025),
        (int) (Constants.WIDTH * 0.35),
        (int) (idProyLabel.getHeight()));
    comboBox.setBackground(Color.decode("#09599B"));
    CustomFormat.formato(comboBox, 1, (float) (Constants.HEIGHT * 0.040));
    comboBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String opcionSeleccionada = comboBox.getSelectedItem().toString();
        for (Project p : proys) {
          if (p.buscarProyecto(opcionSeleccionada) != null) {
            proy = p;
            System.out.println(proy.getCodPyto());
            break;
          }
        }
      }

    });

    imagePanel.add(comboBox);
    CustomButton guardarBtn = new CustomButton();
    guardarBtn.setText("GUARDAR");
    guardarBtn.setBounds((int) (comboBox.getX() + comboBox.getWidth() * 0.1),
        (int) (descripcionArea.getY() + descripcionArea.getHeight() / 2), (int) (idProyLabel.getWidth() * 0.7),
        (int) (idProyLabel.getHeight() * 1.75));
    CustomFormat.formato(guardarBtn, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    guardarBtn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        String nombre = fieldNombre.getText().toUpperCase();
        String descripcion = descripcionArea.getText().toUpperCase();
        String url = urlField.getText();
        String idProy = "" + proy.getCodPyto();
        try {
          Integer.parseInt(idProy);
        } catch (Exception ex) {
          idProy = "";
        }
        if (!nombre.isEmpty() && !descripcion.isEmpty() && !url.isEmpty() && !idProy.isEmpty()) {
          StringBuilder mensaje = new StringBuilder();
          mensaje.append("Guardar datos?");
          mensaje.append("\n");
          mensaje.append("Nombre: ");
          mensaje.append(nombre);
          mensaje.append("\n");
          mensaje.append("Descripcion: ");
          mensaje.append(descripcion);
          mensaje.append("\n");
          mensaje.append("URL: ");
          mensaje.append(url);
          mensaje.append("\n");
          mensaje.append("Proyecto ID: ");
          mensaje.append(idProy);
          Pdf i1 = new Pdf(0, nombre, descripcion, Integer.parseInt(idProy), 0, url, 1);

          int opt = JOptionPane.showConfirmDialog(null, mensaje.toString(), "Insert",
              JOptionPane.YES_NO_OPTION);
          if (opt == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Archivo insertado con exito!", "Ingreso",
                JOptionPane.INFORMATION_MESSAGE);
            pdfReg.agregar(i1);
            imagePanel.removeAll();
            initContent();
            imagePanel.revalidate();
            imagePanel.repaint();
          }
        } else {
          JOptionPane.showMessageDialog(null, "Debe llenar todas las areas correctamente!", "Ingreso",
              JOptionPane.WARNING_MESSAGE);
        }
      }
    });
    imagePanel.add(guardarBtn);

  }

  private void initButtonBack() {
    CustomButton buttonBack = new CustomButton();
    buttonBack.setText("VOLVER");
    buttonBack.setBounds((int) (Constants.WIDTH * 0.5 - descripcionArea.getWidth() * 0.35),
        (int) (descripcionArea.getY() + descripcionArea.getHeight() + Constants.HEIGHT * 0.05),
        (int) (descripcionArea.getWidth() * 0.7), (int) ((int) (Constants.HEIGHT * 0.055) * 1.75));
    CustomFormat.formato(buttonBack, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    buttonBack.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        imagePanel.removeAll();
        new CrudPdfWindow();
        imagePanel.repaint();
        imagePanel.revalidate();
      }
    });
    imagePanel.add(buttonBack);
  }
}
