package touro.chess;

import junit.framework.TestCase;
import org.jetbrains.annotations.Nullable;

public class BoardTest extends TestCase {

    public void setUpBoard()
    {
        //given
        Board board = new Board();
        Location blackPawnLocation = new Location(6, 5);
        Location whitePawnLocation = new Location(1, 5);
        Location blackKingLocation = new Location(7, 3);
        Location whiteKingLocation = new Location(0, 3);
        Location emptyLocation = new Location(5, 2);

        //when
        board.setUpBoard();
        AbstractPiece blackPawn = board.getPiece(blackPawnLocation);
        AbstractPiece whitePawn = board.getPiece(whitePawnLocation);
        AbstractPiece blackKing = board.getPiece(blackKingLocation);
        AbstractPiece whiteKing = board.getPiece(whiteKingLocation);
        AbstractPiece empty = board.getPiece(emptyLocation);

        //then
        assertEquals(blackPawn.getColor(), PieceColor.Black);
        assertEquals(blackPawn.getClass(), PawnPiece.class);
        assertEquals(whitePawn.getColor(), PieceColor.White);
        assertEquals(whitePawn.getClass(), PawnPiece.class);
        assertEquals(blackKing.getColor(), PieceColor.Black);
        assertEquals(blackKing.getClass(), KingPiece.class);
        assertEquals(whiteKing.getColor(), PieceColor.White);
        assertEquals(whiteKing.getClass(), KingPiece.class);
        assertNull(empty);
    }

}