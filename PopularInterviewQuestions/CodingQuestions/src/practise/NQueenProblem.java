/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

import java.util.ArrayList;


/**
 * TODO Administrator (May 30, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class NQueenProblem {

    ArrayList<Positions> queenNProblem(final int n) {
        final Positions p1 = new Positions();
        final ArrayList<Positions> positions = new ArrayList<Positions>();
        final boolean hasFound = solveForNQueens(n, 0, positions);
        if (hasFound) {
            return positions;
        }
        return positions;
    }


    private boolean solveForNQueens(final int n,
                                    final int row,
                                    final ArrayList<Positions> positions) {

        if (n == row) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            boolean safePosition = true;
            for (final Positions position : positions) {
                if (position.col == col || position.row == row || position.col + position.row == row + col
                    || position.row - position.col == row - col) {
                    safePosition = false;
                    break;
                }
            }
            if (safePosition) {
                final Positions newPosition = new Positions();
                newPosition.row = row;
                newPosition.col = col;
                positions.add(row, newPosition);
                if (solveForNQueens(n, row + 1, positions)) {
                    return true;

                }
            }
        }
        if (row != 0) {
            positions.remove(row - 1);
        }
        return false;
    }
}


class Positions {

    int row;
    int col;

    /**
     *
     */
    public Positions() {
        // TODO Administrator (May 30, 2016) - Auto-generated constructor stub.
    }
}
