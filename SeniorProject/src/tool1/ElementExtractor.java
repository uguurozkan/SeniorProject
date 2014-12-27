package tool1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class extracts web elements, which has either 'id' or 'name', of a web
 * page.
 * 
 * @author Ugur Ozkan
 * 
 */
public class ElementExtractor {

	private WebDriver driver;
	private String baseUrl;
	private List<Element> elements;

	public ElementExtractor(String baseUrl) {
		this.baseUrl = baseUrl;
		elements = new ArrayList<Element>();
	}

	public List<Element> getElements() {
		extract();
		return elements;
	}

	private void extract() {
		openWebPage();
		extractElements();
		closeWebPage();
	}

	private void openWebPage() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	private void extractElements() {
		for (WebElement we : driver.findElements(By.cssSelector("*"))) {
			if ((we.getAttribute("name") != null && !we.getAttribute("name").isEmpty())
					|| (we.getAttribute("id") != null && !we.getAttribute("id").isEmpty())) {
				elements.add(new Element(we.getTagName(), we.getAttribute("type"), 
						we.getAttribute("id"), we.getAttribute("name")));
			}
		}
	}

	private void closeWebPage() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
