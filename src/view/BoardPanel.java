
package view;


import controller.ControllerForView;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Mago;

import model.Model;
//import static model.Model.xMago;
import static view.MainGUI.P;
import static view.MainGUI.diff;
import static view.MainGUI.pioggia;
import static view.MainGUI.t0;
import static view.MainGUI.t1;
import static view.MainGUI.int0;
import static view.MainGUI.int1;
import static view.MainGUI.int2;
import static view.MainGUI.int3;
import static view.MainGUI.int4;
import static view.MainGUI.isGameStarted;




public class BoardPanel extends JPanel implements KeyListener {
    BufferedImage sfondo;
    //public static BufferedImage[] arrayMago = new BufferedImage[3];
    //public static BufferedImage mago;
    public static int[] x = new int[5];
    public static int larghezza = 490;
    public static int altezza = 680;
    private final static Dimension PREFERRED_SIZE = new Dimension(larghezza,altezza);
    //int a=0;
    public static Mago maggo;
    BufferedImage a,b,c;

    public BoardPanel() {

        super();
        this.addKeyListener(this);
        try {
            sfondo = ImageIO.read(getClass().getResource("/immagini/Sfondo_senza_mago.png"));
         
            a = ImageIO.read(getClass().getResource("/immagini/Mago.png"));
            b = ImageIO.read(getClass().getResource("/immagini/MagoDx.png"));
            c = ImageIO.read(getClass().getResource("/immagini/MagoSx.png"));
                      
            maggo = new Mago(a,b,c);
            

        }catch (IOException ex) {
        }
        //setFocusable(true);
    }
        

    @Override
    public Dimension getPreferredSize() {
            return PREFERRED_SIZE;
    }
    

    @Override
    public void paintComponent(Graphics g) {

        //Model.getInstance().stampaMago();
        maggo.stampaMago();
        
        super.paintComponent(g);        
        g.drawImage(sfondo,0,0,getWidth(),getHeight(),null);
        g.drawImage( maggo.magoImg() ,maggo.getXMago() ,getHeight()-145,100,108,null);
        if(isGameStarted==true) {

            t1 = System.currentTimeMillis()-P;
            diff = t1 - t0;
            
            if( diff >=int0  )
                g.drawImage(pioggia[0],x[0],Model.getInstance().getY(0),150,180,null);
            if(diff >=int1)
                g.drawImage(pioggia[1],x[1],Model.getInstance().getY(1),150,180,null);
            if(diff >=int2)
                g.drawImage(pioggia[2],x[2],Model.getInstance().getY(2),150,180,null);
            if(diff >=int3)
                g.drawImage(pioggia[3],x[3],Model.getInstance().getY(3),150,180,null);
            if(diff >=int4)
                g.drawImage(pioggia[4],x[4],Model.getInstance().getY(4),150,180,null);
           
            Model.getInstance().resetOndata();           
            //Model.getInstance().movimentoBraccia();
            maggo.movimentoBraccia();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {
                    case KeyEvent.VK_A:

                        boolean cancelA = false;
                        ControllerForView.getInstance().Colpito(cancelA, "A");                       
                        break;


                    case KeyEvent.VK_B:
                        boolean cancelB = false;
                        ControllerForView.getInstance().Colpito(cancelB, "B");
                        break;


                    case KeyEvent.VK_F:
                        boolean cancelF = false;
                        ControllerForView.getInstance().Colpito(cancelF, "F");
                        break;


                    case KeyEvent.VK_H:
                        boolean cancelH = false;
                        ControllerForView.getInstance().Colpito(cancelH, "H");
                        break;


                    case KeyEvent.VK_J:
                        boolean cancelJ = false;
                        ControllerForView.getInstance().Colpito(cancelJ, "J");
                        break;


                    case KeyEvent.VK_K:
                        boolean cancelK = false;
                        ControllerForView.getInstance().Colpito(cancelK, "K");
                        break;


                    case KeyEvent.VK_L:
                        boolean cancelL = false;
                        ControllerForView.getInstance().Colpito(cancelL, "L");
                        break;


                    case KeyEvent.VK_M:
                        boolean cancelM = false;
                        ControllerForView.getInstance().Colpito(cancelM, "M");
                        break;


                    case KeyEvent.VK_P:
                        boolean cancelP = false;
                        ControllerForView.getInstance().Colpito(cancelP, "P");
                        break;


                    case KeyEvent.VK_Q:
                        boolean cancelQ = false;
                        ControllerForView.getInstance().Colpito(cancelQ, "Q");
                        break;
                        
                    case KeyEvent.VK_R:
                        boolean cancelR = false;
                        ControllerForView.getInstance().Colpito(cancelR, "R");
                        break;
                        
                    case KeyEvent.VK_U:
                        boolean cancelU = false;
                        ControllerForView.getInstance().Colpito(cancelU, "U");
                        break;
                        
                    case KeyEvent.VK_V:
                        boolean cancelV = false;
                        ControllerForView.getInstance().Colpito(cancelV, "V");
                        break;
                        
                    case KeyEvent.VK_W:
                        boolean cancelW = false;
                        ControllerForView.getInstance().Colpito(cancelW, "W");
                        break;
                        
                    case KeyEvent.VK_Y:
                        boolean cancelY = false;
                        ControllerForView.getInstance().Colpito(cancelY, "Y");
                        break;

           }

    }

    /* Invoked when a key has been released. */
    @Override
    public void keyReleased(KeyEvent e) {

    }

    /* Invoked when a key has been typed. */
    @Override
    public void keyTyped(KeyEvent e) {

    }
     
  
} // end class
