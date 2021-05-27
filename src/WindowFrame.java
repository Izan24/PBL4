import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowFrame extends JFrame {

	private static final long serialVersionUID = 7864734956122358906L;

	public WindowFrame() {
		super("B-Chef");

		setWindow();

	}

	private void setWindow() {
		this.setSize(1275, 760);
		this.setLocation(300, 150);
		this.setResizable(true);
		this.setBackground(Color.white);
		
		this.setVisible(true);
		
		addPannel();
	}
	
	
	private void addPannel() {
		JPanel panelBotones = new JPanel(new GridBagLayout());
	}
	
	public static void main(String[] args) {
		new WindowFrame();
	}
}
