package accpetedSubmissions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// Ran on leetcode
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> result = new LinkedList<Integer>();
        for(int num : nums){
            if(!map.containsKey(num)) map.put(num, 1);
            else {
                map.put(num, map.get(num)+1);
                
            }
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(new Compa(map));
        treeMap.putAll(map);
        int count=0;
        for(Map.Entry<Integer, Integer> entry : treeMap.entrySet()){
            count +=1;
            result.add(entry.getKey());
            if(count == k) return result;
        }
        return result;
    }
}

class Compa implements Comparator<Integer>{

	HashMap<Integer,Integer> map;
Compa(HashMap<Integer,Integer> map){
	this.map = map;
}

@Override
public int compare(Integer o1, Integer o2) {
    
	// This is the most important part. Without line number 50 and 51, it wont work for tie braker, i.e if the values are same.
	int ret = this.map.get(o2).compareTo(this.map.get(o1));
    if (ret != 0) return ret;
    else return o2.compareTo(o1);
}
}
