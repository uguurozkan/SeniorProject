package tool5;

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
	
	public TestCreator(String projectPath) {
		this(projectPath, null, null, null);
		// TODO
	}
	
	public TestCreator(String modelPath, String interfaceName, String className, List<Element> elements) {
		setContent();
		setModelPath(modelPath);
		setInterfaceName(interfaceName);
		setClassName(className);
		setElements(elements);
	}

	private void setContent() {
		this.content = "";
	}

	private void setModelPath(String modelPath) {
		this.modelPath = modelPath;
	}

	private void setInterfaceName(String interfaceName) {
		if (interfaceName != null && !interfaceName.isEmpty())
			this.interfaceName = interfaceName;
		else
			this.interfaceName = getModelName();
	}

	private String getModelName() {
		return Paths.get(modelPath).getFileName().toString();
	}

	private void setClassName(String className) {
		if (className != null && !className.isEmpty())
			this.className = className;
		else
			this.className = interfaceName + "Test";
	}

	private void setElements(List<Element> elements) {
		ElementConverter ec = new ElementConverter(elements);
		this.methods = ec.getMethodNames();
		this.commands = ec.getCommands();
	}
	
	public String getTestClass() {
		constructTestClass();
		return content;
	}
	
	private void constructTestClass() {
		content += addHeader();
		content += addOverrideMethods();
		content += addFunctionalTest();
		content += addStabilityTest();
		content += addFooter();
	}
	
	private String addHeader() {
		return "\r\n" + 
			"package org.myorg.testautomation;\r\n" + 
			"\r\n" + 
			"import org.graphwalker.core.condition.ReachedVertex;\r\n" + 
			"import org.graphwalker.core.condition.EdgeCoverage;\r\n" + 
			"import org.graphwalker.core.condition.TimeDuration;\r\n" + 
			"import org.graphwalker.core.generator.AStarPath;\r\n" + 
			"import org.graphwalker.core.generator.RandomPath;\r\n" + 
			"import org.graphwalker.core.machine.ExecutionContext;\r\n" + 
			"import org.graphwalker.java.test.TestBuilder;\r\n" + 
			"import org.junit.Test;\r\n" + 
			"\r\n" + 
			"import java.nio.file.Path;\r\n" + 
			"import java.nio.file.Paths;\r\n" + 
			"\r\n" + 
			"import java.util.concurrent.TimeUnit;\r\n" + 
			"\r\n" + 
			"public class " + className + " extends ExecutionContext implements " + interfaceName + " {\r\n" + 
			"    \r\n" +
			"    public final static Path MODEL_PATH = Paths.get(\"" + modelPath + "\");\r\n";
	}
	
	private String addOverrideMethods() {
		String res = "";
		for (int i = 0; i < methods.size(); i++) {
			res += addOverrideMethod(methods.get(i), commands.get(i));
		}
		return res;		
	}
	
	private String addOverrideMethod(String methodName, String command) {
		return "\r\n" +
			"    @Override\r\n" + 
			"    public void " + methodName + "() {\r\n" + 
			"        " + command + "\r\n" + 
			"    }\r\n";
	}
	
	private String addFunctionalTest() {
		return "\r\n" +
			"    @Test\r\n" + 
			"    public void runFunctionalTest() {\r\n" + 
			"        new TestBuilder()\r\n" + 
			"            .setModel(MODEL_PATH)\r\n" + 
			"    		 .setContext(new " + className + "())\r\n" + 
			"            .setPathGenerator(new RandomPath(new EdgeCoverage(100)))\r\n" + 
			"            .setStart(\"e_Start\")\r\n" + 
			"            .execute();\r\n" + 
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
	
	private String addFooter() {
		return "\r\n" +
			"}\r\n";
	}

}
