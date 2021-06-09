package eus.cic.core.app.admin.ui.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;
import java.util.jar.Attributes.Name;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import eus.cic.core.app.admin.controller.AdminUIController;
import eus.cic.core.app.admin.controller.building.AdminBuildingControllerAC;
import eus.cic.core.app.admin.controller.menu.AdminMenuController;
import eus.cic.core.app.admin.controller.menu.AdminMenuControllerAC;
import eus.cic.core.app.uicomponents.components.MDButton;

public class AdminMenuUI extends JPanel {

	private static final Color BG_COLOR = Color.white;

	AdminMenuController controller;

	MDButton buildingButton, roomsButton, workerButton, projectsButton, cardsButton, bookingsButton, permissionsButton,
			checkinsButton, bondsButton;

	public AdminMenuUI(AdminUIController uiController) {
		super(new GridBagLayout());
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		controller = new AdminMenuController(this, uiController);
		this.setBackground(BG_COLOR);
		this.setOpaque(true);

		initButtons();
		addbuttonsPanel();
	}

	private void initButtons() {
		buildingButton = new MDButton("Edificios", new Dimension(150, 150), Color.WHITE, Color.BLACK, 10, controller,
				AdminMenuControllerAC.BUILDINGS);
		roomsButton = new MDButton("Salas", new Dimension(150, 150), Color.WHITE, Color.BLACK, 10, controller,
				AdminMenuControllerAC.ROOMS);
		workerButton = new MDButton("Trabajadores", new Dimension(150, 150), Color.WHITE, Color.BLACK, 10, controller,
				AdminMenuControllerAC.WORKERS);
		projectsButton = new MDButton("Projects", new Dimension(150, 150), Color.WHITE, Color.BLACK, 10, controller,
				AdminMenuControllerAC.PROJECTS);
		cardsButton = new MDButton("Tarjetas", new Dimension(150, 150), Color.WHITE, Color.BLACK, 10, controller,
				AdminMenuControllerAC.CARDS);
		bookingsButton = new MDButton("Reservas", new Dimension(150, 150), Color.WHITE, Color.BLACK, 10, controller,
				AdminMenuControllerAC.BOOKINGS);
		permissionsButton = new MDButton("Permisos", new Dimension(150, 150), Color.WHITE, Color.BLACK, 10, controller,
				AdminMenuControllerAC.PERMISSIONS);
		checkinsButton = new MDButton("Fichas", new Dimension(150, 150), Color.WHITE, Color.BLACK, 10, controller,
				AdminMenuControllerAC.CHECKINS);
		bondsButton = new MDButton("Bonos", new Dimension(150, 150), Color.WHITE, Color.BLACK, 10, controller,
				AdminMenuControllerAC.BONDS);

		buildingButton
				.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.RED),
						BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY)));
		roomsButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.RED),
				BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY)));
		workerButton
				.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.RED),
						BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY)));
		projectsButton
				.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.RED),
						BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY)));
		cardsButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.RED),
				BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY)));
		bookingsButton
				.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.RED),
						BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY)));
		permissionsButton
				.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.RED),
						BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY)));
		checkinsButton
				.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.RED),
						BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY)));
		bondsButton.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, Color.RED),
				BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY)));

	}

	private void addbuttonsPanel() {
		this.add(buildingButton, setConstraints(1, 1));
		this.add(roomsButton, setConstraints(1, 3));
		this.add(workerButton, setConstraints(1, 5));
		this.add(projectsButton, setConstraints(3, 1));
		this.add(cardsButton, setConstraints(3, 3));
		this.add(bookingsButton, setConstraints(3, 5));
		this.add(permissionsButton, setConstraints(5, 1));
		this.add(checkinsButton, setConstraints(5, 3));
		this.add(bondsButton, setConstraints(5, 5));

	}

	private GridBagConstraints setConstraints(int gridx, int gridy) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weighty = 1;
		constraints.weightx = 1;
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		constraints.weighty = 1.0;

		return constraints;
	}

	private Component createButton(String name, ActionListener controller, Color color) {
		JButton boton = new JButton(name);
		boton.addActionListener(controller);
		boton.setActionCommand(name);
		boton.setBackground(color);
		boton.setFocusable(false);
		boton.setPreferredSize(new Dimension(150, 150));
		return boton;
	}

}
