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
        for(int row=0; row < 9; row++)
        {
            Location newLoc = new Location(row, curLocation.getColumn());
                if (curLocation.getRow() != newLoc.getRow() || curLocation.getColumn() != newLoc.getColumn())
                {
                    List.add(new Move(curLocation, newLoc,false));
                }
        }
        for(int col=0; col < 9; col++)
        {
            Location newLoc = new Location(curLocation.getRow(), col);
            if (curLocation.getRow() != newLoc.getRow() || curLocation.getColumn() != newLoc.getColumn())
            {
                List.add(new Move(curLocation, newLoc,false));
            }
        }
        return List;
    }
}
