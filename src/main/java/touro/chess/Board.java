package touro.chess;

public class Board {

    private static final int COLUMNS = 8;
    private static final int ROWS = 8;

    /**
     * Verify that a Move is legal on this Board.
     * @param move
     * @return true if the Move is legal, otherwise false.
     */
    public boolean isLegal(Move move) {
        Square currentSquare = new Square(move.getFrom());
        Square destinationSquare = new Square(move.getTo());
        AbstractPiece currentPiece = currentSquare.getPiece();
        AbstractPiece destinationPiece = destinationSquare.getPiece();

        //this checks if to or from is not on the board
        if (move.getFrom().getColumn() < 1 || move.getFrom().getColumn() > 8
            || move.getFrom().getRow() < 1 || move.getFrom().getRow() > 8
            || move.getTo().getColumn() < 1 || move.getTo().getColumn() > 8
            || move.getTo().getRow() < 1 || move.getTo().getRow() > 8)
        {
            return false;
        }
        else{ //do i have to check that the currentSquare isnt empty or do i assume it has a piece?
            if(destinationSquare.hasPiece() && destinationPiece.getColor().equals(currentPiece.getColor())){
                return false;   //returns false if destination has piece of same color
            }
            else{   //this runs if destination is empty or contains opposing color piece
                //if move is jump
                if(move.isJump()){
                    return true;
                }

                //if move is straight
                else if(currentSquare.getLocation().getColumn() == destinationSquare.getLocation().getColumn() ||
                   currentSquare.getLocation().getRow() == destinationSquare.getLocation().getRow()){
                    //loop through path until destination
                    //return false if any currentSquare has a piece, then break loop
                    //return true if each square is empty
                }
                //if move is diagonal
                //if current.col - destination.col equals current.row - destination.row
                else if((currentSquare.getLocation().getColumn() - destinationSquare.getLocation().getColumn())
                == (currentSquare.getLocation().getRow() - destinationSquare.getLocation().getRow())){
                    //loop through path until destination
                    //return false if any currentSquare has a piece, then break loop
                    //return true if each square is empty
                }
            }
        }
        return false;
    }

}
