package Assignment6.ExtraCredit;

import java.util.*;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length == 0)
            return new ArrayList<>();

        int m = matrix.length, n = matrix[0].length;
        List<Integer> list = new ArrayList<>(m * n);

        int row = 0, col = -1;
        while (true) {

            for (int i = 0; i < n; i++)
                list.add(matrix[row][++col]);

            if (--m == 0)
                break;

            for (int i = 0; i < m; i++)
                list.add(matrix[++row][col]);

            if (--n == 0)
                break;

            for (int i = 0; i < n; i++)
                list.add(matrix[row][--col]);

            if (--m == 0)
                break;

            for (int i = 0; i < m; i++)
                list.add(matrix[--row][col]);

            if (--n == 0)
                break;
        }
        return list;
    }

    public static void main(String[] args) {

        int[][] matrix = { { 1, 2 }, { 3, 4 } };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));

        matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));

        matrix = new int[][] { {1,2,3,4}, {5,6,7,8}, {9,10,11,12} };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));

        matrix = new int[][] { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16} };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));

        matrix = new int[][] { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}, {17,18,19,20} };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }
}
