package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.zeroMatrix;

import java.util.Arrays;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class ZeroMatrixWithoutDataStructureSolution implements ZeroMatrixSolution {
    @Override
    public void zeroMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        boolean firstRowIsZero = false;
        boolean firstColumnIsZero = false;

        if (matrix[0][0] == 0) {
            firstRowIsZero = true;
            firstColumnIsZero = true;
        } else {
            //Check if first row has a zero.
            for (int i =  1; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    firstRowIsZero = true;
                    break;
                }
            }
            //Check if first column has a zero.
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    firstColumnIsZero = true;
                    break;
                }
            }
        }

        // Verify matrix for zeros, skipping first row and first column.
        // Use first row and column to flag which ones I have to fill with zeros.
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //Fill flagged columns with zeros, skipping first column.
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        //Fill flagged rows with zeros, skipping first row.
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }

        //Check if first row needs to be filled
        if (firstRowIsZero) {
            Arrays.fill(matrix[0], 0);
        }

        //Check if first column needs to be filled
        if (firstColumnIsZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
