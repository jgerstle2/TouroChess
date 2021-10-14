package touro.chess;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
        Label moveToLabel = mock(Label.class);
        AbstractPiece piece = mock(AbstractPiece.class);

        List<Move> list = new ArrayList<>();
        Location from = new Location(0,0);
        Location to = new Location(0,1);
        Move move = new Move(from, to, false);
        list.add(move);
        ArrayList<Label> squares = new ArrayList<>();
        squares.add(label);
        squares.add(moveToLabel);

        doReturn("square0").when(label).getId();
        doReturn(label).when(mouseEvent).getSource();
        doReturn(piece).when(board).getPiece(any());
        doReturn(list).when(piece).getMoves();
        doReturn(true).when(board).isLegal(move);

        ClickEventHandler clickEventHandler = new ClickEventHandler(board, squares);

        //when;
        clickEventHandler.onPieceClick(mouseEvent);

        //then
        verify(label).setStyle("Color.lightGray");
    }
}