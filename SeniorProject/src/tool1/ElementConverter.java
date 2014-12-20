package tool1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ugur Ozkan
 * 
 *         This class converts web elements to their corresponding Selenium
 *         commands.
 */
public class ElementConverter {

	private List<Element> elements;
	private List<String> commands;

	public ElementConverter(List<Element> elements) {
		this.elements = elements;
		commands = new ArrayList<String>();
	}

	public List<String> getCommands() {
		convertElementsToCommands();
		return commands;
	}

	private void convertElementsToCommands() {
		for (Element el : elements) {
			if (el.toString() != null)
				commands.add(el.toString());
		}
	}

}
