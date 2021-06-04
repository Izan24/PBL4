package eus.cic.core.app.admin.ui.building;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JList;
import javax.swing.JPanel;

import eus.cic.core.app.admin.controller.building.AdminBuildingController;
import eus.cic.core.app.utils.DoubleClickListener;
import eus.cic.core.app.utils.JSONParser;
import eus.cic.core.models.Building;

public class AdminBuildingUI extends JPanel{
	
	AdminBuildingController controller;
	
	JList<Building> buildings;
	BuildingList listModel;
	BuildingListRenderer renderer;
	DoubleClickListener clickListener;
	
	private static final Font TITLE_FONT = new Font("Calibri", Font.BOLD, 12);
	private static final Color BG_COLOR = Color.white;
	
	
	public AdminBuildingUI() {
		super(new GridLayout(1,2));
		
		this.setBackground(BG_COLOR);
		
		clickListener = new DoubleClickListener(controller);
		
		initJList();
			
		this.add(createListPanel());
		this.add(createParameterPanel());
	}


	private void initJList() {
		buildings = new JList<>();
		listModel = new BuildingList();
		listModel.setList(JSONParser.getBuildings());
		renderer = new BuildingListRenderer();

		buildings.setModel(listModel);
		buildings.setCellRenderer(renderer);
		buildings.addMouseListener(clickListener);
	}


	private JPanel createListPanel() {
		return null;
	}

	private JPanel createParameterPanel() {
		return null;
	}




}
