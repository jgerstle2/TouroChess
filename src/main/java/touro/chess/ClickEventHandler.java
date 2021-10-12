package touro.chess;

import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class ClickEventHandler
{
    private Board board;

    public ClickEventHandler(Board board)
    {
        this.board = board;
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
        int counter = 0;
        for (Move move : moveList)
        {
            if(board.isLegal(move))
            {
                Square moveOption = new Square(move.getTo());
                Location locationOption = moveOption.getLocation();
                int colOption = locationOption.getColumn();
                int rowOption = locationOption.getRow();
                //get num of square from row and col
                int squareNum = (rowOption * 8) + colOption;
                Label moveOptionLabel = (Label) label.getParent().getChildrenUnmodifiable().get(squareNum);
                moveOptionLabel.getStyleClass().add("Color.lightGray");
                counter++;
            }
        }
    }
}
