package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FactorCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	 List<List<Integer>> results = new ArrayList<>();
	 List<Integer> result = new ArrayList<Integer>();
	    public List<List<Integer>> getFactors(int n) {
	        getFactorsT(n, 2);
	        return results;
	    }
	    
	    public void getFactorsT(int n, int start) {
	        if(n <= 1 ) {
	            if(result.size() > 1) {
	                Collections.sort(result);
	                if(results.contains(result)) return;
	                List<Integer> temp = new ArrayList<Integer>();
	                temp.addAll(result);
	                results.add(temp);
	            }
	            return;
	        }
	        
	        for(int i=start;i<=n;i++){  
	            if(n%i == 0) {
	                result.add(i);
	                getFactorsT(n/i, i);
	                result.remove(result.size()-1);
	            }
	            
	        }
	        return;
	    }

}
