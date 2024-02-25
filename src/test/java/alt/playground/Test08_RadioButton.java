package alt.playground;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.dom.model.Rect;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test08_RadioButton {
	//
	WebDriver driver;

	//
	@BeforeTest
	public void setUp() {
		//
		driver = new ChromeDriver();
		driver.get("https://www.leafground.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	//
	@AfterTest
	public void tearDown() {
		driver.quit(); 
	}
	
	//
	@Test
	public void mostFavoriteBrowser() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_radio")).click();
		//

	}
	
	//
	@Test
	public void unSelectable() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_radio")).click();
		//

	}
	
	//
	@Test
	public void findDefaultButton() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_radio")).click();
		//

	}
	
	//
	@Test
	public void selectAnyIfNotSelected() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_radio")).click();
		//

	}

}
