
package view;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.Cavaliere;
import model.Model;
import static view.MainGUI.MOVIMENTO;
import static view.MainGUI.P;
import static view.MainGUI.cavalieri;
import static view.MainGUI.clipPlayer;
import static view.MainGUI.diff;
import static view.MainGUI.giocoiniziato;
import static view.MainGUI.int1;
import static view.MainGUI.int2;
import static view.MainGUI.int3;
import static view.MainGUI.int4;
import static view.MainGUI.int5;
import static view.MainGUI.int6;
import static view.MainGUI.pioggia;
import static view.MainGUI.t0;
import static view.MainGUI.t1;
import static view.MainGUI.y1;
import static view.MainGUI.x;
import static view.MainGUI.y2;
import static view.MainGUI.y3;
import static view.MainGUI.y4;
import static view.MainGUI.y5;
import static view.RightPanel.updateScoreLabel;

public class BoardPanel extends JPanel implements /*ActionListener,*/KeyListener {
        BufferedImage sfondo;
        BufferedImage mago;
        //public static Image cavaliere;
       private Image cavaliere1;
	//---------------------------------------------------------------
	// STATIC CONSTANTS
	//---------------------------------------------------------------
	
	private final static Dimension PREFERRED_SIZE = new Dimension(490,680);
	private final static int X_MARGIN = 10;
	private final static int Y_MARGIN = 10;
        public Boolean[] esploso = new Boolean[5];
       

