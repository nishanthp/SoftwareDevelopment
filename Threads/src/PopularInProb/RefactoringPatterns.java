package PopularInProb;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class RefactoringPatterns {
	static HashMap<CONFIG, Handler> map = new HashMap<>();

	public static void main(String[] args) {
		map.put(CONFIG.SHUFFLED, new Handler() {

			@Override
			public void handle(String input) {
				String[] temp = input.split(" ");
				StringBuffer buffer = new StringBuffer();
				Collections.shuffle(Arrays.asList(temp));
				for (String oneWord : temp) {
					buffer.append(oneWord);
				}
				System.out.println(new String(buffer));
			}
		});
		map.put(CONFIG.UPPERCASE, new Handler() {

			@Override
			public void handle(String input) {
				// convert the input to uppercase.
			}
		});
		RefactoringPatterns rp = new RefactoringPatterns();
		Configuration config = new Configuration();
		config.setShuffleParam(CONFIG.SHUFFLED);
		rp.getHandler(config, "this is a pattern");
	}

	public void getHandler(Configuration reqConfig, String input) {
		map.get(reqConfig.getShuffleParam()).handle(input);
	}
}

interface Handler {
	void handle(String input);
}

class Configuration {
	public CONFIG shuffleParam;
	public CONFIG upperCaseParam;

	public CONFIG getShuffleParam() {
		return shuffleParam;
	}

	public void setShuffleParam(CONFIG shuffleParam) {
		this.shuffleParam = shuffleParam;
	}

	public CONFIG getUpperCaseParam() {
		return upperCaseParam;
	}

	public void setUpperCaseParam(CONFIG upperCaseParam) {
		this.upperCaseParam = upperCaseParam;
	}

}

enum CONFIG {
	SHUFFLED, NOT_SHUFFLED, UPPERCASE, LOWERCASE;

}