package touro.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KingPiece extends AbstractPiece{
    public KingPiece(Location location, PieceColor color) {
        super(location, color);
    }

    @Override
    public List<Move> getMoves() {
        Location currentLocation = getLocation();
        int currentRow = currentLocation.getRow();
        int currentColumn = currentLocation.getColumn();

        //all possible locations
        Location east = new Location(currentRow + 1, currentColumn);
        Location west = new Location(currentRow - 1, currentColumn);
        Location north = new Location(currentRow, currentColumn + 1);
        Location south = new Location(currentRow, currentColumn - 1);
        Location southEast = new Location(currentRow + 1, currentColumn -1);
        Location southWest = new Location(currentRow - 1, currentColumn -1);
        Location northEast = new Location(currentRow + 1, currentColumn + 1);
        Location northWest = new Location(currentRow - 1, currentColumn + 1);

        //list of all legal moves with all the locations
        ArrayList<Move> legalMoves = new ArrayList<>();
        legalMoves.add(new Move(currentLocation, east, false));
        legalMoves.add(new Move(currentLocation, west, false));
        legalMoves.add(new Move(currentLocation, north, false));
        legalMoves.add(new Move(currentLocation, south, false));
        legalMoves.add(new Move(currentLocation, southEast, false));
        legalMoves.add(new Move(currentLocation, southWest, false));
        legalMoves.add(new Move(currentLocation, northEast, false));
        legalMoves.add(new Move(currentLocation, northWest, false));

        return legalMoves;
    }
}
