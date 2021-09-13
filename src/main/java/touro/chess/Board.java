package touro.chess;

public class Board {

    private static final int COLUMNS = 8;
    private static final int ROWS = 8;

    /**
     * Verify that a Move is legal on this Board.
     * @param move
     * @return true if the Move is legal, otherwise false.
     */
    public boolean isLegal(Move move) throws NullPointerException {
        Square currentSquare = new Square(move.getFrom());
        Square destinationSquare = new Square(move.getTo());
        int currentRow = move.getFrom().getRow();
        int currentColumn = move.getFrom().getColumn();
        int destinationRow = move.getTo().getRow();
        int destinationColumn = move.getTo().getColumn();
        AbstractPiece currentPiece = currentSquare.getPiece();
        AbstractPiece destinationPiece = destinationSquare.getPiece();

        //this checks if to or from is not on the board
        if (currentColumn < 1 || currentColumn > 8
            || currentRow < 1 || currentRow > 8
            || destinationColumn < 1 || destinationColumn > 8
            || destinationRow < 1 || destinationRow > 8)
        {
            return false;
        }
        else if(move.getFrom() == move.getTo()){
            return false;
        }
        else if (destinationPiece != null && currentPiece != null) {
            if (destinationSquare.hasPiece() && destinationPiece.getColor() == currentPiece.getColor()) {
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
                        currentSquare = new Square(new Location(row, currentColumn));
                        if (currentSquare.hasPiece()) {
                            return false;
                        }
                    }
                    return true;
                }
                //if move is backwards
                else if (currentRow > destinationRow) {
                    //decrement row, keep column
                    for (int row = (currentRow - 1); row > (destinationRow - 1); row--) {
                        currentSquare = new Square(new Location(row, currentColumn));
                        if (currentSquare.hasPiece()) {
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
                        currentSquare = new Square(new Location(currentRow, col));
                        if (currentSquare.hasPiece()) {
                            return false;
                        }
                    }
                }
                //if move is to the left
                else {
                    //decrement column, keep row
                    for (int col = (currentColumn - 1); col > (destinationColumn - 1); col--) {
                        currentSquare = new Square(new Location(currentRow, col));
                        if (currentSquare.hasPiece()) {
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
                            currentSquare = new Square(new Location(row, col));
                            if (currentSquare.hasPiece()) {
                                return false;
                            }
                        }
                    }
                    //if move is to the left
                    else {
                        //increment row, decrement column
                        for (int col = (currentColumn - 1); col > (destinationColumn - 1); col--) {
                            row++;
                            currentSquare = new Square(new Location(row, col));
                            if (currentSquare.hasPiece()) {
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
                            currentSquare = new Square(new Location(row, col));
                            if (currentSquare.hasPiece()) {
                                return false;
                            }
                        }
                    }
                    //if move is to the left
                    else {
                        //decrement row, decrement column
                        for (int col = (currentColumn - 1); col > (destinationColumn - 1); col--) {
                            row--;
                            currentSquare = new Square(new Location(row, col));
                            if (currentSquare.hasPiece()) {
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
