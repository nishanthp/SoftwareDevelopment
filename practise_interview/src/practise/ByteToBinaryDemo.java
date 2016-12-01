package practise;

public class ByteToBinaryDemo {
	public static void main(String[] args) {
		byte b = (byte) 'a';
		String i = Integer.toBinaryString(b & 0xFF);
		System.out.println(i);
	}
}
