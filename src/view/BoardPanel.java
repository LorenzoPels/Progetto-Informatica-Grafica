
package view;

import controller.ControllerForView;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import model.Cavaliere;
import static model.CavaliereA.Loader;
import model.Model;
import static view.RightPanel.scorelabel;

public class BoardPanel extends JPanel implements ActionListener,KeyListener {
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
        private static Timer timer;
        private int x, y1,y2,y3,y4,y5;
        private final int PAUSE = 10;
        private  int MOVIMENTO = 1;
        private boolean motionControl1,motionControl2,motionControl3,motionControl4,motionControl5;
        
        public static Boolean giocoiniziato = false;
        private Image[] pioggia = new Image[5];
        private int tempo;
        private int variabile;
        public static long t0,t1,P,Pi,Pf;
        public static long diff;
        public int int1=1000;
        public int int2=3000;
        public int int3=4000;
        public int int4=7000;
        public int int5=8000;
        public int int6=10000;
	//---------------------------------------------------------------
	// INSTANCE ATTRIBUTES
	//---------------------------------------------------------------
	/*private boolean isGridVisibleInBoard;
	private boolean isFallingPieceAvailable;
	private boolean isRefBlockRecognizableInBoard;
	public double uX;
	public double uY;
	private Line2D.Double line;
	private Rectangle2D.Double block;*/

	public BoardPanel() {
		super();
                
		/*this.isGridVisibleInBoard = Config.getInstance().isGridVisibleInBoard();
		this.isRefBlockRecognizableInBoard = Config.getInstance().isRefBlockRecognizableInBoard();
		this.line = new Line2D.Double();
		this.block = new Rectangle2D.Double();
		this.setBackground(ColorSettings.getInstance().getColorBackgroundBoard());*/
		this.addKeyListener(this);
            try {
                sfondo = ImageIO.read(new File("src/immagini/Sfondo_senza_mago.png"));
                mago = ImageIO.read(new File("src/immagini/Mago.png"));
                cavaliere = /*ImageIO.read(new File("src/Cavalieri/cavaliere.png"));*/Cavaliere.Loader();
                cavaliere1 = Cavaliere.Loader();
            }catch (IOException ex) {
            }
       
            x = 200;
            y1 = 1;
            y2 = 1;
            y3 = 1;
            y4 = 1;
            y5 = 1;
        
            timer = new Timer(PAUSE, this);
            timer.start();
            Pioggia();
            //t0 = System.currentTimeMillis();
            variabile = (int)(Math.random() * pioggia.length) % pioggia.length;
                
	}
        public Image[] Pioggia(){
        
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
        } 
        
        

