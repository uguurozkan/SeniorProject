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
	private final static String WORKING_DIR = "GraphWalker\\";
	private final static String PROJECT_NAME = "Demo";
	private final static String MODEL_NAME = "Demo.graphml";
	
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
		FileWriter fw = new FileWriter();
		fw.setPath(WORKING_DIR + "Models\\");
		fw.setFileName(MODEL_NAME);
		fw.setContent(gc.getGraphML());
		fw.writeFile();
		
		// Verify Model
		ModelVerifier mv = new ModelVerifier(WORKING_DIR + "graphwalker.jar", WORKING_DIR + "Models\\" + MODEL_NAME, "random", "vertex_coverage(100)");
		if (!mv.verify()) {
			System.err.println("Model is not correct. Fix it and try again.");
			mv.printErrorMessage();
			return;
		}
		System.out.println("Verify done");
		
		// Create Project
		ProjectCreator pc = new ProjectCreator(PROJECT_NAME, MODEL_NAME);
		pc.createProject();
		System.out.println("Project Creation done");
	
		
		// Create Tests
		TestCreator tc = new TestCreator(WORKING_DIR + "Projects\\" + PROJECT_NAME, elements);
		fw.setPath(WORKING_DIR + "Projects\\" + PROJECT_NAME + "\\src\\test\\java\\org\\myorg\\testautomation");
		fw.setFileName(tc.getClassName() + ".java");
		fw.setContent(tc.getTestClass());
		fw.writeFile();
		System.out.println("Test Creation Done");
		
		// Run Tests
		TestRunner tr = new TestRunner(PROJECT_NAME);
		//tr.compileTest();
		tr.invokeTest();
		System.out.println("Test run done.");
		
	}

}
