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
import com.fabo.aplication.models.Auditory;
import com.fabo.aplication.services.AuditoryService;
import com.fabo.aplication.utils.Constants;
import com.fabo.aplication.utils.CustomButton;
import com.fabo.aplication.utils.CustomFormat;
import com.fabo.aplication.utils.ImagePanel;

public class TableAuditoryWindow {
  private ImagePanel imagePanel;
  private JLabel codigoLabel, nombreLabel, seleccionadoLabel;
  private JTextField seleccionadoField;
  private CustomButton botonRegresar;
  private DefaultTableModel tableModel;
  private JComboBox<String> comboBox;
  private AuditoryService auditoriaReg;
  List<Auditory> listaRegistros = new ArrayList<>();
  private String[][] m;
  JScrollPane scrollPane;

  public TableAuditoryWindow() {
    imagePanel = ImagePanel.getInstance();
    imagePanel.setLayout(null);
    this.auditoriaReg = new AuditoryService();
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
    codigoLabel = new JLabel("LISTADO DE AUDITORIAS");
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

  private void botonBack() {
    botonRegresar = new CustomButton();
    botonRegresar.setBounds((Constants.WIDTH * 2 / 17) / 2, (int) (Constants.HEIGHT * 0.70),
        (int) (Constants.WIDTH * 5 / 17),
        (int) (Constants.HEIGHT * 7 / 72));
    CustomFormat.formato(botonRegresar, 0, (float) (Constants.HEIGHT * 0.03), (int) (Constants.WIDTH * 0.05),
        (int) (Constants.WIDTH * 0.0017));
    botonRegresar.setText("REGRESAR");
    botonRegresar.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        imagePanel.removeAll();
        new InitialWindow();
        imagePanel.repaint();
        imagePanel.revalidate();
      }
    });
    imagePanel.add(botonRegresar);
  }

  private void initComponentes() {
    listaRegistros = auditoriaReg.extraerRegistros("todos_todos");
    initLabelPeliculaSeleccionada();
    initLabelTitulo();
    initTabla();
    initSeleccionada();
    funcionarComboBox();
    botonBack();
  }

  private void initTabla() {
    m = new String[listaRegistros.size()][4];
    int ind = 0;
    for (Auditory c : listaRegistros) {
      m[ind][0] = Integer.toString(c.getId());
      m[ind][1] = c.getOrigen();
      m[ind][2] = c.getFecha();
      m[ind][3] = c.getAccion();
      ind++;
    }

    String[] cabecera = { "ID", "ORIGEN", "FECHA", "ACCION" };
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
          mostrarNombreDePelicula(filaSeleccionada, m);
        }
      }
    });
    imagePanel.add(scrollPane);

  }

  private void mostrarTodos(String where) {
    listaRegistros = auditoriaReg.extraerRegistros(where);
    m = new String[listaRegistros.size()][4];
    int ind = 0;
    for (Auditory c : listaRegistros) {
      m[ind][0] = Integer.toString(c.getId());
      m[ind][1] = c.getOrigen();
      m[ind][2] = c.getFecha();
      m[ind][3] = c.getAccion();
      ind++;
    }

    String[] cabecera = { "ID", "ORIGEN", "FECHA", "ACCION" };
    tableModel.setDataVector(m, cabecera);
    tableModel.fireTableDataChanged();
    JTable table = new JTable(tableModel);
    for (int i = 0; i < cabecera.length; i++) {
      table.getColumnModel().getColumn(i).setResizable(false);
    }
    table.setDefaultEditor(Object.class, null);
    table.getTableHeader().setEnabled(false);
    table.getTableHeader().setBackground(Color.decode("#C2B221"));
    table.setRowHeight(40);
    table.setBackground(Color.decode("#C2B221"));
    table.getColumnModel().getColumn(0).setPreferredWidth(140);
    table.getColumnModel().getColumn(1).setPreferredWidth(100);
    table.setFont(table.getFont().deriveFont(18f));
    scrollPane = new JScrollPane(table);
    scrollPane.setBounds(520, 100, 700, 500);
    table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int filaSeleccionada = table.getSelectedRow();
        if (filaSeleccionada != -1) {
          mostrarNombreDePelicula(filaSeleccionada, m);
        }
      }
    });
    imagePanel.add(scrollPane);

  }

  private void funcionarComboBox() {
    String[] opciones = { "Todos_Todos", "INSERT_Todos", "UPDATE_Todos",
        "Todos_Video", "INSERT_Video", "UPDATE_Video",
        "Todos_Pdf", "INSERT_Pdf", "UPDATE_Pdf",
        "Todos_Imagen", "INSERT_Imagen", "UPDATE_Imagen" };
    comboBox = new JComboBox<>(opciones);
    comboBox.setBackground(Color.decode("#6688D4"));
    comboBox.setBounds(70, 160, 400, 50);
    comboBox.setBackground(Color.decode("#09599B"));
    CustomFormat.formato(comboBox, 1, (float) (Constants.HEIGHT * 0.040));
    comboBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String opcionSeleccionada = comboBox.getSelectedItem().toString();
        mostrarTodos(opcionSeleccionada.toLowerCase());
      }

    });

    imagePanel.add(comboBox);
  }

  private void mostrarNombreDePelicula(int tupla, String[][] m) {
    seleccionadoField.setText("");
    seleccionadoField.setText(m[tupla][1]);
  }
}