package domain;

import javafx.scene.paint.Color;

public class Board {

    /**
     * The number of squares in a row (horizontally and vertically)
     */
    public static final int SIZE_OF_SQUARE = 75;
    private final int NUMBER_OF_SQUARES = 8;


    private final Square[][] squares = new Square[NUMBER_OF_SQUARES][NUMBER_OF_SQUARES];


    public Board(){
        this.placeAllSquares();
        this.placeAllPieces();
    }

    private void placeAllSquares(){

        for (int i = 0; i < NUMBER_OF_SQUARES; i++){
            for(int j = 0; j < NUMBER_OF_SQUARES; j++){
                if ((j+i)%2 ==0) {
                    squares[i][j] = new Square(SIZE_OF_SQUARE,Color.WHITE ,j* SIZE_OF_SQUARE, i* SIZE_OF_SQUARE);
                }else {
                    squares[i][j] = new Square(SIZE_OF_SQUARE, Color.GRAY,j* SIZE_OF_SQUARE, i* SIZE_OF_SQUARE);
                }
            }
        }
    }

    // New
    private void placeAllPieces()
    {
        // Placing the white pieces:
        squares[7][1].setPiece(new Knight("file:src/presentation/resources/Chess_nlt60.png",Color.WHITE));
        squares[7][6].setPiece(new Knight("file:src/presentation/resources/Chess_nlt60.png",Color.WHITE));
        squares[7][7].setPiece(new Rook("file:src/presentation/resources/Chess_rlt60.png",Color.WHITE));
        squares[7][0].setPiece(new Rook("file:src/presentation/resources/Chess_rlt60.png",Color.WHITE));
        squares[7][2].setPiece(new Bishop("Presentation/resources/Chess_plt60.png",Color.WHITE));
        squares[7][5].setPiece(new Bishop("Presentation/resources/Chess_plt60.png",Color.WHITE));


        // Placing the black pieces:
        squares[0][7].setPiece(new Rook("file:src/presentation/resources/Chess_rdt60.png",Color.BLACK));
        squares[0][0].setPiece(new Rook("file:src/presentation/resources/Chess_rdt60.png",Color.BLACK));
        squares[0][1].setPiece(new Knight("file:src/presentation/resources/Chess_ndt60.png",Color.BLACK));
        squares[0][6].setPiece(new Knight("file:src/presentation/resources/Chess_ndt60.png",Color.BLACK));
        squares[0][2].setPiece(new Bishop("Presentation/resources/Chess_pdt60.png",Color.BLACK));
        squares[0][5].setPiece(new Bishop("Presentation/resources/Chess_pdt60.png",Color.BLACK));

    }

    /**
     * For drawing the board based on squares
     * @return an array of all square objects on this board
     */
    public Square[] getAllSquares() {
        int index = 0;
        Square [] result = new Square[NUMBER_OF_SQUARES * NUMBER_OF_SQUARES];

        for (int y = 0; y < NUMBER_OF_SQUARES; y++){
            for(int x = 0; x < NUMBER_OF_SQUARES; x++){
                result[index] = this.squares[y][x];
                index++;
            }
        }
        return result;
    }

    /**
     * Gets the square
     * @param x
     * @param y
     * @return
     */
    public Square getSquareAtPosition(int x, int y){
        int posX = x/ SIZE_OF_SQUARE;
        int posY = y/ SIZE_OF_SQUARE;
        return this.squares[posY][posX];
    }

}
