package touro.chess;

import java.util.List;

/**
 * Super class to all Chess pieces.
 */
public abstract class AbstractPiece {

    private Location location;
    private final PieceColor color;
    private boolean moved = false;

    // How should we represent the piece's image?

    public AbstractPiece(Location location, PieceColor color) {
        this.location = location;
        this.color = color;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
        moved = true;
    }

    public PieceColor getColor() {
        return color;
    }

    public boolean hasMoved(){
        return moved;
    }

    /**
     * @return a List of all valid moves that this piece can make from this position.
     */
    public abstract List<Move> getMoves();

}
