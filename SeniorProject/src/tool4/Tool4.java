package tool4;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import utils.CommandLineProcessor;

public class Tool4 extends CommandLineProcessor{

	public static void main(String[] args) {
		ProjectCreator tc = new ProjectCreator("login", "Login.graphml");
		try {
			//tc.createTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 tc.invokeTest();

		//new Tool4();
		
	}
	
	public Tool4(){
		//System.out.println("test1");
		//test();
		//System.out.println("\n\n\nTest2");
		//test2();
		//System.out.println("\n\n\nTest3");
//		try {
//			test3();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		System.out.println("\n\n\n\n\n\n\n");
		test1();
		System.out.println("\n\n\n\n\n\n\n");
		//test();
	}
	
	private void test1() {
		//File wd = new File("C:\\Users\\bluew_000\\git\\SeniorProject\\SeniorProject");
		File wd = new File(System.getProperty("user.dir"));
		System.out.println(wd);
		Process proc = null;
		File workingDirectory = new File("GraphWalker\\Projects\\login");
		String command = " /c mvn test & exit";
		try {
			String s = " /c cd ..\\..\\..\\Desktop\\login\\login & pwd & mvn graphwalker:generate-sources & exit";
		   proc = Runtime.getRuntime().exec("cmd.exe", null, workingDirectory);
		}
		catch (IOException e) {
		   e.printStackTrace();
		}
		if (proc != null) {
			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			   
		   PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
		   //out.println("cd ..\\..\\..\\Desktop\\login\\login");
		   out.println("pwd");
		   //out.println("mvn graphwalker:generate-sources");
		   out.println("mvn test");
		   out.println("exit");
		   try {
		      String line;
		      while ((line = in.readLine()) != null) {
		       System.out.println(line);
		      }
		      proc.waitFor();
		      in.close();
		      //out.close();
		      proc.destroy();
		   }
		   catch (Exception e) {
		      e.printStackTrace();
		   }
		}
	}
	
	
	private void test3() throws IOException, InterruptedException {
		String command2 = "mvn graphwalker:generate­sources -e";
		String command1 = "cd ../";
		//String command1 = "cd ..\\..\\..\\Desktop\\login\\login";
		String command = "echo %cd%";
		
		//System.out.println("User dir: " + System.getProperty("user.dir"));
		//writeOutput(getOutput(getProcess(buildProcessWithWorkDir( "..\\..\\..\\Desktop\\login\\login", command))));
		writeOutput(getOutput(getProcess(buildProcess(command))));
		System.out.println("dasadf\n\n\n");
		ProcessBuilder pb = buildProcess("C:\\Users\\bluew_000\\Desktop\\login\\login", command);
		System.out.println("pb initialized");
		//Process p = getProcess(pb);
		//System.out.println(" p initialized");
		//BufferedReader bf = getOutput(p);
		//System.out.println("bf nitialiezed");
		//writeOutput(bf);
		//System.out.println("ads\n\n");
		//startProcess(pb);
		//System.out.println(pb.directory());
		
		try {
			System.out.println("started");
			Runtime.getRuntime().exec("cmd.exe /c echo gd" );//, null, new File("C:\\Users\\bluew_000\\Desktop\\login\\login"));
			System.out.println("succeded");
		} catch (IOException e) {
			System.out.println("exec pata;di");
			e.printStackTrace();
		}
		//writeOutput(getOutput(getProcess(buildProcessWithWorkDir("C:\\Users\\bluew_000\\Desktop\\login\\login", command))));
		
		
		String commandNew = "echo %cd%";
		String changeDirCommand = "/c cd ..\\..\\..\\Desktop\\login\\login & " + commandNew;
		ProcessBuilder pBuilder = new ProcessBuilder("cmd.exe", changeDirCommand);
		pBuilder.redirectErrorStream(true);
		//pBuilder.directory(new File("C:\\Users\\bluew_000\\Desktop\\login\\login"));
		
		System.out.println("before pBuilder.start");
		Thread.sleep(1000);
		Process process = pBuilder.start();
		Thread.sleep(1000);
		System.out.println("after pBuilder.start");
		Thread.sleep(1000);
		System.out.println("before process.waitfor");
		Thread.sleep(1000);
		//process.waitFor();
		Thread.sleep(1000);
		System.out.println("after process.waitfor");
		Thread.sleep(1000);
		System.out.println("before bf init");
		BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
		Thread.sleep(1000);
		System.out.println("after bf init");
		String line = null;
		while (true) {
			line = getLine(bf, line);
			if (line == null)
				break;
			System.out.println("Usta bu ne" + line);
		}
		System.out.println("dir:   " + pBuilder.directory());
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
	
	protected ProcessBuilder buildProcess(String dir, String command) {
		ProcessBuilder pBuilder = new ProcessBuilder(command);
		pBuilder.redirectErrorStream(true);
		pBuilder.directory(new File(dir));
		return pBuilder;
	}
	
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

	protected BufferedReader getOutput(Process process) {
		return new BufferedReader(new InputStreamReader(
			process.getInputStream()));
	}
	
	private void test2(){
		writeOutput(getOutput(getProcess(buildProcess("cmd.exe /c mvn -version"))));
	}
	private void test() {
		System.out.println("Started...\n\n");
		try {
			Process p = Runtime.getRuntime().exec("C:\\Program Files\\Apache Software Foundation\\apache-maven-3.2.3\\bin\\mvn.bat graphwalker:generate-sources" , null, new File("C:\\Users\\bluew_000\\Desktop\\login\\login"));
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
