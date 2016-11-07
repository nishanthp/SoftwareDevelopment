/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;


/**
 * TODO Administrator (May 29, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class TwoDSubMatrix {

    Result maxSum(final int a[][]) {
        final int rows = a.length;
        final int cols = a[0].length;
        final Result maxResult = new Result();
        for (int left = 0; left < cols; left++) {
            // create a temp array.
            final int[] temp = new int[rows];
            // initialize to 0.
            for (int i = 0; i < rows; i++) {
                temp[i] = 0;
            }
            // kadane Algorithm.
            for (int right = left; right < cols; right++) {
                for (int k = 0; k < a.length; k++) {
                    temp[k] += a[k][right];
                }
                final Kadane kAlgo = new Kadane();
                final Kadane localResult = kAlgo.findMax(temp);
                if (maxResult.getMaxSum() < localResult.max) {
                    maxResult.setuB(localResult.currentStart);
                    maxResult.setlB(localResult.endStart);
                    maxResult.setleftB(left);
                    maxResult.setrightB(right);
                    maxResult.setMaxSum(localResult.max);


                }

            }


        }
        return maxResult;

    }
}


class Kadane {

    /**
     * TODO Administrator (May 29, 2016) - Insert a description of what this method does.
     *
     * @param temp
     */
    int maxSofor = 0;
    int max = 0;
    int currentStart = 0;
    int maxStart = 0;
    int endStart = 0;

    public Kadane findMax(final int[] temp) {

        for (int i = 0; i < temp.length; i++) {
            this.maxSofor += temp[i];
            // condition to have atleast one positive element.
            if (this.maxSofor < 0) {
                this.maxSofor = 0;
                this.currentStart = i + 1;
            }
            if (this.max < this.maxSofor) {
                this.max = this.maxSofor;
                this.maxStart = this.currentStart;
                this.endStart = i;
            }


        }
        return this;

    }


}


class Result {

    int maxSum;
    int upBound;
    int lowBound;
    int leftBound;
    int rightBound;

    void setMaxSum(final int Sum) {
        this.maxSum = Sum;
    }

    void setuB(final int SI) {
        this.upBound = SI;
    }

    void setlB(final int EI) {
        this.lowBound = EI;
    }

    void setleftB(final int index) {
        this.leftBound = index;
    }

    void setrightB(final int index) {
        this.rightBound = index;
    }

    int getMaxSum() {
        return this.maxSum;
    }

    int getuB() {
        return this.upBound;
    }

    int getlB() {
        return this.lowBound;
    }

    int getleftB() {
        return this.leftBound;
    }

    int getrightB() {
        return this.rightBound;
    }
}
