
package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import view.CaricatoreImmagine;

public class ConcreteDrawing extends AbstractDrawing {

    BufferedImage sfondo = null;
    
    private void Caricarisorse(){
    CaricatoreImmagine loader = new CaricatoreImmagine();
    sfondo = loader.caricaImmagine("/immagini/Sfondo.png");
    
    }

    public ConcreteDrawing() {
        Caricarisorse();  // x, y, width, height
    }

    @Override
    public void draw(Graphics g) {
        Graphics g2d = (Graphics2D)g;

        
        g2d.drawImage(sfondo,0,0,null, (ImageObserver) this);
        g2d.dispose();
    }

} // end class
