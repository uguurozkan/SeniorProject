package utils;

import tool1.Element;

public class Command {
	
	private String seleniumCommand;
	
	public String getSeleniumCommand(Element element) {
		this.seleniumCommand = "";
		parseRepresentation(element);
		return seleniumCommand;
	}
	
	private void parseRepresentation(Element element) {
		String[] tokens = element.getMethodRepresentation().split("_");
		if (tokens[0].equals("type")) {
			seleniumCommand += "driver.findElement(By." + tokens[1] + "(\"" + tokens[2] + "\")).clear();\r\n";
			seleniumCommand += "\t\tdriver.findElement(By." + tokens[1] + "(\"" + tokens[2] + "\")).sendKeys(\"Testi\");";
		} else if(tokens[0].equals("clickAndWait")) {
			seleniumCommand += "driver.findElement(By." + tokens[1] + "(\"" + tokens[2] + "\")).click();";
		} else {
			seleniumCommand += "driver.findElement(By." + tokens[1] + "(\"" + tokens[2] + "\"))." + tokens[0] + "();";
		}
	}
	
}
