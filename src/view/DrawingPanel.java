
package view;

import java.awt.Graphics;
import javax.swing.JPanel;


public class DrawingPanel extends JPanel {
   
    private AbstractDrawing dw = null;

    public void setDrawing(AbstractDrawing dw) {
        this.dw = dw;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /* add instructions for your specific drawing */
        dw.draw(g);
    }

} // end class
    
