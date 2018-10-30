
package model;

import java.awt.Image;

public interface IModel {
   /* public int getNumColumnsOfBoard();//forse da usare se il campo di gioco è una matrice

	public int getNumRowsOfBoard();//forse da usare se il campo di gioco è una matrice*/

	public int getScore();//legge il punteggio ottenuto
        public int getY(int i);
        public void resetIndex();
        public void resetY();

	public  void incrementScore(/*int increment*/);//incrementa il puntegio ottenuto

	/*public int numBlocksOfFallingPiece();//numero riferito al tipo di pezzo

	public int iRelOfFallingPiece(int blockLabel);//riga occupata dal pezzo cadente

	public String getNameOfFallingPiece();//non so*/
	
	public void initGame();//non so
        public void Colpito(boolean b, String s);
        public void statoCavaliere(int i);
        public void caricaAnimazioni();
        public Image effettuaAnimazione(String colore, int indice);
        public int movimentoMago(int i);
        public void movimentoBraccia();
        public void stampaMago();

	/*public void hitFallingPiece();//metodo per far esplodere il palloncino

	public boolean isEmptyCell(int i);//verifica se il nemico tocca terra
	
        public void removePiece(int blockLabel);//elimina il pezzo caduto a terra se sprovvisto di palloncini
        
	public String getNameOfPieceAtCell(int i, int j);//non so
	
	public void nextFallingPiece();//forse serve ad impostare il prossimo pezzo
    */
}
