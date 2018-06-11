package popularInProb;

import java.io.File;
import java.io.IOException;

public class FileOperations {
	public static void main(String[] args) {
		String cDrive = "C:" + File.pathSeparator + "pract" + File.pathSeparator + "tes.txt";
		File hpeidmapd = new File(cDrive);
		try {
			boolean diit = hpeidmapd.createNewFile();
			System.out.println(diit);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
