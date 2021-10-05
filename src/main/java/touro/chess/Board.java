package touro.chess;

public class Board {

    private static final int COLUMNS = 8;
    private static final int ROWS = 8;
    private Square[][] squares = new Square[ROWS][COLUMNS];

    /**
     * Creates an empty board
     */
    public Board() {
        for (int column = 0; column < COLUMNS; column++) {
            for (int row = 0; row < ROWS; row++) {
                squares[column][row] = new Square(new Location(row, column));
            }
        }
    }

    public Square getSquare(Location location) {
        return squares[location.getRow()][location.getColumn()];
    }

    public boolean isOnBoard(Move move) {
        return isOnBoard(move.getFrom()) && isOnBoard(move.getTo());
    }

    public boolean isOnBoard(Location location) {
        return location.getRow() > -1 && location.getRow() < 8
                && location.getColumn() > 0 && location.getColumn() < 8;
    }

    public void setPiece(Location location, AbstractPiece piece) {
        squares[location.getRow()][location.getColumn()].setPiece(piece);
    }

    /**
     * Verify that a Move is legal on this Board.
     *
     * @param move
     * @return true if the Move is legal, otherwise false.
     */
    public boolean isLegal(Move move) {
        int currentRow = move.getFrom().getRow();
        int currentColumn = move.getFrom().getColumn();
        int destinationRow = move.getTo().getRow();
        int destinationColumn = move.getTo().getColumn();

        if (!isOnBoard(move)) {
            return false;
        }

        Square currentSquare = getSquare(move.getFrom());
        Square destinationSquare = getSquare(move.getTo());
        AbstractPiece currentPiece = currentSquare.getPiece();
        AbstractPiece destinationPiece = destinationSquare.getPiece();

        if (currentPiece == null) {
            return false;
        } else if (currentSquare == destinationSquare) {
            return false;
        } else if (destinationPiece != null) {
            if (destinationSquare.hasPiece() && destinationPiece.getColor() == currentPiece.getColor()) {
                return false;
            }
        } else {   //if destination is empty or contains opposing color piece
            if (move.isJump()) {
                return true;
            } else {
                while (currentRow != destinationRow || currentColumn != destinationColumn) {
                    if (currentRow < destinationRow) {
                        currentRow++;
                    }
                    else if (currentRow > destinationRow){
                        currentRow--;
                    }
                    if (currentColumn < destinationColumn) {
                        currentColumn++;
                    } else if (currentColumn > destinationColumn) {
                        currentColumn--;
                    }
                    if(squares[currentRow][currentColumn].hasPiece()){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}