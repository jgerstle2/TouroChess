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

        //all possible new locations
        List<Location> possibleLocations = Arrays.asList(
                new Location(currentRow + 1, currentColumn),
                new Location(currentRow - 1, currentColumn),
                new Location(currentRow,currentColumn + 1),
                new Location(currentRow, currentColumn - 1),
                new Location(currentRow + 1, currentColumn -1),
                new Location(currentRow -1, currentColumn -1),
                new Location(currentRow + 1, currentColumn + 1),
                new Location(currentRow -1, currentColumn + 1)
        );
        //check if the moves in possibleLocations are legal and then return list of all legal moves
        ArrayList<Move> legalMoves = new ArrayList<>();
        for (Location newLocation : possibleLocations){
            Move newMove = new Move(currentLocation,newLocation,false);
            Board board = new Board();
            if (board.isLegal(newMove)){
                legalMoves.add(newMove);
            }
        }
        return legalMoves;
    }
}
