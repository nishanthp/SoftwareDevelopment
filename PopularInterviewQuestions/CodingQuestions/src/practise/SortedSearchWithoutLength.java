package practise;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SortedSearchWithoutLength {
public static void main(String []args){
	System.out.println(sortSearch(new Listy(), 6));
}



public static int sortSearch(Listy list, int val){
	int rightIndex = 1;
	while(list.elementAt(rightIndex) != -1 && list.elementAt(rightIndex) < val){
		rightIndex *=2;
	}
	System.out.println("RIGHT INDEX" + rightIndex);
	int index = binarySearch(list, val , rightIndex/2, rightIndex);	
	return index;
}



private static int binarySearch(Listy list, int val, int low, int high) {
	while(low<=high){
		int mid = (low+high)/2;
		if(list.elementAt(mid) == val) return mid;
		else if(list.elementAt(mid) > val) high = mid-1;
		else low = mid+1;
	}
	return -1;
	
}
}



class Listy {
	ArrayList<Integer> list = new ArrayList<Integer>();	
	Listy(){
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
	}
	
	public int elementAt(int index){		
		return  index > list.size() -1 ? -1: list.get(index);
	}
	
}