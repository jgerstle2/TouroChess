package touro.chess;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;


public class BoardTest {

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(() -> {
        });
    }

    @Test
    public void isLegal_validVerticalMove(){
        //given
        Board board = new Board();

        //when
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,1);
        Square destinationSquare = new Square(destinationLocation);
        Square currentSquare = new Square(currentLocation);
        AbstractPiece destinationPiece = new AbstractPiece(destinationLocation,PieceColor.Black) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        AbstractPiece currentPiece = new AbstractPiece(currentLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        currentSquare.setPiece(currentPiece);
        destinationSquare.setPiece(destinationPiece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidVerticalMove(){
        //given
        Board board = new Board();

        //when
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,1);
        Location middleLocation = new Location(3,1);
        Square destinationSquare = new Square(destinationLocation);
        Square currentSquare = new Square(currentLocation);
        Square middleSquare = new Square(middleLocation);
        AbstractPiece destinationPiece = new AbstractPiece(destinationLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        AbstractPiece currentPiece = new AbstractPiece(currentLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        AbstractPiece middlePiece = new AbstractPiece(middleLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        currentSquare.setPiece(currentPiece);
        middleSquare.setPiece(middlePiece);
        destinationSquare.setPiece(destinationPiece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_validHorizontalMove(){
        //given
        Board board = new Board();

        //when
        Location currentLocation = new Location(4,1);
        Location destinationLocation = new Location(4,6);
        Square destinationSquare = new Square(destinationLocation);
        Square currentSquare = new Square(currentLocation);
        AbstractPiece destinationPiece = new AbstractPiece(destinationLocation,PieceColor.Black) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        AbstractPiece currentPiece = new AbstractPiece(currentLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        currentSquare.setPiece(currentPiece);
        destinationSquare.setPiece(destinationPiece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidHorizontalMove(){
        //given
        Board board = new Board();
        Location currentLocation;
        Location destinationLocation;

        //when
        currentLocation = new Location(2,1);
        destinationLocation = new Location(2,5);
        Square destinationSquare = new Square(destinationLocation);
        Square currentSquare = new Square(currentLocation);
        AbstractPiece destinationPiece = new AbstractPiece(destinationLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        AbstractPiece currentPiece = new AbstractPiece(currentLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        currentSquare.setPiece(currentPiece);
        destinationSquare.setPiece(destinationPiece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_validDiagonalMove(){
        //given
        Board board = new Board();

        //when
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,3);
        Square destinationSquare = new Square(destinationLocation);
        Square currentSquare = new Square(currentLocation);
        AbstractPiece destinationPiece = new AbstractPiece(destinationLocation,PieceColor.Black) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        AbstractPiece currentPiece = new AbstractPiece(currentLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        currentSquare.setPiece(currentPiece);
        destinationSquare.setPiece(destinationPiece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidDiagonalMove(){
        //given
        Board board = new Board();
        Location currentLocation;
        Location destinationLocation;

        //when
        currentLocation = new Location(1,1);
        destinationLocation = new Location(8,8);
        Square destinationSquare = new Square(destinationLocation);
        Square currentSquare = new Square(currentLocation);
        AbstractPiece destinationPiece = new AbstractPiece(destinationLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        AbstractPiece currentPiece = new AbstractPiece(currentLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        currentSquare.setPiece(currentPiece);
        destinationSquare.setPiece(destinationPiece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_validJumpMove(){
        //given
        Board board = new Board();

        //when
        Location currentLocation = new Location(1,2);
        Location destinationLocation = new Location(3,1);
        Square destinationSquare = new Square(destinationLocation);
        Square currentSquare = new Square(currentLocation);
        AbstractPiece destinationPiece = new AbstractPiece(destinationLocation,PieceColor.Black) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        AbstractPiece currentPiece = new AbstractPiece(currentLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        currentSquare.setPiece(currentPiece);
        destinationSquare.setPiece(destinationPiece);
        Move move = new Move(currentLocation,destinationLocation,true);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidJumpMove(){
        //given
        Board board = new Board();

        //when
        Location currentLocation = new Location(1,2);
        Location destinationLocation = new Location(2,4);
        Square destinationSquare = new Square(destinationLocation);
        Square currentSquare = new Square(currentLocation);
        AbstractPiece destinationPiece = new AbstractPiece(destinationLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        AbstractPiece currentPiece = new AbstractPiece(currentLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        currentSquare.setPiece(currentPiece);
        destinationSquare.setPiece(destinationPiece);
        Move move = new Move(currentLocation,destinationLocation,true);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidMoveOffBoard(){
        //given
        Board board = new Board();
        Location currentLocation;
        Location destinationLocation;

        //when
        currentLocation = new Location(12,1);
        destinationLocation = new Location(4,1);
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertFalse(board.isLegal(move));
    }
}
