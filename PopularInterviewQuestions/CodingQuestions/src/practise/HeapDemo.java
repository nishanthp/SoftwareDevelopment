package practise;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HeapDemo {
	public static void main(String[] args) {
		Heap heap = new Heap(new ArrayList<Integer>());
		heap.insert(15);
		heap.insert(10);
		heap.insert(12);
		heap.insert(8);
		heap.insert(4);
		heap.insert(2);
		heap.insert(9);
		heap.insert(9);
		heap.insert(6);
		heap.insert(3);
		System.out.println("MAX VALUE:" + heap.delete());
		System.out.println("MAX VALUE:" + heap.delete());
		System.out.println("MAX VALUE:" + heap.delete());
	}
}

class Heap {
	ArrayList<Integer> heap = new ArrayList<>();

	public Heap(ArrayList<Integer> heap) {
		this.heap = heap;
	}

	public void insert(int data) {
		this.heap.add(data);
		shiftUp();
	}

	public int delete() {
		if (this.heap.size() == 0)
			throw new NoSuchElementException();
		if (this.heap.size() == 1)
			return this.heap.remove(0);
		int valueToBeReturned = this.heap.get(0);
		this.heap.set(0, this.heap.remove(size() - 1));
		shiftDown();
		return valueToBeReturned;
	}

	private void shiftUp() {
		int itemIndex = this.heap.size() - 1;
		while (itemIndex > 0) {
			int parentIndex = (itemIndex - 1) / 2;
			int item = this.heap.get(itemIndex);
			int parent = this.heap.get(parentIndex);
			if (item > parent) {
				this.heap.set(itemIndex, parent);
				this.heap.set(parentIndex, item);
				itemIndex = parentIndex;
			} else
				break;
		}
	}

	private void shiftDown() {
		int parentIndex = 0;
		int maxItemIndex;
		int leftChildIndex = 2 * parentIndex + 1;
		while (leftChildIndex < this.heap.size()) {
			maxItemIndex = leftChildIndex;
			int rightChildIndex = leftChildIndex + 1;
			if (rightChildIndex < this.heap.size()) {
				if (this.heap.get(leftChildIndex) < this.heap.get(rightChildIndex)) {
					maxItemIndex = rightChildIndex;
				}
			}
			if (this.heap.get(maxItemIndex) > this.heap.get(parentIndex)) {
				int temp = this.heap.get(parentIndex);
				this.heap.set(parentIndex, this.heap.get(maxItemIndex));
				this.heap.set(maxItemIndex, temp);
				parentIndex = maxItemIndex;
				leftChildIndex = 2 *parentIndex + 1;
			} else
				break;
		}
	}

	public int size() {
		return this.heap.size();
	}
}