package Chess;

public class King extends ClassFigure{
    boolean isFirstStep;
    public King(boolean color, int x, int y, Field field) {
        super(color, color?"\u2654":"\u265A", x, y, field);
        this.isFirstStep = true;
    }
    @Override
    public boolean canMove(int toX, int toY) {
        int difX = toX - this.x;
        int difY = toY - this.y;
        return Math.abs(difX) <= 1 && Math.abs(difY) <= 1 && field.isPathEmpty(this.x, this.y, toX, toY);
    }
    public boolean isVisible() {
        return false;
    }
    public boolean isKing() {
        return true;
    }
}
