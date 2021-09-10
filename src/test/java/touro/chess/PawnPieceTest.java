package touro.chess;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PawnPieceTest {

    @Test
    public void getMoves() {
        // given
        PawnPiece piece = new PawnPiece(new Location(5,5), PieceColor.Black);

        // when
        List<Move> moves= piece.getMoves();

        // then
        assertEquals(3, moves.size());

        Location locationExp= new Location(6,5);
        Location firstMove= moves.get(0).getTo();

        assertEquals(locationExp, firstMove);
    }
}