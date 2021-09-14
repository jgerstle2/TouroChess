package touro.chess;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class kingPieceTest {

    @Test
    public void getMoves() {
        //given
        Location startPosition = new Location(4,4);
        kingPiece king = new kingPiece(startPosition, PieceColor.Black);
        List<Move>practiceList = new ArrayList<>();
        practiceList.add(new Move(startPosition,new Location(3,3),false));
        practiceList.add(new Move(startPosition,new Location(4,3),false));
        practiceList.add(new Move(startPosition,new Location(5,3),false));
        practiceList.add(new Move(startPosition,new Location(3,4),false));
        practiceList.add(new Move(startPosition,new Location(3,5),false));
        practiceList.add(new Move(startPosition,new Location(4,5),false));
        practiceList.add(new Move(startPosition,new Location(5,5),false));
        practiceList.add(new Move(startPosition,new Location(5,4),false));

        //when
        List<Move> legalMoves = king.getMoves();

        //then
        assertEquals(practiceList,legalMoves);
    }
}