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

        int movement;
        int startingRow;
        int neverRow;

        // Black movement = 1, white = -1
        //starting row black = 1 and white = 6
        //Black can never be in row 7 and white can never be in row 0

        if (getColor() == PieceColor.Black) {
            movement = 1;
            startingRow = 1;
            neverRow = 7;
        } else {
            movement = -1;
            startingRow = 6;
            neverRow = 0;
        }

        //if this is first move
        if (row == startingRow) {
            moves.add(new Move(location, new Location(row + movement + movement, col), false, false));
        }

        //move forward
        if (row != neverRow) {
            moves.add(new Move(location, new Location(row + movement, col), false, false));

            //move to the left
            if (col != 7) {
                moves.add(new Move(location, new Location(row + movement, col + 1), false, true));
            }

            //move to the right
            if (col != 0) {
                moves.add(new Move(location, new Location(row + movement, col - 1), false, true));
            }
        }
        return moves;
    }


}