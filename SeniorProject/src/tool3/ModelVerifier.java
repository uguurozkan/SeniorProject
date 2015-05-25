package tool3;

import java.io.BufferedReader;
import java.io.File;

import utils.CommandLineProcessor;

/**
 * This class verifies the correctness of the model.
 * 
 * @author Ugur Ozkan
 * 
 */
public class ModelVerifier extends CommandLineProcessor {

	private String graphWalkerJarPath, yEdJarPath, modelPath, strategy;
	private StringBuilder stringBuilder;

	public ModelVerifier(String jarFilesPath, String modelPath,
			String pathGenerator, String stopCondition) {
		setGraphWalkerJarPath(jarFilesPath);
		setyEdJarPath(jarFilesPath);
		setModelPath(modelPath);
		setStrategy(pathGenerator, stopCondition);
	}

	private void setGraphWalkerJarPath(String jarFilesPath) {
		this.graphWalkerJarPath = jarFilesPath + "graphwalker.jar";
	}

	private void setyEdJarPath(String jarFilesPath) {
		this.yEdJarPath = jarFilesPath + "yEd.jar";
	}
	
	private void setModelPath(String modelPath) {
		if (!modelPath.endsWith(".graphml"))
			this.modelPath = modelPath + ".graphml";
		else
			this.modelPath = modelPath;
	}

	private void setStrategy(String pathGenerator, String stopCondition) {
		this.strategy = " \"" + pathGenerator + "(" + stopCondition + ")\"";
	}

	public boolean verify() {
		String workingDirectory = ".\\";
		String command = "java -jar " + graphWalkerJarPath + " offline -m " + modelPath + strategy;

		@SuppressWarnings("deprecation")
		BufferedReader output = getOutput(getProcess(buildProcess(workingDirectory, command)));
		return (output == null) ? false : processOutput(output);
	}

	private boolean processOutput(BufferedReader reader) {
		stringBuilder = new StringBuilder();
		boolean isVerified = true;
		String line = null;
		while (true) {
			line = getLine(reader);
			if (line == null)
				break;
			if (!isOK(line))
				isVerified = false;
			//stringBuilder.append(line + "\r\n");
			System.out.println(line);
		}
		return isVerified;
	}

	private boolean isOK(String line) {
		return (line.startsWith("{") && line.endsWith("}")) ? true : false;
	}
	
	public void printErrorMessage() {
		System.err.println(stringBuilder.toString());
	}
	
	public void startyEd() {
		String workingDirectory = ".\\";
		String command = "java -jar " + yEdJarPath + " " + modelPath;
		
		startProcess(command, workingDirectory);
	}

}
