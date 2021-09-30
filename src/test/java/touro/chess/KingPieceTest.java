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
        for (int i = 0; i<=7; i++){
            assertEquals(legalMoves.get(i).getTo().getColumn(),practiceList.get(i).getTo().getColumn());
            assertEquals(legalMoves.get(i).getTo().getRow(),practiceList.get(i).getTo().getRow());
        }
    }
}