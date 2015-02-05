import java.awt.Dimension;

import javax.swing.JPanel;

public class Panel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Panel() {
		Dimension size = getPreferredSize();
		
		size.width = 10;
		setPreferredSize(size);
	}
}
