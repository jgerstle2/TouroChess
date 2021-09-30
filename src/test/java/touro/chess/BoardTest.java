package touro.chess;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class BoardTest {

    private final Board board = new Board();

    @Test
    public void isLegal_validVerticalMove(){
        //given
        AbstractPiece currentPiece = mock(AbstractPiece.class);
        AbstractPiece destinationPiece = mock(AbstractPiece.class);
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,1);
        board.setPiece(currentLocation, currentPiece);
        board.setPiece(destinationLocation, destinationPiece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidVerticalMove(){
        //given
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,1);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_validHorizontalMove(){
        //given
        Location currentLocation = new Location(4,1);
        Location destinationLocation = new Location(4,6);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidHorizontalMove(){
        //given
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(2,5);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_validDiagonalMove(){
        //given
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,3);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidDiagonalMove(){
        //given
        Location currentLocation = new Location(0,0);
        Location destinationLocation = new Location(7,7);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_validJumpMove(){
        //given
        Location currentLocation = new Location(1,2);
        Location destinationLocation = new Location(3,1);
        Move move = new Move(currentLocation,destinationLocation,true);

        //when
        board.isLegal(move);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidJumpMove(){
        //given
        Location currentLocation = new Location(1,2);
        Location destinationLocation = new Location(2,4);
        Move move = new Move(currentLocation,destinationLocation,true);

        //when
        board.isLegal(move);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidMoveOffBoard(){
        //given
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
        Location currentLocation = new Location(4,1);
        Location destinationLocation = new Location(4,1);
        Move move = new Move(currentLocation,destinationLocation,false);

        //when
        board.isLegal(move);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

}
