package eus.cic.core.app.uicomponents.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;

import eus.cic.core.app.uicomponents.borders.TransparentRoundBackgroundBorder;

public class RoundTransparentButton extends BasicButtonUI implements MouseListener, KeyListener {

	private Border border;

	private Color font_Color_normal = new Color(78, 78, 78);

	private Color font_Color_active = new Color(255, 255, 255, 255);

	private Color backgroundNormal = new Color(0, 0, 0, 0);

	private Color backgroundActive = new Color(160, 160, 160);

	private Image imageNormal;

	private Image imageActive;

	public RoundTransparentButton(CustomButton c, Color fontNormal, Color fontActive, Color backgroundNormal,
			Color backgroudActive) {
		this.font_Color_normal = fontNormal;
		this.font_Color_active = fontActive;
		this.backgroundNormal = backgroundNormal;
		this.backgroundActive = backgroudActive;
		this.border = new TransparentRoundBackgroundBorder(40);
		c.setBorder(border);
		c.repaint();
		c.addMouseListener(this);
		c.addKeyListener(this);
	}

	public RoundTransparentButton(CustomButton c, Color fontNormal, Color fontActive, Color backgroundNormal,
			Color backgroudActive, Image imageNormal, Image imageActive) {
		this.font_Color_normal = fontNormal;
		this.font_Color_active = fontActive;
		this.backgroundNormal = backgroundNormal;
		this.backgroundActive = backgroudActive;
		this.imageNormal = imageNormal;
		this.imageActive = imageActive;
		this.border = new TransparentRoundBackgroundBorder(40);
		c.setBorder(border);
		c.repaint();
		c.addMouseListener(this);
		c.addKeyListener(this);
	}

	public void paint(Graphics g, JComponent c) {
		CustomButton b = (CustomButton) c;
		Dimension d = b.getSize();

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

		g2.setFont(b.getFont());
		FontMetrics fm = g.getFontMetrics();

		g2.setColor(b.getFontColor());
		String caption = b.getFrontText();

		int dimy = ((int) d.getHeight() + fm.getHeight() / 2) / 2;
		int dimXStr;
		int dimXImg;

		Image image = b.getImage();
		if (b.getAlign() == CustomButton.LEFT_ALIGN) {
			dimXImg = 10;
			dimXStr = c.getX() + 45;
		} else {
			dimXStr = (c.getWidth() / 2 + fm.stringWidth(caption)) / 2;
			dimXImg = dimXStr - (fm.stringWidth(caption) / 2) - 20;
		}
		g2.drawImage(image.getScaledInstance(24, 24, Image.SCALE_SMOOTH), dimXImg, 7, null);
		g2.drawString(caption, dimXStr, dimy + 2);
	}

	public Dimension getPreferredSize(JComponent c) {
		Dimension d = super.getPreferredSize(c);
		if (border != null) {
			Insets ins = border.getBorderInsets(c);
			d.setSize(d.width + ins.left + ins.right, d.height + ins.top + ins.bottom);
		}
		return d;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		CustomButton c = (CustomButton) e.getComponent();
		c.setBackgroundColor(backgroundActive);
		c.setFontColor(font_Color_active);
		c.setImage(imageActive);
	}

	public void mouseExited(MouseEvent e) {
		CustomButton c = (CustomButton) e.getComponent();
		c.setBackgroundColor(backgroundNormal);
		c.setFontColor(font_Color_normal);
		c.setImage(imageNormal);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {
	}

}
