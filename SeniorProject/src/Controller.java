import java.util.List;

import tool1.Element;
import tool1.ElementConverter;
import tool1.ElementExtractor;
import tool2.GraphMLCreator;
import tool2.Node;
import tool3.ModelVerifier;
import tool4.ProjectCreator;
import tool5.TestCreator;
import tool5.TestRunner;
import utils.FileWriter;


public class Controller {

	private final static String BASE_URL = "http://localhost:801/xampp/CS401Website/";
	private final static String PROJECT_NAME = "Demo";
	
	public static void main(String[] args) {
		new Controller();
	}
	
	public Controller() {
		// Extract elements
		ElementExtractor ee = new ElementExtractor(BASE_URL);
		List<Element> elements = ee.getElements();
		
		// Convert elements
		ElementConverter ec = new ElementConverter(elements);
		List<Node> nodes = ec.getNodes();
		
		// Create GraphML
		GraphMLCreator gc = new GraphMLCreator(nodes);
		
		// Write GraphML
		String modelName = "demo";
		FileWriter fw = new FileWriter("GraphWalker\\Models\\", modelName, gc.getGraphML(), ".graphml");
		fw.writeFile();
		
		// Verify Model
		ModelVerifier mv = new ModelVerifier("GraphWalker\\graphwalker.jar", "GraphWalker\\Models\\" + modelName + ".graphml", "random", "vertex_coverage(100)");
		if (!mv.verify()) {
			System.err.println("Model is not correct.");
			return;
		}
		
		// Create Project
		ProjectCreator pc = new ProjectCreator(PROJECT_NAME, modelName);
		pc.createProject();
		
		// Create Tests
		TestCreator tc = new TestCreator("GraphWalker\\Models\\" + modelName + ".graphml", modelName + ".graphml", "", elements);
		fw = new FileWriter("GraphWalker\\", modelName, tc.getTestClass(), ".java");
		
		// Run Tests
		TestRunner tr = new TestRunner(PROJECT_NAME);
		tr.compileTest();
		tr.invokeTest();
	}

}
