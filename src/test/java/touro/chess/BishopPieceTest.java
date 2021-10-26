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
        expectedMoves.add(new Move(location, new Location(3, 3)));
        expectedMoves.add(new Move(location, new Location(2, 2)));
        expectedMoves.add(new Move(location, new Location(1, 1)));
        expectedMoves.add(new Move(location, new Location(0, 0)));

        //Expected moves the lower left
        expectedMoves.add(new Move(location, new Location(5, 3)));
        expectedMoves.add(new Move(location, new Location(6, 2)));
        expectedMoves.add(new Move(location, new Location(7, 1)));

        //Expected moves to the upper right
        expectedMoves.add(new Move(location, new Location(3, 5)));
        expectedMoves.add(new Move(location, new Location(2, 6)));
        expectedMoves.add(new Move(location, new Location(1, 7)));

        //Expected moves to the lower right
        expectedMoves.add(new Move(location, new Location(5, 5)));
        expectedMoves.add(new Move(location, new Location(6, 6)));
        expectedMoves.add(new Move(location, new Location(7, 7)));

        //when
        List<Move> moves = bishop.getMoves();

        //then
        assertEquals(expectedMoves, moves);
    }
}