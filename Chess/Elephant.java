package Chess;

public class Elephant extends ClassFigure{
    boolean isFirstStep;
    public Elephant(boolean color, int x, int y, Field field) {
        super(color, color?"\u2657":"\u265D", x, y, field);
        this.isFirstStep = true;
    }
    @Override
    public boolean canMove(int toX, int toY) {
        int difX = toX - this.x;
        int difY = toY - this.y;
        return Math.abs(difX) == Math.abs(difY) && field.isPathEmpty(this.x, this.y, toX, toY);
    }
    public boolean isVisible() {
        return false;
    }
    public boolean isKing() {
        return false;
    }
}
