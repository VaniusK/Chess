package Chess;
import java.lang.Math;
import java.util.*;
import java.util.Objects;

public class Field {
    ClassFigure[][] field = new ClassFigure[8][8];
    int blackKingX = 0;
    int blackKingY = 4;
    int whiteKingX = 7;
    int whiteKingY = 4;
    public Field() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i < 2) {
                    if (i == 1) field[i][j] = new Pawn(false, i, j, false, this);
                    else  if (j == 0 || j == 7) field[i][j] = new Rook(false, i, j, this);
                    else if (j == 1 || j == 6) field[i][j] = new Knight(false, i, j, this);
                    else if (j == 2 || j == 5) field[i][j] = new Elephant(false, i, j, this);
                    else if (j == 4) field[i][j] = new King(false, i, j, this);
                    else field[i][j] = new Queen(false, i, j, this);
                }
                else if (i > 5) {
                    if (i == 6) field[i][j] = new Pawn(true, i, j, false, this);
                    else  if (j == 0 || j == 7) field[i][j] = new Rook(true, i, j, this);
                    else if (j == 1 || j == 6) field[i][j] = new Knight(true, i, j, this);
                    else if (j == 2 || j == 5) field[i][j] = new Elephant(true, i, j, this);
                    else if (j == 4) field[i][j] = new King(true, i, j, this);
                    else field[i][j] = new Queen(true, i, j, this);
                }
                else {
                    field[i][j] = new Pawn(true, i, j, true, this);
                }
            }
        }
    }
    public boolean isEmpty(int x, int y) {
        return (field[x][y].isVisible());
    }
    @Override
    public String toString() {
        String s = "  A  B  C D  E  F G  H\n";
        for (int i = 0; i < 8; i++) {
            s += (8 - i) + " ";
            for (int j = 0; j < 8; j++) {
                s += field[i][j].toString() + " ";
            }
            s += "\n";
        }
        return s;

    }
    public void setFigure(int x, int y, ClassFigure fig) {
        field[x][y] = fig;
        if (fig.isKing()) {
            if (fig.color) {
                whiteKingX = fig.x;
                whiteKingY = fig.y;
            }
            else {
                blackKingX = fig.x;
                blackKingY = fig.y;
            }
        }
    }
    public boolean isPathEmpty(int oldx, int oldy, int newx, int newy) {
        int origx, origy;
        origx = oldx;
        origy = oldy;
        if (oldx < newx) {
            oldx += Math.min(1, newx - oldx);
        } else {
            oldx -= Math.min(1, oldx - newx);
        }
        if (oldy < newy) {
            oldy += Math.min(1, newy - oldy);
        } else {
            oldy -= Math.min(1, oldy - newy);
        }
        while (oldx != newx || oldy != newy) {
            if (!this.isEmpty(oldx, oldy)) return false;
            System.out.println(oldx + " " + oldy);
            if (oldx < newx) {
                oldx += Math.min(1, newx - oldx);
            } else {
                oldx -= Math.min(1, oldx - newx);
            }
            if (oldy < newy) {
                oldy += Math.min(1, newy - oldy);
            } else {
                oldy -= Math.min(1, oldy - newy);
            }
            System.out.println("2  " + oldx + " " + oldy);
        }
        if (this.isEmpty(oldx, oldy)) return true;
        else if (this.getFigure(newx, newy).color != this.getFigure(origx, origy).color) return true;
        else return false;
    }
    public void Empty(int x, int y) {
        field[x][y] = new Pawn(true, x, y, true, this);
    }
    public ClassFigure getFigure(int x, int y) {
        return field[x][y];
    }
    // public boolean CheckShah() { }

}
