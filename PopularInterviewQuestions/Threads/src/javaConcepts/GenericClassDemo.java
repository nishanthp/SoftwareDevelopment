package JavaConcepts;

public class GenericClassDemo<T extends Object> {
	T sum;
	Integer temp = -1;

	public T add(T num1, T num2) {
		if (num1 instanceof String && num2 instanceof String) {
			sum = (T) (num1.toString() + num2.toString());
		}
		if (num1 instanceof Integer && num2 instanceof Integer) {
			temp = Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
			sum = (T) temp;
		}

		return sum;
	}



	public static void main(String[] args) {
		GenericClassDemo<String> sClass = new GenericClassDemo<>();
		System.out.println(sClass.add("num1", "num2"));

		GenericClassDemo<Integer> iClass = new GenericClassDemo<>();
		System.out.println(iClass.add(10, 23));
		
	}

}
