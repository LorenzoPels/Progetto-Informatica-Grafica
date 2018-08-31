
package view;

import controller.ControllerForView;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;
import model.Cavaliere;
import static model.Cavaliere.Loader;




class MainGUI extends JFrame implements ActionListener  {
public static BoardPanel panel;
private final static int larghezza = 750;
private final static int altezza = 730;
private RightPanel rightpanel;
private static Timer timer;
public static int x, y1,y2,y3,y4,y5;
private final int PAUSE = 10;
public static  int MOVIMENTO = 1;
private boolean motionControl1,motionControl2,motionControl3,motionControl4,motionControl5;

public static Boolean giocoiniziato = false;
public static Image[] pioggia = new Image[5];
public static Cavaliere[] cavalieri = new Cavaliere[5];
private int tempo;
private int variabile;
public static long t0,t1,P,Pi,Pf;
public static long diff;
public static int int1=1000;
public static int int2=3000;
public static int int3=4000;
public static int int4=7000;
public static int int5=8000;
public static int int6=10000;
//public static Boolean integro1,integro2,integro3,integro4,integro5 = true;
//public  Image cavaliere;

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
    x = 200;
    y1 = -100;
    y2 = -100;
    y3 = -100;
    y4 = -100;
    y5 = -100;

    timer = new Timer(PAUSE, this);
    //timer.start();
    //Cavalieri();
    //Pioggia();
    //t0 = System.currentTimeMillis();
    variabile = (int)(Math.random() * pioggia.length) % pioggia.length;
    //setFocusable(true);
            



}
public static Cavaliere[] Cavalieri(){
   cavalieri[0] = Cavaliere.nextFallingPiece();
   cavalieri[1] = Cavaliere.nextFallingPiece();
   cavalieri[2] = Cavaliere.nextFallingPiece();
   cavalieri[3] = Cavaliere.nextFallingPiece();
   cavalieri[4] = Cavaliere.nextFallingPiece();
   return cavalieri;
}


 public static Image[] Pioggia(){
    for(int i=0; i<cavalieri.length;i++)  
        pioggia[i] = Loader(cavalieri[i]);
    return pioggia;
    }
        
public static Boolean InizioGioco(){
        Cavalieri();
        Pioggia();
        timer.start();
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
            //t1 = System.currentTimeMillis()-P;
            return giocoiniziato;
        } 
        
private void createPanel() {
		//this.addComponentListener(this);
		//this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		//this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		//this.setPreferredSize(new Dimension(WINDOW_PREFERRED_WIDTH, WINDOW_PREFERRED_HEIGHT));
		this.rightpanel = new RightPanel();
		//this.setRightPanel();
		Container contPane = this.getContentPane();
		contPane.setLayout(new BorderLayout());
		contPane.add(this.rightpanel,BorderLayout.EAST);
		//contPane.add(rightpanel, BorderLayout.EAST);
		//this.pack();
	}


  @Override
    public void actionPerformed(ActionEvent e) {
        
       if(diff>=int1){
            y1 += (motionControl1) ? MOVIMENTO: /*-MOVIMENTO*/0;
            if(y1 >= -101) motionControl1 = true;
            if(y1 >= getHeight()-340) motionControl1 = false;
            /*if((y1 >= getHeight()-340) &&(pioggia[0]!= null) ){
                timer.stop();
                ControllerForView.getInstance().openGameOverDialog();
            }*/
        }
       
        if(diff>=int2){
            y2 += (motionControl2) ? MOVIMENTO: /*MOVIMENTO*/0;
            if(y2 >= -101) motionControl2 = true;
            if(y2 >= getHeight()-340) motionControl2 = false;
           /* if((y2 >= getHeight()-340) &&(pioggia[1]!= null) ){
                timer.stop();
                ControllerForView.getInstance().openGameOverDialog();
            }*/
        }
        
        if(diff>=int3){
            y3 += (motionControl3) ? MOVIMENTO: /*MOVIMENTO*/0;
            if(y3 >= -101) motionControl3 = true;
            if(y3 >= getHeight()-340) motionControl3 = false;
            /*if((y3 >= getHeight()-340) &&(pioggia[2]!= null) ){
                timer.stop();
                ControllerForView.getInstance().openGameOverDialog();
            }*/
        }
        
        if(diff>=int4){
            y4 += (motionControl4) ? MOVIMENTO:/* MOVIMENTO*/0;
            if(y4 >= -101) motionControl4 = true;
            if(y4 >= getHeight()-340) motionControl4 = false;
            /*if((y4 >= getHeight()-340) &&(pioggia[3]!= null) ){
                timer.stop();
                ControllerForView.getInstance().openGameOverDialog();
            }*/
        }
        
        if(diff>=int5){
            y5 += (motionControl5) ? MOVIMENTO: /*MOVIMENTO*/0;
            if(y5 >= -101) motionControl5 = true;
            if(y5 >= getHeight()-340) motionControl5 = false;
            /*if((y5 >= getHeight()-340) &&(pioggia[4]!= null) ){
                timer.stop();
                ControllerForView.getInstance().openGameOverDialog();
            }*/
        }
         this.panel.repaint();       
        //repaint();
    }


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