	//---------------------------------------------------------------
	// PRIVATE INSTANCE METHODS
	//---------------------------------------------------------------
	/*private void paintGrid(Graphics2D g2d) {
		Color oldColor = g2d.getColor();
		g2d.setColor(Color.DARK_GRAY);

		int numColumns = ControllerForView.getInstance().getNumColumnsOfBoard();
		int numRows = ControllerForView.getInstance().getNumRowsOfBoard();

		// Paint the horizontal grid lines
		for (int i = 0; i <= numRows; i++) {
			this.line.setLine(X_MARGIN, Y_MARGIN + i * this.uY,
							  X_MARGIN + numColumns * this.uX, Y_MARGIN + i * this.uY);
			g2d.draw(this.line);
		}

		// Paint the vertical grid lines
		for (int j = 0; j <= numColumns; j++) {
			this.line.setLine(X_MARGIN + j * this.uX, Y_MARGIN,
							  X_MARGIN + j * this.uX, Y_MARGIN + numRows * this.uY);
			g2d.draw(this.line);
		}

		g2d.setColor(oldColor);
	} // end method paintGrid()

	private void drawBlockAtCell(Graphics2D g2d, int i, int j, String pieceName) {
		Color oldColor = g2d.getColor();
		g2d.setColor(ColorSettings.getInstance().getColorOfPiece(pieceName));
		this.block.setRect(X_MARGIN + this.uX * (double)j, Y_MARGIN + this.uY * (double)(ControllerForView.getInstance().getNumRowsOfBoard() - 1 - i), this.uX, this.uY);
		g2d.fill(this.block);
		g2d.setColor(ColorSettings.getInstance().getColorForOutlineOfPiece(pieceName));
		g2d.draw(this.block);
		g2d.setColor(oldColor);
	}

	private void drawReferenceBlockAtCell(Graphics2D g2d, int i, int j, String pieceName) {
		Color oldColor = g2d.getColor();
		g2d.setColor(ColorSettings.getInstance().getColorOfPiece(pieceName));
		this.block.setRect(X_MARGIN + this.uX * (double)j, Y_MARGIN + this.uY * (double)(ControllerForView.getInstance().getNumRowsOfBoard() - 1 - i), this.uX, this.uY);
		g2d.fill(this.block);
		g2d.setColor(ColorSettings.getInstance().getColorForOutlineOfPiece(pieceName));
		g2d.draw(this.block);
		this.block.setRect(X_MARGIN + this.uX * 0.25 + this.uX * (double)j, Y_MARGIN + this.uY * 0.25 + this.uY * (double)(ControllerForView.getInstance().getNumRowsOfBoard() - 1 - i), this.uX * 0.5, this.uY * 0.5);
		g2d.draw(this.block);
		g2d.setColor(oldColor);
	}

	private void paintFallingPiece(Graphics2D g2d) {
		for (int blockLabel = 0; blockLabel < ControllerForView.getInstance().numBlocksOfFallingPiece(); blockLabel++)
			if ((blockLabel == 0) && this.isRefBlockRecognizableInBoard)
				this.drawReferenceBlockAtCell(g2d,
														ControllerForView.getInstance().iIndex(),
														ControllerForView.getInstance().jIndex(),
														ControllerForView.getInstance().getNameOfFallingPiece());
			else
				this.drawBlockAtCell(g2d,
											(ControllerForView.getInstance().iIndex() + ControllerForView.getInstance().iRelOfFallingPiece(blockLabel)),
											(ControllerForView.getInstance().jIndex() + ControllerForView.getInstance().jRelOfFallingPiece(blockLabel)),
											ControllerForView.getInstance().getNameOfFallingPiece());
	} // end method paintFallingPiece()

	/*
	private void paintFallingPiece(Graphics2D g2d) {
		Color oldColor = g2d.getColor();
		g2d.setColor(ColorSettings.getInstance().getColorOfPiece(ControllerForView.getInstance().getNameOfFallingPiece()));

		for (int blockLabel = 0; blockLabel < ControllerForView.getInstance().numBlocksOfFallingPiece(); blockLabel++) {
			this.block.setRect(X_MARGIN + this.uX * (double)(ControllerForView.getInstance().jIndex() + ControllerForView.getInstance().jRelOfFallingPiece(blockLabel)),
							   Y_MARGIN + this.uY * (double)(ControllerForView.getInstance().getNumRowsOfBoard() - 1 - ControllerForView.getInstance().iIndex() - ControllerForView.getInstance().iRelOfFallingPiece(blockLabel)),
							   this.uX, this.uY);
			g2d.fill(this.block);
		}

		g2d.setColor(ColorSettings.getInstance().getColorForOutlineOfPiece(ControllerForView.getInstance().getNameOfFallingPiece()));
		for (int blockLabel = 0; blockLabel < ControllerForView.getInstance().numBlocksOfFallingPiece(); blockLabel++) {
			this.block.setRect(X_MARGIN + this.uX * (double)(ControllerForView.getInstance().jIndex() + ControllerForView.getInstance().jRelOfFallingPiece(blockLabel)),
							   Y_MARGIN + this.uY * (double)(ControllerForView.getInstance().getNumRowsOfBoard() - 1 - ControllerForView.getInstance().iIndex() - ControllerForView.getInstance().iRelOfFallingPiece(blockLabel)),
							   this.uX, this.uY);
			g2d.draw(this.block);
		}

		// It makes the reference block recognizable if it is enabled the flag isRefBlockRecognizableInBoard
		if (this.isRefBlockRecognizableInBoard) {
			this.block.setRect(X_MARGIN + this.uX * 0.25 + this.uX * (double)(ControllerForView.getInstance().jIndex()),
							   Y_MARGIN + this.uY * 0.25 + this.uY * (double)(ControllerForView.getInstance().getNumRowsOfBoard() - 1 - ControllerForView.getInstance().iIndex()),
							   this.uX * 0.5, this.uY * 0.5);
			g2d.draw(this.block);
		}

		g2d.setColor(oldColor);
	} // end method paintFallingPiece()
	*/

	/*private void paintFilledBoardCells(Graphics2D g2d) {
		Color oldColor = g2d.getColor();
		for (int j = 0; j < ControllerForView.getInstance().getNumColumnsOfBoard(); j++)
			for (int i = 0; i < ControllerForView.getInstance().getNumRowsOfBoard(); i++)
				if (!ControllerForView.getInstance().isEmptyCell(i, j))
					this.drawBlockAtCell(g2d, i, j, ControllerForView.getInstance().getNameOfPieceAtCell(i, j));
		g2d.setColor(oldColor);
	} // end method paintFilledBoardCells()*/

	//---------------------------------------------------------------
	// PUBLIC INSTANCE METHODS
	//---------------------------------------------------------------
	/*public void setGridUnit() {
		this.uX = (double)(getWidth() - 2 * X_MARGIN) / (double)ControllerForView.getInstance().getNumColumnsOfBoard();
		this.uY = (double)(getHeight() - 2 * Y_MARGIN) / (double)ControllerForView.getInstance().getNumRowsOfBoard();
	}

	public void setFallingPieceAvailable() {
		this.isFallingPieceAvailable = true;
	}

	public void setFallingPieceUnavailable() {
		this.isFallingPieceAvailable = false;
	}*/
        

