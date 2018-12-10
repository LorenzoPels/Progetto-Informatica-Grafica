
package model;


import java.awt.Image;                                                          
import static model.Cavaliere.Loader;
import static view.BoardPanel.larghezza;
import static view.MainGUI.ALTEZZA;
import static view.StartWindow.insane;


public class Model implements IModel {
    
    //---------------------------------------------------------------
    // VARIABILI STATICHE
    //---------------------------------------------------------------
    private static Model instance = null;           
      
    //---------------------------------------------------------------
    // VARIABILI PUBBLICHE
    //---------------------------------------------------------------
    public  int score;
    public  int[] index = new int[5];
    public boolean[] controlloreMovimento= new boolean[5];
    public int[] y = new int[5];
    public int[] x = new int[5];
    public int movimento;
    public int rallentaMov;   
    public Image[] pioggia = new Image[5];
    public Cavaliere[] cavalieri = new Cavaliere[5];
    public Boolean[] esplosi = new Boolean[5];
    public String[] colori = new String[5];   
    public long t0,t1,P,Pi,Pf;
    public long diff;
    public int[] intervalli = new int[5]; 
    //---------------------------------------------------------------
    // VARIABILI PRIVATE
    //---------------------------------------------------------------
    private final int altezzaterreno = ALTEZZA-245;
    private Image[] Arancio = new Image[14];
    private Image[] Blu = new Image[14];
    private Image[] Giallo = new Image[14];
    private Image[] Grigio = new Image[14];
    private Image[] Rosa = new Image[14];
    private Image[] Rosso = new Image[14];
    private Image[] Verde = new Image[14];
    private Image[] Viola = new Image[14];  
    Boolean giocoInEsecuzione, giocoIniziato;
    MagoInterface mago;
    
    private Model() {		
        this.initGame();
    }
    
    //---------------------------------------------------------------
    // METODI PUBBLICI
    //---------------------------------------------------------------
    
    public void initGame() {
        giocoInEsecuzione = false;
        giocoIniziato = false;      
        score= 0;       
        for(int i=0; i<cavalieri.length;i++){
            cavalieri[i]=null;
              pioggia[i]=null;
              esplosi[i]=false;
         }
        P=0;     
        Cavalieri();
        Pioggia();
        pioggiaRandom();
        resetIndex();
        resetY();
        caricaAnimazioni();
        t0=t1=P=Pi=Pf=0;
        rallentaMov = 0;
        
        for (int i = 0; i< colori.length; i++)
            colori[i] = null;
        
        int t = 0;
        if(insane==true){
            setMovimento(2);
           
            for (int i = 0;i < intervalli.length ;i++){
                    t+=700;
                    intervalli[i]=t;
            }        
        }else{ 
           setMovimento(1);
           
            for (int i = 0;i < intervalli.length ;i++){
                    t+=900;
                    intervalli[i]=t;
            }
        }
        
        mago = new MagoDefault();
        mago.setXMagoMax(larghezza-150);
        mago.setXMagoMin(50);
        mago.resetMago();
    }
        
    public int getScore() {
        return this.score;
    }
       
    public  void incrementScore() {
        this.score ++;
    }
       
