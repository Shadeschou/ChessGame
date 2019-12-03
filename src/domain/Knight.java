package domain;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Knight extends Piece
{

    
    public Knight(String imageUrl, Color color) {
        super(imageUrl, color);
    }
    
    @Override
    public String toString(){
        return super.toString() + " Knight";
    }

    @Override
    public ArrayList<Square> getPotentialMoves(Square s) {
        return null;
    }


}
