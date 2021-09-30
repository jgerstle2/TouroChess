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
        practiceList.add(new Move(startPosition,new Location(5,4),false));
        practiceList.add(new Move(startPosition,new Location(3,4),false));
        practiceList.add(new Move(startPosition,new Location(4,5),false));
        practiceList.add(new Move(startPosition,new Location(4,3),false));
        practiceList.add(new Move(startPosition,new Location(5,3),false));
        practiceList.add(new Move(startPosition,new Location(3,3),false));
        practiceList.add(new Move(startPosition,new Location(5,5),false));
        practiceList.add(new Move(startPosition,new Location(3,5),false));

        //when
        List<Move> legalMoves = king.getMoves();

        //then
        assertEquals(legalMoves.get(0).getTo().getColumn(),practiceList.get(0).getTo().getColumn());
        assertEquals(legalMoves.get(0).getTo().getRow(),practiceList.get(0).getTo().getRow());
        assertEquals(legalMoves.get(1).getTo().getColumn(),practiceList.get(1).getTo().getColumn());
        assertEquals(legalMoves.get(1).getTo().getRow(),practiceList.get(1).getTo().getRow());
        assertEquals(legalMoves.get(2).getTo().getColumn(),practiceList.get(2).getTo().getColumn());
        assertEquals(legalMoves.get(2).getTo().getRow(),practiceList.get(2).getTo().getRow());
        assertEquals(legalMoves.get(3).getTo().getColumn(),practiceList.get(3).getTo().getColumn());
        assertEquals(legalMoves.get(3).getTo().getRow(),practiceList.get(3).getTo().getRow());
        assertEquals(legalMoves.get(4).getTo().getColumn(),practiceList.get(4).getTo().getColumn());
        assertEquals(legalMoves.get(4).getTo().getRow(),practiceList.get(4).getTo().getRow());
        assertEquals(legalMoves.get(5).getTo().getColumn(),practiceList.get(5).getTo().getColumn());
        assertEquals(legalMoves.get(5).getTo().getRow(),practiceList.get(5).getTo().getRow());
        assertEquals(legalMoves.get(6).getTo().getColumn(),practiceList.get(6).getTo().getColumn());
        assertEquals(legalMoves.get(6).getTo().getRow(),practiceList.get(6).getTo().getRow());
        assertEquals(legalMoves.get(7).getTo().getColumn(),practiceList.get(7).getTo().getColumn());
        assertEquals(legalMoves.get(7).getTo().getRow(),practiceList.get(7).getTo().getRow());
    }
}