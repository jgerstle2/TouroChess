package touro.chess;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class BoardTest {

    @Test
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





    @Test
    public void isLegal_validVerticalMove(){
        //given
        Board board = new Board();
        AbstractPiece piece = mock(AbstractPiece.class);
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,1);
        board.setPiece(currentLocation, piece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_validHorizontalMove(){
        //given
        Board board = new Board();
        AbstractPiece piece = mock(AbstractPiece.class);
        Location currentLocation = new Location(4,1);
        Location destinationLocation = new Location(4,6);
        board.setPiece(currentLocation, piece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_validDiagonalMove(){
        //given
        Board board = new Board();
        AbstractPiece piece = mock(AbstractPiece.class);
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,3);
        board.setPiece(currentLocation, piece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_validJumpMove(){
        //given
        Board board = new Board();
        AbstractPiece piece = mock(AbstractPiece.class);
        Location currentLocation = new Location(1, 2);
        Location destinationLocation = new Location(3,1);
        board.setPiece(currentLocation, piece);
        Move move = new Move(currentLocation,destinationLocation,true);

        //when
        board.isLegal(move);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidMoveSameColor(){
        //given
        Board board = new Board();
        AbstractPiece piece = mock(AbstractPiece.class);
        doReturn(PieceColor.White).when(piece).getColor();
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,1);
        board.setPiece(currentLocation, piece);
        board.setPiece(destinationLocation,piece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidMoveBlockedPath(){
        //given
        Board board = new Board();
        AbstractPiece piece = mock(AbstractPiece.class);
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(2,5);
        Location middleLocation = new Location(2,3);
        board.setPiece(currentLocation, piece);
        board.setPiece(middleLocation,piece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidMoveOffBoard(){
        //given
        Board board = new Board();
        Location currentLocation = new Location(12,1);
        Location destinationLocation = new Location(4,1);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidMoveSameSquare(){
        //given
        Board board = new Board();
        AbstractPiece piece = mock(AbstractPiece.class);
        Location currentLocation = new Location(4,1);
        Location destinationLocation = new Location(4,1);
        board.setPiece(currentLocation, piece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

}

