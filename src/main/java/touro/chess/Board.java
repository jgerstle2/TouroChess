package touro.chess;

import org.jetbrains.annotations.Nullable;

import static touro.chess.PieceColor.Black;
import static touro.chess.PieceColor.White;

public class Board {

    private static final int COLUMNS = 8;
    private static final int ROWS = 8;
    private Square[][] squares = new Square[COLUMNS][ROWS];

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


    /**
     * Sets up the board at the beginning of the game
     */

    public void setUpBoard() {
        //pawns
        for (int column = 0; column < COLUMNS; column++) {
            int rowWhite = 1;
            int rowBlack = 6;
            squares[column][rowWhite].setPiece(new PawnPiece(new Location(rowWhite, column), White));
            squares[column][rowBlack].setPiece(new PawnPiece(new Location(rowBlack, column), Black));
        }
        int rowWhite = 0;
        int rowBlack = 7;
        //rooks
        squares[0][rowWhite].setPiece(new RookPiece(new Location(rowWhite, 0), White));
        squares[7][rowWhite].setPiece(new RookPiece(new Location(rowWhite, 7), White));
        squares[0][rowBlack].setPiece(new RookPiece(new Location(rowBlack, 0), Black));
        squares[7][rowBlack].setPiece(new RookPiece(new Location(rowBlack, 7), White));
        //knights
        squares[1][rowWhite].setPiece(new KnightPiece(new Location(rowWhite, 1), White));
        squares[6][rowWhite].setPiece(new KnightPiece(new Location(rowWhite, 6), White));
        squares[1][rowBlack].setPiece(new KnightPiece(new Location(rowBlack, 1), Black));
        squares[6][rowBlack].setPiece(new KnightPiece(new Location(rowBlack, 6), White));
        //bishop
        squares[2][rowWhite].setPiece(new BishopPiece(new Location(rowWhite, 2), White));
        squares[5][rowWhite].setPiece(new BishopPiece(new Location(rowWhite, 5), White));
        squares[2][rowBlack].setPiece(new BishopPiece(new Location(rowBlack, 2), Black));
        squares[5][rowBlack].setPiece(new BishopPiece(new Location(rowBlack, 5), White));
        //king
        squares[3][rowWhite].setPiece(new KingPiece(new Location(rowWhite, 3), White));
        squares[3][rowBlack].setPiece(new KingPiece(new Location(rowBlack, 3), Black));
        //queen
        squares[4][rowWhite].setPiece(new QueenPiece(new Location(rowWhite, 4), White));
        squares[4][rowBlack].setPiece(new QueenPiece(new Location(rowBlack, 4), Black));

    }

    /**
     * Returns the piece at a given location
     *
     * @param location
     * @return AbstractPiece if there is a piece there, otherwise null
     */
    public @Nullable AbstractPiece getPiece(Location location) {
        return squares[location.getColumn()][location.getRow()].getPiece();
    }

    public Square getSquare(Location location) {
        return squares[location.getColumn()][location.getRow()];
    }

    public boolean isOnBoard(Move move) {
        return isOnBoard(move.getFrom()) && isOnBoard(move.getTo());
    }

    public boolean isOnBoard(Location location) {
        return location.getRow() > -1 && location.getRow() < 8
                && location.getColumn() > 0 && location.getColumn() < 8;
    }

    public void setPiece(Location location, AbstractPiece piece) {
        squares[location.getColumn()][location.getRow()].setPiece(piece);
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
            if (move instanceof KnightMove) {
                return true;
            } else if (move instanceof PawnCaptureMove) {
                // TODO fill this out
            } else if (move instanceof KingCastleMove) {
                //TODO conditions
                //king not in check
                //not moving through check
                //king and rook haven't moved
                if (currentPiece.hasMoved()) {
                    return false;
                }
                //CASTLE RIGHT
                Square castleRight = getSquare(new Location(currentRow, currentColumn + 2));
                //check no pieces in between king and rook
                if (destinationSquare == castleRight) {
                    Square right = getSquare(new Location(currentRow, currentColumn + 1));
                    if (right.hasPiece() && castleRight.hasPiece()) {
                        return false;
                    }
                    //check there is a rook of the right color in that spot
                    Square rookSquare = getSquare(new Location(currentRow, currentColumn + 3));
                    AbstractPiece rookPiece = rookSquare.getPiece();
                    if (rookPiece != null) {
                        if (!rookSquare.hasPiece() && rookPiece.getColor() != currentPiece.getColor()) {
                            return false;
                        }
                    }
                }
                //CASTLE LEFT
                Square castleLeft = getSquare(new Location(currentRow, currentColumn - 2));
                //check no pieces in between king and rook
                if (destinationSquare == castleLeft) {
                    Square left = getSquare(new Location(currentRow, currentColumn - 1));
                    if (left.hasPiece() && castleLeft.hasPiece()) {
                        return false;
                    }
                    //check there is a rook of the right color in that spot
                    Square rookSquareLeft = getSquare(new Location(currentRow, currentColumn - 3));
                    AbstractPiece rookPieceLeft = rookSquareLeft.getPiece();
                    if (rookPieceLeft != null) {
                        if (!rookSquareLeft.hasPiece() && rookPieceLeft.getColor() != currentPiece.getColor()) {
                            return false;
                        }
                    }
                }
            } else {
                while (currentRow != destinationRow || currentColumn != destinationColumn) {
                    if (currentRow < destinationRow) {
                        currentRow++;
                    } else if (currentRow > destinationRow) {
                        currentRow--;
                    }
                    if (currentColumn < destinationColumn) {
                        currentColumn++;
                    } else if (currentColumn > destinationColumn) {
                        currentColumn--;
                    }
                    if (squares[currentColumn][currentRow].hasPiece()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}