import java.io.File;
import java.util.List;

import tool1.Element;
import tool1.ElementConverter;
import tool1.ElementExtractor;
import tool2.GraphMLCreator;
import tool2.Node;
import tool3.ModelVerifier;
import tool4.ProjectCreator;
import tool5.TestCreator;
import tool6.TestRunner;
import utils.FileWriter;


public class Controller {

	private final static String BASE_URL = "http://localhost:801/xampp/CS401Website/";
	private final static String WORKING_DIR = "GraphWalker\\";
	private final static String PROJECT_NAME = "Demo";
	private final static String MODEL_NAME = "Demo.graphml";
	private FileWriter fw = new FileWriter();
	
	public static void main(String[] args) throws InterruptedException {
		new Controller();
	}
	
	public Controller() throws InterruptedException {
		
		// Extract elements
		ElementExtractor ee = new ElementExtractor(BASE_URL);
		List<Element> elements = ee.getElements();
		System.out.println("Phase 1 - Elements extracted.\n\n");
		
		// Convert elements
		ElementConverter ec = new ElementConverter(elements);
		List<Node> nodes = ec.getNodes();
		System.out.println("Phase 1 - Elements converted.\n\n");
	
		// Create GraphML
		GraphMLCreator gc = new GraphMLCreator(nodes);
		
		// Write GraphML
		fw.setPath(WORKING_DIR + "Models\\");
		fw.setFileName(MODEL_NAME);
		fw.setContent(gc.getGraphML());
		fw.writeFile();
		System.out.println("Phase 2 - Model created.\n\n");
		
		// Verify Model
		ModelVerifier mv = new ModelVerifier(WORKING_DIR, WORKING_DIR + "Models\\" + MODEL_NAME, "random", "vertex_coverage(100)");
		File modelFile = new File(WORKING_DIR + "Models\\" + MODEL_NAME);
		while(!mv.verify()) {
			System.err.println("Model is not correct. Fix it and try again.");
			mv.printErrorMessage();
			
			mv.startyEd();
			while(!modelFile.canRead()){
				Thread.sleep(1000);
			}
		}
		System.out.println("Phase 3 - Verification done.\n\n");
		
		// Create Project
		ProjectCreator pc = new ProjectCreator(PROJECT_NAME, MODEL_NAME);
		pc.createProject();
		System.out.println("Phase 4 - Project created.\n\n");
		
		// Create Tests
		TestCreator tc = new TestCreator(WORKING_DIR + "Projects\\" + PROJECT_NAME, elements);
		fw.setPath(WORKING_DIR + "Projects\\" + PROJECT_NAME + "\\src\\test\\java\\org\\myorg\\testautomation");
		fw.setFileName(tc.getClassName() + ".java");
		fw.setContent(tc.getTestClass());
		fw.writeFile();
		System.out.println("Phase 5 - Tests created.\n\n");
		
		// Run Tests
		TestRunner tr = new TestRunner(PROJECT_NAME);
		tr.invokeTest();
		System.out.println("Phase 6 - Tests run.");
		
	}

}
