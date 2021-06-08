package eus.cic.core.app.lists.room;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import eus.cic.core.models.Room;

public class RoomListRenderer implements ListCellRenderer<Room> {
	
	private static final Color BG_COLOR = Color.white;
	public static final Font FONT = new Font("Calibri", Font.PLAIN, 22);

	@Override
	public Component getListCellRendererComponent(JList<? extends Room> list, Room value, int index, boolean isSelected,
			boolean cellHasFocus) {
		JPanel panel = new JPanel(new GridLayout(3, 1));
		JLabel building = new JLabel("Edificio: " + value.getBuilding());
		JLabel floor = new JLabel("Planta: " + value.getFloor());
		JLabel description = new JLabel("Descripcion: " + value.getDescription());

		building.setFont(FONT);
		floor.setFont(FONT);
		description.setFont(FONT);
		
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setOpaque(true);
		
		panel.add(building);
		panel.add(floor);
		panel.add(description);
		
		if(isSelected) panel.setBackground(Color.LIGHT_GRAY);
		else panel.setBackground(BG_COLOR);
		
		return panel;
	}

}
