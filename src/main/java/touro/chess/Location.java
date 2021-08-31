package touro.chess;

public class Location {

    private final int row;
    private final int column;

    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "Location{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    /**
     * @return the move in chess notation https://en.wikipedia.org/wiki/Algebraic_notation_(chess)
     */
    public String toChessNotation() {
        return toString();
    }
}
