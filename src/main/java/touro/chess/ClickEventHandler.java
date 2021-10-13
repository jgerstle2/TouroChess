package touro.chess;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class ClickEventHandler
{
    private Board board;
    private ArrayList<Label> squares;

    public ClickEventHandler(Board board, ArrayList<Label> squares)
    {
        this.board = board;
        this.squares = squares;
    }

    public void onPieceClick(MouseEvent event)
    {
        Object source = event.getSource();
        Label label = (Label) source;
        //removing the name from the source and getting the number of the label.
        String strCount = label.getId().substring(6);
        int count = Integer.parseInt(strCount);
        //getting the row and column from the divisibility of the numbers into 8 since that's the dimensions
        Location coordinates = new Location(count/8, count%8);
        AbstractPiece piece = board.getPiece(coordinates);
        List<Move> moveList = piece.getMoves();

        for (Move move : moveList)
        {
            if(board.isLegal(move))
            {
                Location  moveTo = move.getTo();
                int colOption = moveTo.getColumn();
                int rowOption = moveTo.getRow();
                //get num of square from row and col
                int squareNum = (rowOption * 8) + colOption;
                Label moveToLabel = squares.get(squareNum);
                moveToLabel.setStyle("Color.lightGray");
            }
        }
    }
}
