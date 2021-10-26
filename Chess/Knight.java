package Chess;

public class Knight extends ClassFigure{
    boolean isFirstStep;
    public Knight(boolean color, int x, int y) {
        super(color, color?'\u2658':'\u265E', x, y);
        this.isFirstStep = true;
        this.canHop = true;
    }
    @Override
    public boolean canMove(int toX, int toY) {
        return (Math.abs(x) == 1 && Math.abs(y) == 2) || (Math.abs(x) == 2 && Math.abs(y) == 1);
    }
}
