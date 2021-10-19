package touro.chess;

import java.util.ArrayList;
import java.util.List;

public class KnightPiece extends AbstractPiece {

    public KnightPiece(Location location, PieceColor color) {
        super(location, color);
    }

    @Override
    public List<Move> getMoves() {
        Location currentLocation = getLocation();
        int row = currentLocation.getRow();
        int col = currentLocation.getColumn();

        List<Move> moves = new ArrayList<>();
        moves.add( new JumpMove(getLocation(), new Location(row + 1, col + 2)));
        moves.add( new JumpMove(getLocation(), new Location(row - 1, col + 2)));
        moves.add( new JumpMove(getLocation(), new Location(row + 1, col - 2)));
        moves.add( new JumpMove(getLocation(), new Location(row - 1, col - 2)));
        moves.add( new JumpMove(getLocation(), new Location(row + 2, col - 1)));
        moves.add( new JumpMove(getLocation(), new Location(row + 2, col + 1)));
        moves.add( new JumpMove(getLocation(), new Location(row - 2, col - 1)));
        moves.add( new JumpMove(getLocation(), new Location(row - 2, col + 1)));

        return moves;
    }
}
