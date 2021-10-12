package touro.chess;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KnightPieceTest {
    @Test
    public void getMoves(){
        //given
        Location testLocation = new Location(4,3);
        KnightPiece knightPiece = new KnightPiece(testLocation, PieceColor.Black);
        List<Move> testMove = new ArrayList<>();
        testMove.add(new Move(knightPiece.getLocation(), new Location(5,5),true));
        testMove.add(new Move(knightPiece.getLocation(), new Location(3,5),true));
        testMove.add(new Move(knightPiece.getLocation(), new Location(5,1),true));
        testMove.add(new Move(knightPiece.getLocation(), new Location(3,1),true));
        testMove.add(new Move(knightPiece.getLocation(), new Location(6,2),true));
        testMove.add(new Move(knightPiece.getLocation(), new Location(6,4),true));
        testMove.add(new Move(knightPiece.getLocation(), new Location(2,2),true));
        testMove.add(new Move(knightPiece.getLocation(), new Location(2,4),true));

        //when
        List<Move> listMoves = knightPiece.getMoves();

        //then
        for (int ix = 0; ix < testMove.size(); ix++){
            assertEquals(listMoves.get(ix), testMove.get(ix));
        }
    }
}
