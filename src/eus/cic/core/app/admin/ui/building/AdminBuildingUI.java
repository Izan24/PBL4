package eus.cic.core.app.admin.ui.building;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import eus.cic.core.app.admin.controller.building.AdminBuildingController;
import eus.cic.core.app.admin.controller.building.AdminBuildingControllerAC;
import eus.cic.core.app.lists.building.BuildingList;
import eus.cic.core.app.lists.building.BuildingListRenderer;
import eus.cic.core.app.main.PrincipalWindow;
import eus.cic.core.app.uicomponents.borders.SearchBorder;
import eus.cic.core.app.uicomponents.components.MDButton;
import eus.cic.core.app.uicomponents.components.RoundedTextField;
import eus.cic.core.app.utils.APIRequests;
import eus.cic.core.app.utils.DoubleClickListener;
import eus.cic.core.models.Building;

public class AdminBuildingUI extends JPanel {

	private static final long serialVersionUID = 9077417933852726948L;

	AdminBuildingController controller;

	JList<Building> buildings;
	BuildingList listModel;
	BuildingListRenderer renderer;

	DoubleClickListener clickListener;

	private static final String ADD_STRING = "A�adir";
	private static final String REMOVE_STRING = "-";
	private static final String EDIT_STRING = "...";
	private static final String TITLE_STRING = "Edificios";
	private static final String NAME_STRING = "Nombre:";
	private static final String PCODE_STRING = "Codigo postal:";

	private static final Font TITLE_FONT = new Font("Calibri", Font.BOLD, 45);
	private static final Font FIELD_FONT = new Font("Calibri", Font.PLAIN, 18);

	private static final Color BG_COLOR = Color.white;
	private static final Color ADD_COLOR = new Color(69, 183, 148);
	private static final Color REMOVE_COLOR = new Color(253, 85, 85);
	private static final Color EDIT_COLOR = new Color(255, 217, 102);
	private static final Color FOREGROUND_COLOR_TEXT = new Color(38, 38, 38);
	private static final Color BORDER_COLOR = new Color(166, 166, 166);

	JLabel titleLabel, nameLabel, postalCodeLabel;
	JTextField postalCodeField, nameField;
	MDButton addButton, removeButton, editButton;

	public AdminBuildingUI(PrincipalWindow window) {
		super(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		this.setBackground(BG_COLOR);
		this.setOpaque(true);

		controller = new AdminBuildingController(this, window);
		clickListener = new DoubleClickListener(controller);

		initJList();
		initJLabels();
		initButtons();
		initTextFields();

		this.add(createListButtonPanel(), BorderLayout.CENTER);
		this.add(createParameterPanel(), BorderLayout.EAST);
		this.add(createTitlePanel(), BorderLayout.NORTH);
	}

	private void initJList() {
		buildings = new JList<>();
		listModel = new BuildingList();

		try {
			listModel.setList(APIRequests.getBuildings());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		renderer = new BuildingListRenderer();

		buildings.setModel(listModel);
		buildings.setCellRenderer(renderer);
		buildings.addMouseListener(clickListener);
		buildings.addKeyListener(controller);
	}

	private void initJLabels() {
		titleLabel = new JLabel(TITLE_STRING);
		titleLabel.setFont(TITLE_FONT);

		nameLabel = new JLabel(NAME_STRING);
		nameLabel.setFont(FIELD_FONT);

		postalCodeLabel = new JLabel(PCODE_STRING);
		postalCodeLabel.setFont(FIELD_FONT);
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
		postalCodeField = new RoundedTextField();
		postalCodeField.setFont(FIELD_FONT);
		postalCodeField.setForeground(FOREGROUND_COLOR_TEXT);
		postalCodeField.setColumns(20);
		postalCodeField.setBackground(Color.WHITE);
		postalCodeField.setPreferredSize(new Dimension(100, 45));
		postalCodeField.setBorder(new SearchBorder(10, BORDER_COLOR, false));
		postalCodeField.addKeyListener(controller);

		nameField = new RoundedTextField();
		nameField.setFont(FIELD_FONT);
		nameField.setForeground(FOREGROUND_COLOR_TEXT);
		nameField.setColumns(20);
		nameField.setBackground(Color.WHITE);
		nameField.setPreferredSize(new Dimension(100, 45));
		nameField.setBorder(new SearchBorder(10, BORDER_COLOR, false));
		nameField.addKeyListener(controller);
	}

	private JPanel createListButtonPanel() {
		JPanel listPanel = new JPanel(new BorderLayout());

		listPanel.add(createButtonPanel(), BorderLayout.NORTH);
		listPanel.add(createBuildingsPanel(), BorderLayout.CENTER);

		return listPanel;
	}

	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel(new BorderLayout());
		JPanel buttons = new JPanel(new FlowLayout());
		buttonPanel.setBackground(BG_COLOR);
		buttons.setBackground(BG_COLOR);

		buttons.add(removeButton);
		buttons.add(editButton);

		buttonPanel.add(buttons, BorderLayout.EAST);

		return buttonPanel;
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
		JPanel contentPanel = new JPanel(new GridBagLayout());

		contentPanel.setBackground(BG_COLOR);
		contentPanel.setBorder(BorderFactory.createEmptyBorder(60, 40, 60, 40));

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weighty = 1;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;

		contentPanel.add(createPostalCodePanel(), constraints);
		constraints.gridy = 1;
		contentPanel.add(createNamePanel(), constraints);
		constraints.gridy = 2;
		contentPanel.add(addButton, constraints);

		return contentPanel;
	}

	private JPanel createPostalCodePanel() {
		JPanel postalCodePanel = new JPanel(new GridLayout(2, 1));
		postalCodePanel.setBackground(BG_COLOR);

		postalCodePanel.add(postalCodeLabel);
		postalCodePanel.add(postalCodeField);

		return postalCodePanel;
	}

	private JPanel createNamePanel() {
		JPanel namePanel = new JPanel(new GridLayout(2, 1));
		namePanel.setBackground(BG_COLOR);

		namePanel.add(nameLabel);
		namePanel.add(nameField);

		return namePanel;
	}

	private Component createTitlePanel() {
		JPanel titlePanel = new JPanel(new BorderLayout());
		titlePanel.setBackground(BG_COLOR);
		titlePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0),
				BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_COLOR)));

		titlePanel.add(titleLabel, BorderLayout.WEST);

		return titlePanel;
	}

	public Building getSelectedValue() {
		return buildings.getSelectedValue();
	}

	public String getName() {
		return nameField.getText();
	}

	public String getPostalCode() {
		return postalCodeField.getText();
	}

	public void setNameField(String text) {
		nameField.setText(text);
	}

	public void setPostalCodeField(String text) {
		postalCodeField.setText(text);
	}

	public void addBuilding(Building building) {
		listModel.addElement(building);
	}

	public void removeBuilding() {
		listModel.removeElement(buildings.getSelectedValue());
	}

	public void updateBuilding(Building oldValue, Building newValue) {
		listModel.removeElement(oldValue);
		listModel.addElement(newValue);
	}

	public void resetFields() {
		nameField.setText("");
		postalCodeField.setText("");
	}

}