package touro.chess;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KnightTest {
    @Test
    public void getMoves(){
        //given
        Location testLocation = new Location(4,3);
        Knight knight = new Knight(testLocation, PieceColor.Black);
        List<Move> testMove = new ArrayList<>();
        testMove.add(new Move(knight.getLocation(), new Location(5,5),true));
        testMove.add(new Move(knight.getLocation(), new Location(3,5),true));
        testMove.add(new Move(knight.getLocation(), new Location(5,1),true));
        testMove.add(new Move(knight.getLocation(), new Location(3,1),true));
        testMove.add(new Move(knight.getLocation(), new Location(6,2),true));
        testMove.add(new Move(knight.getLocation(), new Location(6,4),true));
        testMove.add(new Move(knight.getLocation(), new Location(2,2),true));
        testMove.add(new Move(knight.getLocation(), new Location(2,4),true));

        //when
        List<Move> listMoves = knight.getMoves();

        //then
        for (int ix = 0; ix < testMove.size(); ix++){
            assertEquals(listMoves.get(ix).getTo().getColumn(), testMove.get(ix).getTo().getColumn());
            assertEquals(listMoves.get(ix).getTo().getRow(), testMove.get(ix).getTo().getRow());
        }
    }
}