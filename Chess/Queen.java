package Chess;

public class Queen extends ClassFigure{
    boolean isFirstStep;
    public Queen(boolean color, int x, int y) {
        super(color, color?'\u2655':'\u265B', x, y);
        this.isFirstStep = true;
    }
    @Override
    public boolean canMove(int toX, int toY) {
        int difX = toX - this.x;
        int difY = toY - this.y;
        return (difX == 0 || difY == 0) || (Math.abs(difX) == Math.abs(difY));
    }
}
