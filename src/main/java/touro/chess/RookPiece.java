package touro.chess;

import java.util.ArrayList;
import java.util.List;

public class RookPiece extends AbstractPiece
{
    public RookPiece(Location location, PieceColor color)
    {
        super(location, color);
    }

    @Override
    public List<Move> getMoves()
    {
        List<Move> list = new ArrayList<>();
        Location curLocation = getLocation();
        //for every row on the board adding one to the original row placement
        for(int row=0; row < 8; row++)
        {
            Location newLocation = new Location(row, curLocation.getColumn());
            //check if the row and col are not the same as original location if not add new move to list
                if (curLocation.getRow() != newLocation.getRow() || curLocation.getColumn() != newLocation.getColumn())
                {
                    list.add(new Move(curLocation, newLocation));
                }
        }
        //for every col on the board adding one to the original col placement
        for(int col=0; col < 8; col++)
        {
            Location newLoc = new Location(curLocation.getRow(), col);
            //check if the row and col are not the same as original location if not add new move to list
            if (curLocation.getRow() != newLoc.getRow() || curLocation.getColumn() != newLoc.getColumn())
            {
                list.add(new Move(curLocation, newLoc));
            }
        }
        return list;
    }
}
