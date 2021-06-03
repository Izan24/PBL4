package eus.cic.core.app.uicomponents.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eus.cic.core.app.interfaces.IRoundButtonListener;
import eus.cic.core.app.uicomponents.components.MDButton;

public class CreationErrorDialog extends JDialog implements IRoundButtonListener {

	private static final long serialVersionUID = 5750206798109947882L;

	final String DISPOSE_COMAND = "dispose";

	JLabel textlabel, iconLabel;
	JButton confirmButton;
	String text;

	Color bgColor = Color.white;

	public CreationErrorDialog(JFrame frame, String title, boolean mode, String text) {
		super(frame, title, mode);

		this.text = text;
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		initJbuttons();
		initJlabels();

		this.setContentPane(createContent());

		this.pack();
		this.setLocation(frame.getX() + (frame.getWidth() / 2) - (this.getWidth() / 2),
				frame.getY() + (frame.getHeight() / 2) - (this.getHeight() / 2));

		this.setVisible(true);
	}

	private void initJbuttons() {
		confirmButton = new MDButton("Aceptar", new Dimension(100, 30), MDButton.RED, 20, this, DISPOSE_COMAND);
	}

	private void initJlabels() {
		textlabel = new JLabel();
		textlabel.setFont(new Font("Roboto", Font.PLAIN, 15));
		textlabel.setBackground(Color.white);
		textlabel.setFocusable(false);
		textlabel.setText(text);

		iconLabel = new JLabel();
		iconLabel.setBackground(Color.white);
		iconLabel.setFocusable(false);
		iconLabel.setBorder(new EmptyBorder(10, 10, 40, 10));
		iconLabel.setIcon(new ImageIcon("resources/menuIcons/bchef_icon.png"));
	}

	private Container createContent() {
		JPanel errorPanel = new JPanel(new BorderLayout());
		errorPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		errorPanel.setBackground(bgColor);

		errorPanel.add(createCenterPanel(), BorderLayout.CENTER);
		errorPanel.add(createButtonPanel(), BorderLayout.SOUTH);
		return errorPanel;
	}

	private Component createCenterPanel() {
		JPanel centerPanel = new JPanel(new FlowLayout());
		centerPanel.setBackground(bgColor);

		centerPanel.add(iconLabel);
		centerPanel.add(textlabel);

		return centerPanel;
	}

	private Component createButtonPanel() {
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(bgColor);

		buttonPanel.add(confirmButton);

		return buttonPanel;
	}

	@Override
	public void actionPerformed(String command) {
		switch (command) {
		case DISPOSE_COMAND:
			this.dispose();
			break;
		}
	}

}
