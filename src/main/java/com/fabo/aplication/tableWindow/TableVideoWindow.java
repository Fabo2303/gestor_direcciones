package com.fabo.aplication.tableWindow;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.fabo.aplication.InitialWindow;
import com.fabo.aplication.crudwindow.CrudVideoWindow;
import com.fabo.aplication.models.Video;
import com.fabo.aplication.services.VideoService;
import com.fabo.aplication.showWindow.ShowVideoWindow;
import com.fabo.aplication.utils.Constants;
import com.fabo.aplication.utils.CustomButton;
import com.fabo.aplication.utils.CustomFormat;
import com.fabo.aplication.utils.ImagePanel;

public class TableVideoWindow {
  private ImagePanel imagePanel;
  private JLabel codigoLabel, nombreLabel, seleccionadoLabel;
  private JTextField seleccionadoField;
  private CustomButton verDetalleBtn, botonRegresar;
  private DefaultTableModel tableModel;
  private JComboBox<String> comboBox;
  private VideoService pdfReg;
  private Video video;
  List<Video> listaRegistro = new ArrayList<>();
  private String[][] m; // Cambiar el 15 por el tamaño de datos
  JScrollPane scrollPane;

  public TableVideoWindow() {
    imagePanel = ImagePanel.getInstance();
    imagePanel.setLayout(null);
    this.pdfReg = new VideoService();
    initComponentes();
    imagePanel.repaint();
    imagePanel.revalidate();
  }

  private void initLabelTitulo() {
    nombreLabel = new JLabel("ELIGE");
    nombreLabel.setBounds((int) (Constants.WIDTH * 0.05), (int) (Constants.HEIGHT * 0.15),
        (int) (Constants.WIDTH * 0.45),
        (int) (Constants.HEIGHT * 0.055));
    CustomFormat.formato(nombreLabel, 1, (float) (Constants.HEIGHT * 0.040));
    imagePanel.add(nombreLabel);
  }

  private void initLabelPeliculaSeleccionada() {
    codigoLabel = new JLabel("LISTADO DE VIDEOS");
    codigoLabel.setBounds((int) (Constants.WIDTH * 0.30), (int) (Constants.HEIGHT * 0.05),
        (int) (Constants.WIDTH * 0.45),
        (int) (Constants.HEIGHT * 0.055));
    CustomFormat.formato(codigoLabel, 1, (float) (Constants.HEIGHT * 0.045));
    imagePanel.add(codigoLabel);
  }

  private void initSeleccionada() {
    seleccionadoLabel = new JLabel("SELECCIONADA");
    seleccionadoLabel.setBounds((int) (Constants.WIDTH * 0.05), (int) (Constants.HEIGHT * 0.40),
        (int) (Constants.WIDTH * 0.45),
        (int) (Constants.HEIGHT * 0.055));
    CustomFormat.formato(seleccionadoLabel, 1, (float) (Constants.HEIGHT * 0.040));
    imagePanel.add(seleccionadoLabel);

    seleccionadoField = new JTextField();
    seleccionadoField.setBounds((int) (seleccionadoLabel.getX() + Constants.WIDTH * 0.025),
        (int) (seleccionadoLabel.getY() + seleccionadoLabel.getHeight() + Constants.HEIGHT * 0.025),
        (int) (Constants.WIDTH * 0.30),
        (int) (seleccionadoLabel.getHeight()));
    CustomFormat.formato(seleccionadoField, 0, (float) (Constants.HEIGHT * 0.035));
    imagePanel.add(seleccionadoField);
  }

