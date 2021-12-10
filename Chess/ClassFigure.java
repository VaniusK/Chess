package Chess;

public abstract class ClassFigure {
    int x, y;
    String symbol;
    boolean color; // True - white, False - black
    boolean onBoard;
    boolean canHop;
    Field field;

    public ClassFigure(boolean color, String symbol, int x, int y, Field field) {
        this.color = color;
        this.symbol = symbol;
        this.onBoard = true;
        this.x = x;
        this.y = y;
        this.field = field;
    }
    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
    public abstract boolean isVisible();


   public abstract boolean canMove(int toX, int toY);
   public abstract boolean isKing();

    public void move(int toX, int toY) {
        if (canMove(toX, toY) && (this.x != toX || this.y != toY)) {
            field.Empty(this.x, this.y);
            this.x = toX;
            this.y = toY;
            field.setFigure(this.x, this.y, this);
        }
    }

}
