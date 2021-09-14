package touro.chess;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoardTest {

    private final Square[][] squares = new Square[8][8];
    private final Board board = new Board();

    public void createSquares(){
        for(int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                squares[column][row] = new Square(new Location(row, column));
            }
        }
    }

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(() -> {
        });
    }

    @Test
    public void isLegal_validVerticalMove(){
        //given
        createSquares();

        //when
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,1);
        Square currentSquare = squares[2][1];
        Square destinationSquare = squares[4][1];
        Move move = new Move(currentLocation,destinationLocation,false);
        currentSquare.setPiece(new RookPiece(currentLocation, PieceColor.White));
        destinationSquare.setPiece(new RookPiece(destinationLocation, PieceColor.Black));

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidVerticalMove(){
        //given
        createSquares();

        //when
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,1);
        Square currentSquare = squares[2][1];
        Square destinationSquare = squares[4][1];
        currentSquare.setPiece(new RookPiece(currentLocation, PieceColor.White));
        destinationSquare.setPiece(new RookPiece(destinationLocation, PieceColor.White));
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_validHorizontalMove(){
        //given
        createSquares();

        //when
        Location currentLocation = new Location(4,1);
        Location destinationLocation = new Location(4,6);
        Square currentSquare = squares[4][1];
        Square destinationSquare = squares[4][6];
        currentSquare.setPiece(new RookPiece(currentLocation, PieceColor.White));
        destinationSquare.setPiece(new RookPiece(destinationLocation, PieceColor.Black));
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidHorizontalMove(){
        //given
        createSquares();

        //when
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(2,5);
        Location middleLocation = new Location(2,4);
        Square currentSquare = squares[2][1];
        Square destinationSquare = squares[2][5];
        Square middleSquare = squares[2][4];
        currentSquare.setPiece(new RookPiece(currentLocation, PieceColor.White));
        middleSquare.setPiece(new BishopPiece(middleLocation, PieceColor.Black));
        destinationSquare.setPiece(new RookPiece(destinationLocation, PieceColor.Black));
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_validDiagonalMove(){
        //given
        createSquares();

        //when
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,3);
        Square currentSquare = squares[2][1];
        Square destinationSquare = squares[4][3];
        currentSquare.setPiece(new QueenPiece(currentLocation, PieceColor.White));
        destinationSquare.setPiece(new PawnPiece(destinationLocation, PieceColor.Black));
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidDiagonalMove(){
        //given
        createSquares();

        //when
        Location currentLocation = new Location(0,0);
        Location destinationLocation = new Location(7,7);
        Square currentSquare = squares[0][0];
        Square destinationSquare = squares[7][7];
        currentSquare.setPiece(new QueenPiece(currentLocation, PieceColor.White));
        destinationSquare.setPiece(new RookPiece(destinationLocation, PieceColor.White));
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_validJumpMove(){
        //given
        createSquares();

        //when
        Location currentLocation = new Location(1,2);
        Location destinationLocation = new Location(3,1);
        Square currentSquare = squares[1][2];
        currentSquare.setPiece(new KnightPiece(currentLocation, PieceColor.White));
        Move move = new Move(currentLocation,destinationLocation,true);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidJumpMove(){
        //given
        createSquares();

        //when
        Location currentLocation = new Location(1,2);
        Location destinationLocation = new Location(2,4);
        Square currentSquare = squares[1][2];
        Square destinationSquare = squares[2][4];
        currentSquare.setPiece(new KnightPiece(currentLocation, PieceColor.White));
        destinationSquare.setPiece(new RookPiece(destinationLocation, PieceColor.White));
        Move move = new Move(currentLocation,destinationLocation,true);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidMoveOffBoard(){
        //given
        createSquares();

        //when
        Location currentLocation = new Location(12,1);
        Location destinationLocation = new Location(4,1);
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidMoveNullPiece(){
        //given
        createSquares();

        //when
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(2,5);
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidMoveSameSquare(){
        //given
        createSquares();

        //when
        Location currentLocation = new Location(4,1);
        Location destinationLocation = new Location(4,1);
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

}
