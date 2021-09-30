package touro.chess;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class ChessController {

    @FXML
    ArrayList<Label> squares;

    public void initialize() {
        setupInitialBoard();
    }

    private void setupInitialBoard() {
        squares.get(0).getStyleClass().add("BlackRook");
        squares.get(1).getStyleClass().add("BlackKnight");
        squares.get(2).getStyleClass().add("BlackBishop");
        squares.get(3).getStyleClass().add("BlackQueen");
        squares.get(4).getStyleClass().add("BlackKing");
        squares.get(5).getStyleClass().add("BlackBishop");
        squares.get(6).getStyleClass().add("BlackKnight");
        squares.get(7).getStyleClass().add("BlackRook");

        for (int sq = 8; sq <= 15; sq++){
            squares.get(sq).getStyleClass().add("BlackPawn");
        }

        for (int sq = 48; sq <= 55; sq++){
            squares.get(sq).getStyleClass().add("WhitePawn");
        }

        squares.get(56).getStyleClass().add("WhiteRook");
        squares.get(57).getStyleClass().add("WhiteKnight");
        squares.get(58).getStyleClass().add("WhiteBishop");
        squares.get(59).getStyleClass().add("WhiteQueen");
        squares.get(60).getStyleClass().add("WhiteKing");
        squares.get(61).getStyleClass().add("WhiteBishop");
        squares.get(62).getStyleClass().add("WhiteKnight");
        squares.get(63).getStyleClass().add("WhiteRook");
    }

    private void updateImage(Color color, int originSquare, int destinationSquare, Piece piece){
        String movingPiece = color.toString() + "" + piece.toString();
        squares.get(originSquare).getStyleClass().remove(movingPiece);
        squares.get(originSquare).getStyleClass().add("Empty");
        squares.get(destinationSquare).getStyleClass().removeAll();
        squares.get(destinationSquare).getStyleClass().add(movingPiece);

    }

    private enum Piece {
        Rook,
        Knight,
        Bishop,
        Queen,
        King,
        Pawn
    }

    private enum Color {
        Black,
        White
    }

}
