package Chess;

import java.util.Objects;

public class Pawn extends ClassFigure{
    boolean isFirstStep;
    boolean isvisible;
    public Pawn(boolean color, int x, int y, boolean isInvisible, Field field) {
        super(color, color?"\u2659":"\u265f", x, y, field);
        this.isFirstStep = true;
        this.isvisible = isInvisible;
        if (isInvisible) symbol = "\033[47m" + "\033[0;97m" + '\u2659' + "\u001B[0m";
    }
    public boolean isVisible() {
        return this.isvisible;
    }
    @Override
    public boolean canMove(int toX, int toY) {
        int difX = toX - this.x;
        int difY = toY - this.y;
        if (this.color) {
            difX *= -1;
        }
        if (difX == 1 && difY == 0 && field.isPathEmpty(this.x, this.y, toX, toY)) {
            return true;
        } else if (difX == 1 && Math.abs(difY) == 1 && field.getFigure(toX, toY).color != this.color && !field.isEmpty(toX, toY)) {
            return true;
        } else {
            if (this.isFirstStep) {
                this.isFirstStep = false;
                return difX == 2 & difY == 0 && field.isPathEmpty(this.x, this.y, toX, toY);
            } else {
                return false;
            }
        }
    }
    public boolean isKing() {
        return false;
    }
}
