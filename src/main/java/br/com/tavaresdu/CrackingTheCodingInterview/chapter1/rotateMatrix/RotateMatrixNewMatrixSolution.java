package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.rotateMatrix;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class RotateMatrixNewMatrixSolution implements RotateMatrixSolution {

    @Override
    public int[][] rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return null;
        }

        int[][] result = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int rowIndex = matrix.length - 1;
            for (int j = 0; j < matrix[i].length; j++) {
                result[rowIndex--][i] = matrix[i][j];
            }
        }

        return result;
    }
}
