package fr.fablabmars.vue.panneaux;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Entete extends JPanel{

	private static final long serialVersionUID = -3935964236389086371L;
	private JLabel image;
	
	public Entete(String logo){
		super();
		JTextPane textPane = new JTextPane();
		SimpleAttributeSet styleTexte = new SimpleAttributeSet();
		SimpleAttributeSet styleTitre = new SimpleAttributeSet();
		
		StyleConstants.setFontSize(styleTexte, 15);
		StyleConstants.setFontSize(styleTitre, 30);
		textPane.setEditable(false);
		
		try {
			StyledDocument doc = textPane.getStyledDocument();

			doc.insertString(doc.getLength(), "\n" ,styleTexte);
			doc.insertString(doc.getLength(), "FabLab Marseille\n", styleTitre);
			doc.insertString(doc.getLength(), "SIRET n° 792324204 00017\n" ,styleTexte);
			doc.insertString(doc.getLength(), "38, Rue Frédéric Joliot-Curie\n" ,styleTexte);
			doc.insertString(doc.getLength(), "13451 Marseille Cedex 20" ,styleTexte);
		}
		catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		try {
			BufferedImage img = ImageIO.read(new File(logo));
			image = new JLabel(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.add(image,BorderLayout.WEST);
		this.add(textPane,BorderLayout.EAST);
	}
	
}
