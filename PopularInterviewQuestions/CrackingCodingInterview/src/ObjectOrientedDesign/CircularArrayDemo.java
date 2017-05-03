package ObjectOrientedDesign;

import java.util.Iterator;

public class CircularArrayDemo {

	public static void main(String[] args) {
		CircularArray<Integer> array = new CircularArray<Integer>(4);
		array.set(0, 1);
		array.set(1, 2);
		array.set(2, 3);
		array.set(3, 4);

		System.out.println(array.get(3));
		for (int item : array) {
			System.out.println(item);
		}
		
		array.rotate(2);
		System.out.println(array.get(3));
	}
}

class CircularArray<T> implements Iterable<T> {
	public T[] items;
	int size;
	int head = 0;

	public CircularArray(int size) {
		this.size = size;
		items = (T[]) new Object[size];
	}

	public int getSize() {
		return size;
	}

	public void rotate(int pos) {
		head = convertIndex(pos);
	}

	private int convertIndex(int pos) {
		if (pos < 0) {
			pos += items.length;
		} else {
			pos = (head + pos) % items.length;
		}
		return pos;
	}

	public T get(Integer index) {
		if (index < 0 || index >= items.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return items[convertIndex(index)];
	}

	public void set(int indx, T data) {
		items[convertIndex(indx)] = data;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new CircularIterator();
	}

	private class CircularIterator implements Iterator<T> {
		int current = -1;

		@Override
		public boolean hasNext() {
			return current < items.length - 1;
		}

		@Override
		public T next() {
			++current;
			return items[convertIndex(current)];
		}

	}

}
