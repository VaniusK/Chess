package Chess;

public class Rook extends ClassFigure{
    boolean isFirstStep;
    public Rook(boolean color, int x, int y) {
        super(color, color?'\u2656':'\u265C', x, y);
        this.isFirstStep = true;
    }
    @Override
    public boolean canMove(int toX, int toY) {
        int difX = toX - this.x;
        int difY = toY - this.y;
        return difX == 0 || difY == 0;
    }
}
