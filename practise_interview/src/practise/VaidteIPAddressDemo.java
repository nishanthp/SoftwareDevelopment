package practise;

public class VaidteIPAddressDemo {
	public static void main(String[] args) {
		String ip = "127.0.0.1";
		boolean b = validateIP(ip);
		System.out.println(b);

	}

	public static boolean validateIP(String ip) {
		int i;
		String[] input = ip.split("\\.");
		if (input.length != 4) {
			return false;
		}
		for (String tokes : input) {
			try {
				i = Integer.parseInt(tokes);
			} catch (Exception e) {
				return false;
			}
			if (i < 0 && i > 255) {
				return false;
			}
		}
		return true;
	}
}
