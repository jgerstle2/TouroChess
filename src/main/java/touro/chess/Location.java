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

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        else if(obj == null || obj.getClass() != this.getClass()){
            return false;
        } else {
            Location location = (Location) obj;
            return (this.row == location.row && this.column == location.column);
        }
    }

//    @Override
//    public int hashCode(){
//        //return a unique value for each location
//    }

    /**
     * @return the move in chess notation https://en.wikipedia.org/wiki/Algebraic_notation_(chess)
     */
    public String toChessNotation() {
        //add 97 to row so '0' = 97, '1' = 98, etc.
        //convert to ascii value so  97 = 'a', 98 = 'b', etc.
        return (char)(row + 97) + "" + column;
    }
}
