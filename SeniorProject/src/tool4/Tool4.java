package tool4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import utils.CommandLineProcessor;

public class Tool4 extends CommandLineProcessor{

	public static void main(String[] args) {
		//TestCreator tc = new TestCreator("login", "Login.graphml");
		//tc.createTest();
		// tc.invokeTest();

		new Tool4();
		
	}
	
	public Tool4(){
		//System.out.println("test1");
		test();
		//System.out.println("\n\n\nTest2");
		//test2();
		//System.out.println("\n\n\nTest3");
		//test3();
	}
	
	private void test3() {
		String command2 = "mvn graphwalker:generate­sources -e";
		String command1 = "mvn help:active-profiles";
		String command = "echo %cd%";
		System.out.print("\n\ncommand2: ");
		writeOutput(getOutput(getProcess(buildProcess(command))));
	}

	private void test2(){
		writeOutput(getOutput(getProcess(buildProcess("cmd.exe /c mvn -version"))));
	}
	private void test() {
		System.out.println("Started...\n\n");
		try {
			Process p = Runtime.getRuntime().exec("C:\\Program Files\\Apache Software Foundation\\apache-maven-3.2.3\\bin\\mvn.bat graphwalker:generate-sources" , null, new File("GraphWalker\\Projects\\login"));
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}

		} catch (IOException e1) {
			System.out.println("e1");
		} catch (InterruptedException e2) {
			System.out.println("e2");
		}


		System.out.println("\n\nEnded...");
	}

}
