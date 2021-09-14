package touro.chess;

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
    public boolean isLegal(Move move) {
        int currentRow = move.getFrom().getRow();
        int currentColumn = move.getFrom().getColumn();
        int destinationRow = move.getTo().getRow();
        int destinationColumn = move.getTo().getColumn();

        if (currentColumn < 0 || currentColumn > 7
                || currentRow < 0 || currentRow > 7
                || destinationColumn < 0 || destinationColumn > 7
                || destinationRow < 0 || destinationRow > 7)
        {
            return false;
        }

        Square currentSquare = squares[move.getFrom().getRow()][move.getFrom().getColumn()];
        Square destinationSquare = squares[move.getTo().getRow()][move.getTo().getColumn()];
        AbstractPiece currentPiece = currentSquare.getPiece();
        AbstractPiece destinationPiece = destinationSquare.getPiece();

        if (currentPiece == null){
            return false;
        }
        else if(move.getFrom() == move.getTo()){
            return false;
        }
        else if (destinationPiece != null) {
            if (destinationSquare.hasPiece() && destinationPiece.getColor().equals(currentPiece.getColor())) {
                return false;
            }
        }
        else {   //if destination is empty or contains opposing color piece
            if (move.isJump()) {
                return true;
            }
            else if (currentColumn == destinationColumn) { //vertical
                if (currentRow < destinationRow) { //forward
                    for (int row = (currentRow + 1); row < destinationRow; row++) { //increment row, keep column
                        if(squares[row][currentColumn].hasPiece()){
                            return false;
                        }
                    }
                }
                else{ //backwards
                    for (int row = (currentRow - 1); row > destinationRow; row--) { //decrement row, keep column
                        if(squares[row][currentColumn].hasPiece()){
                            return false;
                        }
                    }
                }
                return true;
            }
            else if (currentRow == destinationRow) { //horizontal
                if (currentColumn < destinationColumn) { //right
                    for (int col = (currentColumn + 1); col < destinationColumn; col++) { //increment column, keep row
                        if(squares[currentRow][col].hasPiece()){
                            return false;
                        }
                    }
                }
                else { //left
                    for (int col = (currentColumn - 1); col > destinationColumn; col--) { //decrement column, keep row
                        if(squares[currentRow][col].hasPiece()){
                            return false;
                        }
                    }
                }
                return true;
            }
            else if ((currentColumn - destinationColumn) == (currentRow - destinationRow)) { //diagonal
                int row = currentRow;
                if (currentRow < destinationRow) { //forward
                    if (currentColumn < destinationColumn) { //right
                        for (int col = (currentColumn + 1); col < destinationColumn; col++) { //increment row, increment column
                            row++;
                            if(squares[row][col].hasPiece()){
                                return false;
                            }
                        }
                    }
                    else { //left
                        for (int col = (currentColumn - 1); col > destinationColumn; col--) { //increment row, decrement column
                            row++;
                            if(squares[row][col].hasPiece()){
                                return false;
                            }
                        }
                    }
                }
                else { //backward
                    if (currentColumn < destinationColumn) { //right
                        for (int col = (currentColumn + 1); col < destinationColumn; col++) { //decrement row, increment column
                            row--;
                            if(squares[row][col].hasPiece()){
                                return false;
                            }
                        }
                    }
                    else { //left
                        for (int col = (currentColumn - 1); col > destinationColumn; col--) { //decrement row, decrement column
                            row--;
                            if(squares[row][col].hasPiece()){
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
