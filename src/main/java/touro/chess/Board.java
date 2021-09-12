package touro.chess;

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
        for(int column = 0; column < COLUMNS; column++)
        {
            for (int row = 0; row < ROWS; row++)
            {
                Location location = new Location(row, column);
                PieceColor color = row < 2 ? PieceColor.White : PieceColor.Black;
                if (row == 1 || row == 6) //pawn
                {
                    //squares[column][row].setPiece(new PawnPiece(location, color));
                }
                else  if (row == 0 || row == 7)
                {
                    if (column == 0 || column == 7) //rook
                    {
                        //squares[column][row].setPiece(new RookPiece(location, color));
                    }
                    else if (column == 1 || column == 6) //knight
                    {
                        //squares[column][row].setPiece(new KnightPiece(location, color));
                    }
                    else if (column == 2 || column == 5) //bishop
                    {
                        //squares[column][row].setPiece(new BishopPiece(location, color));
                    }
                    else if(column == 3) //king
                    {
                        //squares[column][row].setPiece(new KingPiece(location, color));
                    }
                    else if (column == 4) //queen
                    {
                        //squares[column][row].setPiece(new QueenPiece(location, color));
                    }
                }

            }
        }
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
