package com.fabo.aplication.utils;

import java.awt.Color;
import javax.swing.*;

public class CustomFormat {
  private static CustomFont fuente = new CustomFont();;

  public static void formato(JComponent l, int estilo, float tamanio) {
    l.setFont(fuente.MyFont(estilo, tamanio));
    l.setOpaque(false);
    l.setBorder(BorderFactory.createEmptyBorder());
    l.setForeground(new Color(255, 255, 255));
  }

  public static void formato(JComboBox<String> b, int estilo, float tamanio) {
    b.setFont(fuente.MyFont(estilo, tamanio));
    b.setOpaque(false);
    b.setBorder(BorderFactory.createEmptyBorder());
    b.setForeground(new Color(0, 0, 0));
  }

  public static void formato(JTextArea ta) {
    ta.setFont(fuente.MyFont(0, 30f));
    ta.setOpaque(true);
    ta.setEditable(false);
    ta.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
    ta.setForeground(new Color(0, 0, 0));
    ta.setBackground(new Color(255, 255, 255));
  }

  public static void formato(CustomButton button, int estilo, float tamanio, int radius, int grosor) {
    button.setFont(fuente.MyFont(estilo, tamanio));
    button.configColor(radius, new Color(204, 204, 204), new Color(204, 204, 204), grosor);
  }
}
