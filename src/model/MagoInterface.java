
package model;

import java.awt.image.BufferedImage;


public interface MagoInterface {
    
    
    public BufferedImage magoImg();
    
    public void stampaMago();
        
    public void movimentoBraccia();
    
    public void gestisciMago(int c);
    
    public int movimentoMago(int i);
     
    public int getXMago();
    
    public void resetMago();
    
    public void setXMagoMax(int x);
    
    public void setXMagoMin(int x);
    
}

