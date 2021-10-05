package touro.chess;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BishopPieceTest
{
    @Test
    public void getMoves()
    {
        //given
        Location location = new Location(4,4);
        BishopPiece bishop = new BishopPiece(location, PieceColor.Black);
        List<Move> expectedMoves = new ArrayList<>();

        //Expected moves to the upper left
        expectedMoves.add(new Move(location, new Location(3, 3), false));
        expectedMoves.add(new Move(location, new Location(2, 2), false));
        expectedMoves.add(new Move(location, new Location(1, 1), false));
        expectedMoves.add(new Move(location, new Location(0, 0), false));

        //Expected moves the lower left
        expectedMoves.add(new Move(location, new Location(5, 3), false));
        expectedMoves.add(new Move(location, new Location(6, 2), false));
        expectedMoves.add(new Move(location, new Location(7, 1), false));

        //Expected moves to the upper right
        expectedMoves.add(new Move(location, new Location(3, 5), false));
        expectedMoves.add(new Move(location, new Location(2, 6), false));
        expectedMoves.add(new Move(location, new Location(1, 7), false));

        //Expected moves to the lower right
        expectedMoves.add(new Move(location, new Location(5, 5), false));
        expectedMoves.add(new Move(location, new Location(6, 6), false));
        expectedMoves.add(new Move(location, new Location(7, 7), false));

        //when
        List<Move> moves = bishop.getMoves();

        //then
        for(int ii = 0; ii < expectedMoves.size(); ii++)
        {
            Assert.assertEquals(expectedMoves.get(ii).getTo().getRow(), moves.get(ii).getTo().getRow());
            Assert.assertEquals(expectedMoves.get(ii).getTo().getColumn(), moves.get(ii).getTo().getColumn());
        }
    }
}