	@Override
	public Dimension getPreferredSize() {
		return PREFERRED_SIZE;
	}
       
        
     /*   private void slowMethod(int sec){
            try{
                Thread.sleep(1000*sec);
            }catch(InterruptedException ie){
                ie.printStackTrace();;
            }
        }
        
        private void executeSlowMethodInBackground(final int sec) {
        SwingWorker worker = new SwingWorker<Void, Void>() {
            @Override
            public Void doInBackground() {
                System.out.println("in ... doInBackground()");
                slowMethod(sec);
                return null;
            }

            @Override
            public void done() {
                System.out.println("in ... done()");
                numSlowClicks++;
                jlab2.setText(lab2Prefix + numSlowClicks);
            }
        };
        worker.execute();
    } // end method executeSlowMethodInBackground()*/

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
                if( diff >=int2  )//6 secondi
                g.drawImage(pioggia[1],x+100,y2,null);
                if( diff >=int3  )//9 secondi
                g.drawImage(pioggia[2],x-200,y3,null);
                if( diff >=int4  )//12 secondi
                g.drawImage(pioggia[3],x+200,y4,null);
                if( diff >=int5  )// 15secondi
                g.drawImage(pioggia[4],x+250,y5,null);
                if( (diff >=int6) /*&& (diff<=30500) */  )//18 secondi
                    if(y5>=getHeight()-340){    
                        t0=System.currentTimeMillis();
                        Pioggia();
                        y1=y2=y3=y4=y5=1;
                        MOVIMENTO++;
                        int1+=-300;
                        int2+=-500;
                        int3+=-300;
                        int4+=-600;
                        int5+=-500;
                        int6+=-500;
                    }
               //}
            }
	}


	//-------------------------------------------------------------------------
	// To implement the interface java.awt.event.KeyListener
	//-------------------------------------------------------------------------
	/* Invoked when a key has been pressed. */
        
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:// vk qualcosa indica ciò che innesca la rotazione
				Model.getInstance().incrementScore();
                                RightPanel.updateScoreLabel(Model.getInstance().getScore());
                            
                            /*ControllerForView.getInstance().left();*/
				this.repaint();
				//System.out.println("Pressed key: VK_LEFT");*/
				break;
			/*case KeyEvent.VK_RIGHT:
				ControllerForView.getInstance().right();
				this.repaint();
				//System.out.println("Pressed key: VK_RIGHT");
				break;
			case KeyEvent.VK_DOWN:
				ControllerForView.getInstance().down();
				this.repaint();
				//System.out.println("Pressed key: VK_DOWN");
				break;
			case KeyEvent.VK_UP:
				ControllerForView.getInstance().rotate();
				this.repaint();
				//System.out.println("Pressed key: VK_UP");
				break;
			case KeyEvent.VK_A:
				ControllerForView.getInstance().next();
				this.repaint();
				//System.out.println("Pressed key: VK_A");
				break;
			//default: System.out.println("Use only the following keys: VK_LEFT, VK_RIGHT, VK_DOWN, VK_UP");*/
		}
	}

	/* Invoked when a key has been released. */
        
	public void keyReleased(KeyEvent e) {
		// do nothing
	}

	/* Invoked when a key has been typed. */
        
	public void keyTyped(KeyEvent e) {
		// do nothing
	}

    @Override
    public void actionPerformed(ActionEvent e) {
       if(diff>=int1){
            y1 += (motionControl1) ? MOVIMENTO: /*-MOVIMENTO*/0;
            if(y1 >= 0) motionControl1 = true;
            if(y1 >= getHeight()-340) motionControl1 = false;
        }
       
        if(diff>=int2){
            y2 += (motionControl2) ? MOVIMENTO: /*MOVIMENTO*/0;
            if(y2 >= 0) motionControl2 = true;
            if(y2 >= getHeight()-340) motionControl2 = false;
        }
        
        if(diff>=int3){
            y3 += (motionControl3) ? MOVIMENTO: /*MOVIMENTO*/0;
            if(y3 >= 0) motionControl3 = true;
            if(y3 >= getHeight()-340) motionControl3 = false;
        }
        
        if(diff>=int4){
            y4 += (motionControl4) ? MOVIMENTO:/* MOVIMENTO*/0;
            if(y4 >= 0) motionControl4 = true;
            if(y4 >= getHeight()-340) motionControl4 = false;
        }
        
        if(diff>=int5){
            y5 += (motionControl5) ? MOVIMENTO: /*MOVIMENTO*/0;
            if(y5 >= 0) motionControl5 = true;
            if(y5 >= getHeight()-340) motionControl5 = false;
        }
        
        
        

        repaint();
    }

} // end class
