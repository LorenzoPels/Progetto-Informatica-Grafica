
package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import view.BoardPanel;

public class Pioggia extends JPanel implements ActionListener{
    
    private Image cavaliere;
    private Timer timer;
    private int x, y;
    private final int PAUSE = 10;
    private final int MOVIMENTO = 1;
    private boolean motionControl;
    
    public Pioggia(){
        super();
        try {
            cavaliere = ImageIO.read(new File("src/Cavalieri/cavaliere.png"));
        }catch (IOException ex) {}
         
        x = 200;
        y = -40;
        
        timer = new Timer(PAUSE, this);
        timer.start();
                
    }
        @Override
	public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            
            g.drawImage(cavaliere,x,y,null);
            
	}

      @Override
    public void actionPerformed(ActionEvent e) {
        
        boolean motionControll = true;
        
        y += (motionControl) ? -MOVIMENTO : MOVIMENTO;

       if (y == getHeight()-145)
           y=-40;
        

        repaint();
    }

    
    
}
