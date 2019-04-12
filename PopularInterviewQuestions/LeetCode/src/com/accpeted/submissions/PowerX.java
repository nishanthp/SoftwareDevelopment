package com.accpeted.submissions;

public class PowerX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double myPow(double x, int n) {
        if (n==0) return 1; // hits this base condition if n is negative.
        if (n==1) return x; // hits this base condition if n is positive.
        double temp = myPow(x, n/2);
        if(n%2 == 0) return temp*temp; // mod operation is same for both positive and negative numbers.
        else {
            if(n >= 0) {
                return (double) temp*temp*x; // important part. 
            }
            else return (double) (temp*temp)/x;
        }
    }

}
