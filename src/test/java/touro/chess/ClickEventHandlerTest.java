package touro.chess;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ClickEventHandlerTest
{
    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(()-> {});
    }

    @Test
    public void onPieceClick()
    {
        //given
        Board board = mock(Board.class);
        MouseEvent mouseEvent = mock(MouseEvent.class);
        Label label = mock(Label.class);
        AbstractPiece piece = mock(AbstractPiece.class);
        List<Move> list = new ArrayList<>();
        doReturn("square0").when(label).getId();
        doReturn(label).when(mouseEvent).getSource();
        doReturn(piece).when(board).getPiece(any());
        doReturn(list).when(piece).getMoves();

        ClickEventHandler clickEventHandler = new ClickEventHandler(board);

        //when;
        clickEventHandler.onPieceClick(mouseEvent);
        //then
        
    }
}