package application;

import domain.Board;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import domain.Square;

import java.util.ArrayList;

public class Controller {

    private Board board;
    private Square tempSquare;
    private boolean moveInProgress;
    public static ArrayList<Square> possibleMoves = new ArrayList<Square>();

    @FXML
    private Canvas backg, foreg, top;

    @FXML
    private void initialize() {
        board = new Board();
        drawBoard();
        drawPieces();  // New
    }

    private void drawBoard()  // (3) New
    {
        for (Square s : this.board.getAllSquares()) {
            drawSquare(s);
        }
    }

    private void drawPieces() {
        for (Square s : board.getAllSquares()) {
            if (s.getPiece() != null) {
                drawImage(s, s.getPiece().getImageUrl());
            }
        }
    }


    private void drawSquare(Square s) {
        GraphicsContext gc = backg.getGraphicsContext2D();
        gc.setFill(s.getColor());
        gc.fillRect(s.getPosX(), s.getPosY(), s.getSize(), s.getSize());
    }


    private void drawImage(Square s, String url) {
        GraphicsContext gc = foreg.getGraphicsContext2D();
        Image image = new Image(url);
        gc.drawImage(image, s.getPosX(), s.getPosY(), s.getSize(), s.getSize());
    }

    private void clearMarkedSquare(Square s) {
        GraphicsContext gc = foreg.getGraphicsContext2D();
        gc.clearRect(s.getPosX(), s.getPosY(), s.getSize(), s.getSize());
    }

    private void clearTopCanvas()
    {
        GraphicsContext gc = top.getGraphicsContext2D();
        gc.clearRect(0, 0, 600, 600);
    }

    private void drawMarker(Square s) {
        GraphicsContext gc = top.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.strokeRect(s.getPosX(), s.getPosY(), s.getSize(), s.getSize());
    }

    private boolean hasPiece(Square s) {
        boolean hasPiece = false;
        if (s.getPiece() != null) {
            hasPiece = true;
        }
        return hasPiece;
    }

    @FXML
    private void handlePressed(MouseEvent event) {
        Square actualSquare = board.getSquareAtPosition((int) event.getX(), (int) event.getY());
        if (actualSquare.isEmpty()){
            return;
        }
        possibleMoves = actualSquare.getPiece().getPotentialMoves(actualSquare);

        for (Square s : possibleMoves) {
            drawMarker(s);
        }


        // step 1 check that we have a piece
        this.moveInProgress = hasPiece(actualSquare);
        tempSquare = actualSquare;
        // step 2
        if (this.moveInProgress) {
            clearMarkedSquare(actualSquare);
        }
        System.out.println("(debug) moveInProgress = " + this.moveInProgress);
        System.out.println("(debug) index in x-direction : " + actualSquare.getXIndex());
        System.out.println("(debug) index in y-direction : " + actualSquare.getYIndex());
    }

    @FXML
    private void handleReleased(MouseEvent event) {
        Square actualSquare = board.getSquareAtPosition((int) event.getX(), (int) event.getY());
        if (tempSquare == null || tempSquare.isEmpty()){
            return;
        }
        System.out.println("actualSquare" + actualSquare.getPosX());
        clearTopCanvas();
        if (this.moveInProgress && isPossibleMove(actualSquare)) {
            System.out.println("moved piece to new location");
            actualSquare.setPiece(tempSquare.getPiece());
            drawImage(actualSquare, tempSquare.getPiece().getImageUrl());
            tempSquare.setPiece(null);
        } else {
            drawImage(tempSquare,tempSquare.getPiece().getImageUrl());
            System.out.println("moved back to orignal position");
        }
        this.moveInProgress = false;
    }

    private boolean isPossibleMove (Square square){
        for (Square s: possibleMoves) {
            if(s.getPosX() == square.getPosX() && s.getPosY() == square.getPosY()){
                return true;
            }
        }
        return false;
    }


}
