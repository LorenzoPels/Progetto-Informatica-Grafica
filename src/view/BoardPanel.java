
package view;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Cavaliere;
import model.Model;
import static view.MainGUI.MOVIMENTO0;
import static view.MainGUI.MOVIMENTO1;
import static view.MainGUI.MOVIMENTO2;
import static view.MainGUI.MOVIMENTO3;
import static view.MainGUI.MOVIMENTO4;
import static view.MainGUI.P;
import static view.MainGUI.cavalieri;
import static view.MainGUI.scoppio;
import static view.MainGUI.diff;
import static view.MainGUI.esplosi;
import static view.MainGUI.getPanel;
import static view.MainGUI.giocoiniziato;
import static view.MainGUI.pioggia;
import static view.MainGUI.t0;
import static view.MainGUI.t1;
import static view.MainGUI.x;
import static view.RightPanel.updateScoreLabel;
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
import static view.MainGUI.int5;
import static view.MainGUI.index0;
import static view.MainGUI.index1;
import static view.MainGUI.index2;
import static view.MainGUI.index3;
import static view.MainGUI.index4;




public class BoardPanel extends JPanel implements KeyListener {
    BufferedImage sfondo;
    BufferedImage mago;
    private int count=0;
    private final static Dimension PREFERRED_SIZE = new Dimension(490,680);

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
            if( diff >=int0  )
                g.drawImage(pioggia[0],x-100,y0,150,180,null);
            if(diff >=int1)
                g.drawImage(pioggia[1],x+100,y1,150,180,null);
            if(diff >=int2)
                g.drawImage(pioggia[2],x-200,y2,150,180,null);
            if(diff >=int3)
                g.drawImage(pioggia[3],x+200,y3,150,180,null);
            if(diff >=int4)
                g.drawImage(pioggia[4],x+250,y4,150,180,null);
           // if( diff >=int5 )
                if(pioggia[0]== null && pioggia[1]== null && pioggia[2]== null && pioggia[3]== null && pioggia[4]== null  ){    
                    t0=System.currentTimeMillis();
                    P=0;
                    MainGUI.Cavalieri();
                    MainGUI.Pioggia();
                    MainGUI.Esplosi();
                    y0=y1=y2=y3=y4=-100;
                    index0=index1=index2=index3=index4=0; 
                    
                    if(int0>=200){
                       /* MOVIMENTO0++;
                        MOVIMENTO1++;
                        MOVIMENTO2++;
                        MOVIMENTO3++;
                        MOVIMENTO4++;*/
                        int0+=-100;
                        int1+=-320;
                        int2+=-440;
                        int3+=-600;
                        int4+=-720;
                        //int5+=-2000;
                    } 
                    if(int0>=600){
                        MOVIMENTO0++;
                        MOVIMENTO1++;
                        MOVIMENTO2++;
                        MOVIMENTO3++;
                        MOVIMENTO4++;
                        //System.out.println(MOVIMENTO0+"\n"+int0);

                    }


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
                        for(int i =0;(i<cavalieri.length)&&(cancelA==false);i++){
                            if((cavalieri[i].getName()== "A") && (esplosi[i]==false)){
                  /*              try {
                                    animazione(cavalieri[i], i );
                                } catch (IOException ex) {
                                    Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }                   */
                                pioggia[i] = null;
                                cavalieri[i] = null;
                                esplosi[i] = true;
                                cavalieri[i]=Cavaliere.nextCavaliere();
                                scoppio.play();
                                Model.getInstance().incrementScore();
                                updateScoreLabel(Model.getInstance().getScore());
                                cancelA = true;
                            }
                            /*if(cavalieri[i]==null)
                                i++;*/
                        }
                        break;


                    case KeyEvent.VK_B:
                        boolean cancelB = false;
                        for(int i =0;(i<cavalieri.length)&&(cancelB==false);i++){
                            if((cavalieri[i].getName()== "B") && (esplosi[i] == false)){

                                pioggia[i] = null;
                                cavalieri[i] = null;
                                esplosi[i] = true;
                                cavalieri[i]=Cavaliere.nextCavaliere();
                                scoppio.play();
                                Model.getInstance().incrementScore();
                                updateScoreLabel(Model.getInstance().getScore());
                                cancelB = true;
                            }
                            /* if(cavalieri[i]==null)
                                i++;*/
                        }
                        break;


                    case KeyEvent.VK_F:
                        boolean cancelF = false;
                        for(int i =0;(i<cavalieri.length)&&(cancelF==false);i++){
                            if((cavalieri[i].getName()== "F") && (esplosi[i] == false)){
                                pioggia[i] = null;
                                cavalieri[i] = null;
                                esplosi[i] = true;
                                cavalieri[i]=Cavaliere.nextCavaliere();
                                scoppio.play();
                                Model.getInstance().incrementScore();
                                updateScoreLabel(Model.getInstance().getScore());
                                cancelF = true;
                            }
                             /*if(cavalieri[i]==null)
                                i++;*/
                        }
                        break;


                    case KeyEvent.VK_H:
                        boolean cancelH = false;
                        for(int i =0;(i<cavalieri.length)&&(cancelH==false);i++){
                            if((cavalieri[i].getName()== "H") && (esplosi[i] == false)){
                                pioggia[i] = null;
                                cavalieri[i] = null;
                                esplosi[i] = true;
                                cavalieri[i]=Cavaliere.nextCavaliere();
                                scoppio.play();
                                Model.getInstance().incrementScore();
                                updateScoreLabel(Model.getInstance().getScore());
                                cancelH = true;
                            }
                            /* if(cavalieri[i]==null)
                               i++;*/
                        }
                        break;


                    case KeyEvent.VK_J:
                        boolean cancelJ = false;
                        for(int i =0;(i<cavalieri.length)&&(cancelJ==false);i++){
                            if((cavalieri[i].getName()== "J") && (esplosi[i] == false)){
                                pioggia[i] = null;
                                cavalieri[i] = null;
                                esplosi[i] = true;
                                cavalieri[i]=Cavaliere.nextCavaliere();
                                scoppio.play();
                                Model.getInstance().incrementScore();
                                updateScoreLabel(Model.getInstance().getScore());
                               cancelJ = true;
                            }
                             /*if(cavalieri[i]==null)
                               i++;*/
                        }
                        break;


                    case KeyEvent.VK_K:
                        boolean cancelK = false;
                        for(int i =0;(i<cavalieri.length)&&(cancelK==false);i++){
                            if((cavalieri[i].getName()== "K") && (esplosi[i] == false)){
                                pioggia[i] = null;
                                cavalieri[i] = null;
                                esplosi[i] = true;
                                cavalieri[i]=Cavaliere.nextCavaliere();
                                scoppio.play();
                                Model.getInstance().incrementScore();
                                updateScoreLabel(Model.getInstance().getScore());
                                cancelK = true;
                            }
                            /* if(cavalieri[i]==null)
                                i++;*/
                        }
                        break;


                    case KeyEvent.VK_L:
                        boolean cancelL = false;
                        for(int i =0;(i<cavalieri.length)&&(cancelL==false);i++){
                            if((cavalieri[i].getName()== "L") && (esplosi[i] == false)){
                                pioggia[i] = null;
                                cavalieri[i] = null;
                                esplosi[i] = true;
                                cavalieri[i]=Cavaliere.nextCavaliere();
                                scoppio.play();
                                Model.getInstance().incrementScore();
                                updateScoreLabel(Model.getInstance().getScore());
                               cancelL = true;
                            }
                            /* if(cavalieri[i]==null)
                               i++;*/
                        }
                        break;


                    case KeyEvent.VK_M:
                        boolean cancelM = false;
                        for(int i =0;(i<cavalieri.length)&&(cancelM==false);i++){
                            if((cavalieri[i].getName()== "M") && (esplosi[i] == false)){
                                pioggia[i] = null;
                                cavalieri[i] = null;
                                esplosi[i] = true;
                                cavalieri[i]=Cavaliere.nextCavaliere();
                                scoppio.play();
                                Model.getInstance().incrementScore();
                                updateScoreLabel(Model.getInstance().getScore());
                                cancelM = true;
                            }
                            /* if(cavalieri[i]==null)
                                i++;*/
                        }
                        break;


                    case KeyEvent.VK_P:
                        boolean cancelP = false;
                        for(int i =0;(i<cavalieri.length)&&(cancelP==false);i++){
                            if((cavalieri[i].getName()== "P") && (esplosi[i] == false)){
                                pioggia[i] = null;
                                cavalieri[i] = null;
                                esplosi[i] = true;
                                cavalieri[i]=Cavaliere.nextCavaliere();
                                scoppio.play();
                                Model.getInstance().incrementScore();
                                updateScoreLabel(Model.getInstance().getScore());
                                cancelP = true;
                            }
                            /* if(cavalieri[i]==null)
                                i++;*/
                        }
                        break;


                    case KeyEvent.VK_Q:
                        boolean cancelQ = false;
                        for(int i =0;(i<cavalieri.length)&&(cancelQ==false);i++){
                            if((cavalieri[i].getName()== "Q") && (esplosi[i] == false)){
                                pioggia[i] = null;
                                cavalieri[i] = null;
                                esplosi[i] = true;
                                cavalieri[i]=Cavaliere.nextCavaliere();
                                scoppio.play();
                                Model.getInstance().incrementScore();
                                updateScoreLabel(Model.getInstance().getScore());
                                cancelQ = true;
                            }
                             /*if(cavalieri[i]==null)
                                i++;*/
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
