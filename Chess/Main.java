package Chess;
import java.lang.*;
import java.util.*;


public class Main {
    public static int[] inputPosition(String s) {
        int[] ans = new int[2];
        ans[1] = Integer.parseInt(s.substring(1).toUpperCase()) - 1;
        ans[0] = (int)((char)(s.toCharArray()[0])) - 65;
        return ans;
    }

    public static void printField(ClassFigure[][] field) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        System.out.println("Формат ввода: B3 или b3");
        Field field = new Field();
        Scanner sc = new Scanner(System.in);
        System.out.println(field);
        int oldx, oldy, newx, newy;
        String u;
        boolean move = false;
        while (true) {
            try {
                if (move) {
                    System.out.print("Чёрные выбирают фигуру: ");
                    u = sc.nextLine();
                    if (u.length() != 2) throw new Exception();
                    oldy = inputPosition(u)[0];
                    oldx = 7 - inputPosition(u)[1];
                    oldy = Math.max(Math.min(oldy, 7), 0);
                    oldx = Math.max(Math.min(oldx, 7), 0);
                    System.out.print("Чёрные выбирают новую позицию фигуры: ");
                    u = sc.nextLine();
                    if (u.length() != 2) throw new Exception();
                    newy = inputPosition(u)[0];
                    newx = 7 - inputPosition(u)[1];
                    newy = Math.max(Math.min(newy, 7), 0);
                    newx = Math.max(Math.min(newx, 7), 0);
                    if (!field.getFigure(oldx, oldy).color) field.getFigure(oldx, oldy).move(newx, newy);
                    System.out.println(field);
                } else {
                    System.out.print("Белые выбирают фигуру: ");
                    u = sc.nextLine();
                    if (u.length() != 2) throw new Exception();
                    oldy = inputPosition(u)[0];
                    oldx = 7 - inputPosition(u)[1];
                    oldy = Math.max(Math.min(oldy, 7), 0);
                    oldx = Math.max(Math.min(oldx, 7), 0);
                    System.out.print("Белые выбирают новую позицию фигуры: ");
                    u = sc.nextLine();
                    if (u.length() != 2) throw new Exception();
                    newy = inputPosition(u)[0];
                    newx = 7 - inputPosition(u)[1];
                    newy = Math.max(Math.min(newy, 7), 0);
                    newx = Math.max(Math.min(newx, 7), 0);
                    if (field.getFigure(oldx, oldy).color) field.getFigure(oldx, oldy).move(newx, newy);
                    System.out.println(field);
                }
                move = !move;
            } catch(Exception e) {
                System.out.println("Формат ввода: B3 или b3");
            }
        }

    }
}
