
package view;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class MainGUI extends JFrame {
private BoardPanel panel;
private final static int larghezza = 600;
private final static int altezza = 700;

MainGUI() {
 
super("Esempio Animazione");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setPreferredSize(new Dimension(larghezza,altezza));
panel = new BoardPanel();
add(panel);
setResizable(true);
pack();
setLocationRelativeTo(null);
}

/*public static void makeGUI() {
MainGUI mg = new MainGUI();
mg.setPreferredSize(new Dimension(400,800));
mg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

mg.setVisible(true);
}*/

public static void main(String[] args) {
try {
javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
public void run() {
new MainGUI().setVisible(true);
}
});
} catch(Exception e) {}
}
}