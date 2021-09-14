package touro.chess;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class chessNotationTest {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void toChessNotation() {
        Location loc = new Location(1,5);
        assertEquals( "a5", loc.toChessNotation());

        Location loc2 = new Location(7,7);
        assertEquals( "g7", loc2.toChessNotation());
    }
}