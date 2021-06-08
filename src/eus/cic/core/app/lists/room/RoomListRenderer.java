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
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JLabel building = new JLabel("Edificio: " + value.getBuilding());
		building.setFont(FONT);
		JLabel floor = new JLabel("Planta: " + value.getFloor());
		floor.setFont(FONT);
		JLabel description = new JLabel("Descripcion: " + value.getDescription());
		description.setFont(FONT);
		
		panel.setBackground(BG_COLOR);
		panel.setOpaque(true);
		
		panel.add(building);
		panel.add(floor);
		panel.add(description);
		
		return panel;
	}

}
