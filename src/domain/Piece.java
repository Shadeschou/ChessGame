package domain;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public abstract class Piece implements Movable {
    private String imageUrl;
    private Color color;
    
  
    public Piece(String imageUrl, Color color) {
        this.imageUrl = imageUrl;
        this.color = color;
    }


    public Color getColor() {
        return this.color;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }
    
    /**
     *
     * @return 
     */
    public boolean isWhite(){
        if (this.color.equals(Color.WHITE)){
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return isWhite()?"WHITE":"BLACK";
    }

    @Override
    public abstract ArrayList<Square> getPotentialMoves(Square s);
}
