package utils;

import tool1.Element;

public class Command {
	
	private String seleniumCommand;
	
	public Command() {
		this.seleniumCommand = "";
	}
	
	public String getSeleniumCommand(Element element) {
		parseRepresentation(element);
		return seleniumCommand;
	}
	
	private void parseRepresentation(Element element) {
		String[] tokens = element.getMethodRepresentation().split("_");
		if (tokens[0] == "type") {
			seleniumCommand += "driver.findElement(By." + tokens[1] + "(\"" + tokens[2] + "\")).clear\r\n";
			seleniumCommand += "driver.findElement(By." + tokens[1] + "(\"" + tokens[2] + "\"))." + tokens[0] + "(\"Testi\");\r\n";
		} else {
			seleniumCommand += "driver.findElement(By." + tokens[1] + "(\"" + tokens[2] + "\"))." + tokens[0] + "();\r\n";
		}
	}
	
}
