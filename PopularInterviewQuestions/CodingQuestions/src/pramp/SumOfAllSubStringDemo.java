package newSet;

public class SumOfAllSubStringDemo {
	public static void main(String[] args) {
		SumOfAllSubStringDemo s = new SumOfAllSubStringDemo();
		System.out.println(s.sum("123"));
	}

	public int sum(String input) {
		int sum = 0;
		for (int i = 0; i < input.length(); i++) {
			Character digit = input.charAt(i);
			sum += Integer.parseInt(digit.toString());
			for (int j = i + 1; j < input.length(); j++) {
				String temp = input.substring(i, j + 1);
				sum += Integer.parseInt(temp.toString());
			}
		}
		return sum;
	}
}
