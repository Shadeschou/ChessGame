package domain;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(String imageUrl, Color color) {
        super(imageUrl, color);
    }

    @Override
    public String toString() {
        return super.toString() + " Bishop";
    }

    @Override
    public ArrayList<Square> getPotentialMoves(Square s) {
        ArrayList<Square> res = new ArrayList<Square>();
        int currentX = s.getXIndex();
        int currentY = s.getYIndex();
        int minX;
        int minY;
        if (currentX < currentY){
            minX = 0;
            minY = currentY - currentX;
        }else {
            minX = currentX - currentY;
            minY = 0;
        }
        for (int i = 0; i < 8; i++) {
            if (minX + i == 8 || minY + i ==8){
                break;
            }
            if (i+minX != currentX) {
                res.add(new Square(Board.SIZE_OF_SQUARE, Color.RED, (i+minX) * Board.SIZE_OF_SQUARE, (i+minY) * Board.SIZE_OF_SQUARE));
            }
        }
        if (currentX < 7-currentY){
            minX = 0;
            minY = currentY + currentX;
        }else {
            minX = currentX - (7-currentY);
            minY = 7;
        }
        for (int i = 0; i < 8; i++) {
            if (minX + i == 8 || minY - i ==0){
                break;
            }
            if (i+minX != currentX) {
                res.add(new Square(Board.SIZE_OF_SQUARE, Color.RED, (i+minX) * Board.SIZE_OF_SQUARE, (minY-i) * Board.SIZE_OF_SQUARE));
            }
        }

        return res;
    }
}
