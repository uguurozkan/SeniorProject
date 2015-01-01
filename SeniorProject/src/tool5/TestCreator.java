package tool5;

import utils.CommandLineProcessor;

public class TestCreator extends CommandLineProcessor{
	
	private String projectName;
	
	public TestCreator(String projectName) {
		this.projectName = projectName;
	}

	public void invokeTest() {
		String workingDirectory = "GraphWalker\\Projects\\" + projectName;
		String command = "mvn test";

		writeOutput(getProcess(command, workingDirectory));
	}
}
