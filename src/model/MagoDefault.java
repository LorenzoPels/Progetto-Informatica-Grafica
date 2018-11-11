
package model;

import java.awt.image.BufferedImage;
import static view.BoardPanel.larghezza;
import static view.BoardPanel.x;
import static view.MainGUI.t1;


public class MagoDefault implements MagoInterface {
    
    //---------------------------------------------------------------
    // VARIABILI STATICHE
    //---------------------------------------------------------------  
    public static BufferedImage[] arrayMago = new BufferedImage[3];;
    public static BufferedImage mago;
    public static int xMago ;
    public static int xMagoMax;
    public static int xMagoMin;
    private static long tmago;
    //---------------------------------------------------------------
    // VARIABILI PRIVATE
    //--------------------------------------------------------------- 
    int direzioneMago;

    public MagoDefault(BufferedImage a, BufferedImage b, BufferedImage c) {arrayMago =  new BufferedImage[3];
            
            arrayMago[0] = a;
            arrayMago[1] = b;
            arrayMago[2] = c;
       
            mago = arrayMago[0];
            
            xMago = larghezza/2;
            xMagoMax= 500;
            xMagoMin = 100;
            direzioneMago= 1;
    
            tmago= 0 ;
    }
    
    
    //---------------------------------------------------------------
    //  METODI PUBBLICI
    //--------------------------------------------------------------- 
       
    public BufferedImage magoImg(){
        return this.mago;
    }
    
    public void stampaMago(){
        if (xMago == xMagoMax ){
            direzioneMago=-1;
            mago = arrayMago[0];
        }
        if (xMago == xMagoMin){
            direzioneMago=+1;
            mago = arrayMago[0];
        }        
        xMago+=direzioneMago;
    }              
        
    public void movimentoBraccia(){
        if((t1-tmago)>= 500)
                mago = arrayMago[0];
    }
    
     public void gestisciMago(int c){
        int i;
        i= movimentoMago(c);
        mago = arrayMago[i];
    }
    
     public int movimentoMago(int i){
        int imgMago = 0;
        if(xMago < x[i] ){
            imgMago = 1;
            xMagoMax = x[i]+50;
            direzioneMago=+1;
        }
        if(xMago > x[i] ){
            imgMago = 2;
            xMagoMin=x[i]-50;
            direzioneMago=-1;
        }
        tmago =  System.currentTimeMillis();
        return imgMago;       
    }
     
    public int getXMago(){
        return this.xMago;
    }
    
    
    public void resetMago(){
        mago = arrayMago[0];
    }
    
    public void setXMagoMax(int x){
        xMagoMax = x;
    }
    
    public void setXMagoMin(int x){
        xMagoMin = x;
   }
    
}
