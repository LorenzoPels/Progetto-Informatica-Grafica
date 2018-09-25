
package view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class CaricatoreImmagine {
    BufferedImage img;
    public BufferedImage caricaImmagine(String posizione){
        try {
            img = ImageIO.read(getClass().getResource(posizione));
        } catch (IOException ex) {
            Logger.getLogger(CaricatoreImmagine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img;
    }
}
