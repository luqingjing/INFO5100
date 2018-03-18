package MidtermPartB;

import java.util.ArrayList;

class Cell{

    int x, y;

    Cell(int x, int y){

        this.x = x;
        this.y = y;
    }

    public String toString() {

        return "[" + this.x + ", "+ this.y + "]";
    }
}
public class MazeSolution {

    public ArrayList<Cell> findPath(int[][] maze) {

        ArrayList<Cell> result = new ArrayList<>();

        if (maze == null || maze.length == 0 || maze[0].length == 0)
            return result;

        ArrayList<Cell> path = new ArrayList<>();

        addCell(result, path, 0, 0, maze);
        return result;
    }

    public void addCell(ArrayList<Cell> result, ArrayList<Cell> path, int i, int j, int[][] maze) {

        if (maze[i][j] == 0)
            return;

        path.add(new Cell(i, j));
        int m = maze.length, n = maze[0].length;

        if (i == m - 1 && j == n - 1) {

            result.addAll(path);
            return;
        }

        if (i < m - 1)
            addCell(result, path, i + 1, j, maze);

        if (j < n - 1)
            addCell(result, path, i, j + 1, maze);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        int[][] maze = new int[][] {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        MazeSolution solution = new MazeSolution();
        for (Cell c : solution.findPath(maze)) {
            System.out.println(c);
        }
    }
}
