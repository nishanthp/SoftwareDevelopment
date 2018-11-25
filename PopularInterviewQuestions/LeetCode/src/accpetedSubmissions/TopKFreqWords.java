package accpetedSubmissions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopKFreqWords {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<String> result = new LinkedList<String>();
        for(String num : words){
            if(!map.containsKey(num)) map.put(num, 1);
            else {
                map.put(num, map.get(num)+1);
                
            }
        }
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(new Compar(map));
        treeMap.putAll(map);
        int count=0;
        for(Map.Entry<String, Integer> entry : treeMap.entrySet()){
            count +=1;
            result.add(entry.getKey());
            if(count == k) return result;
        }
        return result;
    }
}

class Compar implements Comparator<String>{

	HashMap<String,Integer> map;
Compar(HashMap<String,Integer> map){
	this.map = map;
}

@Override
public int compare(String o1, String o2) {
    
	// This is the most important part. Without line number 50 and 51, it wont work for tie braker, i.e if the values are same.
	int ret = this.map.get(o2).compareTo(this.map.get(o1));
    if (ret != 0) return ret;
    else return o1.compareTo(o2);
}

}
