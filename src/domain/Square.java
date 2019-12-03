package domain;
import javafx.scene.paint.Color;


public class Square {
    private int size;
    private Color color;
    private int posX;
    private int posY;
    private Piece piece;

    public Square(int size, Color color, int posX, int posY) {
        this.size = size;
        this.color = color;
        this.posX = posX;
        this.posY = posY;
    }

    public boolean isEmpty(){
        if (this.piece ==null){
            return true;
        }
        else return false;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPosX() {
        return posX;
    }


    public Piece getPiece() {
        return piece;
    }


    public void setPiece(Piece piece) {
        this.piece = piece;
    }


    public int getPosY()
    {
        return posY;
    }

    public int getXIndex(){
        return this.posX/Board.SIZE_OF_SQUARE;
    }

    public int getYIndex(){
        return this.posY/Board.SIZE_OF_SQUARE;
    }
}

