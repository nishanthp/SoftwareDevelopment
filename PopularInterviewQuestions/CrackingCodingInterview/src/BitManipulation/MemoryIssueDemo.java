package BitManipulation;

public class MemoryIssueDemo {
	public static void main(String[] args) {
		// might contain upto 32000 numbers.
		int[] array = {};
		BitSet s = new BitSet(array.length);
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			// numbers are from 1...N
			int temp = num - 1;
			if (s.get(temp)) {
				System.out.println(num);
			}else{
				s.set(temp);
			}
		}
	}

}

class BitSet {
	int[] bits;

	BitSet(int size) {
		// divide by 32.
		bits = new int[size >> 5 + 1];
	}

	public boolean get(int num) {
		// divide by 32
		int wordNumber = num >> 5;
		// mod of 32
		int bitNumber = num % 32;
		return (bits[wordNumber] & (1 << bitNumber)) != 0;
	}

	public void set(int num) {
		int wordNumber = num >> 5;
		int bitNumber = num % 32;
		bits[wordNumber] |= 1 << bitNumber;
	}

}
