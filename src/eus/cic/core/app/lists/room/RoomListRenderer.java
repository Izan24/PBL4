package eus.cic.core.app.lists.room;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import eus.cic.core.models.Room;

public class RoomListRenderer implements ListCellRenderer<Room> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Room> list, Room value, int index, boolean isSelected,
			boolean cellHasFocus) {
		JPanel panel = new JPanel(new GridLayout());
		JLabel building = new JLabel("Edificio: " + value.getBuildingId());
		JLabel floor = new JLabel("Planta: " + value.getFloor());
		JLabel description = new JLabel("Descripcion: " + value.getDescription());
		
		panel.add(building);
		panel.add(floor);
		panel.add(description);
		
		return panel;
	}

}
