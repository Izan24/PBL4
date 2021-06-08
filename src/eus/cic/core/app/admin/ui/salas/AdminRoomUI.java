package eus.cic.core.app.admin.ui.salas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import eus.cic.core.app.admin.controller.building.AdminBuildingController;
import eus.cic.core.app.admin.controller.building.AdminBuildingControllerAC;
import eus.cic.core.app.admin.controller.rooms.AdminRoomController;
import eus.cic.core.app.lists.building.BuildingList;
import eus.cic.core.app.lists.building.BuildingListRenderer;
import eus.cic.core.app.lists.room.RoomList;
import eus.cic.core.app.lists.room.RoomListRenderer;
import eus.cic.core.app.main.PrincipalWindow;
import eus.cic.core.app.uicomponents.borders.SearchBorder;
import eus.cic.core.app.uicomponents.components.MDButton;
import eus.cic.core.app.uicomponents.components.RoundedTextField;
import eus.cic.core.app.utils.DoubleClickListener;
import eus.cic.core.models.Building;
import eus.cic.core.models.Room;

public class AdminRoomUI extends JPanel {
	AdminRoomController controller;

	JList<Room> rooms;
	RoomList listModel;
	RoomListRenderer renderer;

	DoubleClickListener clickListener;

	private static final String ADD_STRING = "Añadir";
	private static final String REMOVE_STRING = "-";
	private static final String EDIT_STRING = "...";
	private static final String TITLE_STRING = "Salas";
	private static final String DESCRIPTION_STRING = "Descripcion:";
	private static final String BUILDING_STRING = "Edificio:";
	private static final String FLOOR_STRING = "Piso:";

	private static final Font TITLE_FONT = new Font("Calibri", Font.BOLD, 45);
	private static final Font FIELD_FONT = new Font("Calibri", Font.PLAIN, 18);

	private static final Color BG_COLOR = Color.white;
	private static final Color ADD_COLOR = new Color(69, 183, 148);
	private static final Color REMOVE_COLOR = new Color(253, 85, 85);
	private static final Color EDIT_COLOR = new Color(255, 217, 102);
	private static final Color FOREGROUND_COLOR_TEXT = new Color(38, 38, 38);
	private static final Color BORDER_COLOR = new Color(166, 166, 166);

	JLabel titleLabel, floorLabel, descriptionLabel, buildingLabel;
	JTextField descriptionField, floorField;
	JComboBox<Building> buildingBox;
	MDButton addButton, removeButton, editButton;

