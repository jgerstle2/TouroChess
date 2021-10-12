package touro.chess;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return row == location.row && column == location.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    /**
     * @return the move in chess notation https://en.wikipedia.org/wiki/Algebraic_notation_(chess)
     */
    public String toChessNotation() {
        //add 97 to row so '0' = 97, '1' = 98, etc.
        //convert to ascii value so  97 = 'a', 98 = 'b', etc.
        return (char)(row + 97) + "" + column;
    }
}
