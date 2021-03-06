package eus.cic.core.app.utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import eus.cic.core.app.interfaces.IClickable;

public class DoubleClickListener extends MouseAdapter {
	
	IClickable component;
	 

	public DoubleClickListener(IClickable component) {
		this.component = component;
	}

	public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();
            component.clicked();
        }
    }
}