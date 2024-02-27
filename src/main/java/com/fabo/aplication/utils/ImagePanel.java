package com.fabo.aplication.utils;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import lombok.NoArgsConstructor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@NoArgsConstructor
public class ImagePanel extends JPanel {
  private BufferedImage image;
  private static ImagePanel instance;

  public static ImagePanel getInstance() {
    if (instance == null) {
      instance = new ImagePanel();
    }
    return instance;
  }

  public void setImage(String path) {
    try {
      image = ImageIO.read(new File(path));
    } catch (IOException e) {
      System.out.println("La imagen no existe");
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (image != null) {
      g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
  }
}
