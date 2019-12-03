package domain;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(String imageUrl, Color color)
    {
        super(imageUrl, color);
    }

    /***
     * Makes an array of legal moves
     * @param s current Square of the piece.
     * @return a list of possible moves
     */
    public ArrayList<Square> getPotentialMoves(Square s){
        ArrayList<Square> res = new ArrayList<Square>();
        int indexX = s.getXIndex();
        int indexY = s.getYIndex();

        for (int i = 0; i < 8; i++){
            if (i !=indexX) {
                res.add(new Square(Board.SIZE_OF_SQUARE, Color.RED, i * Board.SIZE_OF_SQUARE, indexY * Board.SIZE_OF_SQUARE));
            }
        }
        for (int i = 0; i < 8; i++){
            if (i !=indexY){
                res.add(new Square(Board.SIZE_OF_SQUARE,Color.RED,indexX*Board.SIZE_OF_SQUARE,i*Board.SIZE_OF_SQUARE));
            }
        }

        return res;
    }

    @Override
    public String toString(){
        return super.toString() + " Rook";
    }
}
