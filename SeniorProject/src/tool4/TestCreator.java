package tool4;

import utils.CommandLineProcessor;

/**
 * This class creates and invokes tests.
 * 
 * @author Ugur Ozkan
 * 
 */
public class TestCreator extends CommandLineProcessor {

	private String projectName, modelName;

	public TestCreator(String projectName, String modelName) {
		this.projectName = projectName;
		this.modelName = modelName;
	}

	public void invokeTest() {
		String workingDirectory = "GraphWalker\\Projects\\" + projectName;
		String command = "mvn test";
		
		//startProcess(command);
		writeOutput(getOutput(getProcess(command, workingDirectory)));
		//startProcess(buildProcess(command));
	}

	public void createTest() throws InterruptedException {
		createFolderHierarchy();
		copyNecessaryFiles();
		generatesources();
	}	

	private void createFolderHierarchy() {
		String workingDirectory = ".\\";
		String command1 = "mkdir GraphWalker\\Projects\\" + projectName	+ "\\src\\main\\java\\org\\myorg\\testautomation";
		String command2 = "mkdir GraphWalker\\Projects\\" + projectName	+ "\\src\\main\\resources\\org\\myorg\\testautomation";
		String command3 = "mkdir GraphWalker\\Projects\\" + projectName	+ "\\src\\test\\java\\org\\myorg\\testautomation";

		String command = command1 + " & " + command2 + " & " + command3;
		startProcess(command, workingDirectory);
		//startProcess(buildProcess(command));
	}
	
	private void copyNecessaryFiles() {
		String workingDirectory = ".\\";
		String command1 = "copy GraphWalker\\Model\\" + modelName + " GraphWalker\\Projects\\" + projectName + "\\src\\main\\resources\\org\\myorg\\testautomation";
		String command2 = "copy GraphWalker\\pom.xml GraphWalker\\Projects\\" + projectName;
		
		String command = command1 + " & " + command2;
		startProcess(command, workingDirectory);
		//startProcess(buildProcess(command));
		
	}
	
	private void generatesources() { 
		String workingDirectory = "GraphWalker\\Projects\\" + projectName;
		String command = "mvn graphwalker:generate-sources";

		//startProcess(command);
		writeOutput(getOutput(getProcess(command, workingDirectory)));
		//writeOutput(getOutput(getProcess(buildProcess(command2, "GraphWalker\\Projects\\" + projectName))));
	
	}

}
