package eus.cic.core.app.lists.building;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import eus.cic.core.models.Building;

public class BuildingList extends AbstractListModel<Building> {

	List<Building> list;

	public BuildingList() {
		list = new ArrayList<>();
	}

	public void setList(List<Building> list) {
		this.list = list;
	}

	public void addElement(Building element) {
		if (element != null) {
			list.add(element);
			this.fireContentsChanged(this, 0, list.size() - 1);
		}
	}

	public void removeElement(Building element) throws IndexOutOfBoundsException {
		if (element != null) {
			list.remove(list.indexOf(element));
			this.fireContentsChanged(this, 0, list.size() - 1);
		}
	}

	public List<Building> getList() {
		return list;
	}

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public Building getElementAt(int index) {
		return list.get(index);
	}

}
