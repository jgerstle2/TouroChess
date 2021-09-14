package touro.chess;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ChessController {

    @FXML
    ArrayList<Label> squares;

    public void initialize() {
        setupInitialBoard();
    }

    private void setupInitialBoard() {
        squares.get(0).setStyle("-fx-background-image: url(\"/images/b_rook.png\");");
        squares.get(1).setStyle("-fx-background-image: url(\"/images/b_knight.png\");");
        squares.get(2).setStyle("-fx-background-image: url(\"/images/b_bishop.png\");");
        squares.get(3).setStyle("-fx-background-image: url(\"/images/b_queen.png\");");
        squares.get(4).setStyle("-fx-background-image: url(\"/images/b_king.png\");");
        squares.get(5).setStyle("-fx-background-image: url(\"/images/b_bishop.png\");");
        squares.get(6).setStyle("-fx-background-image: url(\"/images/b_knight.png\");");
        squares.get(7).setStyle("-fx-background-image: url(\"/images/b_rook.png\");");

        for (int sq = 8; sq <= 15; sq++){
            squares.get(sq).setStyle("-fx-background-image: url(\"/images/b_pawn.png\");");
        }

        for (int sq = 48; sq <= 55; sq++){
            squares.get(sq).setStyle("-fx-background-image: url(\"/images/w_pawn.png\");");
        }

        squares.get(56).setStyle("-fx-background-image: url(\"/images/w_rook.png\");");
        squares.get(57).setStyle("-fx-background-image: url(\"/images/w_knight.png\");");
        squares.get(58).setStyle("-fx-background-image: url(\"/images/w_bishop.png\");");
        squares.get(59).setStyle("-fx-background-image: url(\"/images/w_queen.png\");");
        squares.get(60).setStyle("-fx-background-image: url(\"/images/w_king.png\");");
        squares.get(61).setStyle("-fx-background-image: url(\"/images/w_bishop.png\");");
        squares.get(62).setStyle("-fx-background-image: url(\"/images/w_knight.png\");");
        squares.get(63).setStyle("-fx-background-image: url(\"/images/w_rook.png\");");
    }

    private void updateImage(){

    }


}
