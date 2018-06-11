package glassDoor;

public class ReplaceAllStringDemo {
	public static void main(String[] args) {
		String input = "thisishowitworks";
		String pattern = "works";
		String replacement = "shouldworks";
		ReplaceAllStringDemo d = new ReplaceAllStringDemo();
		System.out.println(d.replaceAll(input, pattern, replacement));
	}

	private String replaceAll(String input, String pattern, String replacement) {
		StringBuffer buffer = new StringBuffer();
		int startIndex = 0;
		while (startIndex < input.length()) {
			int patterIndex = input.indexOf(pattern, startIndex);
			if (patterIndex > 0) {
				buffer.append(input.substring(startIndex, patterIndex));
				buffer.append(replacement);
				startIndex = patterIndex + pattern.length();
			}
		}
		// last part of the string.
		buffer.append(input.substring(startIndex));
		return buffer.toString();
	}
}
