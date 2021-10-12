package touro.chess;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PawnPieceTest {


    @Test
    public void getMovesBlack() {
        // given
        PawnPiece piece = new PawnPiece(new Location(5, 5), PieceColor.Black);

        // when
        List<Move> moves = piece.getMoves();

        // then
        assertEquals(3, moves.size());

        //first move on list
        Location firstLocation = moves.get(0).getTo();

        assertEquals( new Location(6, 5), firstLocation);

        //second move on list
        Location secLocation = moves.get(1).getTo();

        assertEquals(new Location(6, 6), secLocation);

        //third move on list
        Location thirdLocation = moves.get(2).getTo();

        assertEquals(new Location(6, 4), thirdLocation);
    }

    @Test
    public void getMovesWhite() {
        // given
        PawnPiece piece = new PawnPiece(new Location(5, 5), PieceColor.White);

        // when
        List<Move> moves = piece.getMoves();

        // then
        assertEquals(3, moves.size());

        //first move on list
        Location firstLocation = moves.get(0).getTo();

        assertEquals( new Location(4, 5), firstLocation);

        //second move on list
        Location secLocation = moves.get(1).getTo();

        assertEquals(new Location(4, 6), secLocation);

        //third move on list
        Location thirdLocation = moves.get(2).getTo();

        assertEquals(new Location(4, 4), thirdLocation);
    }

    @Test
    public void getMovesBlackFirstMove() {

        //add 1,0 1,1 1,-1 and for row 2 or 7 add 2,0

        // given
        PawnPiece piece = new PawnPiece(new Location(1, 5), PieceColor.Black);

        // when
        List<Move> moves = piece.getMoves();

        // then
        assertEquals(4, moves.size());

        //first move on list
        Location firstLocation = moves.get(0).getTo();

        assertEquals(new Location(3, 5), firstLocation);

        //second move on list
        Location secLocation = moves.get(1).getTo();

        assertEquals(new Location(2, 5), secLocation);

        //third move on list
        Location thirdLocation = moves.get(2).getTo();

        assertEquals(new Location(2, 6), thirdLocation);

        //fourth move on list
        Location fourthLocation = moves.get(3).getTo();

        assertEquals(new Location(2, 4), fourthLocation);
    }

    @Test
    public void getMovesWhiteFirstMove() {
        //add -1,0 -1,-1 -1,+1 and for row 2 or 7 add -2,0

        // given
        PawnPiece piece = new PawnPiece(new Location(6, 5), PieceColor.White);

        // when
        List<Move> moves = piece.getMoves();

        // then
        assertEquals(4, moves.size());

        //first move on list
        Location firstLocation = moves.get(0).getTo();

        assertEquals(new Location(4, 5), firstLocation);

        //second move on list
        Location secLocation = moves.get(1).getTo();

        assertEquals(new Location(5, 5), secLocation);

        //third move on list
        Location thirdLocation = moves.get(2).getTo();

        assertEquals(new Location(5, 6), thirdLocation);

        //fourth move on list
        Location fourthLocation = moves.get(3).getTo();

        assertEquals(new Location(5, 4), fourthLocation);
    }

    @Test
    public void getMovesBlackRightMoveLastColumn() {

        // given
        PawnPiece piece = new PawnPiece(new Location(4, 7), PieceColor.Black);

        // when
        List<Move> moves = piece.getMoves();

        // then
        assertEquals(2, moves.size());

        //first move on list
        Location firstLocation = moves.get(0).getTo();

        assertEquals(new Location(5, 7), firstLocation);

        //second move on list
        Location secLocation = moves.get(1).getTo();

        assertEquals(new Location(5, 6), secLocation);
    }

    @Test
    public void getMovesBlackLeftMoveFirstColumn() {

        // given
        PawnPiece piece = new PawnPiece(new Location(4, 0), PieceColor.Black);

        // when
        List<Move> moves = piece.getMoves();

        // then
        assertEquals(2, moves.size());

        //first move on list
        Location firstLocation = moves.get(0).getTo();

        assertEquals(new Location(5, 0), firstLocation);

        //second move on list
        Location secLocation = moves.get(1).getTo();

        assertEquals( new Location(5, 1), secLocation);
    }

    @Test
    public void getMovesWhiteRightMoveLastColumn() {

        // given
        PawnPiece piece = new PawnPiece(new Location(4, 7), PieceColor.White);

        // when
        List<Move> moves = piece.getMoves();

        // then
        assertEquals(2, moves.size());

        //first move on list
        Location firstLocation = moves.get(0).getTo();

        assertEquals(new Location(3, 7), firstLocation);

        //second move on list
        Location secLocation = moves.get(1).getTo();

        assertEquals(new Location(3, 6), secLocation);
    }

    @Test
    public void getMovesWhiteLeftMoveFirstColumn() {

        // given
        PawnPiece piece = new PawnPiece(new Location(4, 0), PieceColor.White);

        // when
        List<Move> moves = piece.getMoves();

        // then
        assertEquals(2, moves.size());

        //first move on list
        Location firstLocation = moves.get(0).getTo();

        assertEquals(new Location(3, 0), firstLocation);

        //second move on list
        Location secLocation = moves.get(1).getTo();

        assertEquals(new Location(3, 1), secLocation);
    }

    @Test
    public void getMovesBlackLastRow() {

        // given
        PawnPiece piece = new PawnPiece(new Location(7, 5), PieceColor.Black);

        // when
        List<Move> moves = piece.getMoves();

        // then
        assertEquals(0, moves.size());
    }

    @Test
    public void getMovesWhiteLastRow() {

        // given
        PawnPiece piece = new PawnPiece(new Location(0, 5), PieceColor.White);

        // when
        List<Move> moves = piece.getMoves();

        // then
        assertEquals(0, moves.size());
    }

}