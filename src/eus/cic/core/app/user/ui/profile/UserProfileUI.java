package eus.cic.core.app.user.ui.profile;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import eus.cic.core.app.lists.room.RoomList;
import eus.cic.core.app.lists.room.RoomListRenderer;
import eus.cic.core.models.Room;

public class UserProfileUI extends JPanel {
	
	JList<Room> rooms;
	RoomList listModel;
	RoomListRenderer renderer;
	
	private static final Font TITLE_FONT = new Font("Calibri", Font.BOLD, 24);
	private static final Font FIELD_FONT = new Font("Calibri", Font.PLAIN, 18);
	
	private static final String NAME_STRING = "Nombre: ";
	private static final String SURNAME_STRING = "Apellido: ";
	private static final String DEPARTMENT_STRING = "Departamento: ";
	private static final String PHONE_NUMBER_STRING = "Telefono: ";
	private static final String MAIL_STRING = "Email: ";
	private static final String ID_STRING = "DNI/ID: ";
	private static final String TYPE_STRING = "Tipo: ";
	
	private static final String DATA_PANEL_TITLE_STRING = "Datos";
	private static final String ROOM_LIST_PANEL_TITLE_STRING = "Datos";
	
	private static final Color BG_COLOR = Color.white;
	private static final Color FOREGROUND_COLOR_TEXT = new Color(38, 38, 38);
	private static final Color BORDER_COLOR = new Color(166, 166, 166);
	
	JLabel nameLabel, surnameLabel, departmentLabel, PhoneNumberLabel, mailLabel, iDLabel, typeLabel;
	JLabel titleData, titleList;
	
	public UserProfileUI() {
		super(new GridLayout(1, 2));
		this.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		this.setBackground(BG_COLOR);
		this.setOpaque(true);
		
		initJList();
		initLabels();
		
		this.add(createTitledDataPanel());
		this.add(createTitledListPanel());
	}

	private Component createTitledListPanel() {
		JPanel titledPanel = new JPanel(new BorderLayout());
		
		titledPanel.add(createRoomListPanel(), BorderLayout.CENTER);
		titledPanel.add(createTitlePanel(titleList), BorderLayout.NORTH);
		
		return titledPanel;
	}

	private Component createTitledDataPanel() {
		JPanel titledPanel = new JPanel(new BorderLayout());
		
		
		titledPanel.add(createUserDataPanel(), BorderLayout.CENTER);
		titledPanel.add(createTitlePanel(titleData), BorderLayout.NORTH);
		
		return titledPanel;
	}

	private Component createTitlePanel(JLabel titleLabel) {
		JPanel titlePanel = new JPanel(new FlowLayout());
		titlePanel.setBackground(BG_COLOR);
		titlePanel.setOpaque(true);
		
		titlePanel.add(titleLabel);
		titlePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_COLOR));
		
		return titlePanel;
	}

	private Component createRoomListPanel() 
	{
		JScrollPane roomListPanel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		roomListPanel.setBackground(BG_COLOR);
		roomListPanel.setOpaque(true);
		
		roomListPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		roomListPanel.setViewportView(rooms);
		
		return roomListPanel;
	}

	private Component createUserDataPanel() {
		JPanel dataPanel = new JPanel(new GridLayout(7, 1));
		dataPanel.setBackground(BG_COLOR);
		dataPanel.setOpaque(true);
		
		dataPanel.add(nameLabel);
		dataPanel.add(surnameLabel);
		dataPanel.add(departmentLabel);
		dataPanel.add(PhoneNumberLabel);
		dataPanel.add(mailLabel);
		dataPanel.add(iDLabel);
		dataPanel.add(typeLabel);
		
		return dataPanel;
	}

	private void initLabels() {
		nameLabel = new JLabel(NAME_STRING);
		nameLabel.setFont(FIELD_FONT);
		nameLabel.setForeground(FOREGROUND_COLOR_TEXT);
		
		surnameLabel = new JLabel(SURNAME_STRING);
		surnameLabel.setFont(FIELD_FONT);
		surnameLabel.setForeground(FOREGROUND_COLOR_TEXT);
		
		departmentLabel = new JLabel(DEPARTMENT_STRING);
		departmentLabel.setFont(FIELD_FONT);
		departmentLabel.setForeground(FOREGROUND_COLOR_TEXT);
		
		PhoneNumberLabel = new JLabel(PHONE_NUMBER_STRING);
		PhoneNumberLabel.setFont(FIELD_FONT);
		PhoneNumberLabel.setForeground(FOREGROUND_COLOR_TEXT);
		
		mailLabel = new JLabel(MAIL_STRING);
		mailLabel.setFont(FIELD_FONT);
		mailLabel.setForeground(FOREGROUND_COLOR_TEXT);
		
		iDLabel = new JLabel(ID_STRING);
		iDLabel.setFont(FIELD_FONT);
		iDLabel.setForeground(FOREGROUND_COLOR_TEXT);
		
		typeLabel = new JLabel(TYPE_STRING);
		typeLabel.setFont(FIELD_FONT);
		typeLabel.setForeground(FOREGROUND_COLOR_TEXT);
		
		titleData = new JLabel(DATA_PANEL_TITLE_STRING);
		titleData.setFont(TITLE_FONT);
		titleData.setForeground(FOREGROUND_COLOR_TEXT);
		
		titleList = new JLabel(ROOM_LIST_PANEL_TITLE_STRING);
		titleList.setFont(TITLE_FONT);
		titleList.setForeground(FOREGROUND_COLOR_TEXT);
		
	}

	private void initJList() {
		rooms = new JList<>();
		listModel = new RoomList();
		renderer = new RoomListRenderer();
		
		rooms.setModel(listModel);
		rooms.setCellRenderer(renderer);
	}

}
