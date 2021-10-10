package touro.chess;

import javafx.scene.input.MouseEvent;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.doReturn;

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
        Location location = new Location((int) 10.7, (int) 60.5);
        Square square = new Square();
        doReturn(10.7).when(mouseEvent).getSceneX();
        doReturn(60.5).when(mouseEvent).getSceneY();
        //when
        ClickEventHandler.OnPieceClick(mouseEvent);
        //then
        Assert.assertEquals(ClickEventHandler.squares, square);
    }
}