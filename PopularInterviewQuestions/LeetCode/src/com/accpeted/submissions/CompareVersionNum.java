package com.accpeted.submissions;

public class CompareVersionNum {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int compareVersion(String version1, String version2) {
        String[] vers1 = version1.split("\\.");
        String[] vers2 = version2.split("\\.");
        int max = Math.max(vers1.length, vers2.length);
        for(int i=0;i<max;i++){
            Integer v1 = i < vers1.length ? Integer.valueOf(vers1[i]) : 0;
            Integer v2 = i < vers2.length ? Integer.valueOf(vers2[i]) : 0;
            int compare = Integer.compare(v1, v2);
            if(compare != 0) return compare;
        }
        return 0;
    }

}
