package touro.chess;

import javafx.scene.input.MouseEvent;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ClickEventHandlerTest
{
    private MouseEvent mouseEvent;
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
        ClickEventHandler clickEventHandler = new ClickEventHandler();
        Board board = new Board();
        board.setUpBoard();
        Location location = new Location((int) 10.7, (int) 60.5);
        Square square = new Square(location);
        KnightPiece knightPiece = new KnightPiece(location, PieceColor.Black);
        square.setPiece(knightPiece);
        mouseEvent.getSceneX() = mock(mouseEvent.getSceneX().class);
        doReturn(10.7).when(mouseEvent).getSceneX();
        doReturn(60.5).when(mouseEvent).getSceneY();

        //when;
        clickEventHandler.OnPieceClick(mouseEvent);
        //then
        Assert.assertEquals(clickEventHandler.squares, square);
    }
}