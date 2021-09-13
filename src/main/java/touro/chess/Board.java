package touro.chess;

import org.jetbrains.annotations.Nullable;

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
     * Verify that a Move is legal on this Board.
     * @param move
     * @return true if the Move is legal, otherwise false.
     */
    public boolean isLegal(Move move) throws NullPointerException, ArrayIndexOutOfBoundsException {
        Square currentSquare = squares[move.getFrom().getRow()][move.getFrom().getColumn()];
        Square destinationSquare = squares[move.getTo().getRow()][move.getTo().getColumn()];
        int currentRow = move.getFrom().getRow();
        int currentColumn = move.getFrom().getColumn();
        int destinationRow = move.getTo().getRow();
        int destinationColumn = move.getTo().getColumn();
        AbstractPiece currentPiece = currentSquare.getPiece();
        AbstractPiece destinationPiece = destinationSquare.getPiece();

        //this checks if to or from is not on the board
        if (currentColumn < 0 || currentColumn > 7
            || currentRow < 0 || currentRow > 7
            || destinationColumn < 0 || destinationColumn > 7
            || destinationRow < 0 || destinationRow > 7)
        {
            return false;
        }
        else if(move.getFrom() == move.getTo()){
            return false;
        }
        else if (destinationPiece != null && currentPiece != null) {
            if (destinationSquare.hasPiece() && destinationPiece.getColor().equals(currentPiece.getColor())) {
                return false;   //returns false if destination has piece of same color
            }
        }
        else {   //this runs if destination is empty or contains opposing color piece
            if (move.isJump()) {
                return true;
            }
            //if move is vertical
            else if (currentColumn == destinationColumn) {
                //if move is forward
                if (currentRow < destinationRow) {
                    //increment row, keep column
                    for (int row = (currentRow + 1); row < (destinationRow + 1); row++) {
                        currentSquare = squares[row][currentColumn];
                        if (currentSquare.getPiece() != null) {
                            return false;
                        }
                    }
                    return true;
                }
                //if move is backwards
                else if (currentRow > destinationRow) {
                    //decrement row, keep column
                    for (int row = (currentRow - 1); row > (destinationRow - 1); row--) {
                        currentSquare = squares[row][currentColumn];
                        if (currentSquare.getPiece() != null) {
                            return false;
                        }
                    }
                    return true;
                }
            }

            //if move is horizontal
            else if (currentRow == destinationRow) {
                //if move is to the right
                if (currentColumn < destinationColumn) {
                    //increment column, keep row
                    for (int col = (currentColumn + 1); col < (destinationColumn + 1); col++) {
                        currentSquare = squares[currentRow][col];
                        if (currentSquare.getPiece() != null) {
                            return false;
                        }
                    }
                }
                //if move is to the left
                else {
                    //decrement column, keep row
                    for (int col = (currentColumn - 1); col > (destinationColumn - 1); col--) {
                        currentSquare = squares[currentRow][col];
                        if (currentSquare.getPiece() != null) {
                            return false;
                        }
                    }
                }
                return true;
            }

            //if move is diagonal
            //if current.col - destination.col equals current.row - destination.row
            else if ((currentColumn - destinationColumn) == (currentRow - destinationRow)) {
                int row = currentRow;
                //if move is forward
                if (currentRow < destinationRow) {
                    //if move is to the right
                    if (currentColumn < destinationColumn) {
                        //increment row, increment column
                        for (int col = (currentColumn + 1); col < (destinationColumn + 1); col++) {
                            row++;
                            currentSquare = squares[row][col];
                            if (currentSquare.getPiece() != null) {
                                return false;
                            }
                        }
                    }
                    //if move is to the left
                    else {
                        //increment row, decrement column
                        for (int col = (currentColumn - 1); col > (destinationColumn - 1); col--) {
                            row++;
                            currentSquare = squares[row][col];
                            if (currentSquare.getPiece() != null) {
                                return false;
                            }
                        }
                    }
                }
                //if move is backward
                else {
                    //if move is to the right
                    if (currentColumn < destinationColumn) {
                        //decrement row, increment column
                        for (int col = (currentColumn + 1); col < (destinationColumn + 1); col++) {
                            row--;
                            currentSquare = squares[row][col];
                            if (currentSquare.getPiece() != null) {
                                return false;
                            }
                        }
                    }
                    //if move is to the left
                    else {
                        //decrement row, decrement column
                        for (int col = (currentColumn - 1); col > (destinationColumn - 1); col--) {
                            row--;
                            currentSquare = squares[row][col];
                            if (currentSquare.getPiece() != null) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
