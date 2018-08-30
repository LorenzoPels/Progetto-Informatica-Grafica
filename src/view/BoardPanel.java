
package view;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.Model;
import static view.MainGUI.MOVIMENTO;
import static view.MainGUI.P;
import static view.MainGUI.cavalieri;
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
        private Image cavaliere;
       private Image cavaliere1;
	//---------------------------------------------------------------
	// STATIC CONSTANTS
	//---------------------------------------------------------------
	
	private final static Dimension PREFERRED_SIZE = new Dimension(490,680);
	private final static int X_MARGIN = 10;
	private final static int Y_MARGIN = 10;
       

	public BoardPanel() {
		super();
                
		this.addKeyListener(this);
            try {
                sfondo = ImageIO.read(new File("src/immagini/Sfondo_senza_mago.png"));
                mago = ImageIO.read(new File("src/immagini/Mago.png"));
               // cavaliere = /*ImageIO.read(new File("src/Cavalieri/cavaliere.png"));*/Cavaliere.Loader();
               // cavaliere1 = Cavaliere.Loader();
             
            }catch (IOException ex) {
            }
       
            /*x = 200;
            y1 = 1;
            y2 = 1;
            y3 = 1;
            y4 = 1;
            y5 = 1;
        
            timer = new Timer(PAUSE, this);
            timer.start();
            Pioggia();
            //t0 = System.currentTimeMillis();
            variabile = (int)(Math.random() * pioggia.length) % pioggia.length;*/
            setFocusable(true);
                
	}
       /* public Image[] Pioggia(){
        
        pioggia[0] = Cavaliere.Loader();
        pioggia[1] = Cavaliere.Loader();
        pioggia[2] = Cavaliere.Loader();
        pioggia[3] = Cavaliere.Loader();
        pioggia[4] = Cavaliere.Loader();
        return pioggia;
        }
        
        public static Boolean InizioGioco(){
        giocoiniziato = true;
        t0 = System.currentTimeMillis();
        return giocoiniziato;
        
        
        
        }
        public static Boolean  PausaGioco(){
            timer.stop();
            giocoiniziato = false;
            Pi = System.currentTimeMillis();
            
            return giocoiniziato;
        } 
        public static Boolean  RiprendiGioco(){
            Pf = System.currentTimeMillis();
            P += Pf-Pi;
            timer.start();
            giocoiniziato = true;
            
            return giocoiniziato;
        } */
        
        
        

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
                
                //g.drawImage(cavaliere,x-150,y,null);
                
                //g.drawImage(cavaliere1,x+200,y,null);
                t1 = System.currentTimeMillis()-P;
                diff = t1 - t0;
              
              // for(int i=0;i<pioggia.length && stampaggio ==true ;i++){
                if( diff >=int1  )//3 secondi
                    g.drawImage(pioggia[0],x-100,y1,null);
                if(diff >=int2)//6 secondi
                    g.drawImage(pioggia[1],x+100,y2,null);
                if(diff >=int3)//9 secondi
                    g.drawImage(pioggia[2],x-200,y3,null);
                if(diff >=int4)//12 secondi
                    g.drawImage(pioggia[3],x+200,y4,null);
                if(diff >=int5)// 15secondi
                    g.drawImage(pioggia[4],x+250,y5,null);
                if( (diff >=int6) /*&& (diff<=30500) */  )//18 secondi
                    if(y5>=getHeight()-340){    
                        t0=System.currentTimeMillis();
                        MainGUI.Cavalieri();
                        MainGUI.Pioggia();
                        y1=y2=y3=y4=y5=-100;
                        MOVIMENTO++;
                        int1+=-300;
                        int2+=-500;
                        int3+=-300;
                        int4+=-600;
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
          /*  if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                Model.getInstance().incrementScore();
                updateScoreLabel(Model.getInstance().getScore());
                
            }*/
           
		switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
                            
                            for(int i =0;i<cavalieri.length;i++){
                                if(cavalieri[i].getName()== "A"){
                                    pioggia[i] = null;
                                    //cavalieri[i] = null;
                                    Model.getInstance().incrementScore();
                                    updateScoreLabel(Model.getInstance().getScore());
                                }
                            }
				
                                //this.repaint();
                               break;
                        case KeyEvent.VK_B:
				for(int i =0;i<cavalieri.length;i++){
                                    if(cavalieri[i].getName()== "B"){
                                        pioggia[i] = null;
                                        //cavalieri[i] = null;
                                        Model.getInstance().incrementScore();
                                        updateScoreLabel(Model.getInstance().getScore());
                                    }
                                } 
                                break;
                                
                        case KeyEvent.VK_F:
				for(int i =0;i<cavalieri.length;i++){
                                    if(cavalieri[i].getName()== "F"){
                                        pioggia[i] = null;
                                        //cavalieri[i] = null;
                                        Model.getInstance().incrementScore();
                                        updateScoreLabel(Model.getInstance().getScore());
                                    }
                                }
                                break;
                                
                        case KeyEvent.VK_H:
				for(int i =0;i<cavalieri.length;i++){
                                    if(cavalieri[i].getName()== "H"){
                                        pioggia[i] = null;
                                        //cavalieri[i] = null;
                                        Model.getInstance().incrementScore();
                                        updateScoreLabel(Model.getInstance().getScore());
                                    }
                                }
                                break;
                        case KeyEvent.VK_J:
				for(int i =0;i<cavalieri.length;i++){
                                    if(cavalieri[i].getName()== "J"){
                                        pioggia[i] = null;
                                        //cavalieri[i] = null;
                                        Model.getInstance().incrementScore();
                                        updateScoreLabel(Model.getInstance().getScore());
                                    }
                                } 
                                break;
                        case KeyEvent.VK_K:
				for(int i =0;i<cavalieri.length;i++){
                                    if(cavalieri[i].getName()== "K"){
                                        pioggia[i] = null;
                                        //cavalieri[i] = null;
                                        Model.getInstance().incrementScore();
                                        updateScoreLabel(Model.getInstance().getScore());
                                    }
                                }
                                break;
                        case KeyEvent.VK_L:
				for(int i =0;i<cavalieri.length;i++){
                                    if(cavalieri[i].getName()== "L"){
                                        pioggia[i] = null;
                                        //cavalieri[i] = null;
                                        Model.getInstance().incrementScore();
                                        updateScoreLabel(Model.getInstance().getScore());
                                    }
                                }
                                break;
                        case KeyEvent.VK_M:
				for(int i =0;i<cavalieri.length;i++){
                                    if(cavalieri[i].getName()== "M"){
                                        pioggia[i] = null;
                                        //cavalieri[i] = null;
                                        Model.getInstance().incrementScore();
                                        updateScoreLabel(Model.getInstance().getScore());
                                    }
                                } 
                                break;
                        case KeyEvent.VK_P:
				for(int i =0;i<cavalieri.length;i++){
                                    if(cavalieri[i].getName()== "P"){
                                        pioggia[i] = null;
                                        //cavalieri[i] = null;
                                        Model.getInstance().incrementScore();
                                        updateScoreLabel(Model.getInstance().getScore());
                                    }
                                }
                                break;
                        case KeyEvent.VK_Q:
				for(int i =0;i<cavalieri.length;i++){
                                    if(cavalieri[i].getName()== "Q"){
                                        pioggia[i] = null;
                                        //cavalieri[i] = null;
                                        Model.getInstance().incrementScore();
                                        updateScoreLabel(Model.getInstance().getScore());
                                    }
                                }
                                break;
               }
                       
	}

	/* Invoked when a key has been released. */
        @Override
	public void keyReleased(KeyEvent e) {
		// do nothing
	}

	/* Invoked when a key has been typed. */
        @Override
	public void keyTyped(KeyEvent e) {
		// do nothing
	}

   /* @Override
    public void actionPerformed(ActionEvent e) {
        
       if(diff>=int1){
            y1 += (motionControl1) ? MOVIMENTO: 0;
            if(y1 >= 0) motionControl1 = true;
            if(y1 >= getHeight()-340) motionControl1 = false;
        }
       
        if(diff>=int2){
            y2 += (motionControl2) ? MOVIMENTO: 0;
            if(y2 >= 0) motionControl2 = true;
            if(y2 >= getHeight()-340) motionControl2 = false;
        }
        
        if(diff>=int3){
            y3 += (motionControl3) ? MOVIMENTO: 0;
            if(y3 >= 0) motionControl3 = true;
            if(y3 >= getHeight()-340) motionControl3 = false;
        }
        
        if(diff>=int4){
            y4 += (motionControl4) ? MOVIMENTO:0;
            if(y4 >= 0) motionControl4 = true;
            if(y4 >= getHeight()-340) motionControl4 = false;
        }
        
        if(diff>=int5){
            y5 += (motionControl5) ? MOVIMENTO: 0;
            if(y5 >= 0) motionControl5 = true;
            if(y5 >= getHeight()-340) motionControl5 = false;
        }
        
        
        

        repaint();
    }*/

} // end class
