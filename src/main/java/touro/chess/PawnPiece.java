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

        if (super.getColor().toString().equals("Black")) {
            //add 1,0 or 2,0 and 1,1 1,-1

            if (row == 2) {
                moves.add(new Move(location, new Location(row + 2, col), false, false));
            } else {
                moves.add(new Move(location, new Location(row + 1, col), false, false));
            }


            moves.add(new Move(location, new Location(row + 1, col + 1), false, true));
            moves.add(new Move(location, new Location(row + 1, col - 1), false, true));

        } else if (super.getColor().toString().equals("White")) {
            //add -1,0 or -2,0 and -1,-1 -1,+1

            if (row == 7) {
                moves.add(new Move(location, new Location(row - 2, col), false, false));
            }
            else{
                moves.add(new Move(location, new Location(row - 1, col), false, false));
            }

            moves.add(new Move(location, new Location(row - 1, col - 1), false, true));
            moves.add(new Move(location, new Location(row - 1, col + 1), false, true));

        }

        return moves;
    }
}