package touro.chess;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;


public class RookPieceTest
{

    @Test
    public void getMoves00()
    {
        //given
        Location location = new Location(0,0);
        RookPiece rook = new RookPiece(location, PieceColor.Black);
        List<Move> validValues = new ArrayList<>();
        for(int row = location.getRow()+1; row < 8; ++row)
        {
            validValues.add(new Move(location, new Location(row, location.getColumn()), false));
        }
        for(int col = location.getColumn()+1; col < 8; ++col)
        {
            validValues.add(new Move(location, new Location(location.getRow(), col), false));
        }
        //when
        List<Move> list = rook.getMoves();
        //then
        int count = 0;

        for(Move move: list)
        {
            assertEquals(move.getTo().getColumn(),validValues.get(count).getTo().getColumn());
            assertEquals(move.getTo().getRow(),validValues.get(count).getTo().getRow());
            count++;
        }
    }
    @Test
    public void getMoves88()
    {
        //given
        Location location = new Location(7,7);
        RookPiece rook = new RookPiece(new Location(7,7), PieceColor.Black);
        List<Move> validValues = new ArrayList<>();
        for(int row = 0; row < 7; ++row)
        {
            validValues.add(new Move(location, new Location(row, location.getColumn()), false));
        }
        for(int col = 0; col < 7; ++col)
        {
            validValues.add(new Move(location, new Location(location.getRow(), col), false));
        }
        //when
        List<Move> list = rook.getMoves();
        //then
        int count = 0;
        for(Move move: list)
        {
            assertEquals(move.getTo().getColumn(),validValues.get(count).getTo().getColumn());
            assertEquals(move.getTo().getRow(),validValues.get(count).getTo().getRow());
            count++;
        }
    }
    @Test
    public void getMoves24()
    {
        //given
        Location location = new Location(2,4);
        RookPiece rook = new RookPiece(new Location(2,4), PieceColor.Black);
        List<Move> validValues = new ArrayList<>();
        for(int row = 0; row < 8; ++row)
        {
            if (location.getRow() != row)
            {
                validValues.add(new Move(location, new Location(row, location.getColumn()), false));
            }
        }
        for(int col = 0; col < 8; ++col)
        {
            if (location.getColumn() != col)
            {
                validValues.add(new Move(location, new Location(location.getRow(), col), false));
            }
        }
        //when
        List<Move> list = rook.getMoves();
        //then
        int count = 0;
        for(Move move: list)
        {
            assertEquals(move.getTo().getColumn(),validValues.get(count).getTo().getColumn());
            assertEquals(move.getTo().getRow(),validValues.get(count).getTo().getRow());
            count++;
        }
    }
}