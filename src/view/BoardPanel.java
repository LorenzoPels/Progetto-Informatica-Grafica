
package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
        BufferedImage sfondo;
        BufferedImage mago;
	//---------------------------------------------------------------
	// STATIC CONSTANTS
	//---------------------------------------------------------------
	
	private final static Dimension PREFERRED_SIZE = new Dimension(490,680);
	private final static int X_MARGIN = 10;
	private final static int Y_MARGIN = 10;

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
		this.setBackground(ColorSettings.getInstance().getColorBackgroundBoard());
		this.addKeyListener(this);*/
        try {
            sfondo = ImageIO.read(new File("src/immagini/Sfondo_senza_mago.png"));
            
        }catch (IOException ex) {

        }
        
        try {
            mago = ImageIO.read(new File("src/immagini/Mago.png"));
            
        } catch (IOException ex) {

        }
       
        
        setVisible(true);
        
        
                
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

	@Override
	public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(sfondo,0,0,getWidth(),getHeight(),null);
            g.drawImage(mago,190,540,100,108,null);
	}


	//-------------------------------------------------------------------------
	// To implement the interface java.awt.event.KeyListener
	//-------------------------------------------------------------------------
	/* Invoked when a key has been pressed. */
	/*public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:// vk qualcosa indica ciò che innesca la rotazione
				ControllerForView.getInstance().left();
				this.repaint();
				//System.out.println("Pressed key: VK_LEFT");
				break;
			case KeyEvent.VK_RIGHT:
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
			//default: System.out.println("Use only the following keys: VK_LEFT, VK_RIGHT, VK_DOWN, VK_UP");
		}
	}*/

	/* Invoked when a key has been released. */
	/*public void keyReleased(KeyEvent e) {
		// do nothing
	}*/

	/* Invoked when a key has been typed. */
	/*public void keyTyped(KeyEvent e) {
		// do nothing
	}*/

   

    

} // end class
