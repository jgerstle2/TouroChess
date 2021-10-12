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
    private Board board;
    public void onPieceClick(MouseEvent event)
    {
        Object source = event.getSource();
        System.out.println(source);
        Label label = (Label) source;
        int count = 0;
        for(Label squareLabel : squares)
        {
            if (squareLabel == label)
            {
                break;
            }
            count++;
        }
        //getting the row and column from the divisibility of the numbers into 8 since that's the dimensions
        Location coordinates = new Location(count/8, count%8);
        AbstractPiece piece = board.getPiece(coordinates);
        System.out.println(coordinates);
        List<Move> moveList = piece.getMoves();
        int counter = 0;
        for (Move move : moveList)
        {
            if(board.isLegal(move))
            {
                Square moveOption = new Square(move.getTo());
                Location locationOption = moveOption.getLocation();
                int colOption = locationOption.getColumn();
                int rowOption = locationOption.getRow();
                int squareNum = (rowOption * 8) + colOption;
                squares.get(squareNum).getStyleClass().add("Color.lightGray");
                counter++;
            }
        }
    }
}
