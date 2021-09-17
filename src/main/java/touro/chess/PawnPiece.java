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

        if (getColor() == PieceColor.Black) {
            //assuming black starts at row 1 (assuming rows and col are from 0-7)
            //add 1,0 1,1 1,-1 and for row 1 or 6 add 2,0

            //if this is first move
            if (row == 1) {
                moves.add(new Move(location, new Location(row + 2, col), false, false));
            }

            //move forward one
            if (row != 7) {
                moves.add(new Move(location, new Location(row + 1, col), false, false));

                //move to the left
                if (col != 7) {
                    moves.add(new Move(location, new Location(row + 1, col + 1), false, true));
                }

                //move to the right
                if (col != 0) {
                    moves.add(new Move(location, new Location(row + 1, col - 1), false, true));
                }
            }

        } else if (getColor() == PieceColor.White) {
            //assuming white starts at row 6 (assuming rows and col are from 0-7)
            //add -1,0 -1,-1 -1,+1 and for row 1 or 6 add -2,0

            //if this is first move
            if (row == 6) {
                moves.add(new Move(location, new Location(row - 2, col), false, false));
            }

            //move forward one
            if (row != 0) {
                moves.add(new Move(location, new Location(row - 1, col), false, false));

                //move to the right
                if (col != 0) {
                    moves.add(new Move(location, new Location(row - 1, col - 1), false, true));
                }

                //move to the left
                if (col != 7) {
                    moves.add(new Move(location, new Location(row - 1, col + 1), false, true));
                }
            }
        }
        return moves;
    }
}