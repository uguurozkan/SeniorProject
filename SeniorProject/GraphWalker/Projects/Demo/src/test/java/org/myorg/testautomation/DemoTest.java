package org.myorg.testautomation;

import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.TestBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.concurrent.TimeUnit;

public class DemoTest extends ExecutionContext implements Demo {
    
    public final static Path MODEL_PATH = Paths.get("org\\myorg\\testautomation\\Demo.graphml");
  	 private WebDriver driver;
    private String baseUrl;
	 
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:801/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl + "/xampp/CS401Website/");
    }

    @Override
    public void e_v_type_name_firstname() {
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys("Testi");
    }

    @Override
    public void v_type_name_firstname() {
		// No need to fill.
    }

    @Override
    public void v_type_name_firstnameLink() {
		// No need to fill.
    }

    @Override
    public void e_v_type_name_lastname() {
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys("Testi");
    }

    @Override
    public void v_type_name_lastname() {
		// No need to fill.
    }

    @Override
    public void v_type_name_lastnameLink() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_sex_0() {
		driver.findElement(By.id("sex-0")).click();
    }

    @Override
    public void v_click_id_sex_0() {
		// No need to fill.
    }

    @Override
    public void v_click_id_sex_0Link() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_sex_1() {
		driver.findElement(By.id("sex-1")).click();
    }

    @Override
    public void v_click_id_sex_1() {
		// No need to fill.
    }

    @Override
    public void v_click_id_sex_1Link() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_exp_0() {
		driver.findElement(By.id("exp-0")).click();
    }

    @Override
    public void v_click_id_exp_0() {
		// No need to fill.
    }

    @Override
    public void v_click_id_exp_0Link() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_exp_1() {
		driver.findElement(By.id("exp-1")).click();
    }

    @Override
    public void v_click_id_exp_1() {
		// No need to fill.
    }

    @Override
    public void v_click_id_exp_1Link() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_exp_2() {
		driver.findElement(By.id("exp-2")).click();
    }

    @Override
    public void v_click_id_exp_2() {
		// No need to fill.
    }

    @Override
    public void v_click_id_exp_2Link() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_exp_3() {
		driver.findElement(By.id("exp-3")).click();
    }

    @Override
    public void v_click_id_exp_3() {
		// No need to fill.
    }

    @Override
    public void v_click_id_exp_3Link() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_exp_4() {
		driver.findElement(By.id("exp-4")).click();
    }

    @Override
    public void v_click_id_exp_4() {
		// No need to fill.
    }

    @Override
    public void v_click_id_exp_4Link() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_exp_5() {
		driver.findElement(By.id("exp-5")).click();
    }

    @Override
    public void v_click_id_exp_5() {
		// No need to fill.
    }

    @Override
    public void v_click_id_exp_5Link() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_exp_6() {
		driver.findElement(By.id("exp-6")).click();
    }

    @Override
    public void v_click_id_exp_6() {
		// No need to fill.
    }

    @Override
    public void v_click_id_exp_6Link() {
		// No need to fill.
    }

    @Override
    public void e_v_type_id_datepicker() {
		driver.findElement(By.id("datepicker")).clear();
		driver.findElement(By.id("datepicker")).sendKeys("Testi");
    }

    @Override
    public void v_type_id_datepicker() {
		// No need to fill.
    }

    @Override
    public void v_type_id_datepickerLink() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_profession_0() {
		driver.findElement(By.id("profession-0")).click();
    }

    @Override
    public void v_click_id_profession_0() {
		// No need to fill.
    }

    @Override
    public void v_click_id_profession_0Link() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_profession_1() {
		driver.findElement(By.id("profession-1")).click();
    }

    @Override
    public void v_click_id_profession_1() {
		// No need to fill.
    }

    @Override
    public void v_click_id_profession_1Link() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_tool_0() {
		driver.findElement(By.id("tool-0")).click();
    }

    @Override
    public void v_click_id_tool_0() {
		// No need to fill.
    }

    @Override
    public void v_click_id_tool_0Link() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_tool_1() {
		driver.findElement(By.id("tool-1")).click();
    }

    @Override
    public void v_click_id_tool_1() {
		// No need to fill.
    }

    @Override
    public void v_click_id_tool_1Link() {
		// No need to fill.
    }

    @Override
    public void e_v_click_id_tool_2() {
		driver.findElement(By.id("tool-2")).click();
    }

    @Override
    public void v_click_id_tool_2() {
		// No need to fill.
    }

    @Override
    public void v_click_id_tool_2Link() {
		// No need to fill.
    }

    @Override
    public void e_v_clickAndWait_id_submit() {
		driver.findElement(By.id("submit")).click();
    }

    @Override
    public void v_clickAndWait_id_submit() {
		// No need to fill.
    }

    @Override
    public void v_clickAndWait_id_submitLink() {
		// No need to fill.
    }

    @Test
    public void runFunctionalTest() {
        new TestBuilder()
            .setModel(MODEL_PATH)
    		 .setContext(new DemoTest())
            .setPathGenerator(new RandomPath(new EdgeCoverage(100)))
            .setStart("e_Start")
            .execute();
    }

    @Test
    public void runStabilityTest() {
    	new TestBuilder()
    		.setModel(MODEL_PATH)
    		.setContext(new DemoTest())
    		.setPathGenerator(new RandomPath(new TimeDuration(30, TimeUnit.SECONDS)))
    		.setStart("e_Start")
    		.execute();
    }

    @Override
    public void e_Start() {
        setUp();
    }
    
    @Override
    public void StartLink() {
        // No need to fill.
    }

}
