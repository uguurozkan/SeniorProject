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

	protected BufferedReader getOutput(Process process) {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));
		process.destroy();
		return bufferedReader;
	}

	/**
	 * Creates a ProcessBuilder
	 * 
	 * @param command
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
	 * @param dir
	 * @param command
	 * @return pBuilder
	 * @deprecated
	 */
	protected ProcessBuilder buildProcess(String dir, String command) {
		ProcessBuilder pBuilder = new ProcessBuilder(command);
		pBuilder.redirectErrorStream(true);
		pBuilder.directory(new File(dir));
		return pBuilder;
	}

	/**
	 * This method uses ProcessBuilder to start the process.
	 * 
	 * @param pBuilder
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
			System.out
					.println("Interrupted Exception. Problem with waitFor inside startProcess(ProcessBuilder pBuilder).");
			e.printStackTrace();
		}
	}

	/**
	 * Convenience method for startProcess. It uses Runtime.getRuntime().exec
	 * method while starting the process.
	 * 
	 * @param command
	 */
//	protected void startProcess(String command) {
//		try {
//			Runtime.getRuntime().exec("cmd.exe" + " /c " + command + " & exit", null, workingDirectory).waitFor();
//			
//		} catch (IOException e) {
//			System.err.println("Problem with the startProcess().");
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			System.out.println("Interrupted Exception. Problem with waitFor inside startProcess().");
//			e.printStackTrace();
//		} 
//	}
	
	protected void startProcess(String command, String dir) {
		workingDirectory = new File(dir);
		try {
			Runtime.getRuntime().exec("cmd.exe" + " /c " + command + " & exit", null, workingDirectory).waitFor();
			
		} catch (IOException e) {
			System.err.println("Problem with the startProcess().");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception. Problem with waitFor inside startProcess().");
			e.printStackTrace();
		} 
	}

	/**
	 * This method uses ProcessBuilder to start the process.
	 * 
	 * @param pBuilder
	 * @return process
	 * @deprecated
	 */
	protected Process getProcess(ProcessBuilder pBuilder) {
		Process process = null;
		try {
			process = pBuilder.start();
			process.waitFor();
		} catch (IOException e) {
			System.err.println("Problem with the process.");
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception.");
		}
		return process;
	}

	/**
	 * Convenience method for getProcess. It uses Runtime.getRuntime().exec()
	 * method while starting the process.
	 * 
	 * @return Process process
	 */
//	protected Process getProcess(String command) {
//		Process process = null;
//		try {
//			process = Runtime.getRuntime()
//					.exec("cmd.exe /c " + command, null, workingDirectory);
//			process.waitFor();
//		} catch (IOException e) {
//			System.err.println("Problem with the startProcess().");
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			System.out.println("Interrupted Exception. Problem with waitFor inside getProcess().");
//			e.printStackTrace();
//		}
//		return process;
//	}
	
	protected Process getProcess(String command, String dir) {
		workingDirectory = new File(dir);
		Process process = null;
		try {
			process = Runtime.getRuntime()
					.exec("cmd.exe /c " + command, null, workingDirectory);
			process.waitFor();
		} catch (IOException e) {
			System.err.println("Problem with the startProcess().");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception. Problem with waitFor inside getProcess().");
			e.printStackTrace();
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
		closeReader(reader);
	}

	private void closeReader(BufferedReader reader) {
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Problem occured while closing BufferedReader.");
			e.printStackTrace();
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

}
