package PopularInProb;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAllOccurancesDemo {
	public static void main(String[] args) throws IOException {
		String filePath = "C:" + File.separator + "text.txt";
		String word = "geeks";
		FindAllOccurances occurance = new FindAllOccurances(filePath, word);
		occurance.findStartingIndex();
	}
}

class FindAllOccurances {
	String pattern;
	String filePath;

	public FindAllOccurances(String filePath, String patternToBeMatched) {
		this.filePath = filePath;
		this.pattern = patternToBeMatched;
	}

	public void findStartingIndex() throws IOException {
		try (FileReader file = new FileReader(this.filePath); BufferedReader inputStream = new BufferedReader(file)) {
			String line;
			Pattern p = Pattern.compile("geeks", Pattern.CASE_INSENSITIVE);
			while ((line = inputStream.readLine()) != null) {
				Matcher matcher = p.matcher(line);
				while (matcher.find()) {
					System.out.println(matcher.start());
				}
			}
		} catch (FileNotFoundException e) {
			throw new IOException("File not found.", e);
		}

	}

}
