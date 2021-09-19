package touro.chess;

import touro.chess.AbstractPiece;
import touro.chess.Location;
import touro.chess.Move;
import touro.chess.PieceColor;

import java.util.ArrayList;
import java.util.List;

public class PawnPiece extends AbstractPiece {

    public PawnPiece(Location location, PieceColor color) {
        super(location, color);
    }

    @Override
    public List<Move> getMoves() {
        Location location = super.getLocation();
        int row = location.getRow();
        int col = location.getColumn();

        List<Move> moves = new ArrayList<Move>();

        int movement = 1;
        int firstMovement;
        int startingRow;


        if (getColor() == PieceColor.Black) {
            //assuming black starts at row 1 (assuming rows and col are from 0-7)
            //add 1,0 1,1 1,-1 and for row 1 or 6 add 2,0
            startingRow = 1;

            //if this is first move
            if (row == startingRow) {
                firstMovement = 2;
                moves.add(new Move(location, new Location(row + firstMovement, col), false, false));
            }

            //move forward
            if (row != 7) {
                moves.add(new Move(location, new Location(row + movement, col), false, false));

                //move to the left
                if (col != 7) {
                    moves.add(new Move(location, new Location(row + movement, col + movement), false, true));
                }

                //move to the right
                if (col != 0) {
                    moves.add(new Move(location, new Location(row + movement, col - movement), false, true));
                }
            }
        } else {
            startingRow = 6;

            //if this is first move
            if (row == startingRow) {
                firstMovement = -2;
                moves.add(new Move(location, new Location(row + firstMovement, col), false, false));
            }

            if (row != 0) {
                moves.add(new Move(location, new Location(row - movement, col), false, false));

                //move to the right
                if (col != 0) {
                    moves.add(new Move(location, new Location(row - movement, col - movement), false, true));
                }

                //move to the left
                if (col != 7) {
                    moves.add(new Move(location, new Location(row - movement, col + movement), false, true));
                }
            }
        }
        return moves;
    }


}