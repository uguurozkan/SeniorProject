package tool1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import tool2.Edge;
import tool2.Node;

public class RecordedCaseConverter {
	
	private List<Node> nodes;
	private List<Edge> edges;

	public RecordedCaseConverter(List<Node> nodes) {
		this.nodes = nodes;	
		this.edges = new ArrayList<>();
	}

	public List<Edge> getEdges() {
		convertToEdges();		
		return edges;
	}

	private void convertToEdges() {
		List<String> sequences = new ArrayList<>();
		try {
			sequences = parseRecordedCases();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		int counter = 0;
		while (counter < sequences.size() - 1) {
			Node source = findNode(sequences.get(counter));
			Node target = findNode(sequences.get(counter + 1));
			
			if (source != null && target != null) {
				edges.add(new Edge(null, source, target, ""));
			}
			
			counter++;
		}
	}
	
	private Node findNode(String name) {
		for (Node node : nodes) {
			if (node.getLabel().equals("v_" + name)) {
				return node;
			}
		}
		
		return null;
	}
	
	private List<String> parseRecordedCases() throws IOException {
		List<String> methods = new ArrayList<>();
		File workingDirectory = new File("GraphWalker\\RecordedCases\\");
		File[] testSequenceFiles = workingDirectory.listFiles();

		if (testSequenceFiles != null) {
			for (File testSequenceFile : testSequenceFiles) {
				Document doc = Jsoup.parse(testSequenceFile, null);
				Elements links = doc.select("tr");
				for (int i = 1; i < links.size(); i++) {
					org.jsoup.nodes.Element element = links.get(i);
					String method = (element.child(0).ownText() + "_" + element.child(1).ownText()).replaceAll("[^\\w|/]", "_");
					methods.add(method);
				}
				methods.add("EOF");
			}
		}
		return methods;
	}
}
