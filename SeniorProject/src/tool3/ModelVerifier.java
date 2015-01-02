package tool3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import utils.CommandLineProcessor;

/**
 * This class verifies the correctness of the model.
 * 
 * @author Ugur Ozkan
 * 
 */
public class ModelVerifier extends CommandLineProcessor {

	private String graphWalkerJarPath, modelPath, strategy;
	private StringBuilder stringBuilder;

	public ModelVerifier(String graphWalkerJarPath, String modelPath,
			String pathGenerator, String stopCondition) {
		setGraphWalkerJarPath(graphWalkerJarPath);
		setModelPath(modelPath);
		setStrategy(pathGenerator, stopCondition);
	}

	private void setGraphWalkerJarPath(String graphWalkerJarPath) {
		if (!graphWalkerJarPath.endsWith(".jar"))
			this.graphWalkerJarPath = graphWalkerJarPath + ".jar";
		else
			this.graphWalkerJarPath = graphWalkerJarPath;
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
			stringBuilder.append(line + "\r\n");
		}
		return isVerified;
	}

	private boolean isOK(String line) {
		return (line.startsWith("{") && line.endsWith("}")) ? true : false;
	}
	
	public void printErrorMessage() {
		System.err.println(stringBuilder.toString());
	}

}
