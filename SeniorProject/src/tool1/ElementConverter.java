package tool1;

import java.util.ArrayList;
import java.util.List;

import utils.Command;
import tool2.Node;

/**
 * This class converts web elements to their corresponding Selenium commands and
 * methods.
 * 
 * @author Ugur Ozkan
 * 
 */
public class ElementConverter {

	private List<Element> elements;
	private List<String> methods, commands;
	private List<Node> nodes;

	public ElementConverter(List<Element> elements) {
		this.elements = elements;
		methods = new ArrayList<String>();
		commands = new ArrayList<String>();
		nodes = new ArrayList<Node>();
	}

	public List<String> getMethodNames() {
		convertElementsToMethodNames();
		return methods;
	}

	private void convertElementsToMethodNames() {
		for (Element el : elements) {
			if (el.toString() != null)
				methods.add(el.toString());
		}
	}
	
	public List<String> getCommands() {
		convertElementsToCommands();
		return commands;		
	}

	private void convertElementsToCommands() {
		Command command = new Command();
		for (Element el : elements) {
			if (el.toString() != null)
				commands.add(command.getSeleniumCommand(el));
		}
	}
	
	public List<Node> getNodes() {
		convertElementsToNodes();
		return nodes;
	}

	private void convertElementsToNodes() {
		double xPos = 0, yPos = 0;
		for (Element el : elements) {
			if (el.toString() != null) {
				nodes.add(new Node(null, xPos, yPos, el.toString()));
				yPos += 50;
			}
		}
	}

}
