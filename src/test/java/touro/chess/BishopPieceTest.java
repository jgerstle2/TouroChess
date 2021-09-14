package touro.chess;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BishopPieceTest
{
    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
    }

    @Test
    public void getMoves()
    {
        //given
        Location location = mock(Location.class);
        PieceColor color = PieceColor.Black;
        BishopPiece bishop = new BishopPiece(location, color);
        doReturn(4).when(bishop.getLocation()).getRow();
        doReturn(4).when(bishop.getLocation()).getColumn();
        List<Move> expectedMoves = new ArrayList<>();
        //Expected moves to the upper left
        expectedMoves.add(new Move(bishop.getLocation(), new Location(3, 3), false));
        expectedMoves.add(new Move(bishop.getLocation(), new Location(2, 2), false));
        expectedMoves.add(new Move(bishop.getLocation(), new Location(1, 1), false));

        //Expected moves the lower left
        expectedMoves.add(new Move(bishop.getLocation(), new Location(5, 3), false));
        expectedMoves.add(new Move(bishop.getLocation(), new Location(6, 2), false));
        expectedMoves.add(new Move(bishop.getLocation(), new Location(7, 1), false));

        //Expected moves to the upper right
        expectedMoves.add(new Move(bishop.getLocation(), new Location(3, 5), false));
        expectedMoves.add(new Move(bishop.getLocation(), new Location(2, 6), false));
        expectedMoves.add(new Move(bishop.getLocation(), new Location(1, 7), false));

        //Expected moves to the lower right
        expectedMoves.add(new Move(bishop.getLocation(), new Location(5, 5), false));
        expectedMoves.add(new Move(bishop.getLocation(), new Location(6, 6), false));
        expectedMoves.add(new Move(bishop.getLocation(), new Location(7, 7), false));
        expectedMoves.add(new Move(bishop.getLocation(), new Location(8, 8), false));

        //when
        List<Move> moves = bishop.getMoves();

        //then
        for(int ix = 0; ix < moves.size(); ix++)
        {
            Assert.assertEquals(expectedMoves.get(ix).getTo().getRow(), moves.get(ix).getTo().getRow());
            Assert.assertEquals(expectedMoves.get(ix).getTo().getColumn(), moves.get(ix).getTo().getColumn());
        }
    }
}