package alt.playground;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test11_Menu {
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
	public void menuBar() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt42")).click();
		driver.findElement(By.id("menuform:m_menu")).click();
		//
		List<WebElement> menubar = new ArrayList<WebElement>();
		menubar = driver.findElements(By.xpath("//div[@id='j_idt87:j_idt89']//a//span[@class='ui-menuitem-text']"));
		System.out.println(menubar.size());
		for (WebElement menuitem : menubar) {
			System.out.println(menuitem.getText());
			
		}
		
	}
	
}
