package eus.cic.core.app.uicomponents.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class RoundedTextField extends JTextField implements FocusListener {

	private static final long serialVersionUID = -5175905329740849910L;
	private final String hint;
	public  Color foreground_normal = new Color(127, 127, 127);

	public RoundedTextField(String hint) {
		super(hint);
		this.hint = hint;
		super.setMargin(new Insets(4, 8, 4, 8));
		super.addFocusListener(this);
	}
	
	public RoundedTextField() {
		this.hint = "";
		super.setMargin(new Insets(4, 8, 4, 8));
		super.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (super.getText().equals(hint)) {
			super.setText("");
			super.setForeground(foreground_normal);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (super.getText().trim().equals("")) {
			super.setText(hint);
			super.setForeground(Color.GRAY);
		}
	}

	@Override
	public String getText() {
		return super.getText();
	}

	@Override
	public void setText(String arg0) {
		super.setText(arg0);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
