package tool1;

import java.util.ArrayList;
import java.util.List;

import utils.Command;

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

	public ElementConverter(List<Element> elements) {
		this.elements = elements;
		methods = new ArrayList<String>();
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

}
