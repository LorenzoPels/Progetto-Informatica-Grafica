
package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class MainGUI extends JFrame {
private BoardPanel panel;
private final static int larghezza = 750;
private final static int altezza = 730;
private RightPanel rightpanel;


MainGUI() {
 
super("Magic Touch Game");
//MainGUI maingui = new MainGUI();
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setPreferredSize(new Dimension(larghezza,altezza));
this.createPanel();
panel = new BoardPanel();
add(panel);
setResizable(true);
pack();
setLocationRelativeTo(null);

}
private void createPanel() {
		//this.addComponentListener(this);
		//this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		//this.setPreferredSize(new Dimension(WINDOW_PREFERRED_WIDTH, WINDOW_PREFERRED_HEIGHT));
		this.rightpanel = new RightPanel();
		//this.setRightPanel();
		Container contPane = this.getContentPane();
		contPane.setLayout(new BorderLayout());
		contPane.add(this.rightpanel,BorderLayout.EAST);
		//contPane.add(rightpanel, BorderLayout.EAST);
		//this.pack();
	}

/*public static void makeGUI() {
MainGUI mg = new MainGUI();
mg.setPreferredSize(new Dimension(400,800));
mg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

mg.setVisible(true);
}*/

public static void main(String[] args) {
try {
javax.swing.SwingUtilities.invokeLater(new Runnable() {
public void run() {
new MainGUI().setVisible(true);
}
});
} catch(Exception e) {}
}
}