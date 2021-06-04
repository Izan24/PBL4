package eus.cic.core.app.admin.ui.building;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JList;
import javax.swing.JPanel;

import eus.cic.core.app.admin.controller.AdminBuildingController;
import eus.cic.core.models.Building;

public class AdminBuilding extends JPanel{
	
	AdminBuildingController controller;
	
	JList<Building> buildings;
	BuildingList listModel;
	BuildingListRenderer renderer;
	
	private static final Font TITLE_FONT = new Font("Calibri", Font.BOLD, 12);
	private static final Color BG_COLOR = Color.white;
	
	
	public AdminBuilding() {
		super(new GridLayout(1,2));
		
		this.setBackground(BG_COLOR);
		
		initJList();
			
		this.add(createListPanel());
		this.add(createParameterPanel());
	}


	private void initJList() {
		buildings = new JList<>();
		listModel = new BuildingList();
		//listModel.setList(JSONCalls.getPage(0));
		renderer = new BuildingListRenderer();

		buildings.setModel(listModel);
		buildings.setCellRenderer(renderer);
		//buildings.addMouseListener(listener);
	}


	private JPanel createListPanel() {
		return null;
	}

	private JPanel createParameterPanel() {
		return null;
	}




}
