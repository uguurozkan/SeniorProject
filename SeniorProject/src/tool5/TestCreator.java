package tool5;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import tool1.Element;
import tool1.ElementConverter;
import utils.CommandLineProcessor;

/**
 * This class generates the necessary test class code.
 * 
 * @author Ugur Ozkan
 *
 */
public class TestCreator extends CommandLineProcessor {

	String projectPath, className, interfaceName, modelPath, content;
	private List<String> methods, commands;
	
	public TestCreator(String projectPath, List<Element> elements) {
		this(projectPath, elements, null);
	}
	
	public TestCreator(String projectPath, List<Element> elements, String modelName) {
		this(projectPath, elements, modelName, null);
	}
	
	public TestCreator(String projectPath, List<Element> elements, String modelName, String interfaceName) {
		this(projectPath, elements, modelName, interfaceName, null);
	}
	
	public TestCreator(String projectPath, List<Element> elements, String modelName, String interfaceName, String className) {
		setContent();
		setProjectPath(projectPath);
		setElements(elements);
		setModelPath(modelName);
		setInterfaceName(interfaceName);
		setClassName(className);				
	}
	
	private void setContent() {
		this.content = "";
	}
	
	private void setProjectPath(String projectPath) {
		if (projectPath.contains("/") && (projectPath.charAt(projectPath.length() - 1) != '/'))
			this.projectPath = projectPath + '/';
		else if (projectPath.contains("\\") && (projectPath.charAt(projectPath.length() - 1) != '\\'))
			this.projectPath = projectPath + '\\';
		else
			this.projectPath = projectPath;
	}
	
	private void setElements(List<Element> elements) {
		ElementConverter ec = new ElementConverter(elements);
		this.methods = ec.getMethodNames();
		this.commands = ec.getCommands();
	}
	
	private void setModelPath(String modelName) {
		if (modelName == null) {
			String projectName = new File(projectPath).getName();
			modelName = projectName.substring(0, 1).toUpperCase() + projectName.substring(1);
		}
		
		if (!modelName.toLowerCase().endsWith(".graphml"))
			this.modelPath = "org\\\\myorg\\\\testautomation\\\\" + modelName + ".graphml";
		else
			this.modelPath = "org\\\\myorg\\\\testautomation\\\\" + modelName;
	}
	
	private void setInterfaceName(String interfaceName) {
		if (interfaceName != null && !interfaceName.isEmpty())
			this.interfaceName = interfaceName;
		else
			this.interfaceName = getModelName();
	}
	
	private String getModelName() {
		String modelNameWithExtension = Paths.get(modelPath).getFileName().toString();
		return modelNameWithExtension.substring(0, modelNameWithExtension.lastIndexOf('.'));
	}
	
	private void setClassName(String className) {
		if (className != null && !className.isEmpty())
			this.className = className;
		else
			this.className = interfaceName + "Test";
	}
	
	public String getTestClass() {
		constructTestClass();
		return content;
	}
	
	private void constructTestClass() {
		content += addHeader();
		content += addBeforeStatement();
		content += addOverrideMethods();
		content += addFunctionalTest();
		content += addStabilityTest();
		content += addAfterStatement();
		content += addFooter();
	}
	
	private String addHeader() {
		return "" + 
			"package org.myorg.testautomation;\r\n" + 
			"\r\n" + 
			"import org.graphwalker.core.condition.ReachedVertex;\r\n" + 
			"import org.graphwalker.core.condition.EdgeCoverage;\r\n" + 
			"import org.graphwalker.core.condition.TimeDuration;\r\n" + 
			"import org.graphwalker.core.generator.AStarPath;\r\n" + 
			"import org.graphwalker.core.generator.RandomPath;\r\n" + 
			"import org.graphwalker.core.machine.ExecutionContext;\r\n" + 
			"import org.graphwalker.java.test.TestBuilder;\r\n" + 
			"\r\n" +
			"import org.openqa.selenium.By;\r\n" + 
			"import org.openqa.selenium.NoSuchElementException;\r\n" + 
			"import org.openqa.selenium.WebDriver;\r\n" + 
			"import org.openqa.selenium.WebElement;\r\n" + 
			"import org.openqa.selenium.firefox.FirefoxDriver;\r\n" +
			"\r\n" +
			"import org.junit.Test;\r\n" + 
			"\r\n" + 
			"import java.nio.file.Path;\r\n" + 
			"import java.nio.file.Paths;\r\n" + 
			"\r\n" + 
			"import java.util.concurrent.TimeUnit;\r\n" + 
			"\r\n" + 
			"public class " + className + " extends ExecutionContext implements " + interfaceName + " {\r\n" + 
			"    \r\n" +
			"    public final static Path MODEL_PATH = Paths.get(\"" + modelPath + "\");\r\n" +
			"  	 private WebDriver driver;\r\n" + 
			"    private String baseUrl;\r\n";
	}
	
	private String addBeforeStatement() {
		return "\r\n" +
			"    public void setUp() {\r\n" + 
			"        driver = new FirefoxDriver();\r\n" + 
			"        baseUrl = \"http://localhost/\";\r\n" + 
			"        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);\r\n" + 
			"        driver.get(baseUrl + \"/xampp/CS402Website/\");\r\n" +
			"    }\r\n";
	}
	
	private String addOverrideMethods() {
		String res = "";
		for (int i = 0; i < methods.size(); i++) {
			res += addOverrideMethod("e_v_", methods.get(i), commands.get(i));
			res += addOverrideMethod("v_", methods.get(i), "// No need to fill.");
			res += addOverrideMethod("v_", methods.get(i) + "Link", "// No need to fill.");
		}		
		return res;
	}
	
	private String addOverrideMethod(String type, String methodName, String command) {
		return "\r\n" +
			"    @Override\r\n" + 
			"    public void " + type + methodName + "() {\r\n" + 
			"\t\t" + command + "\r\n" + 
			"    }\r\n";
	}
	
	private String addFunctionalTest() {
		return "\r\n" +
			"    @Test\r\n" + 
			"    public void runFunctionalTest() {\r\n" + 
			"       new TestBuilder()\r\n" + 
			"       	.setModel(MODEL_PATH)\r\n" + 
			"    		.setContext(new " + className + "())\r\n" + 
			"           .setPathGenerator(new RandomPath(new EdgeCoverage(100)))\r\n" + 
			"           .setStart(\"e_Start\")\r\n" + 
			"    	    .execute();\r\n" + 
			"    }\r\n";
	}
	
	private String addStabilityTest() {
		return "\r\n" +
			"    @Test\r\n" + 
			"    public void runStabilityTest() {\r\n" + 
			"    	new TestBuilder()\r\n" + 
			"    		.setModel(MODEL_PATH)\r\n" + 
			"    		.setContext(new " + className + "())\r\n" + 
			"    		.setPathGenerator(new RandomPath(new TimeDuration(30, TimeUnit.SECONDS)))\r\n" + 
			"    		.setStart(\"e_Start\")\r\n" + 
			"    		.execute();\r\n" + 
			"    }\r\n";
	}
	
	private String addAfterStatement() {
		return "\r\n" +
			"    @Override\r\n" + 
			"    public void e_Start() {\r\n" + 
			"        setUp();\r\n" + 
			"    }\r\n" +
			"    \r\n" +
			"    @Override\r\n" + 
			"    public void StartLink() {\r\n" + 
			"        // No need to fill.\r\n" + 
			"    }\r\n";

	}
	
	private String addFooter() {
		return "\r\n" +
			"}\r\n";
	}

	public String getProjectPath() {
		return projectPath;
	}
	
	public String getClassName() {
		return className;
	}

}
