package touro.chess;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    @Test
    public void toChessNotation() {
        Location loc = new Location(0,4);
        assertEquals( "a4", loc.toChessNotation());

        Location loc2 = new Location(6,6);
        assertEquals( "g6", loc2.toChessNotation());



    }
}