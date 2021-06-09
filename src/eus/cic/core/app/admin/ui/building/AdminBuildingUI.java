package eus.cic.core.app.admin.ui.building;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import eus.cic.core.app.admin.controller.building.AdminBuildingController;
import eus.cic.core.app.admin.controller.building.AdminBuildingControllerAC;
import eus.cic.core.app.uicomponents.borders.SearchBorder;
import eus.cic.core.app.uicomponents.components.MDButton;
import eus.cic.core.app.uicomponents.components.RoundedTextField;
import eus.cic.core.app.utils.DoubleClickListener;
import eus.cic.core.models.Building;

public class AdminBuildingUI extends JPanel {

	AdminBuildingController controller;

	JList<Building> buildings;
	BuildingList listModel;
	BuildingListRenderer renderer;

	DoubleClickListener clickListener;

	private static final String ADD_STRING = "Añadir";
	private static final String REMOVE_STRING = "-";
	private static final String EDIT_STRING = "...";

	private static final Font TITLE_FONT = new Font("Calibri", Font.BOLD, 24);
	private static final Font FIELD_FONT = new Font("Calibri", Font.PLAIN, 18);

	private static final Color BG_COLOR = Color.white;
	private static final Color ADD_COLOR = new Color(69, 183, 148);
	private static final Color REMOVE_COLOR = new Color(253, 85, 85);
	private static final Color EDIT_COLOR = new Color(255, 217, 102);
	private static final Color FOREGROUND_COLOR_TEXT = new Color(38, 38, 38);
	private static final Color BORDER_COLOR = new Color(166, 166, 166);

	JTextField postalCodeField, nameField;
	MDButton addButton, removeButton, editButton;

	public AdminBuildingUI() {
		super(new GridLayout(1, 2));
		this.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		this.setBackground(BG_COLOR);
		this.setOpaque(true);

		controller = new AdminBuildingController(this);
		clickListener = new DoubleClickListener(controller);

		initJList();
		initButtons();
		initTextFields();

		this.add(createListButtonPanel());
		this.add(createParameterPanel());
	}

	private void initJList() {
		buildings = new JList<>();
		listModel = new BuildingList();
		//listModel.setList(JSONCalls.getBuildings());
		renderer = new BuildingListRenderer();

		buildings.setModel(listModel);
		buildings.setCellRenderer(renderer);
		buildings.addMouseListener(clickListener);
	}

	private void initButtons() {
		addButton = new MDButton(ADD_STRING, new Dimension(80, 40), ADD_COLOR, 10, controller,
				AdminBuildingControllerAC.ADD_BUILDING);
		removeButton = new MDButton(REMOVE_STRING, new Dimension(40, 40), REMOVE_COLOR, 10, controller,
				AdminBuildingControllerAC.REMOVE_BUILDING);
		editButton = new MDButton(EDIT_STRING, new Dimension(40, 40), EDIT_COLOR, 10, controller,
				AdminBuildingControllerAC.EDIT_BUILDING);
	}

	private void initTextFields() {
		postalCodeField = new RoundedTextField("Codigo postal");
		postalCodeField.setFont(FIELD_FONT);
		postalCodeField.setForeground(FOREGROUND_COLOR_TEXT);
		postalCodeField.setColumns(20);
		postalCodeField.setBackground(Color.WHITE);
		postalCodeField.setPreferredSize(new Dimension(100, 45));
		postalCodeField.setBorder(new SearchBorder(10, BORDER_COLOR, false));

		nameField = new RoundedTextField("Nombre");
		nameField.setFont(FIELD_FONT);
		nameField.setForeground(FOREGROUND_COLOR_TEXT);
		nameField.setColumns(20);
		nameField.setBackground(Color.WHITE);
		nameField.setPreferredSize(new Dimension(100, 45));
		nameField.setBorder(new SearchBorder(10, BORDER_COLOR, false));
	}

	private JPanel createListButtonPanel() {
		JPanel listPanel = new JPanel(new BorderLayout());
		JPanel buttonPanel = new JPanel(new FlowLayout());

		buttonPanel.add(removeButton);
		buttonPanel.add(editButton);

		listPanel.add(buttonPanel, BorderLayout.NORTH);
		listPanel.add(createBuildingsPanel(), BorderLayout.CENTER);

		return listPanel;
	}

	private JScrollPane createBuildingsPanel() {
		JScrollPane ingredientListPanel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ingredientListPanel.setBackground(BG_COLOR);
		ingredientListPanel.setOpaque(true);
		ingredientListPanel.setPreferredSize(new Dimension(258, 130));

		ingredientListPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

		ingredientListPanel.setViewportView(buildings);

		return ingredientListPanel;
	}

	private JPanel createParameterPanel() {
		JPanel parameterPanel = new JPanel(new GridLayout(3, 1));

		parameterPanel.add(postalCodeField);
		parameterPanel.add(nameField);
		parameterPanel.add(addButton);

		return parameterPanel;
	}

	public Building getSelectedValue() {
		return buildings.getSelectedValue();
	}

	public void updateValue(Building oldValue, Building newValue) {
		listModel.removeElement(oldValue);
		listModel.addElement(newValue);
	}

}