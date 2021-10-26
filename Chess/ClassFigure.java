package Chess;

public abstract class ClassFigure {
    int x, y;
    char symbol;
    boolean color; // True - white, False - black
    boolean onBoard;
    boolean canHop;

    public ClassFigure(boolean color, char symbol, int x, int y) {
        this.color = color;
        this.symbol = symbol;
        this.onBoard = true;
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return String.valueOf(symbol);
    }


   public abstract boolean canMove(int toX, int toY);

    public void move(int toX, int toY) {
        if (!this.color) {
            toY = toY * -1;
        }
        if (canMove(toX, toY)) {
            this.x = toX;
            this.y = toY;
        }
    }

}
