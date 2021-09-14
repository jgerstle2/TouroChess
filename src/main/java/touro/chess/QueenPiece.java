package touro.chess;

import java.util.ArrayList;
import java.util.List;

public class QueenPiece extends AbstractPiece{

    public QueenPiece(Location location, PieceColor color) {
        super(location, color);
    }

    @Override
    public List<Move> getMoves() {
        List<Move> moveList = new ArrayList<>();
        Location currentLocation = this.getLocation();
        int row = currentLocation.getRow();
        int col = currentLocation.getColumn();
        int newCol;
        int newRow;

        //horizontal moves:
        for (newCol = 1; newCol <= 8; newCol++){
            moveList.add(new Move(currentLocation, new Location(row, newCol),false));
        }
        //vertical moves:
        for (newRow = 1; newRow <= 8; newRow++){
            moveList.add(new Move(currentLocation, new Location(newRow, col), false));
        }

        //diagonal moves:
        //up & right
        newCol = col +1;
        newRow = row +1;
        while(newCol < 9 && newRow < 9 ){
            moveList.add(new Move(currentLocation, new Location(newRow,newCol),false));
            newCol++;
            newRow++;
        }

        //down & left
        newCol = col-1;
        newRow = row-1;
        while(newCol > 0 && newRow > 0 ){
            moveList.add(new Move(currentLocation, new Location(newRow,newCol),false));
            newCol--;
            newRow--;
        }

        //up & left
        newCol = col-1;
        newRow = row+1;
        while(newCol > 0 && newRow < 9 ){
            moveList.add(new Move(currentLocation, new Location(newRow,newCol),false));
            newCol--;
            newRow++;
        }

        //down & right
        newCol = col+1;
        newRow = row-1;
        while(newCol < 9 && newRow > 0 ){
            moveList.add(new Move(currentLocation, new Location(newRow,newCol),false));
            newCol++;
            newRow--;
        }

        //ensure that all moves in list are legal?
        return moveList;
    }
}
