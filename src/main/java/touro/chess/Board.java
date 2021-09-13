package touro.chess;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Board {

    private static final int COLUMNS = 8;
    private static final int ROWS = 8;
    private Square[][] squares = new Square[COLUMNS][ROWS];

    /**
     * Creates an empty board
     */
    public Board()
    {
        for(int column = 0; column < COLUMNS; column++) {
            for (int row = 0; row < ROWS; row++) {
                squares[column][row] = new Square(new Location(row, column));
            }
        }
    }

    /**
     * Sets up the board at the beginning of the game
     */

    public void setUpBoard()
    {
        //pawns
        for(int column = 0; column < COLUMNS; column++)
        {
            int rowWhite = 1;
            int rowBlack = 6;
            squares[column][rowWhite].setPiece(new PawnPiece(new Location(rowWhite, column), PieceColor.White));
            squares[column][rowBlack].setPiece(new PawnPiece(new Location(rowBlack, column), PieceColor.Black));
        }
        int rowWhite = 0;
        int rowBlack = 7;
        //rooks
        squares[0][rowWhite].setPiece(new RookPiece(new Location(rowWhite, 0), PieceColor.White));
        squares[7][rowWhite].setPiece(new RookPiece(new Location(rowWhite, 7), PieceColor.White));
        squares[0][rowBlack].setPiece(new RookPiece(new Location(rowBlack, 0), PieceColor.Black));
        squares[7][rowBlack].setPiece(new RookPiece(new Location(rowBlack, 7), PieceColor.White));
        //knights
        squares[1][rowWhite].setPiece(new KnightPiece(new Location(rowWhite, 1), PieceColor.White));
        squares[6][rowWhite].setPiece(new KnightPiece(new Location(rowWhite, 6), PieceColor.White));
        squares[1][rowBlack].setPiece(new KnightPiece(new Location(rowBlack, 1), PieceColor.Black));
        squares[6][rowBlack].setPiece(new KnightPiece(new Location(rowBlack, 6), PieceColor.White));
        //bishop
        squares[2][rowWhite].setPiece(new BishopPiece(new Location(rowWhite, 2), PieceColor.White));
        squares[5][rowWhite].setPiece(new BishopPiece(new Location(rowWhite, 5), PieceColor.White));
        squares[2][rowBlack].setPiece(new BishopPiece(new Location(rowBlack, 2), PieceColor.Black));
        squares[5][rowBlack].setPiece(new BishopPiece(new Location(rowBlack, 5), PieceColor.White));
        //king
        squares[3][rowWhite].setPiece(new KingPiece(new Location(rowWhite, 3), PieceColor.White));
        squares[3][rowBlack].setPiece(new KingPiece(new Location(rowBlack, 3), PieceColor.Black));
        //queen
        squares[4][rowWhite].setPiece(new QueenPiece(new Location(rowWhite, 4), PieceColor.White));
        squares[4][rowBlack].setPiece(new QueenPiece(new Location(rowBlack, 4), PieceColor.Black));

    }

    /**
     * Returns the piece at a given location
     * @param location
     * @return AbstractPiece if there is a piece there, otherwise null
     */
    public @Nullable AbstractPiece getPiece(Location location)
    {
        return squares[location.getColumn()][location.getRow()].getPiece();
    }


    /**
     * Verify that a Move is legal on this Board.
     * @param move
     * @return true if the Move is legal, otherwise false.
     */
    public boolean isLegal(Move move) {
        return false;
    }

}
