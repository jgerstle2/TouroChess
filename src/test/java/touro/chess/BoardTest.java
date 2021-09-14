package touro.chess;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class BoardTest {

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(() -> {
        });
    }

    //get the code for the pieces. create specific pieces that have a list of moves
    //use these pieces in the tests instead of abstract pieces

    @Test
    public void isLegal_validVerticalMove(){
        //given
        Square[][] squares = new Square[8][8];
        for(int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                squares[column][row] = new Square(new Location(row, column));
            }
        }
        Board board = new Board();

        //when
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,1);
        Square currentSquare = squares[2][1];
        Square destinationSquare = squares[4][1];
        ArrayList<Move> legalMoves = new ArrayList<>();
        Move move = new Move(currentLocation,destinationLocation,false);
        legalMoves.add(move);
        AbstractPiece destinationPiece = new AbstractPiece(destinationLocation,PieceColor.Black) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        AbstractPiece currentPiece = new AbstractPiece(currentLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return legalMoves;
            }
        };
        currentSquare.setPiece(currentPiece);
        destinationSquare.setPiece(destinationPiece);

        //then
        Assert.assertTrue(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidVerticalMove(){
        //given
        Square[][] squares = new Square[8][8];
        for(int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                squares[column][row] = new Square(new Location(row, column));
            }
        }
        Board board = new Board();

        //when
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,1);
        Location middleLocation = new Location(3,1);
        Square currentSquare = squares[2][1];
        Square destinationSquare = squares[4][1];
        Square middleSquare = squares[3][1];
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
        Square[][] squares = new Square[8][8];
        for(int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                squares[column][row] = new Square(new Location(row, column));
            }
        }
        Board board = new Board();

        //when
        Location currentLocation = new Location(4,1);
        Location destinationLocation = new Location(4,6);
        Square currentSquare = squares[4][1];
        Square destinationSquare = squares[4][6];
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
        Square[][] squares = new Square[8][8];
        for(int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                squares[column][row] = new Square(new Location(row, column));
            }
        }
        Board board = new Board();

        //when
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(2,5);
        Square currentSquare = squares[2][1];
        Square destinationSquare = squares[2][5];
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
        Square[][] squares = new Square[8][8];
        for(int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                squares[column][row] = new Square(new Location(row, column));
            }
        }
        Board board = new Board();

        //when
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(4,3);
        Square currentSquare = squares[2][1];
        Square destinationSquare = squares[4][3];
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
        Square[][] squares = new Square[8][8];
        for(int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                squares[column][row] = new Square(new Location(row, column));
            }
        }
        Board board = new Board();

        //when
        Location currentLocation = new Location(0,0);
        Location destinationLocation = new Location(7,7);
        Square currentSquare = squares[0][0];
        Square destinationSquare = squares[7][7];
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
        Square[][] squares = new Square[8][8];
        for(int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                squares[column][row] = new Square(new Location(row, column));
            }
        }
        Board board = new Board();

        //when
        Location currentLocation = new Location(1,2);
        Location destinationLocation = new Location(3,1);
        Square currentSquare = squares[1][2];
        Square destinationSquare = squares[3][1];
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
        Square[][] squares = new Square[8][8];
        for(int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                squares[column][row] = new Square(new Location(row, column));
            }
        }
        Board board = new Board();

        //when
        Location currentLocation = new Location(1,2);
        Location destinationLocation = new Location(2,4);
        Square currentSquare = squares[1][2];
        Square destinationSquare = squares[2][4];
        AbstractPiece destinationPiece = new AbstractPiece(destinationLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        AbstractPiece currentPiece = new AbstractPiece(currentLocation, PieceColor.White) {
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
        Square[][] squares = new Square[8][8];
        for(int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                squares[column][row] = new Square(new Location(row, column));
            }
        }
        Board board = new Board();

        //when
        Location currentLocation = new Location(2,1);
        Location destinationLocation = new Location(2,5);
        Square destinationSquare = squares[2][5];
        AbstractPiece destinationPiece = new AbstractPiece(destinationLocation,PieceColor.White) {
            @Override
            public List<Move> getMoves() {
                return null;
            }
        };
        destinationSquare.setPiece(destinationPiece);
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertFalse(board.isLegal(move));
    }

    @Test
    public void isLegal_invalidMoveSameSquare(){
        //given
        Board board = new Board();

        //when
        Location currentLocation = new Location(4,1);
        Location destinationLocation = new Location(4,1);
        Move move = new Move(currentLocation,destinationLocation,false);

        //then
        Assert.assertFalse(board.isLegal(move));
    }
}
