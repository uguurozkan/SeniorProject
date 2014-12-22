package tool3;

import java.io.BufferedReader;

import utils.CommandLineProcessor;

/**
 * This class verifies the correctness of the model.
 * 
 * @author Ugur Ozkan
 * 
 */
public class ModelVerifier extends CommandLineProcessor {

	private String graphWalkerJarPath, modelPath, strategy;

	public ModelVerifier(String graphWalkerJarPath, String modelPath, String pathGenerator, String stopCondition) {
		this.graphWalkerJarPath = graphWalkerJarPath; // TODO not .jar ?
		this.modelPath = modelPath; // TODO not .graphml ?
		setStrategy(pathGenerator, stopCondition);
	}

	private void setStrategy(String pathGenerator, String stopCondition) {
		this.strategy = " \"" + pathGenerator + "(" + stopCondition + ")\"";
	}

	public boolean verify() {
		String command = "java -jar " + graphWalkerJarPath + " offline -m " + modelPath + strategy;

		BufferedReader output = getOutput(getProcess(buildProcess(command)));
		return (output == null) ? false : processOutput(output);
	}

	private boolean processOutput(BufferedReader reader) {
		String line = null;
		while (true) {
			line = getLine(reader, line);
			if (line == null)
				break;
			if (!processLine(line))
				return false;
		}
		return true;
	}

	private boolean processLine(String line) {
		return (line.startsWith("{\"") && line.endsWith("\"}")) ? true : false;
	}

}
