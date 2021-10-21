package touro.chess;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KingPieceTest {

    @Test
    public void getMoves() {
        //given
        Location startPosition = new Location(4,4);
        KingPiece king = new KingPiece(startPosition, PieceColor.Black);
        List<Move>practiceList = new ArrayList<>();
        practiceList.add(new Move(startPosition,new Location(5,4)));
        practiceList.add(new Move(startPosition,new Location(3,4)));
        practiceList.add(new Move(startPosition,new Location(4,5)));
        practiceList.add(new Move(startPosition,new Location(4,3)));
        practiceList.add(new Move(startPosition,new Location(5,3)));
        practiceList.add(new Move(startPosition,new Location(3,3)));
        practiceList.add(new Move(startPosition,new Location(5,5)));
        practiceList.add(new Move(startPosition,new Location(3,5)));
        //castle moves
        practiceList.add(new KingCastleMove(startPosition,new Location(4, 2)));
        practiceList.add(new KingCastleMove(startPosition,new Location(4, 6)));

        //when
        List<Move> legalMoves = king.getMoves();

        //then
        assertEquals(legalMoves, practiceList);
    }
}