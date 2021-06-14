package eus.cic.core.app.lists.room;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import eus.cic.core.models.Room;

public class RoomList extends AbstractListModel<Room> {
	
	private static final long serialVersionUID = -8092307996227708108L;
	List<Room> list;
	
	public RoomList() {
		list = new ArrayList<>();
	}
	
	public void setList(List<Room> list) {
		this.list = list;
	}
	
	public void addElement(Room element) {
		if(element != null) {
			list.add(element);
			this.fireContentsChanged(this, 0, list.size() - 1);
		}
	}
	
	public void removeElement(Room element) throws IndexOutOfBoundsException{
		if (element != null) {
			list.remove(list.indexOf(element));
			this.fireContentsChanged(this, 0, list.size() - 1);
		}
	}
	
	public List<Room> getList(){
		return list;
	}
	
	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public Room getElementAt(int index) {
		return list.get(index);
	}
}
