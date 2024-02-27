package com.fabo.aplication.utils;

import java.awt.Font;
import java.io.InputStream;

public class CustomFont {
	private Font font;

	public CustomFont() {
		String fontName = "LibreBaskerville-Regular.ttf";
		try {
			// Se carga la fuente
			InputStream is = getClass().getResourceAsStream(fontName);
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (Exception ex) {
			// Si existe un error se carga fuente por defecto ARIAL
			System.err.println(fontName + " No se cargo la fuente");
			font = new Font("Arial", Font.PLAIN, 40);
		}
	}

	public Font MyFont(int estilo, float tamanio) {
		return font.deriveFont(estilo, tamanio);
	}
}
