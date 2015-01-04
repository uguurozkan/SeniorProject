package tool6;

import utils.CommandLineProcessor;

public class TestRunner extends CommandLineProcessor {
	
	private String projectName;
	
	public TestRunner (String projectName) {
		this.projectName = projectName;
	}
	
	public void invokeTest() {
		String workingDirectory = "GraphWalker\\Projects\\" + projectName;
		String command = "mvn test";

		writeOutput(getProcess(command, workingDirectory));
	}

}
