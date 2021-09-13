package touro.chess;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class RookPieceTest
{

    @Test
    public void getMoves00()
    {
        //given
        RookPiece rook = new RookPiece(new Location(0,0), PieceColor.Black);
        //when
        List<Move> list = rook.getMoves();
        //then
        for(Move move: list)
        {
            assertTrue(move.getTo().getColumn()==0 || move.getTo().getRow()==0);
        }
    }
    @Test
    public void getMoves88()
    {
        //given
        RookPiece rook = new RookPiece(new Location(8,8), PieceColor.Black);
        //when
        List<Move> list = rook.getMoves();
        //then
        for(Move move: list)
        {
            assertTrue(move.getTo().getColumn()==0 || move.getTo().getRow()==0);
        }
    }
    @Test
    public void getMoves24()
    {
        //given
        RookPiece rook = new RookPiece(new Location(2,4), PieceColor.Black);
        //when
        List<Move> list = rook.getMoves();
        //then
        for(Move move: list)
        {
            assertTrue(move.getTo().getColumn()==0 || move.getTo().getRow()==0);
        }
    }
}