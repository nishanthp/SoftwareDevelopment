package Arrays;

public class ShortURLDemo {
	public static void main(String[] args) {
		ShortURLDemo demo = new ShortURLDemo();
		String shortUrl = demo.convertIdToShortUrl(12345);
		System.out.println(shortUrl);
		long id = demo.convertShortUrltoInt(reverse(shortUrl));
		System.out.println(id);
	}

	private static String reverse(String shortUrl) {
		StringBuffer buffer = new StringBuffer();
		for (int i = shortUrl.length() - 1; i >= 0; i--) {
			buffer.append(shortUrl.charAt(i));
		}
		return new String(buffer);
	}

	public String convertIdToShortUrl(int id) {
		char[] map = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9' };
		StringBuffer str = new StringBuffer();
		while (id != 0) {
			str.append(map[id % 62]);
			id = id / 62;
		}
		return new String(str);
	}

	public long convertShortUrltoInt(String url) {
		long id = 0;
		for (int i = 0; i < url.length(); i++) {
			if ('0' <= url.charAt(i) && url.charAt(i) <= '9') {
				id = id * 62 + url.charAt(i) - '0' + 52;
			}
			if ('A' <= url.charAt(i) && url.charAt(i) <= 'Z') {
				id = id * 62 + url.charAt(i) - 'A' + 26;
			}
			if ('a' <= url.charAt(i) && url.charAt(i) <= 'z') {
				id = id * 62 + url.charAt(i) - 'a';
			}
		}
		return id;
	}
}
