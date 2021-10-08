package touro.chess;

public class Move {

    private final Location from;
    private final Location to;

    /**
     * Only the Knight can jump over other pieces. Every other piece moves in a straight line.
     */
    private final boolean jump;

    /**
     * Specifies that this move can only be done to capture another piece (Pawn moving diagonally)
     */
    private final boolean captureOnly;

    public Move(Location from,
                Location to,
                boolean jump) {
        this(from, to, jump, false);
    }

    public Move(
            Location from,
            Location to,
            boolean jump,
            boolean captureOnly) {
        this.from = from;
        this.to = to;
        this.jump = jump;
        this.captureOnly = captureOnly;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public boolean isJump() {
        return jump;
    }

    public boolean isCaptureOnly() {
        return captureOnly;
    }

    @Override
    public String toString() {
        return "Move{" +
                "from=" + from +
                ", to=" + to +
                ", jump=" + jump +
                ", captureOnly=" + captureOnly +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        else if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        else{
            Move move = (Move) obj;
            return (this.to == move.to && this.from == move.from
                    && this.captureOnly == move.captureOnly
                    && this.jump == move.jump);
        }
    }

//    @Override
//    public int hashcode(){
//        //return unique value for each move
//    }
}
