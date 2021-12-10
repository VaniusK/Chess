package Chess;

public class Knight extends ClassFigure{
    boolean isFirstStep;
    public Knight(boolean color, int x, int y, Field field) {
        super(color, color?"\u2658":"\u265E", x, y, field);
        this.isFirstStep = true;
        this.canHop = true;
    }
    @Override
    public boolean canMove(int toX, int toY) {
        System.out.println((Math.abs(toY - this.y) == 1 && Math.abs(toX - this.x) == 2) || (Math.abs(toY - this.y) == 2 && Math.abs(toX - this.x) == 1));
        return (Math.abs(toY - this.y) == 1 && Math.abs(toX - this.x) == 2) || (Math.abs(toY - this.y) == 2 && Math.abs(toX - this.x) == 1);
    }
    public boolean isVisible() {
        return false;
    }
    public boolean isKing() {
        return false;
    }
}
