package Chess;

public class Pawn extends ClassFigure{
    boolean isFirstStep;
    public Pawn(boolean color, int x, int y) {
        super(color, color?'\u2659':'\u265f', x, y);
        this.isFirstStep = true;
    }
    @Override
    public boolean canMove(int toX, int toY) {
        int difX = toX - this.x;
        int difY = toY - this.y;
        if (difX == 0 && difY == 1) {
            return true;
        } else return difX == 0 & difY == 2 && this.isFirstStep;
    }
}
