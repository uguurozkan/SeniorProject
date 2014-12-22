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
		String command = "mvn test"; // TODO mvn not working
		startProcess(buildProcess(command));
	}

	public void createTest() {
		createFolderHierarchy();
		copyNecessaryFiles();
		generatesources();
	}	

	private void createFolderHierarchy() {
		String command1 = "mkdir GraphWalker\\Projects\\" + projectName	+ "\\src\\main\\java\\org\\myorg\\testautomation";
		String command2 = "mkdir GraphWalker\\Projects\\" + projectName	+ "\\src\\main\\resources\\org\\myorg\\testautomation";
		String command3 = "mkdir GraphWalker\\Projects\\" + projectName	+ "\\src\\test\\java\\org\\myorg\\testautomation";

		String command = command1 + " && " + command2 + " && " + command3;
		startProcess(buildProcess(command));
	}
	
	private void copyNecessaryFiles() {
		String command1 = "copy GraphWalker\\Model\\" + modelName + "GraphWalker\\Projects\\" + projectName + "\\src\\main\\resources\\org\\myorg\\testautomation";
		String command2 = "copy GraphWalker\\pom.xml GraphWalker\\Projects\\" + projectName;
		
		String command = command1 + " && " + command2;
		startProcess(buildProcess(command));
	}
	
	private void generatesources() { // TODO mvn not working
		String command1 = "cd GraphWalker\\Projects\\" + projectName;
		String command2 = "mvn graphwalker:generate­sources";
		
		String command = command1 + " && " + command2;
		startProcess(buildProcess(command));
	}

}
