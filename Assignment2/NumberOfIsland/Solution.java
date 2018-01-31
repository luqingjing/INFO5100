package Assignment2.NumberOfIsland;

import java.util.Queue;
import java.util.LinkedList;

public class Solution {

    public int numberOfIsland(int[][] grid){

        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        // An m loop is used. The time complexity here is O(m).
        for(int i = 0; i < grid.length ; i++) {

            // An n loop is used. The time complexity here is O(m * n).
            for(int j =0 ; j < grid[i].length ; j++) {

                if (!visited[i][j] && grid[i][j] == 1) {

//                    dfs(grid,visited,i,j);
                    bfs(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    // The worst space complexity is O(m * n),
    // in case that the grid map is filled with lands where dfs goes by m * n deep.
    public void dfs(int[][] grid, boolean[][] visited, int i, int j){

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0 || visited[i][j])
            return;

        visited[i][j] = true;

        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);

    }

    class Point {

        int i, j;
        public Point(int i, int j) {

            this.i = i;
            this.j = j;
        }
    }

    // The worst space complexity is O(m * n),
    // because in worst case where the grid is filled with lands, the size of queue can grow up to m * n.
    public void bfs(int[][] grid, boolean[][] visited, int i, int j) {
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(i, j));
        while (!queue.isEmpty()) {

            Point p = queue.remove();
            visited[p.i][p.j] = true;

            if(p.i > 0 && grid[p.i - 1][p.j] == 1 && !visited[p.i - 1][p.j])
                queue.add(new Point(p.i - 1, p.j));

            if(p.j < visited[0].length - 1 && grid[p.i][p.j + 1] == 1 && !visited[p.i][p.j + 1])
                queue.add(new Point(p.i, p.j + 1));

            if(p.i < visited.length - 1 && grid[p.i + 1][p.j] == 1 && !visited[p.i + 1][p.j])
                queue.add(new Point(p.i + 1, p.j));

            if(p.j > 0 && grid[p.i][p.j - 1] == 1 && !visited[p.i][p.j - 1])
                queue.add(new Point(p.i, p.j - 1));
        }
    }



    public static void main(String args[]){

        int matrix[][] = {
                {1,0,0,1,0},
                {1,0,1,1,1},
                {0,1,0,1,0},
                {1,0,0,0,1},
                {1,0,0,1,0}
        };
        Solution island = new Solution();
        int count = island.numberOfIsland(matrix);
        System.out.println(count);
    }
}
