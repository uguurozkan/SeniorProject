package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FooTestClass {

	public static void main(String[] args) {
		//normalizeTest();
		//setPathTest();
		//mvnTestWithFullPath();
		//mvnTest();
		//tokenizerTest();
		
	}

	private static void tokenizerTest() {
		String[] tokens = "click_id_exp-3".split("_");
		for (int x=0; x<tokens.length; x++)
	         System.out.println(tokens[x]);
	}

	private static void setPathTest() {
		System.out.println(setPath("GraphWalker\\Model"));
		System.out.println(setPath("GraphWalker\\Model\\"));
		System.out.println(setPath("GraphWalker/Model/"));
		System.out.println(setPath("GraphWalker\\Model/"));
	}

	private static void normalizeTest() {
		System.out.println(normalize("abc-"));
		System.out.println(normalize("abc_ads"));
		System.out.println(normalize("abc123"));
		System.out.println(normalize("abc_132"));
		System.out.println(normalize("abc123%^&*()$123dsadsa"));
		System.out.println(normalize("abc_ads321$%$%2__/?(?&^?24!@#!$##%$^&**(^)&*@!asagdfal;kk;ljkds;1"));
	}

	private static String normalize(String s) {
		return s.replaceAll("[^\\w]", "_");  // TODO change this with REGEX
	}
	
	
	private static String setPath(String path) {
		if (path.contains("/") && (path.charAt(path.length() - 1) != '/'))
			return path + '/';
		if (path.contains("\\") && (path.charAt(path.length() - 1) != '\\'))
			return path + '\\';
		else
			return path;
	}
	
	
	private static void mvnTestWithFullPath() {
		System.out.println("Started mvnTest with fullPath...\n\n");
		try {
			Process p = Runtime.getRuntime().exec("C:\\Program Files\\Apache Software Foundation\\apache-maven-3.2.3\\bin\\mvn.bat test" , null, new File("C:\\Users\\bluew_000\\Desktop\\login\\login"));
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
	
	private static void mvnTest() {
		System.out.println("Started mvnTest without fullPath...\n\n");
		try {
			Process p = Runtime.getRuntime().exec("mvn.bat graphwalker:generate-sources" , null, new File("C:\\Users\\bluew_000\\Desktop\\login\\login"));
			System.out.println("After_exec");
			
			

			p.waitFor();
			System.out.println("After_waitFor");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			System.out.println("After_BufferReader-Initialization");
			
			String line = reader.readLine();
			System.out.println("After_readLine");
			
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			System.out.println("After_whileLoop");
			
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}


		System.out.println("\n\nEnded...");
	}
	
	private static void mvnGenerateSources() {
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
