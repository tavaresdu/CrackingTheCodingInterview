package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.rotateMatrix;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class RotateMatrixSameMatrixSolution implements RotateMatrixSolution {

    @Override
    public int[][] rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return null;
        }
        final int MAX_INDEX = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < MAX_INDEX - i; j++) {
                int aux = matrix[i][j];
                int previousX = i;
                int previousY = j;
                for (int k = 0; k < 3; k++) {
                    int x = previousY;
                    int y = MAX_INDEX - previousX;
                    matrix[previousX][previousY] = matrix[x][y];
                    previousX = x;
                    previousY = y;
                }
                matrix[previousX][previousY] = aux;
            }
        }
        return matrix;
    }
}
