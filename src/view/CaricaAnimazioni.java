
package view;

import java.awt.Image;



public class CaricaAnimazioni {
    
    private Image[] Arancio = new Image[14];
    private Image[] Blu = new Image[14];
    private Image[] Giallo = new Image[14];
    private Image[] Grigio = new Image[14];
    private Image[] Rosa = new Image[14];
    private Image[] Rosso = new Image[14];
    private Image[] Verde = new Image[14];
    private Image[] Viola = new Image[14];
    
    
        public CaricaAnimazioni(){
            CaricatoreImmagine loader = new CaricatoreImmagine();
            for(int i =0;i<=13;i++){
                Arancio[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereArancio/cavaliereArancio"+i+ ".png");
                Blu[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereBlu/cavaliereBlu"+i+ ".png");
                Giallo[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereGiallo/cavaliereGiallo"+i+ ".png");
                Grigio[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereGrigio/cavaliereGrigio"+i+ ".png");
                Rosa[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereRosa/cavaliereRosa"+i+ ".png");
                Rosso[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereRosso/cavaliereRosso"+i+ ".png");
                Verde[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereVerde/cavaliereVerde"+i+ ".png");
                Viola[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereViola/cavaliereViola"+i+ ".png");
            }
        }
        
        public Image effettuaAnimazione(String colore, int indice){
                Image frameAnimazione = null;
                
                    if(colore=="Arancio")
                       frameAnimazione = Arancio[indice]; 
                    if(colore=="Blu")
                       frameAnimazione = Blu[indice]; 
                    
                    if(colore=="Giallo")
                        frameAnimazione = Giallo[indice]; 
                        
                    if(colore=="Grigio")
                        frameAnimazione = Grigio[indice]; 
                        
                    if(colore=="Rosa")
                        frameAnimazione = Rosa[indice]; 
                        
                    if(colore=="Rosso")
                        frameAnimazione = Rosso[indice]; 
                        
                    if(colore=="Verde")
                        frameAnimazione = Verde[indice]; 
                        
                    if(colore=="Viola")
                        frameAnimazione = Viola[indice]; 
                    
                    return frameAnimazione;
                        
        }

        
        
        
        
}
