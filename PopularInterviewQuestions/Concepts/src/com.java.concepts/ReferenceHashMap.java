package javaConcepts;

import java.util.IdentityHashMap;

public class ReferenceHashMap {

	public static void main(String[] args) {
		Integer[] nums = {1,2,3};
		Integer[] nums2 = nums;
		// Similar to hashmap but the keys are compared by reference instead of value.
 		IdentityHashMap<Integer[], Integer> referenceMap = new IdentityHashMap<>();
		referenceMap.put(nums, 1);
		if(referenceMap.containsKey(nums2)){
			System.out.println("keys are compared by reference");
		}

	}
	
	

}
