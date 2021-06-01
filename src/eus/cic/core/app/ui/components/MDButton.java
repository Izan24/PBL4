package eus.cic.core.app.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

import eus.cic.core.app.interfaces.IRoundButtonListener;

public class MDButton extends JButton {
	
	private static final long serialVersionUID = -2453371689513957129L;
	
	public static final Color GREEN = new Color(69, 183, 148);
	public static final Color RED = new Color(253, 85, 85);
	public static final Font FONT = new Font("Calibri", Font.BOLD, 18);
	
	
	/*
	 * Constructor with listener and action command
	 */
	public MDButton(String string, Dimension size, Color color, Integer radius, IRoundButtonListener list, String actionCommand) {
		super(string);
		this.setPreferredSize(size);
		this.setUI(new UIRoundButton(this, radius, color, Color.white, FONT, list, actionCommand));
		
	}
	
	
	/*
	 * Constructor without listener
	 */
	public MDButton(String string, Dimension size, Color color, Integer radius) {
		super(string);
		this.setPreferredSize(size);
		this.setUI(new UIRoundButton(this, radius, color, Color.white, FONT, null, null));	
	}
}
