package Assignment4;

public class MazeSolution {

    static int[] findStartPoint(char[][] maze) {

        int[] startPoint = new int[2];

        for (int i = 0; i < maze.length; i++) {

            for (int j = 0; j < maze[0].length; j++) {

                if (maze[i][j] == 'S') {
                    startPoint[0] = i;
                    startPoint[1] = j;
                }
            }
        }
        return startPoint;
    }

    static int[] findFinishPoint(char[][] maze) {

        int[] finishPoint = new int[2];

        for (int i = 0; i < maze.length; i++) {

            for (int j = 0; j < maze[0].length; j++) {

                if (maze[i][j] == 'F') {
                    finishPoint[0] = i;
                    finishPoint[1] = j;
                }
            }
        }
        return finishPoint;
    }

    public static String findPathway(char[][] maze) {

        if (maze == null || maze.length == 0 || maze[0].length == 0)
            return "";

        int[] startPoint = findStartPoint(maze);
        int[] finishPoint = findFinishPoint(maze);

        int[][] visited = new int[maze.length][maze[0].length];

        return solveMaze(maze, "", startPoint[0], startPoint[1], finishPoint[0], finishPoint[1], visited);
    }

    public static String solveMaze(char[][] maze, String path, int current0, int current1, int end0, int end1, int[][] visited) {

        if (current0 == end0 && current1 == end1)
            return path;

        String solution = "";
        visited[current0][current1] = 1;

        // goUp
        if (current0 > 0 && maze[current0 - 1][current1] != '@' && visited[current0 - 1][current1] == 0) {

            solution = solveMaze(maze, path + "U", current0 - 1, current0, end0, end1, visited);
            if (!solution.equals("")) {
                return solution;
            }
        }

        // goDown
        if (current0 < maze.length - 1 && maze[current0 + 1][current1] != '@' && visited[current0 + 1][current1] == 0) {

            solution = solveMaze(maze, path + "D", current0 + 1, current1, end0, end1, visited);
            if (!solution.equals("")) {
                return solution;
            }
        }

        // goLeft
        if (current1 > 0 && maze[current0][current1 - 1] != '@' && visited[current0][current1 - 1] == 0) {

            solution = solveMaze(maze, path + "L", current0, current1 - 1, end0, end1, visited);
            if (!solution.equals("")) {
                return solution;
            }
        }

        // goRight
        if (current1 < maze[0].length - 1 && maze[current0][current1 + 1] != '@' && visited[current0][current1 + 1] == 0) {

            solution = solveMaze(maze, path + "R", current0, current1 + 1, end0, end1, visited);
            if (!solution.equals("")) {
                return solution;
            }
        }
        return solution;
    }

    public static void main(String[] args) {

/*        char[][] maze = new char[][] {

                {'S', '@', '@', '@'},
                {'+', '+', '+', '+'},
                {'@', '@', '@', 'F'}
        };*/

        char[][] maze = new char[][] {
                
                {'@', 'S', '@', '@', '@', '@', '@'},
                {'@', '+', '+', '+', '+', '+', '@'},
                {'@', '@', '+', '@', '+', '@', '@'},
                {'@', '+', '+', '@', '+', '+', '@'},
                {'@', '@', '@', '@', '+', '@', '@'},
                {'@', '+', '+', '+', '+', '+', '@'},
                {'@', 'F', '@', '@', '@', '@', '@'}
        };
        System.out.println(MazeSolution.findPathway(maze));
    }
}
