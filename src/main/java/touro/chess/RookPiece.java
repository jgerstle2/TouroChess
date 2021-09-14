package touro.chess;

import java.util.ArrayList;
import java.util.List;

public class RookPiece extends AbstractPiece
{
    private Object Move;

    public RookPiece(Location location, PieceColor color)
    {
        super(location, color);
    }

    @Override
    public List<Move> getMoves()
    {
        List<Move> List = new ArrayList<Move>();
        Location curLocation = getLocation();
        //for every row on the board adding one to the original row placement
        for(int row=0; row < 9; row++)
        {
            Location newLoc = new Location(row, curLocation.getColumn());
            //check if the row and col are not the same as original location if not add new move to list
                if (curLocation.getRow() != newLoc.getRow() || curLocation.getColumn() != newLoc.getColumn())
                {
                    List.add(new Move(curLocation, newLoc,false));
                }
        }
        //for every col on the board adding one to the original col placement
        for(int col=0; col < 9; col++)
        {
            Location newLoc = new Location(curLocation.getRow(), col);
            //check if the row and col are not the same as original location if not add new move to list
            if (curLocation.getRow() != newLoc.getRow() || curLocation.getColumn() != newLoc.getColumn())
            {
                List.add(new Move(curLocation, newLoc,false));
            }
        }
        return List;
    }
}
