package touro.chess;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class QueenPieceTest {
    @Test
    public void getMoves() {
        //given
        Location startLocation = new Location(2, 1);
        QueenPiece queenPiece = new QueenPiece(startLocation, PieceColor.White);
        List<Move> expectedMoveList = new ArrayList<>();
        expectedMoveList.add(new Move(startLocation, new Location(2,0))); //expected horizontal move
        expectedMoveList.add(new Move(startLocation, new Location(0,1))); //expected vertical move
        expectedMoveList.add(new Move(startLocation, new Location(3,2))); //expected diagonal up & right
        expectedMoveList.add(new Move(startLocation, new Location(1,0))); //expected diagonal down & left
        expectedMoveList.add(new Move(startLocation, new Location(3,0))); //expected diagonal up & left
        expectedMoveList.add(new Move(startLocation, new Location(1,2))); //expected diagonal down & right

        //when
        List<Move> moveList = queenPiece.getMoves();

        //then
        //check horizontal
        assertEquals(moveList.get(0), expectedMoveList.get(0));
        //check vertical
        assertEquals(moveList.get(8), expectedMoveList.get(1));
        //check up&right
        assertEquals(moveList.get(16), expectedMoveList.get(2));
        //check down&left
        assertEquals(moveList.get(21), expectedMoveList.get(3));
        //check up&left
        assertEquals(moveList.get(22), expectedMoveList.get(4));
        //check down&right
        assertEquals(moveList.get(23), expectedMoveList.get(5));
     }
}