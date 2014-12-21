package tool3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Ugur Ozkan
 * 
 *         This class verifies the correctness of the model.
 * 
 */
public class ModelVerifier {

	private String graphWalkerJarPath;
	private String modelPath;
	private String strategy;

	public ModelVerifier(String graphWalkerJarPath, String modelPath,
			String pathGenerator, String stopCondition) {
		this.graphWalkerJarPath = graphWalkerJarPath; // TODO not .jar ?
		this.modelPath = modelPath; // TODO not .graphml ?
		setStrategy(pathGenerator, stopCondition);
	}

	private void setStrategy(String pathGenerator, String stopCondition) {
		this.strategy = " \"" + pathGenerator + "(" + stopCondition + ")\"";
	}

	public boolean verify() {
		BufferedReader output = getOutput();
		return (output == null) ? false : processOutput(output);
	}

	private BufferedReader getOutput() {
		String command = "java -jar " + graphWalkerJarPath + " offline -m " + modelPath + strategy;
		ProcessBuilder graphWalker = new ProcessBuilder("cmd.exe", "/c", command);
		graphWalker.redirectErrorStream(true);
		Process process = getProcess(graphWalker);

		return (process == null) ? null : new BufferedReader(new InputStreamReader(process.getInputStream()));
	}

	private Process getProcess(ProcessBuilder pBuilder) {
		Process process = null;
		try {
			process = pBuilder.start();
		} catch (IOException e) {
			System.err.println("Problem with the process.");
		}
		return process;
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

	private String getLine(BufferedReader reader, String line) {
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.out.println("Problem with the readLine process.");
		}
		return line;
	}

	private boolean processLine(String line) {
		return (line.startsWith("{\"") && line.endsWith("\"}")) ? true : false;
	}

	public String getErrorMessage() {return "";} // TODO getError message
}
