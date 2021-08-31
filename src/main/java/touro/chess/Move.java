package touro.chess;

public class Move {

    private final Location from;
    private final Location to;

    /**
     * Only the Knight can jump over other pieces. Every other piece moves in a straight line.
     */
    private final boolean jump;

    public Move(
            Location from,
            Location to,
            boolean jump) {
        this.from = from;
        this.to = to;
        this.jump = jump;
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

    @Override
    public String toString() {
        return "Move{" +
                "from=" + from +
                ", to=" + to +
                ", jump=" + jump +
                '}';
    }
}
