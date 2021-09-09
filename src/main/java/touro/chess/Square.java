package touro.chess;

import org.jetbrains.annotations.Nullable;

public class Square {

    private final Location location;
    private @Nullable AbstractPiece piece;

    public Square(Location location) {
        this.location = location;
    }

    public Square(Location location, AbstractPiece piece)
    {
        this.location = location;
        this.piece = piece;
    }

    public Location getLocation() {
        return location;
    }

    public @Nullable AbstractPiece getPiece() {
        return piece;
    }

    public void setPiece(@Nullable AbstractPiece piece) {
        this.piece = piece;
    }

    public boolean hasPiece() {
        return piece != null;
    }
}
