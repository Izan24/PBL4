package eus.cic.core.app.uicomponents.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

public class MDButtonPanel extends JPanel implements ActionListener{
	

	private static final long serialVersionUID = 5864232316023256749L;
	public static final Integer BUTTON_FICHAS = 0;
	public static final Integer BUTTON_BONOS = 1;
	public static final Integer BUTTON_RESERVAS = 2;
	public static final Integer BUTTON_REUNIONES = 3;
	public static final Integer BUTTON_PERFIL = 4;
	public static final Font FONT = new Font("Calibri", Font.PLAIN, 22);
	public static final Color COLOR_VERDE = new Color(69, 183, 148);
	
	JButton fichasButton, bonosButton, reservasButton, reunionesButton, perfilButton;
	List<JButton> buttons;
	List<String> names;
	ActionListener listener;
	
	
	public MDButtonPanel(ActionListener listener) {
		super();
		this.listener = listener;
		names = initNames();
		buttons = initButtons();
		createPanel();
		this.setPreferredSize(new Dimension(1367, 44));
		this.setBackground(Color.WHITE);
		this.revalidate();
		this.repaint();
		selectButton(2);
	}
	
	private List<String> initNames() {
		List<String> list = new ArrayList<>();
		list.add(BUTTON_FICHAS, "Fichas");
		list.add(BUTTON_BONOS, "Bonos");
		list.add(BUTTON_RESERVAS, "Reservas");
		list.add(BUTTON_REUNIONES, "Reuniones");
		list.add(BUTTON_PERFIL, "Perfil");
		return list;
	}
	
	private List<JButton> initButtons() {
		List<JButton> list = new ArrayList<>();
		for (int i = 0; i <= 4; i++) {
			JButton tempButton = new JButton(names.get(i));
			tempButton.setBackground(Color.WHITE);
			tempButton.setFont(FONT);
			tempButton.setBorder(new EmptyBorder(0,0,0,0));
			tempButton.setFocusable(false);
			tempButton.addActionListener(listener);
			tempButton.addActionListener(this);
			tempButton.setUI(new BasicButtonUI());
			tempButton.setActionCommand(String.valueOf(i));
			tempButton.setPreferredSize(new Dimension(250, 40));
			list.add(tempButton);
		}
		return list;
	}
	 private void createPanel() {
		 for (JButton jButton : buttons) {
			this.add(jButton);
		}
	 }
	 
	 private void selectButton(Integer selectedButton) {
		 for (JButton jButton : buttons) {
			jButton.setBorder(new EmptyBorder(0,0,0,0));
		}
		 JButton selected = buttons.get(selectedButton);
		 selected.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, COLOR_VERDE));
		 this.repaint();
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		Integer selectedButton = Integer.valueOf(e.getActionCommand());
		selectButton(selectedButton);
	}
}
