package touro.chess;

import javafx.fxml.FXML;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ClickEventHandler
{
    @FXML
    ArrayList<Label> squares;
    public void OnPieceClick(MouseEvent event)
    {
        Location location = new Location((int) event.getSceneX(), (int) event.getSceneY());
        Square squareSelected = new Square(location);
        AbstractPiece piece = squareSelected.getPiece();
        List<Move> moveList = new ArrayList<>(piece.getMoves());
        int count = 0;
        for (Move move : moveList)
        {
            if(Board.isLegal(move))
            {
                Square moveOption = new Square(move.getTo());
                Location locationOption = moveOption.getLocation();
                int colOption = locationOption.getColumn();
                int rowOption = locationOption.getRow();
                int squareNum = (rowOption * 8) + colOption;
                squares.get(squareNum).getStyleClass().add("Color.lightGray");
                count++;
            }
        }
    }
}
