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
            assertTrue(move.getTo().getColumn()==0 ^ move.getTo().getRow()==0);
        }
    }
    @Test
    public void getMoves88()
    {
        //given
        RookPiece rook = new RookPiece(new Location(7,7), PieceColor.Black);
        //when
        List<Move> list = rook.getMoves();
        //then
        for(Move move: list)
        {
            assertTrue(move.getTo().getColumn()==7 ^ move.getTo().getRow()==7);
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
            assertTrue(move.getTo().getRow()==2 ^ move.getTo().getColumn()==4);
        }
    }
}