package touro.chess;

import java.util.ArrayList;
import java.util.List;

public class BishopPiece extends AbstractPiece
{
    public BishopPiece(Location location, PieceColor color)
    {
        super(location, color);
    }

    @Override
    public List<Move> getMoves()
    {
        List<Move> moves = new ArrayList<>();
//        int row = this.getLocation().getRow();
//        int col = this.getLocation().getColumn();

        //Possible moves to the upper left
        for(int row = this.getLocation().getRow(), col = this.getLocation().getColumn();
            col >= 1; row--, col--)
        {
            Location newLocation = new Location(row, col);
            moves.add(new Move(this.getLocation(), newLocation, false));
        }

//        //Possible moves to the lower left
//        for(int row = this.getLocation().getRow(), col = this.getLocation().getColumn();
//            col >= 1; row++, col--)
//        {
//            Location newLocation = new Location(row, col);
//            moves.add(new Move(this.getLocation(), newLocation, false));
//        }
//
//        //Possible moves to the upper right
//        for(int row = this.getLocation().getRow(), col = this.getLocation().getColumn();
//            col <= 8; row--, col++)
//        {
//            Location newLocation = new Location(row, col);
//            moves.add(new Move(this.getLocation(), newLocation, false));
//        }
//
//        //Possible moves to the lower right
//        for(int row = this.getLocation().getRow(), col = this.getLocation().getColumn();
//            col <= 8; row++, col++)
//        {
//            Location newLocation = new Location(row, col);
//            moves.add(new Move(this.getLocation(), newLocation, false));
//        }
        return moves;
    }
}
