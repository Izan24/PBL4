package eus.cic.core.app.admin.ui.building;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import eus.cic.core.models.Building;

public class BuildingListRenderer implements ListCellRenderer<Building>{

	@Override
	public Component getListCellRendererComponent(JList<? extends Building> list, Building value, int index,
			boolean isSelected, boolean cellHasFocus) {
		JPanel panel = new JPanel(new FlowLayout());
		JLabel buildingName = new JLabel(value.getNombre());
		
		
		if (isSelected) panel.setBackground(Color.LIGHT_GRAY);
		else panel.setBackground(Color.WHITE);
		
		panel.add(buildingName);
		
		return panel;
	}

}
