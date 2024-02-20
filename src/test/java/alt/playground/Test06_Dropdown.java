package alt.playground;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v118.dom.model.Rect;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test06_Dropdown {
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
	public void selectFavoriteAutomationTool() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_dropdown")).click();
		//
		WebElement dropAutomation = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select automationList = new Select(dropAutomation);
		automationList.selectByVisibleText("Playwright");
	}

	//
	@Test
	public void selectFavoriteCountry() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_dropdown")).click();
		//
		WebElement dropAutomation = driver.findElement(By.id("j_idt87:country_input"));
		Select countryList = new Select(dropAutomation);
		countryList.selectByValue("Brazil"); // value in DOM
	}
	
	//
	@Test
	public void selectFavoriteCountryCity() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_dropdown")).click();
		//
		
		Thread.sleep(3000);
		WebElement dropAutomation1 = driver.findElement(By.id("j_idt87:country_input"));
		Select countryList = new Select(dropAutomation1);
		countryList.selectByVisibleText("Brazil");
		Thread.sleep(3000);
		WebElement dropAutomation2 = driver.findElement(By.id("j_idt87:city_input"));
		Select cityList = new Select(dropAutomation2);
		cityList.selectByVisibleText("Salvador");
	}
	
	//
	@Test
	public void typeAndChooseCourse() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_dropdown")).click();
		//
		driver.findElement(By.id("j_idt87:auto-complete_input")).sendKeys("AWS"+Keys.ENTER);
		Thread.sleep(3000);
	}
	
	//
	@Test
	public void chooseLanguageRandomly() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_dropdown")).click();
		//
		WebElement languageDropdown = driver.findElement(By.id("j_idt87:lang_input"));
		Select language = new Select(languageDropdown);
		language.selectByIndex(3);
		Thread.sleep(3000);
	}
	
	//
	@Test
	public void chooseLanguageAndSelectItem2() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_dropdown")).click();
		//
		WebElement languageDropdown = driver.findElement(By.id("j_idt87:lang_input"));
		Select language = new Select(languageDropdown);
		language.selectByIndex(3);
		Thread.sleep(3000);
	}
}
