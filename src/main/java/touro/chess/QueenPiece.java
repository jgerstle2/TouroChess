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
        //right
        int x,y;
        x = col+2;
        while(x < 9){
            moveList.add(new Move(currentLocation, new Location(x,row),false));
            x+=2;
        }
        //left
        x = col-2;
        while (x > 0 ){
            moveList.add(new Move(currentLocation, new Location(x,row),false));
            x-=2;
        }

        //vertical moves:
        //up
        y = row+2;
        while (y < 9){
            moveList.add(new Move(currentLocation, new Location(col,y),false));
            y+=2;
        }
        //down
        y = row-2;
        while (y > 0){
            moveList.add(new Move(currentLocation, new Location(col,y),false));
            y-=2;
        }

        //diagonal moves:
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
