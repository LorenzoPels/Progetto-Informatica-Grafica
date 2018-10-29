
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
import static view.MainGUI.P;
import static view.MainGUI.diff;
import static view.MainGUI.pioggia;
import static view.MainGUI.t0;
import static view.MainGUI.t1;
import static view.MainGUI.y0;
import static view.MainGUI.y1;
import static view.MainGUI.y2;
import static view.MainGUI.y3;
import static view.MainGUI.y4;
import static view.MainGUI.int0;
import static view.MainGUI.int1;
import static view.MainGUI.int2;
import static view.MainGUI.int3;
import static view.MainGUI.int4;
import static view.MainGUI.index0;
import static view.MainGUI.index1;
import static view.MainGUI.index2;
import static view.MainGUI.index3;
import static view.MainGUI.index4;
import static view.MainGUI.isGameStarted;
import static view.MainGUI.movimento;
import static view.StartWindow.insane;
import static view.View.xMago;




public class BoardPanel extends JPanel implements KeyListener {
    BufferedImage sfondo;
    static BufferedImage[] arrayMago = new BufferedImage[3];
    static BufferedImage mago;
    private int count=0;
    //private long tmago;
    public static int[] x = new int[5];
    public static int larghezza = 490;
    public static int altezza = 680;
    private final static Dimension PREFERRED_SIZE = new Dimension(larghezza,altezza);
    int a=0;

    public BoardPanel() {

        super();
        this.addKeyListener(this);
        try {
            sfondo = ImageIO.read(getClass().getResource("/immagini/Sfondo_senza_mago.png"));
            arrayMago[0] = ImageIO.read(getClass().getResource("/immagini/Mago.png"));
            arrayMago[1] = ImageIO.read(getClass().getResource("/immagini/MagoDx.png"));
            arrayMago[2] = ImageIO.read(getClass().getResource("/immagini/MagoSx.png"));
            mago = arrayMago[0];

        }catch (IOException ex) {
        }
        //setFocusable(true);
    }
    
    public static void pioggiaRandom(){
        for(int i=0;i<pioggia.length;i++){
            x[i] = (int)(Math.random() * (larghezza-295)) % (larghezza-295);
            if(x[i]<148)
                x[i]+=148;
            if(i>0){
                if((x[i] > (x[i-1]-148)) && (x[i]<= x[i-1]))
                    x[i] = x[i-1]-148;
                if((x[i] < (x[i-1]+148)) && (x[i]>= x[i-1]))
                    x[i] = x[i-1]+148;
            } 
                
        }
        
    }

    @Override
    public Dimension getPreferredSize() {
            return PREFERRED_SIZE;
    }
    
    
    
    
    @Override
    public void paintComponent(Graphics g) {

        View.getInstance().stampaMago();
      
        super.paintComponent(g);        
        g.drawImage(sfondo,0,0,getWidth(),getHeight(),null);
        g.drawImage(mago,xMago,getHeight()-145,100,108,null);
        if(isGameStarted==true) {

            t1 = System.currentTimeMillis()-P;
            diff = t1 - t0;
            //System.out.println(diff);
            if( diff >=int0  )
                g.drawImage(pioggia[0],x[0],y0,150,180,null);
            if(diff >=int1)
                g.drawImage(pioggia[1],x[1],y1,150,180,null);
            if(diff >=int2)
                g.drawImage(pioggia[2],x[2],y2,150,180,null);
            if(diff >=int3)
                g.drawImage(pioggia[3],x[3],y3,150,180,null);
            if(diff >=int4)
                g.drawImage(pioggia[4],x[4],y4,150,180,null);
           // if( diff >=int5 )
            if(pioggia[0]== null && pioggia[1]== null && pioggia[2]== null && pioggia[3]== null && pioggia[4]== null  ){    
                t0=System.currentTimeMillis();
                P=0;
                MainGUI.Cavalieri();
                MainGUI.Pioggia();
                MainGUI.Esplosi();
                pioggiaRandom();
                y0=y1=y2=y3=y4=-100;
                index0=index1=index2=index3=index4=0; 
                if(int0>100)
                    int0-=100;
                if( (int1-int0) > 500 )
                    int1-=200;
                if( (int2-int1) > 500 )
                    int2-=200;
                if( (int3-int2) > 500 )
                    int3-=200;
                if( (int4-int3) > 500 )
                    int4-=200;
                // in questo modo movimento aumenta ogni due ondate 
                if(insane == true){                        //per ora non funziona 
                    if( movimento < 6 ){
                       // if( (movimento+a)%2 == 0)
                            a++;
                        /*else*/ movimento++;
                    }
                }else{
                    if( movimento < 4 ){
                        if( (movimento+a)%2 == 0)
                            a++;
                        else movimento++;               
                    }
                }
                
            }
            /*if((t1-tmago)>= 500)
                    mago = arrayMago[0];*/
            View.getInstance().movimentoBraccia();
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
