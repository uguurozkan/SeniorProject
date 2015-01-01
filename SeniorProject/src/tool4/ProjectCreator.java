package tool4;

import utils.CommandLineProcessor;

/**
 * This class creates project resources.
 * 
 * @author Ugur Ozkan
 * 
 */
public class ProjectCreator extends CommandLineProcessor {

	private String projectName, modelName;

	public ProjectCreator(String projectName, String modelName) {
		this.projectName = projectName;
		this.modelName = modelName;
	}

	public void createProject() {
		createFolderHierarchy();
		copyNecessaryFiles();
		generatesources();
		copyGeneratedFiles();
	}

	private void createFolderHierarchy() {
		String workingDirectory = ".\\";
		String command1 = "mkdir GraphWalker\\Projects\\" + projectName
				+ "\\src\\main\\java\\org\\myorg\\testautomation";
		String command2 = "mkdir GraphWalker\\Projects\\" + projectName
				+ "\\src\\main\\resources\\org\\myorg\\testautomation";
		String command3 = "mkdir GraphWalker\\Projects\\" + projectName
				+ "\\src\\test\\java\\org\\myorg\\testautomation";

		String command = command1 + " & " + command2 + " & " + command3;
		startProcess(command, workingDirectory);
	}

	private void copyNecessaryFiles() {
		String workingDirectory = "GraphWalker";
		String command1 = "copy"
				+ " Models\\" + modelName 
				+ " Projects\\" + projectName + "\\src\\main\\resources\\org\\myorg\\testautomation";
		String command2 = "copy "
				+ "pom.xml "
				+ "Projects\\" + projectName;

		String command = command1 + " & " + command2;
		startProcess(command, workingDirectory);
	}

	private void generatesources() {
		String workingDirectory = "GraphWalker\\Projects\\" + projectName;
		String command = "mvn graphwalker:generate-sources";

		// startProcess(command);
		writeOutput(getProcess(command, workingDirectory));
	}

	private void copyGeneratedFiles() {
		String workingDirectory = "GraphWalker\\Projects\\" + projectName;
		String command = "copy"
				+ " target\\generated-sources\\graphwalker\\org\\myorg\\testautomation\\"
				+ " src\\test\\java\\org\\myorg\\testautomation\\";

		startProcess(command, workingDirectory);
	}

}