	public AdminRoomUI(PrincipalWindow window) {
		super(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		this.setBackground(BG_COLOR);
		this.setOpaque(true);

		controller = new AdminRoomController(this, window);
		clickListener = new DoubleClickListener(controller);

		initJList();
		initJLabels();
		initButtons();
		initComboBox();
		initTextFields();

		this.add(createListButtonPanel(), BorderLayout.CENTER);
		this.add(createParameterPanel(), BorderLayout.EAST);
		this.add(createTitlePanel(), BorderLayout.NORTH);
	}

	private void initJList() {
		rooms = new JList<>();
		listModel = new RoomList();
		// listModel.setList(JSONCalls.getRooms());
		renderer = new RoomListRenderer();

		rooms.setModel(listModel);
		rooms.setCellRenderer(renderer);
		rooms.addMouseListener(clickListener);
		rooms.addKeyListener(controller);
	}

	private void initJLabels() {
		titleLabel = new JLabel(TITLE_STRING);
		titleLabel.setFont(TITLE_FONT);

		descriptionLabel = new JLabel(DESCRIPTION_STRING);
		descriptionLabel.setFont(FIELD_FONT);

		buildingLabel = new JLabel(BUILDING_STRING);
		buildingLabel.setFont(FIELD_FONT);

		floorLabel = new JLabel(FLOOR_STRING);
		floorLabel.setFont(FIELD_FONT);
	}

	private void initButtons() {
		addButton = new MDButton(ADD_STRING, new Dimension(80, 40), ADD_COLOR, 10, controller,
				AdminBuildingControllerAC.ADD_BUILDING);
		removeButton = new MDButton(REMOVE_STRING, new Dimension(40, 40), REMOVE_COLOR, 10, controller,
				AdminBuildingControllerAC.REMOVE_BUILDING);
		editButton = new MDButton(EDIT_STRING, new Dimension(40, 40), EDIT_COLOR, 10, controller,
				AdminBuildingControllerAC.EDIT_BUILDING);
	}

	private void initComboBox() {
		// List<Room> rooms = Jsoncalls()..;
		// List<Room> rooms = new ArrayList<>();

		buildingBox = new JComboBox<>();
		// roomBox.add(rooms);
	}

	private void initTextFields() {
		descriptionField = new RoundedTextField();
		descriptionField.setFont(FIELD_FONT);
		descriptionField.setForeground(FOREGROUND_COLOR_TEXT);
		descriptionField.setColumns(20);
		descriptionField.setBackground(Color.WHITE);
		descriptionField.setPreferredSize(new Dimension(100, 45));
		descriptionField.setBorder(new SearchBorder(10, BORDER_COLOR, false));
		descriptionField.addKeyListener(controller);

		floorField = new RoundedTextField();
		floorField.setFont(FIELD_FONT);
		floorField.setForeground(FOREGROUND_COLOR_TEXT);
		floorField.setColumns(20);
		floorField.setBackground(Color.WHITE);
		floorField.setPreferredSize(new Dimension(100, 45));
		floorField.setBorder(new SearchBorder(10, BORDER_COLOR, false));
		floorField.addKeyListener(controller);
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

		ingredientListPanel.setViewportView(rooms);

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

		contentPanel.add(createDescriptionPanel(), constraints);
		constraints.gridy = 1;
		contentPanel.add(createBuildingNamePanel(), constraints);
		constraints.gridy = 2;
		contentPanel.add(addButton, constraints);

		return contentPanel;
	}

	private JPanel createDescriptionPanel() {
		JPanel postalCodePanel = new JPanel(new GridLayout(2, 1));
		postalCodePanel.setBackground(BG_COLOR);

		postalCodePanel.add(descriptionLabel);
		postalCodePanel.add(descriptionField);

		return postalCodePanel;
	}

	private JPanel createBuildingNamePanel() {
		JPanel namePanel = new JPanel(new GridLayout(1, 2));
		namePanel.setBackground(BG_COLOR);

		namePanel.add(createBuildingPanel());
		namePanel.add(createFloorPanel());

		return namePanel;
	}

	private JPanel createBuildingPanel() {
		JPanel buildingPanel = new JPanel(new GridLayout(2, 1));
		buildingPanel.setBackground(BG_COLOR);

		buildingPanel.add(buildingLabel);
		buildingPanel.add(buildingBox);

		return buildingPanel;
	}

	private JPanel createFloorPanel() {
		JPanel floorPanel = new JPanel(new GridLayout(2, 1));
		floorPanel.setBackground(BG_COLOR);

		floorPanel.add(floorLabel);
		floorPanel.add(floorField);

		return floorPanel;
	}

	private Component createTitlePanel() {
		JPanel titlePanel = new JPanel(new BorderLayout());
		titlePanel.setBackground(BG_COLOR);
		titlePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0),
				BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_COLOR)));

		titlePanel.add(titleLabel, BorderLayout.WEST);

		return titlePanel;
	}

	public Room getSelectedValue() {
		return rooms.getSelectedValue();
	}

	public String getDescription() {
		return descriptionField.getText();
	}

	public String getFloor() {
		return floorField.getText();
	}

	public void setDescriptionField(String text) {
		descriptionField.setText(text);
	}

	public void setFloorField(String text) {
		floorField.setText(text);
	}

	public void addRoom(Room room) {
		listModel.addElement(room);
	}

	public void removeRoom() {
		listModel.removeElement(rooms.getSelectedValue());
	}

	public void updateRoom(Room oldValue, Room newValue) {
		listModel.removeElement(oldValue);
		listModel.addElement(newValue);
	}

	public void resetFields() {
		descriptionField.setText("");
		floorField.setText("");
	}
}
