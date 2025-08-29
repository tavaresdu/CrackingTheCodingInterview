package br.com.tavaresdu.CrackingTheCodingInterview.chapter1.zeroMatrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N) (more precisely O(2√N))
 */
public class ZeroMatrixHashSetSolution implements ZeroMatrixSolution {
    @Override
    public void zeroMatrix(int[][] matrix) {
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (zeroRows.contains(i) || zeroCols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