    public void caricaAnimazioni(){
        CaricatoreImmagine loader = new CaricatoreImmagine();
        for(int i =0;i<=13;i++){
            Arancio[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereArancio/cavaliereArancio"+i+ ".png");
            Blu[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereBlu/cavaliereBlu"+i+ ".png");
            Giallo[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereGiallo/cavaliereGiallo"+i+ ".png");
            Grigio[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereGrigio/cavaliereGrigio"+i+ ".png");
            Rosa[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereRosa/cavaliereRosa"+i+ ".png");
            Rosso[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereRosso/cavaliereRosso"+i+ ".png");
            Verde[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereVerde/cavaliereVerde"+i+ ".png");
            Viola[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereViola/cavaliereViola"+i+ ".png");
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
    
    public int getAltezzaterreno(){
        return altezzaterreno;
    }
    public int getIndex(int i){
        return index[i];
    }
    
     public void resetIndex(){
         for(int i=0;i<index.length;i++)
             index[i]=0;
     }
     
     public void setIndex(int i, int a){
             index[i]=a;
     }
    
    public boolean getControlloreMovimento(int i){
        return controlloreMovimento[i];
    }
    
     public void setControlloreMovimento(int i,Boolean b){
         controlloreMovimento[i]=b;
     }
    
    public int[] getYArray(){
        return y;
    }
    public int[] getXArray(){
        return x;
    }
    public void resetY(){
        for(int i=0;i<y.length;i++)
             y[i]=-150;
    }
    
    public void setY(int i, int a){
        y[i] = a;
    }
    
    public int getMovimento(){
        return movimento;
    }
    public void setMovimento(int mv){
        movimento = mv;
    }
    
    public void incrementaMovimento(){
        movimento++;
    }
    
    public Image[] getPioggia(){
        return pioggia;
    }
    
    public void Pioggia(){
    for(int i=0; i<cavalieri.length;i++)  
       pioggia[i] = Loader(cavalieri[i]);
    }
    
    public  Image getPioggia(int i){
        return pioggia[i];
    }
    
    public  void setPioggia(int i, Image img){
        pioggia[i]=img;
    }
    
    public Cavaliere getCavalieri(int i){
        return cavalieri[i];
    }
    
    public void Cavalieri(){
        for(int i=0; i<cavalieri.length;i++)  
            cavalieri[i] = Cavaliere.nextCavaliere();
        }
    
    public  Cavaliere[] getCavalieri(){
        return cavalieri;
    }
    
    public  void setCavalieri(int i,Cavaliere cv){
        cavalieri[i]=cv;
    }
    
    public Boolean[] getEsplosi(){
        return esplosi;
    }
    
    public  void Esplosi(){
        for(int i=0; i<cavalieri.length;i++)  
            esplosi[i] = false;      
    }
    
    public  Boolean getEsplosi(int i){
        return esplosi[i];
    }
    
    
    public  void setEsplosi(int i, Boolean b){
        esplosi[i]=b;
    }
    
    public int getIntervalli(int i){
        return intervalli[i];
    }
    public void setIntervallo(int i, int val){
        intervalli[i]=val;
    }
    
    public void pioggiaRandom(){   
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
    
    public long getT0(){
        return t0;
    }    
    public void setT0(){
        t0=System.currentTimeMillis();
    }
    public long getT1(){
        return t1;
    }
    public void setT1(){
        t1=System.currentTimeMillis()-P;
    }
    
    public void setP(long tmp){
        P = tmp;
    }
    
    public long getP(){
        return P;
    }
    
    public long getPi(){
        return Pi;
    }
        
    public void setPi(){
        Pi = System.currentTimeMillis();
    }
        
    public long getPf(){
        return Pf;
    }

    public void setPf(){
        Pf = System.currentTimeMillis();
    }
    
    public MagoInterface getMago(){
        return this.mago;
    }
    
    public Boolean getGiocoInEsecuzione(){
        return giocoInEsecuzione;
    }
     public void setGiocoInEsecuzione(Boolean b){
        giocoInEsecuzione = b;
    }
    public Boolean getGiocoIniziato(){
        return giocoIniziato;
    }
    public void setGiocoIniziato(Boolean b){
        giocoIniziato = b;
    }
    
    public String getColore(int i){
        return colori[i];
    }
        
    public void setColore(int i, String s){
        colori[i]= s;
    }
    
    public int getRallentaMov(){
        return rallentaMov;
    }
        
    public void incrementRallentaMov(){
        rallentaMov++;
    }
    
    //---------------------------------------------------------------
    // METODI STATICI
    //---------------------------------------------------------------
    public static IModel getInstance() {
            if (instance == null)
                    instance = new Model();
            return instance;
    }

}

