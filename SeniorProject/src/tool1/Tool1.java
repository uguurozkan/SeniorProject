package tool1;

import java.util.List;

public class Tool1 {
	private final static String BASE_URL = "http://localhost:801/xampp/CS401Website/";

	public static void main(String[] args) {
		ElementExtractor ee = new ElementExtractor(BASE_URL);
		ElementConverter ec = new ElementConverter(ee.getElements());
		List<String> c = ec.getCommands();
		for (String s : c) {
			System.out.println(s.toString());
		}
	}

}
