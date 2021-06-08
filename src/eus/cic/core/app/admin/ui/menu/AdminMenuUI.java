package eus.cic.core.app.admin.ui.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.awt.event.ActionListener;
import java.util.jar.Attributes.Name;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import eus.cic.core.app.admin.controller.menu.AdminMenuController;

public class AdminMenuUI extends JPanel {

	private static final Color BG_COLOR = Color.white;
	
	AdminMenuController controller;

	public AdminMenuUI() {
		super(new GridBagLayout());
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		controller = new AdminMenuController(this);
		this.setBackground(BG_COLOR);
		this.setOpaque(true);	
		
		addbuttonsPanel();
		
	}

	private void addbuttonsPanel() {
		this.add (createButton("Edificios", controller, Color.white), setConstraints(1,1));
		this.add (createButton("Salas", controller, Color.white), setConstraints(1,3));
		this.add (createButton("Trabajadores", controller, Color.white), setConstraints(1,5));
		this.add (createButton("Proyectos", controller, Color.white), setConstraints(3,1));
		this.add (createButton("Tarjetas", controller, Color.white), setConstraints(3,3));
		this.add (createButton("Reservas", controller, Color.white), setConstraints(3,5));
		this.add (createButton("Permisos", controller, Color.white), setConstraints(5,1));
		this.add (createButton("Fichas", controller, Color.white), setConstraints(5,3));
		this.add (createButton("Bonos", controller, Color.white), setConstraints(5,5));
		
	}

	private GridBagConstraints setConstraints(int gridx, int gridy) {
		GridBagConstraints constraints = new GridBagConstraints();
		//constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weighty = 1;
		constraints.weightx = 1;
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.weighty = 1.0;
		//constraints.weightx = 0.0;
		
		return constraints;
	}

	private Component createButton(String name, ActionListener controller ,Color color) {
		JButton boton = new JButton(name);
		boton.addActionListener(controller);
		boton.setActionCommand(name);
		boton.setBackground(color);
		boton.setFocusable(false);
		boton.setPreferredSize(new Dimension(150,150));
		return boton;
	}


}