  private void botonVerDeTalle() {
    verDetalleBtn = new CustomButton();
    verDetalleBtn.setBounds((Constants.WIDTH * 2 / 17) / 2, (int) (Constants.HEIGHT * 0.60),
        (int) (Constants.WIDTH * 5 / 17),
        (int) (Constants.HEIGHT * 7 / 72));
    CustomFormat.formato(verDetalleBtn, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    verDetalleBtn.setText("VER DETALLE");
    verDetalleBtn.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        imagePanel.removeAll();
        new ShowVideoWindow(video);
        imagePanel.repaint();
        imagePanel.revalidate();
      }
    });
    imagePanel.add(verDetalleBtn);
  }

  private void botonRegresar() {
    botonRegresar = new CustomButton();
    botonRegresar.setBounds((Constants.WIDTH * 2 / 17) / 2, (int) (Constants.HEIGHT * 0.75),
        (int) (Constants.WIDTH * 5 / 17),
        (int) (Constants.HEIGHT * 7 / 72));
    CustomFormat.formato(botonRegresar, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    botonRegresar.setText("REGRESAR");
    botonRegresar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        imagePanel.removeAll();
        new CrudVideoWindow();
        imagePanel.repaint();
        imagePanel.revalidate();
      }
    });
    imagePanel.add(botonRegresar);
  }

  private void initComponentes() {
    cargarDatos();
    initLabelPeliculaSeleccionada();
    initLabelTitulo();
    initTabla();
    initSeleccionada();
    funcionarComboBox();
    botonVerDeTalle();
    botonRegresar();
  }

  private void cargarDatos() {
    listaRegistro = pdfReg.extraerRegistros();
  }

  private void initTabla() {
    m = new String[listaRegistro.size()][5];
    int ind = 0;
    for (Video c : listaRegistro) {
      m[ind][0] = Integer.toString(c.getId());
      m[ind][1] = c.getTitulo();
      m[ind][2] = Integer.toString(c.getId_proy());
      m[ind][3] = c.getUrl();
      m[ind][4] = Integer.toString(c.getVisualizacion());
      ind++;
    }

    String[] cabecera = { "ID", "TÍTULO", "ID_PROY", "URL", "VISUALIZACION" };
    tableModel = new DefaultTableModel(m, cabecera);
    JTable table = new JTable(tableModel);
    for (int i = 0; i < cabecera.length; i++) {
      table.getColumnModel().getColumn(i).setResizable(false);
    }
    table.setDefaultEditor(Object.class, null);
    table.getTableHeader().setEnabled(false);
    table.getTableHeader().setBackground(Color.decode("#09599B"));
    table.setRowHeight(40);
    table.setBackground(Color.decode("#1B7ECF"));
    table.getColumnModel().getColumn(0).setPreferredWidth(140);
    table.getColumnModel().getColumn(1).setPreferredWidth(100);

    CustomFormat.formato(table, 1, (float) (Constants.HEIGHT * 0.025));

    scrollPane = new JScrollPane(table);
    scrollPane.setBounds(520, 100, 700, 500);
    table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int filaSeleccionada = table.getSelectedRow();
        // Verificar si se hizo clic en una fila válida
        if (filaSeleccionada != -1) {
          for (Video i : listaRegistro) {
            if (i.getId() == Integer.valueOf(m[filaSeleccionada][0])) {
              video = i;
              break;
            }
          }
          mostrarNombreDePelicula(filaSeleccionada, m);
        }
      }
    });
    imagePanel.add(scrollPane);

  }

  private void mostrarTodos() {
    // tableModel.setRowCount(0);
    m = new String[listaRegistro.size()][5];
    int ind = 0;
    for (Video c : listaRegistro) {
      m[ind][0] = Integer.toString(c.getId());
      m[ind][1] = c.getTitulo();
      m[ind][2] = Integer.toString(c.getId_proy());
      m[ind][3] = c.getUrl();
      m[ind][4] = Integer.toString(c.getVisualizacion());
      ind++;
    }

    String[] cabecera = { "ID", "TÍTULO", "ID_PROY", "URL", "VISUALIZACION" };
    tableModel.setDataVector(m, cabecera);
    tableModel.fireTableDataChanged();
    JTable table = new JTable(tableModel);
    for (int i = 0; i < cabecera.length; i++) {
      table.getColumnModel().getColumn(i).setResizable(false);
    }
    table.setDefaultEditor(Object.class, null);
    table.getTableHeader().setEnabled(false);
    table.setRowHeight(40);
    table.setBackground(Color.cyan);
    table.getColumnModel().getColumn(0).setPreferredWidth(140);
    table.getColumnModel().getColumn(1).setPreferredWidth(100);
    table.setFont(table.getFont().deriveFont(18f));
    scrollPane = new JScrollPane(table);
    scrollPane.setBounds(520, 100, 700, 500);
    table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int filaSeleccionada = table.getSelectedRow();
        // Verificar si se hizo clic en una fila válida
        if (filaSeleccionada != -1) {
          mostrarNombreDePelicula(filaSeleccionada, m);
        }
      }
    });
    imagePanel.add(scrollPane);

  }

  private void funcionarComboBox() {
    String[] opciones = { "Todos", "Solo disponibles", "Solo no disponibles" };
    comboBox = new JComboBox<>(opciones);
    comboBox.setBounds(70, 160, 400, 50);
    comboBox.setBackground(Color.decode("#09599B"));
    CustomFormat.formato(comboBox, 1, (float) (Constants.HEIGHT * 0.040));
    comboBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String opcionSeleccionada = comboBox.getSelectedItem().toString();
        // tableModel.setRowCount(0);
        // Realizar acciones según la opción seleccionada
        if (opcionSeleccionada.equals("Todos")) {
          listaRegistro = pdfReg.extraerRegistros();
          mostrarTodos();
        } else if (opcionSeleccionada.equals("Solo disponibles")) {
          listaRegistro = pdfReg.extraerVisualizables();
          mostrarTodos();
        } else if (opcionSeleccionada.equals("Solo no disponibles")) {
          listaRegistro = pdfReg.extraerNoVisualizables();
          mostrarTodos();
        }
      }

    });

    imagePanel.add(comboBox);
  }

  private void mostrarNombreDePelicula(int tupla, String[][] m) {
    seleccionadoField.setText("");
    seleccionadoField.setText(m[tupla][1]);
  }
}
