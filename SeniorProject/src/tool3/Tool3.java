package tool3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tool3 {

	public static void main(String[] args) throws IOException {
		
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "java -jar GraphWalker\\graphwalker.jar offline -m GraphWalker\\Model\\test.graphml \"random(vertex_coverage(100))\"");
		builder.redirectErrorStream(true);
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
		    if (line == null) { break; }
		    System.out.println(line);
		}
		
		ModelVerifier mv = new ModelVerifier("GraphWalker\\graphwalker.jar", "GraphWalker\\Model\\test.graphml", "random", "vertex_coverage(100)");
		System.out.println(mv.verify());

	}

}
