package touro.chess;

import javafx.scene.input.MouseEvent;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ClickEventHandlerTest
{

    /**BeforeClass
    public static void beforeClass()
    {
        com.sun.javafx.application.PlatformImpl.startup(() ->
        {
        });
    }*/
    @Test
    public void onPieceClick()
    {
        //given
        Board board = new Board();
        board.setUpBoard();
        MouseEvent mouseEvent = mock(MouseEvent.class);
        doReturn(13).when(mouseEvent).getSource();
        doReturn(mouseEvent.getSource()).when(mouseEvent);


        ClickEventHandler clickEventHandler = new ClickEventHandler(board);
        board.setUpBoard();
        Location location = new Location(1, 5);
        Square square = new Square(location);
        PawnPiece pawnPiece = new PawnPiece(location, PieceColor.Black);
        square.setPiece(pawnPiece);

        //when;
        clickEventHandler.onPieceClick(mouseEvent);
        //then
        Assert.assertEquals(clickEventHandler.squares, square);
    }
}