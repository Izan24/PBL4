package eus.cic.core.app.uicomponents.dialogs;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser extends JFileChooser {

	private static final long serialVersionUID = 1173315926850030299L;

	public FileChooser() {
		super();

		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG", "png", "JPG", "jpg");

		this.setFileFilter(filter);

		int returnVal = this.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " + this.getSelectedFile().getName());

		}
	}

}
