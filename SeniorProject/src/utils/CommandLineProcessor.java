package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is a general class for command line processes.
 * 
 * @author Ugur Ozkan
 * 
 */
public class CommandLineProcessor {

	private File workingDirectory = new File(System.getProperty("user.dir"));

	/**
	 * Creates a ProcessBuilder
	 * 
	 * @param command
	 *            a specified system command
	 * @return pBuilder
	 * @deprecated
	 */
	protected ProcessBuilder buildProcess(String command) {
		ProcessBuilder pBuilder = new ProcessBuilder("cmd.exe", "/c", command);
		pBuilder.redirectErrorStream(true);
		return pBuilder;
	}

	/**
	 * Creates a ProcessBuilder with a working directory.
	 * 
	 * @param directory
	 *            a working directory
	 * @param command
	 *            a specified system command
	 * @return pBuilder
	 * @deprecated
	 */
	protected ProcessBuilder buildProcess(String directory, String command) {
		ProcessBuilder pBuilder = new ProcessBuilder("cmd.exe", "/c", command);
		pBuilder.redirectErrorStream(true);
		pBuilder.directory(new File(directory));
		return pBuilder;
	}

	/**
	 * This method uses ProcessBuilder to start the process.
	 * 
	 * @param pBuilder
	 *            a specified ProcessBuilder
	 * @deprecated
	 */
	protected void startProcess(ProcessBuilder pBuilder) {
		try {
			pBuilder.start().waitFor();
		} catch (IOException e) {
			System.err
					.println("Problem with the startProcess(ProcessBuilder pBuilder).");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("Interrupted Exception. Problem with waitFor inside startProcess(ProcessBuilder pBuilder).");
			e.printStackTrace();
		}
	}

	/**
	 * Convenience method for startProcess. It uses Runtime.getRuntime().exec
	 * method while starting the process.
	 * 
	 * @param command
	 *            a specified system command
	 * @param directory
	 *            a specified working directory
	 */
	protected void startProcess(String command, String directory) {
		workingDirectory = new File(directory);
		String fullCommand = "cmd.exe" + " /c " + command + " & exit";

		try {
			Runtime.getRuntime()
					.exec(fullCommand, null, workingDirectory)
					.waitFor();
		} catch (IOException e) {
			System.err.println("Problem with the startProcess().");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("Interrupted Exception. Problem with waitFor inside startProcess().");
			e.printStackTrace();
		}
	}

	/**
	 * This method uses ProcessBuilder to start the process.
	 * 
	 * @param pBuilder
	 *            a specified ProcessBuilder
	 * @return process
	 * @deprecated
	 */
	protected Process getProcess(ProcessBuilder pBuilder) {
		Process process = null;
		try {
			process = pBuilder.start();
			waitFor(process);
		} catch (IOException e) {
			System.err.println("Problem with the process.");
		} 
		return process;
	}

	/**
	 * Convenience method for getProcess. It uses Runtime.getRuntime().exec()
	 * method while starting the process.
	 * 
	 * @param command
	 *            a specified system command
	 * @param directory
	 *            a specified working directory
	 * @return process
	 */
	protected Process getProcess(String command, String directory) {
		workingDirectory = new File(directory);
		String fullCommand = "cmd.exe /c " + command;

		Process process = null;
		try {
			process = Runtime.getRuntime().exec(fullCommand, null, workingDirectory);
			// process.waitFor(); // Causes deadlock
		} catch (IOException e) {
			System.err.println("Problem with the startProcess().");
			e.printStackTrace();
		}
		return process;
	}

	protected BufferedReader getOutput(Process process) {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));
		process.destroy();
		return bufferedReader;
	}

	protected void writeOutput(Process process) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

		String line = null;
		while ((line = getLine(reader)) != null) {
			System.out.println(line);
		}
		waitFor(process);
		closeReader(reader);
		process.destroy();
	}

	private void waitFor(Process process) {
		try {
			process.waitFor();
		} catch (InterruptedException e) {
			System.err.println("Interrupted Exception. Problem with waitFor.");
			e.printStackTrace();
		}
	}

	private void closeReader(BufferedReader reader) {
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Problem occured while closing BufferedReader.");
			e.printStackTrace();
		}
	}

	protected String getLine(BufferedReader reader) {
		String line = null;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.err.println("Problem with the readLine process.");
		}
		return line;
	}

}
