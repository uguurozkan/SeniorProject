package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is a general class for command line processes.
 * 
 * @author Ugur Ozkan
 * 
 */
public class CommandLineProcessor {

	protected BufferedReader getOutput(Process process) {
		return new BufferedReader(new InputStreamReader(
				process.getInputStream()));
	}

	protected ProcessBuilder buildProcess(String command) {
		ProcessBuilder pBuilder = new ProcessBuilder("cmd.exe", "/c", command);
		pBuilder.redirectErrorStream(true);
		return pBuilder;
	}

	protected void startProcess(ProcessBuilder pBuilder) {
		try {
			pBuilder.start();
		} catch (IOException e) {
			System.err.println("Problem with the process.");
		}
	}

	protected Process getProcess(ProcessBuilder pBuilder) {
		Process process = null;
		try {
			process = pBuilder.start();
		} catch (IOException e) {
			System.err.println("Problem with the process.");
		}
		return process;
	}

	protected void writeOutput(BufferedReader reader) {
		String line = null;
		while (true) {
			line = getLine(reader, line);
			if (line == null)
				break;
			System.out.println(line);
		}
	}

	protected String getLine(BufferedReader reader, String line) {
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.err.println("Problem with the readLine process.");
		}
		return line;
	}

	protected String getErrorMessage() { // TODO getError message
		return "";
	} 

}
