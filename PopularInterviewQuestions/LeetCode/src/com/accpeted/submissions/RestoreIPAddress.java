package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddress {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	//Very interesting problem. But a normal DFS. 
	List<String> result = new LinkedList<String>();
    public List<String> restoreIpAddresses(String s) { 
         restoreIpAddresses(s, "", 0, 0);
         return result;
    }
    public void restoreIpAddresses(String s, String prefix, int currIndex, int dotCount) {
        if(dotCount > 4) return;
        if(dotCount == 4 && currIndex == s.length()) result.add(prefix);
        // Think about why 4. 
        for(int i=1; i<4;i++){
            if(currIndex + i > s.length()) break;
            String temp = s.substring(currIndex, currIndex+i);
            if((temp.startsWith("0") && temp.length() >1) || (i==3 && Integer.valueOf(temp) >= 256)) continue;
        
            restoreIpAddresses(s, prefix+temp+(dotCount==3?"":"."), currIndex+i, dotCount+1);
        }
    }

}
