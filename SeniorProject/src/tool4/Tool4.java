package tool4;

public class Tool4 {

	public static void main(String[] args) {
		TestCreator tc = new TestCreator("login", "test.graphml");
		tc.createTest();
		tc.invokeTest();
	}

}
