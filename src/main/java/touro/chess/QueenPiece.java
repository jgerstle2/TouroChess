package touro.chess;

import java.util.List;

public class QueenPiece extends AbstractPiece{

    public QueenPiece(Location location, PieceColor color) {
        super(location, color);
    }

    @Override
    public List<Move> getMoves() {
        Location currentLocation = this.getLocation();
        int row = currentLocation.getRow();
        int col = currentLocation.getColumn();
        List<Move> moveList = null;

        //horizontal moves:
        for (int x = 1; x <= 8; x++){
            moveList.add(new Move(currentLocation, new Location(x,row),false));
        }
        //vertical moves:
        for (int y = 1; y <= 8; y++){
            moveList.add(new Move(currentLocation, new Location(col,y), false));
        }

        //diagonal moves:
        int x, y;

        //up & right
        x = col +1;
        y = row +1;
        while(x < 9 && y < 9 ){
            moveList.add(new Move(currentLocation, new Location(x,y),false));
            x++;
            y++;
        }

        //down & left
        x = col-1;
        y = row-1;
        while(x > 0 && y > 0 ){
            moveList.add(new Move(currentLocation, new Location(x,y),false));
            x--;
            y--;
        }

        //up & left
        x = col-1;
        y = row+1;
        while(x > 0 && y < 9 ){
            moveList.add(new Move(currentLocation, new Location(x,y),false));
            x--;
            y++;
        }

        //down & right
        x = col+1;
        y = row-1;
        while(x < 9 && y > 0 ){
            moveList.add(new Move(currentLocation, new Location(x,y),false));
            x++;
            y--;
        }

        //ensure that all moves in list are legal?
        return moveList;
    }
}