	public BoardPanel() {
		super();
                
		this.addKeyListener(this);
            try {
                sfondo = ImageIO.read(getClass().getResource("/immagini/Sfondo_senza_mago.png"));
                mago = ImageIO.read(getClass().getResource("/immagini/Mago.png"));
              
             
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
            
            super.paintComponent(g);
            g.drawImage(sfondo,0,0,getWidth(),getHeight(),null);
            g.drawImage(mago,getWidth()-350,getHeight()-145,100,108,null);
           if(giocoiniziato==true) {
                
                t1 = System.currentTimeMillis()-P;
                diff = t1 - t0;
                //System.out.println(diff);
                if( diff >=int1  )
                    g.drawImage(pioggia[0],x-100,y1,150,180,null);
                if(diff >=int2)
                    g.drawImage(pioggia[1],x+100,y2,150,180,null);
                if(diff >=int3)
                    g.drawImage(pioggia[2],x-200,y3,150,180,null);
                if(diff >=int4)
                    g.drawImage(pioggia[3],x+200,y4,150,180,null);
                if(diff >=int5)
                    g.drawImage(pioggia[4],x+250,y5,150,180,null);
                if( diff >=int6 )
                    if(/*y5>=getHeight()-340*/pioggia[4]==null){    
                        t0=System.currentTimeMillis();
                        P=0;
                        MainGUI.Cavalieri();
                        MainGUI.Pioggia();
                        y1=y2=y3=y4=y5=-100;
                        MOVIMENTO++;
                        int1+=-500;
                        int2+=-500;
                        int3+=-500;
                        int4+=-500;
                        int5+=-500;
                        int6+=-500;
                        
                    }
               //}*/
            }
	}


	//-------------------------------------------------------------------------
	// To implement the interface java.awt.event.KeyListener
	//-------------------------------------------------------------------------
	/* Invoked when a key has been pressed. */
        @Override
	public void keyPressed(KeyEvent e) {
                
		switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
                            
                            boolean cancelA = false;
                            for(int i =0;i<cavalieri.length;i++){
                                if(cavalieri[i].getName()== "A" && cancelA==false){
                                    pioggia[i] = null;
                                    cavalieri[i] = null;
                                    cavalieri[i]=Cavaliere.nextFallingPiece();
                                    clipPlayer.play();
                                    Model.getInstance().incrementScore();
                                    updateScoreLabel(Model.getInstance().getScore());
                                    cancelA = true;
                                }
                            }
                            break;
                
                         
                        case KeyEvent.VK_B:
                            boolean cancelB = false;
                            for(int i =0;i<cavalieri.length;i++){
                                if(cavalieri[i].getName()== "B" && cancelB==false){
                                    pioggia[i] = null;
                                    cavalieri[i] = null;
                                    cavalieri[i]=Cavaliere.nextFallingPiece();
                                    clipPlayer.play();
                                    Model.getInstance().incrementScore();
                                    updateScoreLabel(Model.getInstance().getScore());
                                    cancelB = true;
                                }
                            }
                            break;
                
                          
                        case KeyEvent.VK_F:
                            boolean cancelF = false;
                            for(int i =0;i<cavalieri.length;i++){
                                if(cavalieri[i].getName()== "F" && cancelF==false){
                                    pioggia[i] = null;
                                    cavalieri[i] = null;
                                    cavalieri[i]=Cavaliere.nextFallingPiece();
                                    clipPlayer.play();
                                    Model.getInstance().incrementScore();
                                    updateScoreLabel(Model.getInstance().getScore());
                                    cancelF = true;
                                }
                            }
                            break;
                
                        
                        case KeyEvent.VK_H:
                            boolean cancelH = false;
                            for(int i =0;i<cavalieri.length;i++){
                                if(cavalieri[i].getName()== "H" && cancelH==false){
                                    pioggia[i] = null;
                                    cavalieri[i] = null;
                                    cavalieri[i]=Cavaliere.nextFallingPiece();
                                    clipPlayer.play();
                                    Model.getInstance().incrementScore();
                                    updateScoreLabel(Model.getInstance().getScore());
                                    cancelH = true;
                                }
                            }
                            break;
                
                           
                        case KeyEvent.VK_J:
                            boolean cancelJ = false;
                            for(int i =0;i<cavalieri.length;i++){
                                if(cavalieri[i].getName()== "J" && cancelJ==false){
                                    pioggia[i] = null;
                                    cavalieri[i] = null;
                                    cavalieri[i]=Cavaliere.nextFallingPiece();
                                    clipPlayer.play();
                                    Model.getInstance().incrementScore();
                                    updateScoreLabel(Model.getInstance().getScore());
                                   cancelJ = true;
                                }
                            }
                            break;
                
                           
                        case KeyEvent.VK_K:
                            boolean cancelK = false;
                            for(int i =0;i<cavalieri.length;i++){
                                if(cavalieri[i].getName()== "K" && cancelK==false){
                                    pioggia[i] = null;
                                    cavalieri[i] = null;
                                    cavalieri[i]=Cavaliere.nextFallingPiece();
                                    clipPlayer.play();
                                    Model.getInstance().incrementScore();
                                    updateScoreLabel(Model.getInstance().getScore());
                                    cancelK = true;
                                }
                            }
                            break;
                    
                        
                        case KeyEvent.VK_L:
                            boolean cancelL = false;
                            for(int i =0;i<cavalieri.length;i++){
                                if(cavalieri[i].getName()== "L" && cancelL==false){
                                    pioggia[i] = null;
                                    cavalieri[i] = null;
                                    cavalieri[i]=Cavaliere.nextFallingPiece();
                                    clipPlayer.play();
                                    Model.getInstance().incrementScore();
                                    updateScoreLabel(Model.getInstance().getScore());
                                   cancelL = true;
                                }
                            }
                            break;
                    
                           
                        case KeyEvent.VK_M:
                            boolean cancelM = false;
                            for(int i =0;i<cavalieri.length;i++){
                                if(cavalieri[i].getName()== "M" && cancelM==false){
                                    pioggia[i] = null;
                                    cavalieri[i] = null;
                                    cavalieri[i]=Cavaliere.nextFallingPiece();
                                    clipPlayer.play();
                                    Model.getInstance().incrementScore();
                                    updateScoreLabel(Model.getInstance().getScore());
                                    cancelM = true;
                                }
                            }
                            break;
                    
                          
                        case KeyEvent.VK_P:
                            boolean cancelP = false;
                            for(int i =0;i<cavalieri.length;i++){
                                if(cavalieri[i].getName()== "P" && cancelP==false){
                                    pioggia[i] = null;
                                    cavalieri[i] = null;
                                    cavalieri[i]=Cavaliere.nextFallingPiece();
                                    clipPlayer.play();
                                    Model.getInstance().incrementScore();
                                    updateScoreLabel(Model.getInstance().getScore());
                                    cancelP = true;
                                }
                            }
                            break;
                    
                           
                        case KeyEvent.VK_Q:
                            boolean cancelQ = false;
                            for(int i =0;i<cavalieri.length;i++){
                                if(cavalieri[i].getName()== "Q" && cancelQ==false){
                                    pioggia[i] = null;
                                    cavalieri[i] = null;
                                    cavalieri[i]=Cavaliere.nextFallingPiece();
                                    clipPlayer.play();
                                    Model.getInstance().incrementScore();
                                    updateScoreLabel(Model.getInstance().getScore());
                                    cancelQ = true;
                                }
                            }
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
