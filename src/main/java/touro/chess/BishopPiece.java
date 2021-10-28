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
        int currentRow = this.getLocation().getRow();
        int currentCol = this.getLocation().getColumn();

        //Possible moves to the upper left
        for(int row = (currentRow) - 1, col = (currentCol) - 1;
            col >= 0 && row >= 0; row--, col--)
        {
            moves.add(new Move(this.getLocation(), new Location(row, col)));
        }

        //Possible moves to the lower left
        for(int row = (currentRow) + 1, col = (currentCol) - 1;
            col >= 0 && row <= 7; row++, col--)
        {
            moves.add(new Move(this.getLocation(), new Location(row, col)));
        }

        //Possible moves to the upper right
        for(int row = (currentRow) - 1, col = (currentCol) + 1;
            col <= 7 && row >= 0; row--, col++)
        {
            moves.add(new Move(this.getLocation(), new Location(row, col)));
        }

        //Possible moves to the lower right
        for(int row = (currentRow) + 1, col = (currentCol) + 1;
            col <= 7 && row <= 7; row++, col++)
        {
            moves.add(new Move(this.getLocation(), new Location(row, col)));
        }
        return moves;
    }
}
