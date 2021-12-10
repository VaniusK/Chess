package Chess;

public class Rook extends ClassFigure{
    boolean isFirstStep;
    public Rook(boolean color, int x, int y, Field field) {
        super(color, color?"\u2656":"\u265C", x, y, field);
        this.isFirstStep = true;
    }
    @Override
    public boolean canMove(int toX, int toY) {
        int difX = toX - this.x;
        int difY = toY - this.y;
        return difX == 0 || difY == 0 && field.isPathEmpty(this.x, this.y, toX, toY);
    }
    public boolean isVisible() {
        return false;
    }
    public boolean isKing() {
        return false;
    }
}
